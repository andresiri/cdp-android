package br.andre.cdp.cdp_android.mvp.login;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * Created by helio on 5/18/17.
 */

public interface ISignupView {

    void init();
    void OnClickSignup() throws UnsupportedEncodingException, JSONException;

    void goNextActivity();

    /*
    * RETURNS OF INTERACTOR
    */
    void returnSignupSuccess(String msg);
    void returnSignupError(String msg);

}
