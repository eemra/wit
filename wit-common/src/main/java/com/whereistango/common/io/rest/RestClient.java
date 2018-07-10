/**
 * 
 */
package com.whereistango.common.io.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;
import com.whereistango.common.exception.CommonException;
import com.whereistango.common.gson.GsonUtility;
import com.whereistango.common.io.http.HttpMethod;
import com.whereistango.common.io.rest.service.IRestMethodPath;
import com.whereistango.common.type.CommonResultCode;

/**
 * @author resulav
 *
 */
public class RestClient {

    private static final Logger  LOG                           = LoggerFactory.getLogger(RestClient.class);

    public final static String   REQ_ENTITY_MEDIA_TYPE_DEFAULT = MediaType.APPLICATION_JSON;
    public final static String[] REQ_ACCEPT_MEDIA_TYPE_DEFAULT = {REQ_ENTITY_MEDIA_TYPE_DEFAULT};

    /**
     * @param httpMethod
     * @param url
     * @param requestObject
     * @param responseTypeRef
     * @return
     * @throws Exception
     */
    public final static <T> T callRemote(final HttpMethod httpMethod, final String url, final Object requestObject,
                                         final TypeToken<T> responseTypeToken, Object... parameters) {
        StringBuilder serviceUrl = new StringBuilder(url).append(getParameterText(parameters));
        return callRemote(httpMethod, serviceUrl.toString(), requestObject, REQ_ENTITY_MEDIA_TYPE_DEFAULT, REQ_ACCEPT_MEDIA_TYPE_DEFAULT,
                          responseTypeToken);
    }

    /**
     * @param httpMethod
     * @param url
     * @param requestObject
     * @param responseTypeRef
     * @return
     * @throws Exception
     */
    public final static <T> T callRemoteByRestMethodPath(final HttpMethod httpMethod, final String baseUrl, final IRestMethodPath restMethodPath,
                                                         final Object requestObject, final TypeToken<T> responseTypeToken, Object... parameters) {

        StringBuilder serviceUrl = new StringBuilder(baseUrl);

        while (serviceUrl.length() - 1 == serviceUrl.lastIndexOf(IRestMethodPath.PATH_DELIMITER)) {
            if (LOG.isTraceEnabled()) {
                LOG.trace("baseUrl before: " + serviceUrl.toString());
            }

            serviceUrl = new StringBuilder(serviceUrl.substring(0, serviceUrl.length() - 1));

            if (LOG.isTraceEnabled()) {
                LOG.trace("baseUrl after: " + serviceUrl.toString());
            }
        }

        if (restMethodPath != null) {
            serviceUrl.append(restMethodPath.getServiceAndMethodPath());
        }

        return callRemote(httpMethod, serviceUrl.toString(), requestObject, REQ_ENTITY_MEDIA_TYPE_DEFAULT, REQ_ACCEPT_MEDIA_TYPE_DEFAULT,
                          responseTypeToken);
    }

    /**
     * if parameterValues empty, returns empty text. Otherwise, returns parameter path text like "/test/1" for parameter1 as test and parameter2 as 1
     * 
     * @param parameterValues
     * @return String as parameter path text
     */
    private static String getParameterText(Object... parameterValues) {

        StringBuilder sb = new StringBuilder();

        if (parameterValues == null || parameterValues.length == 0) {
            return sb.toString();
        }

        for (Object parameterValue : parameterValues) {
            sb.append(IRestMethodPath.PATH_DELIMITER).append(parameterValue);
        }

        return sb.toString();
    }

    /**
     * @param httpMethod
     * @param url
     * @param requestObject
     * @param reqMediaType
     * @param acceptMediaTypes
     * @param responseTypeRef
     * @return
     * @throws Exception
     */
    private final static <T> T callRemote(final HttpMethod httpMethod, final String url, final Object requestObject, final String reqMediaType,
                                          final String[] acceptMediaTypes, final TypeToken<T> responseTypeToken) {
        String respJson = null;
        T returnObject = null;
        try {
            respJson = callRemoteCommon(httpMethod, url, requestObject, reqMediaType, acceptMediaTypes);

            returnObject = GsonUtility.getGson().fromJson(respJson, responseTypeToken.getType());
        } catch (CommonException e) {
            throw e;
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.INVALID_RESPONSE, e, "Url= " + url + ". Response body= " + respJson);
        } finally {
        }

        return returnObject;
    }

    /**
     * @param httpMethod
     * @param url
     * @param requestObject
     * @param reqMediaType
     * @param acceptMediaTypes
     * @return
     * @throws Exception
     */
    private final static String callRemoteCommon(final HttpMethod httpMethod, final String url, final Object requestObject, final String reqMediaType,
                                                 final String[] acceptMediaTypes) {
        String respJson = null;
        Response response = null;
        try {

            //            final String jsonStr = GsonUtility.getGson().toJson(requestObject);
            //
            //            final URI uri = toUri(url);
            //            final ResteasyClient restClient = new ResteasyClientBuilder().build();
            //            final ResteasyWebTarget target = restClient.target(uri);
            //            final Builder reqBuilder = target.request().accept(acceptMediaTypes);
            //            final Entity<String> entity;
            //
            //            switch (httpMethod) {
            //            case GET:
            //                response = reqBuilder.get();
            //                break;
            //
            //            case POST:
            //                entity = Entity.entity(jsonStr, reqMediaType);
            //                response = reqBuilder.post(entity);
            //                break;
            //
            //            case DELETE:
            //                response = reqBuilder.delete();
            //                break;
            //
            //            case PUT:
            //                entity = Entity.entity(jsonStr, reqMediaType);
            //                response = reqBuilder.put(entity);
            //                break;
            //
            //            case HEAD:
            //                response = reqBuilder.head();
            //                break;
            //
            //            case OPTIONS:
            //                response = reqBuilder.options();
            //                break;
            //
            //            case TRACE:
            //                response = reqBuilder.trace();
            //                break;
            //
            //            default:
            //                throw new CommonException(CommonResultCode.INVALID_REST_CALL_PARAMETER, "Invalid HttpMethod= " + httpMethod);
            //            }
            //
            //            if (response.getStatus() != 200) { // Not HTTP 200 OK
            //                throw new CommonException(CommonResultCode.REST_CALL_FAILED, "Http status is " + response.getStatus() + " for url= " + url);
            //            }
            //
            //            respJson = response.readEntity(String.class);

        } catch (CommonException e) {
            throw e;
        } catch (IllegalStateException e) {
            throw new CommonException(CommonResultCode.UNREACABLE_REST_SERVICE, e, "Url= " + url + ". Response body= " + respJson);
            // } catch (IOException e) {
            // throw new
            // CommonException(CommonResultCode.UNREACABLE_REST_SERVICE, e,
            // "Url= " + url + ". Response body= " + respJson);
        } catch (com.google.gson.JsonSyntaxException e) {
            throw new CommonException(CommonResultCode.INVALID_RESPONSE, e, "Url= " + url + ". Response body= " + respJson);
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.UNREACABLE_REST_SERVICE, e, "Url= " + url + ". Response body= " + respJson);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (final Throwable e) {
                    LOG.error("cannot close response", e);
                }
            }
        }

        return respJson;
    }

    /**
     * @param uriStr
     * @return
     */
    //    private static final URI toUri(final String uriStr) {
    //        URI result = null;
    //        try {
    //            result = new URI(uriStr);
    //        } catch (final URISyntaxException e) {
    //            throw new RuntimeException(e);
    //        }
    //
    //        return result;
    //    }

}
