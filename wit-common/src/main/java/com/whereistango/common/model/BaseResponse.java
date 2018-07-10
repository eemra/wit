/**
 * 
 */
package com.whereistango.common.model;

import java.io.Serializable;

import com.whereistango.common.type.CommonResultCode;
import com.whereistango.common.type.interfaces.IResultCode;
import com.whereistango.common.util.ResponseUtility;

/**
 * @author resulav
 *
 */

public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long              responseCode;

    private String            responseMessage;

    private String            additionalText;

    private Long              sessionId;

    /**
     * Just for Gson.fromJson method
     */
    public BaseResponse() {
    }

    /**
         * 
         */
    public BaseResponse(IResultCode resultDef, Long sessionId, String... additionalTexts) {
        this.responseCode = resultDef.getCode();
        this.responseMessage = resultDef.getShortDescription();
        this.sessionId = sessionId;
        this.additionalText = ResponseUtility.prepareAdditionalInfo(additionalTexts);
    }

    /**
     * @return
     */
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     */
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return
     */
    public Long getResponseCode() {
        return responseCode;
    }

    /**
     * @return
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    /**
     * @return
     */
    public boolean isSuccess() {
        return CommonResultCode.SUCCESS.equals(responseCode);
    }

    /**
     * @return
     */
    public boolean isWarning() {
        return (isSuccess() == false) && (CommonResultCode.WARNING.equals(responseCode) == true);
    }

    /**
     * @return
     */
    public boolean isFailure() {
        return (isSuccess() == false) && (isWarning() == false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ResponseUtility.toJsonAsBaseResponse(this);
    }

}
