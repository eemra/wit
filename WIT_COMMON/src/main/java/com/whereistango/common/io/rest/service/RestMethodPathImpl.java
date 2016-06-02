/**
 * 
 */
package com.whereistango.common.io.rest.service;

import com.google.gson.reflect.TypeToken;
import com.whereistango.common.io.http.HttpMethod;

/**
 * @author resulav
 *
 */
public class RestMethodPathImpl implements IRestMethodPath {

    private final int          serviceId;
    private final String       servicePath;
    private final int          methodId;
    private final String       methodPath;
    private final HttpMethod   httpMethod;
    private final TypeToken<?> returnType;
    private final String       serviceAndMethodPath;

    /**
     * 
     */
    public RestMethodPathImpl(int serviceId, String servicePath, int methodId, String methodPath, HttpMethod httpMethod, TypeToken<?> returnType) {
        this.serviceId = serviceId;
        this.servicePath = servicePath != null ? ((servicePath.startsWith(PATH_DELIMITER)) ? (servicePath) : (PATH_DELIMITER + servicePath))
                : servicePath;
        this.methodId = methodId;
        this.methodPath = methodPath != null ? ((methodPath.startsWith(PATH_DELIMITER)) ? (methodPath) : (PATH_DELIMITER + methodPath)) : methodPath;
        this.httpMethod = httpMethod;
        this.returnType = returnType;

        String methodFullPath = "";

        if (this.servicePath != null) {
            methodFullPath = servicePath;
        }

        if (this.methodPath != null) {
            methodFullPath = methodFullPath + this.methodPath;
        }

        this.serviceAndMethodPath = methodFullPath;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceOnlyPath() {
        return servicePath;
    }

    public int getMethodId() {
        return methodId;
    }

    public String getMethodOnlyPath() {
        return methodPath;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public TypeToken<?> getReturnType() {
        return returnType;
    }

    public String getServiceAndMethodPath() {
        return serviceAndMethodPath;
    }

}
