package br.andre.cdp.cdp_android.mvp.pelada.createpelada;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.Pelada;

/**
 * Created by andremiranda on 03/07/17.
 */

public interface ICreatePeladaPresenter {

    void createPelada(Pelada pelada) throws UnsupportedEncodingException, JSONException;
}
