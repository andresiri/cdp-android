package br.andre.cdp.cdp_android.support;

/**
 * Created by helio on 5/16/17.
 */

public class URLs {

    private static final String HOST = "http://";
    private static final String DOMAIN = "10.0.2.2:5000/";

    public static String loginPost(){
        return new StringBuilder(HOST).append(DOMAIN).append("api/token").toString();
    }

}
