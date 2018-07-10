/**
 * 
 */
package com.whereistango.common.io.http;

/**
 * @author resulav
 *
 */
public enum HttpMethod {

    OPTIONS("OPTIONS"),
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    TRACE("TRACE"),
    CONNECT("CONNECT");

    private final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static final HttpMethod getHttpMethod(String name) {

        if (name == null) {
            return GET;
        }

        for (HttpMethod httpMethod : HttpMethod.values()) {
            if (httpMethod.name.equalsIgnoreCase(name)) {
                return httpMethod;
            }
        }

        return GET;
    }
}
