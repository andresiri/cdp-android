package br.andre.cdp.cdp_android.mvp.login;

/**
 * Created by helio on 5/16/17.
 */

public interface ILoginView  {

    void init();
    void OnClickSign();
    void OnClickForgotPassword();
    void OnClickLoginSignup();

    void goNextActivity();

    /*
    * RETURNS OF INTERACTOR
    */
    void returnLoginValidateSuccess(String msg);
    void returnLoginValidateError(String msg);

}
