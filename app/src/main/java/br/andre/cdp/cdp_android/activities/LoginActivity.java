package br.andre.cdp.cdp_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import br.andre.cdp.cdp_android.BuildConfig;
import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.mvp.login.ILoginView;
import br.andre.cdp.cdp_android.mvp.login.LoginPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by andremiranda on 15/05/17.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {

    /*@BindView(R.id.btnLoginSignin) Button btnLoginSign;*/

    @BindView(R.id.etLoginUser)
    EditText etLoginUser;

    @BindView(R.id.etLoginPass)
    EditText etLoginPass;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    @Override
    public void init() {

        ButterKnife.bind(this);
        presenter = new LoginPresenter(this, this);

        if (BuildConfig.DEBUG){
            etLoginUser.setText("heliofeliciano@gmail.com");
            etLoginPass.setText("helio");
        }
    }

    @Override
    @OnClick(R.id.btnLoginSignin)
    public void OnClickSign() {

        if (checkUserAndPasswordValid()) {
            presenter.trySign(etLoginUser.getText().toString(), etLoginPass.getText().toString());
        }

        /**/

    }

    private Boolean checkUserAndPasswordValid() {

        if (etLoginPass.getText().toString().equals("")
                || etLoginUser.getText().toString().equals("")) {

            Toast.makeText(getBaseContext(), getString(R.string.msg_login_empty), Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    @Override
    @OnClick(R.id.tvSignup)
    public void OnClickLoginSignup() {

        Intent it = new Intent(this, SignupActivity.class);
        startActivity(it);

    }

    @Override
    public void OnClickForgotPassword() {

    }

    @Override
    public void goNextActivity() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void returnLoginValidateSuccess(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
        goNextActivity();
    }

    @Override
    public void returnLoginValidateError(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
