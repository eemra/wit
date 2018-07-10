/**
 * 
 */
package com.whereistango.common.model;

import java.io.Serializable;

/**
 * @author resulav
 *
 */
public class Context implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long              sessionId;

    public static Context newInstance() {
        return new Context();
    }

    /**
     * @return the sessionId
     */
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     *            the sessionId to set
     */
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

}
