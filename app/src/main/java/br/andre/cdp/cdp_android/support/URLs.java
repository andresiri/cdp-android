package br.andre.cdp.cdp_android.support;

/**
 * Created by helio on 5/16/17.
 */

public class URLs {

    private static final String HOST = "http://";
    private static final String DOMAIN = "10.0.2.2:5000/";


    public static final String LOGIN = HOST + DOMAIN + "api/token";

    public static final String USER = HOST + DOMAIN + "api/user";
    public static final String TEAM_CREATE = HOST + DOMAIN + "api/peladas/{peladaid}/add-team";

    public static final String PELADAS = HOST + DOMAIN + "api/peladas";
}
