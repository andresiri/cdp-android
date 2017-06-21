package br.andre.cdp.cdp_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import br.andre.cdp.cdp_android.BuildConfig;
import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.login.ISignupView;
import br.andre.cdp.cdp_android.login.SignupPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by helio on 5/18/17.
 */

public class SignupActivity extends AppCompatActivity implements ISignupView {

    @BindView(R.id.etSignupEmail)
    EditText _etSignupEmail;

    @BindView(R.id.etSignupLastName)
    EditText _etSignupPass;

    @BindView(R.id.etSignupName)
    EditText _etSignupName;

    SignupPresenter signupPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();
    }

    @Override
    public void init() {

        ButterKnife.bind(this);
        signupPresenter = new SignupPresenter(this, this);

        if (BuildConfig.DEBUG){
            _etSignupEmail.setText("heliofeliciano@gmail.com");
            _etSignupName.setText("Helio F S Junior");
            _etSignupPass.setText("helio");
        }

    }

    private Boolean checkDatasValid() {

        if (_etSignupPass.getText().toString().equals("")
                || _etSignupEmail.getText().toString().equals("")
                || _etSignupName.getText().toString().equals("")) {

            Toast.makeText(getBaseContext(), getString(R.string.msg_login_empty), Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    @OnClick(R.id.btnSignup)
    @Override
    public void OnClickSignup() {

        if (checkDatasValid()) {
            signupPresenter.onSignup(_etSignupEmail.getText().toString(), _etSignupPass.getText().toString(), _etSignupName.getText().toString());
        }

    }

    @Override
    public void goNextActivity() {

    }

    @Override
    public void returnSignupSuccess(String msg) {

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void returnSignupError(String msg) {

    }
}
