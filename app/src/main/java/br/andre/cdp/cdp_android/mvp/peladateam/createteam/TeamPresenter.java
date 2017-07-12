package br.andre.cdp.cdp_android.mvp.peladateam.createteam;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.model.NewTeam;
import br.andre.cdp.cdp_android.mvp.peladateam.interactor.TeamInteractor;

/**
 * Created by helio on 7/10/17.
 */

public class TeamPresenter implements ITeamPresenter {

    TeamInteractor _interactor;
    ITeamView _view;
    Context _context;

    public TeamPresenter(Context context, ITeamView viewTeam) {

        // Call interactor
        _interactor = new TeamInteractor();
        _context = context;
        _view = viewTeam;

    }

    public void getPeladas() {
        _interactor.getPeladas(_context, _view);
    }

    @Override
    public void save(NewTeam newTeam) throws UnsupportedEncodingException, JSONException {

        // To use interact's methods
        _interactor.saveTeam(_context, _view, newTeam);
    }

}
