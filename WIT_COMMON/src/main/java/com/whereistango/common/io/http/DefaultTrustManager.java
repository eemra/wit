/**
 * 
 */
package com.whereistango.common.io.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author resulav
 *
 */
public class DefaultTrustManager implements TrustManager, X509TrustManager {

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public boolean isServerTrusted(X509Certificate[] certs) {
        return true;
    }

    public boolean isClientTrusted(X509Certificate[] certs) {
        return true;
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
        return;
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
        return;
    }
}