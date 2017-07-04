package br.andre.cdp.cdp_android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.andre.cdp.cdp_android.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnMainCreatePelada)
    public void OnClickCreatePelada() {

        startActivity(new Intent(this, CreatePeladaAcitivity.class));
    }
}
