package br.andre.cdp.cdp_android.mvp.pelada.createpelada;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

/**
 * Created by andremiranda on 03/07/17.
 */

public interface ICreatePeladaView {

    void OnClickSave() throws UnsupportedEncodingException, JSONException;

    /*
    * RETURNS OF INTERACTOR
    */
    void returnSuccess(String msg);
    void returnError(String msg);
}
