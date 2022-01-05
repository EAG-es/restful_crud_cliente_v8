/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incli.restful;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/**
 *
 * @author daw
 */
public class Usar_ssls {
    public List <String> hostnames_a_evitar_list = new ArrayList ();
    
    public Usar_ssls () 
    {
        hostnames_a_evitar_list.add("localhost");
    }
    /*
    <Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
           maxThreads="200" scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="${user.home}/.keystore" keystorePass="pensarconLOGICA"
           clientAuth="false" sslProtocol="TLS"
           keyAlias="pc05.departamento"
    />
    */
    /**
     * Permite evitar la comprobación que produce la excepcion: javax.net.ssl.SSLHandshakeException: java.security.cert.CertificateException: No name matching localhost found
     * Este método no debe utilizarse.
     * Lo mejor, en lugar de utilizar esta opción, sería generar un certificado con su CN=/servidor/, por ejemplo: CN=localhost
     * Si se genera con: keytool -genkey -alias tomcat -keyalg RSA
     * La pregunta del nombre y apellidos corresponde con el CN y debe responderse con: /servidor/
     * Si no se puede modificar el certificado del servidor, este método puentea la verificación del nombre del servidor.
     * Ya que se producirá una excepcion: javax.net.ssl.SSLHandshakeException: java.security.cert.CertificateException: No name matching localhost found 
     */
    public final void evitar_excepcion_no_name_matching ()
    {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
            new HostnameVerifier () {
                public boolean verify(String hostname,
                        javax.net.ssl.SSLSession sslSession) {
                    if (hostnames_a_evitar_list.contains(hostname)) {
                        return true;
                    }
                    return false;
                }
            }
        );
    }

    public static void evitar_excepcion_no_name_matching (HostnameVerifier hostnameVerifier)
    {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
    }

    public static HostnameVerifier obtener_HostnameVerifier_simple() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                return true;
            }
        };
    }

    public static SSLContext getSSLContext() 
    {
        javax.net.ssl.TrustManager x509 = new javax.net.ssl.X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("SSL");
            ctx.init(null, new javax.net.ssl.TrustManager[]{x509}, null);
        } catch (java.security.GeneralSecurityException ex) {
        }
        return ctx;
    }
    
}
