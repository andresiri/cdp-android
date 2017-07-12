package br.andre.cdp.cdp_android.mvp.peladateam.createteam;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import br.andre.cdp.cdp_android.domain.Pelada;

/**
 * Created by helio on 7/10/17.
 */

public interface ITeamView {

    void init();
    void OnClickSave() throws UnsupportedEncodingException, JSONException;
    void loadCollorSpinner();
    void getPeladaSpinner();

    void doAfterSave();

    /*
    * RETURNS OF INTERACTOR
    */
    void returnSuccess(String msg);
    void returnError(String msg);
    void loadPeladaSpinner(List<Pelada> peladaList);

}
