/**
 * 
 */
package com.whereistango.common.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.whereistango.common.exception.CommonException;
import com.whereistango.common.gson.GsonUtility;
import com.whereistango.common.model.BaseResponse;
import com.whereistango.common.model.Response;
import com.whereistango.common.type.CommonResultCode;

/**
 * @author resulav
 *
 */
@SuppressWarnings("rawtypes")
public class ResponseUtility {

    private static final Gson   GSON                      = GsonUtility.getGson();

    private static final String ADDITIONAL_INFO_SEPARATOR = ". ";

    public static boolean isSuccess(BaseResponse baseResponse) {
        return isSuccess(baseResponse.getResponseCode());
    }

    public static boolean isFailure(BaseResponse baseResponse) {
        return isFailure(baseResponse.getResponseCode());
    }

    public static boolean isWarning(BaseResponse baseResponse) {
        return isWarning(baseResponse.getResponseCode());
    }

    public static boolean isSuccess(long responseCode) {
        return responseCode == CommonResultCode.SUCCESS.getCode();
    }

    public static boolean isWarning(long responseCode) {
        return responseCode == CommonResultCode.WARNING.getCode();
    }

    public static boolean isFailure(long responseCode) {
        return isSuccess(responseCode) == false && isWarning(responseCode) == false;
    }

    public static Response<?> toResponse(String asJson) {
        return GSON.fromJson(asJson, Response.class);
    }

    //    public static <T extends Response> T toResponse(String asJson, Class<T> clazz) {
    //        return GSON.fromJson(asJson, clazz);
    //    }

    public static <T extends Response> T toResponse(String asJson, TypeToken<T> typeToken) {
        return GSON.fromJson(asJson, typeToken.getType());
    }

    public static BaseResponse toBaseResponse(String asJson) {
        return GSON.fromJson(asJson, BaseResponse.class);
    }

    public static String toJsonAsResponse(Response<?> Response) {
        return GSON.toJson(Response);
    }

    public static String toJsonAsBaseResponse(BaseResponse BaseResponse) {
        return GSON.toJson(BaseResponse);
    }

    public static String toJsonAsEscapeData(Response<?> Response) {
        return GsonUtility.getGson("data").toJson(Response);
    }

    public static String toJsonAsExclusionStrategy(Response<?> Response) {
        return GsonUtility.getGsonForExcludeField().toJson(Response);
    }

    public static String prepareAdditionalInfo(String... additionalInfo) {
        if (additionalInfo == null || additionalInfo.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (String addtionalInfo : additionalInfo) {
            if (sb.length() != 0) {
                sb.append(ADDITIONAL_INFO_SEPARATOR);
            }
            sb.append(addtionalInfo);
        }

        return sb.toString();
    }

    public static void validate(Response Response) throws CommonException {
        if (isFailure(Response) == true) {
            throw new CommonException(ResultCodeUtility.getResultCode(Response.getResponseMessage()), Response.getAdditionalText());
        }
    }

    public static <E extends CommonException> void validate(Response response, Class<E> exceptionClass) throws CommonException {
        if (isSuccess(response) == false) {
            try {
                throw CommonException.convert(ResultCodeUtility.getResultCode(response.getResponseMessage()), exceptionClass);
            } catch (Exception e) {
                e.printStackTrace();
                throw new CommonException(ResultCodeUtility.getResultCode(response.getResponseMessage()));
            }
        }
    }

    //    public static void main(String[] args) {
    //        test();
    //        testList();
    //        testMap();
    //
    //    }
    //
    //    private static void testMap() {
    //
    //        Type type = new TypeToken<Response<Map<String, Context>>>() {
    //        }.getType();
    //
    //        Map<String, Context> map = new HashMap<String, Context>();
    //
    //        Context c1 = Context.newInstance();
    //        c1.setSessionId(1l);
    //
    //        Context c2 = Context.newInstance();
    //        c2.setSessionId(2l);
    //
    //        map.put("1", c1);
    //        map.put("2", c2);
    //
    //        Response<Map<String, Context>> response = Response.newSuccess(map);
    //
    //        String json = toJsonAsResponse(response);
    //        System.out.println(json);
    //
    //        //        Response<List<String>> response2 = toResponse(json, response.getTypeToken());
    //
    //        Response<Map<String, Context>> response2 = new Gson().fromJson(json, type);
    //
    //        System.out.println(response2.getData().get("2").getSessionId());
    //
    //    }
    //
    //    private static void testList() {
    //
    //        Type type = new TypeToken<Response<List<Context>>>() {
    //        }.getType();
    //
    //        List<Context> contextList = new ArrayList<Context>();
    //
    //        Context c1 = Context.newInstance();
    //        c1.setSessionId(1l);
    //
    //        Context c2 = Context.newInstance();
    //        c2.setSessionId(2l);
    //
    //        contextList.add(c1);
    //        contextList.add(c2);
    //
    //        Response<List<Context>> response = Response.newSuccess(contextList);
    //
    //        String json = toJsonAsResponse(response);
    //        System.out.println(json);
    //
    //        //        Response<List<String>> response2 = toResponse(json, response.getTypeToken());
    //
    //        //        Response<List<Context>> response2 = new Gson().fromJson(json, response.getTypeToken());
    //        Response<List<Context>> response2 = new Gson().fromJson(json, type);
    //
    //        System.out.println(response2.getData().get(1).getSessionId());
    //
    //    }
    //
    //    private static void test() {
    //
    //        Type type = new TypeToken<Response<Context>>() {
    //        }.getType();
    //
    //        Context context = Context.newInstance();
    //        context.setSessionId(1l);
    //
    //        Response<Context> response3 = Response.newSuccess(context);
    //
    //        String json2 = toJsonAsResponse(response3);
    //        System.out.println(json2);
    //
    //        Response<Context> response4 = new Gson().fromJson(json2, type);
    //
    //        //        Response<Context> response4 = new Gson().fromJson(json2, new CommonTypeToken<Response<Context>>().getTypeToken().getType());
    //
    //        System.out.println(response4.getData().getSessionId());
    //
    //    }
    //    private static <T> T getTypeToken(){
    //        
    //    }
}
