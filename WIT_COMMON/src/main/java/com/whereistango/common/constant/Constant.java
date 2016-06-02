/**
 * 
 */
package com.whereistango.common.constant;

import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author resulav
 *
 */
public class Constant {

    public static final String           REST_API_DATE_FORMAT_TEXT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final SimpleDateFormat REST_API_DATE_FORMAT      = new SimpleDateFormat(REST_API_DATE_FORMAT_TEXT);

    /**
     * Default sessionID is 1111....111. 1 character count is equal VsfsConfConstants.SESSION_ID_LENGHT
     */
    public static final int              SESSION_ID_LENGHT         = 18;
    public static final long             DEFAULT_SESSION_ID;
    static {
        long sessionId = -1l;

        try {
            sessionId = Long.parseLong(RandomStringUtils.random(SESSION_ID_LENGHT, new char[] {'1'}));
        } catch (Exception e) {
        }
        DEFAULT_SESSION_ID = sessionId;
    }
}
