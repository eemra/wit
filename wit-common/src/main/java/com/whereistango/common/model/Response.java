/**
 * 
 */
package com.whereistango.common.model;

import com.whereistango.common.atomic.ThreadLocal;
import com.whereistango.common.type.CommonResultCode;
import com.whereistango.common.type.interfaces.IResultCode;
import com.whereistango.common.util.ResponseUtility;

/**
 * @author resulav
 *
 */
public class Response<T> extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private T                 data;

    /**
     * Just for Gson.fromJson method
     */
    public Response() {
    }

    public Response(IResultCode IResultCode, Long sessionId, T data, String... additionalText) {
        super(IResultCode, sessionId, additionalText);
        this.data = data;
    }

    public static <K> Response<K> newSuccess(K data) {
        return new Response<K>(CommonResultCode.SUCCESS, ThreadLocal.getContext().getSessionId(), data);
    }

    public static <K> Response<K> newSuccess() {
        return new Response<K>(CommonResultCode.SUCCESS, ThreadLocal.getContext().getSessionId(), null);
    }

    public static <K> Response<K> newFailure(IResultCode resultCode, String... additionalInfo) {
        return new Response<K>(resultCode, ThreadLocal.getContext().getSessionId(), null, additionalInfo);
    }

    public static <K> Response<K> newFailure(IResultCode resultCode) {
        return new Response<K>(resultCode, ThreadLocal.getContext().getSessionId(), null);
    }

    public static <K> Response<K> newWarning(K data, String... additionalText) {
        return new Response<K>(CommonResultCode.WARNING, ThreadLocal.getContext().getSessionId(), data, additionalText);
    }

    public static <K> Response<K> newWarning() {
        return new Response<K>(CommonResultCode.WARNING, ThreadLocal.getContext().getSessionId(), null);
    }

    /**
     * @return
     */
    public T getData() {
        return data;
    }

    //    public Type getTypeToken() {
    //        return new TypeToken<Response<T>>() {
    //        }.getType();
    //    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ResponseUtility.toJsonAsResponse(this);
    }

}
