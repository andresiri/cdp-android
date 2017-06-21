package br.andre.cdp.cdp_android.login;

import android.content.Context;

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
    public void onSignup(String user, String pass, String name) {

        _interactor.registerUser(_context, _view, user, pass, name);

    }
}
