package br.andre.cdp.cdp_android.mvp.login;

import android.content.Context;

/**
 * Created by helio on 5/16/17.
 */

public class LoginPresenter implements ILoginPresenter {

    private LoginInteractor _interactor;
    ILoginView _view;
    private Context _context;

    public LoginPresenter(Context context, ILoginView view){
        _interactor = new LoginInteractor();
        _view = view;
        _context = context;
    }

    @Override
    public void trySign(String user, String pass) {

        _interactor.checkLoginIsValid(_context, _view, user, pass);

    }

}
