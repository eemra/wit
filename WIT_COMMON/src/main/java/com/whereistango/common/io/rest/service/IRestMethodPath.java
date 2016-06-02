/**
 * 
 */
package com.whereistango.common.io.rest.service;

import com.google.gson.reflect.TypeToken;
import com.whereistango.common.io.http.HttpMethod;
import com.whereistango.common.model.Response;

/**
 * @author resulav
 *
 */
public interface IRestMethodPath {

    public static final String                 PATH_DELIMITER           = "/";

    public static final TypeToken<Response<?>> VOID_RESPONSE_TYPE_TOKEN = new TypeToken<Response<?>>() {
                                                                        };

    /**
     * @return
     */
    int getServiceId();

    /**
     * @return
     */
    String getServiceOnlyPath();

    /**
     * @return
     */
    int getMethodId();

    /**
     * @return
     */
    String getMethodOnlyPath();

    /**
     * @return
     */
    HttpMethod getHttpMethod();

    /**
     * @return
     */
    TypeToken<?> getReturnType();

    /**
     * @return
     */
    String getServiceAndMethodPath();
}
