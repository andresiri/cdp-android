package br.andre.cdp.cdp_android.login;

/**
 * Created by helio on 5/18/17.
 */

public interface ISignupView {

    void init();
    void OnClickSignup();

    void goNextActivity();

    /*
    * RETURNS OF INTERACTOR
    */
    void returnSignupSuccess(String msg);
    void returnSignupError(String msg);

}
