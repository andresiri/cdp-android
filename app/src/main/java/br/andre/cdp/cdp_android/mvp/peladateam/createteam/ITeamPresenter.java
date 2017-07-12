package br.andre.cdp.cdp_android.mvp.peladateam.createteam;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewTeam;

/**
 * Created by helio on 7/10/17.
 */

public interface ITeamPresenter {

    void save(NewTeam newTeam) throws UnsupportedEncodingException, JSONException;
    void getPeladas();

}
