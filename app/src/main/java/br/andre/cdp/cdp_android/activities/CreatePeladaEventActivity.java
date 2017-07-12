package br.andre.cdp.cdp_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.andre.cdp.cdp_android.BuildConfig;
import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.mvp.login.LoginPresenter;
import butterknife.ButterKnife;

/**
 * Created by helio on 7/4/17.
 */

public class CreatePeladaEventActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpeladaevent);

        init();
    }

    public void init() {

        /*ButterKnife.bind(this);
        _presenter = new LoginPresenter(this, this);

        if (BuildConfig.DEBUG){
            etLoginUser.setText("heliofeliciano@gmail.com");
            etLoginPass.setText("helio");
        }*/
    }
}
