package br.andre.cdp.cdp_android.mvp.peladateam.interactor;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewTeam;
import br.andre.cdp.cdp_android.mvp.peladateam.createteam.ITeamView;

/**
 * Created by helio on 7/10/17.
 */

public interface ITeamInteractor {

    void saveTeam(Context context, ITeamView view, NewTeam team) throws JSONException, UnsupportedEncodingException;
    void getPeladas(Context context, ITeamView view);

}
