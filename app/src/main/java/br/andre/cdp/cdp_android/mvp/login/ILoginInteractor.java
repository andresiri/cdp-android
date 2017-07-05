package br.andre.cdp.cdp_android.mvp.login;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewUserModel;

/**
 * Created by helio on 5/16/17.
 */

interface ILoginInteractor {

    void checkLoginIsValid(Context context, ILoginView view, String user, String pass);
    void registerUser(Context context, ISignupView view, NewUserModel newUser) throws JSONException, UnsupportedEncodingException;

}
