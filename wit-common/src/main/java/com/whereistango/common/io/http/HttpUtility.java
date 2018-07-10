/**
 * 
 */
package com.whereistango.common.io.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * @author resulav
 *
 */
public class HttpUtility {

    static {
        try {
            trustAllHttpsCertificates();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifierImpl());
    }

    private static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager myTrustManager = new DefaultTrustManager();
        trustAllCerts[0] = myTrustManager;
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }

    public static String doHttp(HttpMethod httpMethod, String httpActionUrl, Map<String, String> headerMap, Map<String, String> parameterMap,
                                String requestBody) throws IOException, SocketTimeoutException, Exception {
        HttpURLConnection conn = null;
        try {
            return execute(conn, httpMethod, httpActionUrl, headerMap, parameterMap, requestBody);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static String doHttps(HttpMethod httpMethod, String httpActionUrl, Map<String, String> headerMap, Map<String, String> parameterMap,
                                 String requestBody) throws IOException, SocketTimeoutException, Exception {
        HttpsURLConnection conn = null;
        try {
            return execute(conn, httpMethod, httpActionUrl, headerMap, parameterMap, requestBody);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

    }

    private static String execute(HttpURLConnection conn, HttpMethod httpMethod, String httpActionUrl, Map<String, String> headerMap,
                                  Map<String, String> parameterMap, String requestBody) throws Exception {

        String response = null;

        Scanner s = null;
        OutputStream os = null;
        InputStream in = null;

        try {
            String httpParameters = getQueryString(parameterMap);

            /*
             * Prepare Request Parameters
             */
            URL url;
            if (httpParameters != null) {
                if (httpActionUrl.contains("?")) {
                    if (httpActionUrl.endsWith("\\&")) {
                        url = new URL(httpActionUrl + httpParameters);
                    } else {
                        url = new URL(httpActionUrl + "&" + httpParameters);
                    }
                } else {
                    url = new URL(httpActionUrl + "?" + httpParameters);
                }

            } else {
                url = new URL(httpActionUrl);
            }

            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            /*
             * Prepare Connection
             */
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(httpMethod.getName());

            /*
             * Prepare Headers
             */
            if (headerMap != null && headerMap.size() > 0) {
                for (String header : headerMap.keySet()) {
                    if (header == null) {
                        continue;
                    }

                    String value = headerMap.get(header);
                    if (value == null) {
                        continue;
                    }

                    conn.setRequestProperty(header, value);
                }
            }

            /*
             * Set request body
             */
            if (requestBody != null) {
                byte[] outputInBytes = requestBody.getBytes("UTF-8");

                os = conn.getOutputStream();
                os.write(outputInBytes);
            }

            /*
             * execute request and read response
             */
            if (conn.getResponseCode() != 200) {
                in = conn.getErrorStream();
            } else {
                in = conn.getInputStream();
            }

            if (in != null) {
                s = new Scanner(in);

                s.useDelimiter("\\Z");

                if (s.hasNext())
                    response = s.next();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return response;
    }

    protected static String getQueryString(Map<String, String> httpRequestParameterMap) throws Exception {
        if (httpRequestParameterMap == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (String httpParameter : httpRequestParameterMap.keySet()) {
            String paramValue = httpRequestParameterMap.get(httpParameter);
            if (paramValue == null) {
                continue;
            }

            if (sb.length() != 0) {
                sb.append("&");
            }

            sb.append(URLEncoder.encode(httpParameter, "UTF-8")).append("=").append(URLEncoder.encode(paramValue, "UTF-8"));
        }

        return sb.toString();
    }
}
