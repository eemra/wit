/**
 * 
 */
package com.whereistango.common.io.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author resulav
 *
 */
public class HostnameVerifierImpl implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}
