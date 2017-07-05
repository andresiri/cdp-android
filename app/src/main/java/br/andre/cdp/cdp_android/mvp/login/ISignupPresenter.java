package br.andre.cdp.cdp_android.mvp.login;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewUserModel;

/**
 * Created by helio on 6/5/17.
 */

interface ISignupPresenter {

    void onSignup(NewUserModel newUser) throws UnsupportedEncodingException, JSONException;

}
