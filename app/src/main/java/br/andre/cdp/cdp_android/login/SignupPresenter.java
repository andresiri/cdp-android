package br.andre.cdp.cdp_android.login;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewUserModel;

/**
 * Created by helio on 5/16/17.
 */

public class SignupPresenter implements ISignupPresenter {

    private LoginInteractor _interactor;
    ISignupView _view;
    private Context _context;

    public SignupPresenter(Context context, ISignupView view){
        _interactor = new LoginInteractor();
        _view = view;
        _context = context;
    }

    @Override
    public void onSignup(NewUserModel newUser) throws UnsupportedEncodingException, JSONException {

        _interactor.registerUser(_context, _view, newUser);
    }
}
