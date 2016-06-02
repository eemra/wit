/**
 * 
 */
package com.whereistango.common.atomic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whereistango.common.exception.CommonException;
import com.whereistango.common.gson.GsonUtility;
import com.whereistango.common.model.Context;
import com.whereistango.common.type.CommonResultCode;

/**
 * @author resulav
 *
 */
public class ThreadLocal {

    private static Logger                                LOG          = LoggerFactory.getLogger(ThreadLocal.class);

    private static final InheritableThreadLocal<Context> THREAD_LOCAL = new InheritableThreadLocal<Context>() {

                                                                          @Override
                                                                          protected Context initialValue() {
                                                                              return Context.newInstance();
                                                                          }
                                                                      };

    public static synchronized Context getContext() {
        try {
            if (LOG.isTraceEnabled()) {
                LOG.trace("VsfsThreadLocal.getContext: " + GsonUtility.getGson().toJson(THREAD_LOCAL.get()));
            }

            return THREAD_LOCAL.get();
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.THREAD_LOCAL_FAILURE, e, "VsfsTreadLocal.getContext error");
        }
    }

    public static void setContext(Context Context) {
        try {
            if (LOG.isTraceEnabled()) {
                LOG.trace("VsfsThreadLocal.setContext: " + GsonUtility.getGson().toJson(Context));
            }

            THREAD_LOCAL.set(Context);
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.THREAD_LOCAL_FAILURE, e, "VsfsTreadLocal.setContext error");
        }
    }

    public static void remove() {
        try {
            if (LOG.isTraceEnabled()) {
                LOG.trace("VsfsThreadLocal.remove: " + GsonUtility.getGson().toJson(THREAD_LOCAL.get()));
            }

            THREAD_LOCAL.remove();
        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.THREAD_LOCAL_FAILURE, e, "VsfsTreadLocal.remove error");
        }
    }

    public static void setSessionId(Long sessionId) {
        try {
            getContext().setSessionId(sessionId);

            if (LOG.isTraceEnabled()) {
                LOG.trace("VsfsThreadLocal.setSessionId: " + GsonUtility.getGson().toJson(THREAD_LOCAL.get()));
            }

        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.THREAD_LOCAL_FAILURE, e, "VsfsTreadLocal.remove error");
        }
    }

    public static Long getSessionId() {
        try {
            if (LOG.isTraceEnabled()) {
                LOG.trace("VsfsThreadLocal.getSessionId: " + GsonUtility.getGson().toJson(THREAD_LOCAL.get()));
            }

            return getContext().getSessionId();

        } catch (Throwable e) {
            throw new CommonException(CommonResultCode.THREAD_LOCAL_FAILURE, e, "VsfsTreadLocal.remove error");
        }
    }

}
