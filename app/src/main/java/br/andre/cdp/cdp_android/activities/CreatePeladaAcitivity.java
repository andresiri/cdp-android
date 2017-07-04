package br.andre.cdp.cdp_android.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.login.LoginPresenter;
import br.andre.cdp.cdp_android.mvp.pelada.createpelada.CreatePeladaPresenter;
import br.andre.cdp.cdp_android.mvp.pelada.createpelada.ICreatePeladaView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by helio on 5/18/17.
 */

public class CreatePeladaAcitivity extends AppCompatActivity implements ICreatePeladaView {

    @BindView(R.id.newpelada_etName)
    EditText newpelada_etName;

    CreatePeladaPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpelada);

        ButterKnife.bind(this);
        presenter = new CreatePeladaPresenter(this, this);
    }

    @Override
    @OnClick(R.id.newpelada_btnSave)
    public void OnClickSave() {

        Pelada pelada = new Pelada();
        pelada.name = newpelada_etName.getText().toString();

        try {
            presenter.createPelada(pelada);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnSuccess(String msg) {

    }

    @Override
    public void returnError(String msg) {

    }
}
