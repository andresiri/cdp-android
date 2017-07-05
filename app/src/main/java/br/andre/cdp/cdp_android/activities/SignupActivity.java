package br.andre.cdp.cdp_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.BuildConfig;
import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.model.NewUserModel;
import br.andre.cdp.cdp_android.mvp.login.ISignupView;
import br.andre.cdp.cdp_android.mvp.login.SignupPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by helio on 5/18/17.
 */

public class SignupActivity extends AppCompatActivity implements ISignupView {

    @BindView(R.id.etSignupEmail)
    EditText _etSignupEmail;

    @BindView(R.id.etSignupPassword)
    EditText _etSignupPass;

    @BindView(R.id.etSignupLastName)
    EditText _etSignupLastName;

    @BindView(R.id.etSignupFirstName)
    EditText _etSignupFirstName;

    SignupPresenter signupPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        init();
    }

    @Override
    public void init() {

        ButterKnife.bind(this);
        signupPresenter = new SignupPresenter(this, this);

        if (BuildConfig.DEBUG){
            _etSignupEmail.setText("heliofeliciano@gmail.com");
            _etSignupFirstName.setText("Helio F S Junior");
            _etSignupPass.setText("helio");
        }

    }

    private Boolean checkDataValid() {

        if (_etSignupPass.getText().toString().equals("")
                || _etSignupEmail.getText().toString().equals("")
                || _etSignupFirstName.getText().toString().equals("")) {

            Toast.makeText(getBaseContext(), getString(R.string.msg_login_empty), Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    @OnClick(R.id.btnSignup)
    @Override
    public void OnClickSignup() {

        if (checkDataValid()) {

            NewUserModel newUser = new NewUserModel();
            newUser.email = _etSignupEmail.getText().toString();
            newUser.password = _etSignupPass.getText().toString();
            newUser.firstName = _etSignupFirstName.getText().toString();
            newUser.lastName = _etSignupLastName.getText().toString();

            try {
                signupPresenter.onSignup(newUser);
            } catch (UnsupportedEncodingException | JSONException e) {
                e.printStackTrace();
            }
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

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
