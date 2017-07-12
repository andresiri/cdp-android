package br.andre.cdp.cdp_android.mvp.pelada.iteractor;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.mvp.pelada.createpelada.ICreatePeladaView;

/**
 * Created by andremiranda on 03/07/17.
 */

interface IPeladaInteractor {

    void createPelada(Context context, ICreatePeladaView view, Pelada pelada) throws JSONException, UnsupportedEncodingException;
    void getPeladas(Context context, ICreatePeladaView view);
}
