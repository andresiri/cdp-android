package br.andre.cdp.cdp_android.login;

import android.content.Context;

/**
 * Created by helio on 5/16/17.
 */

interface ILoginInteractor {

    void checkLoginIsValid(Context context, ILoginView view, String user, String pass);
    void registerUser(Context context, ISignupView view, String user, String pass, String name);

}
