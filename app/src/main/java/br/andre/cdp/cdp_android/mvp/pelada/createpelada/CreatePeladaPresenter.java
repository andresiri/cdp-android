package br.andre.cdp.cdp_android.mvp.pelada.createpelada;

import android.content.Context;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.mvp.pelada.iteractor.PeladaInteractor;

/**
 * Created by andremiranda on 03/07/17.
 */

public class CreatePeladaPresenter implements ICreatePeladaPresenter {

    private PeladaInteractor _interactor;
    ICreatePeladaView _view;
    private Context _context;

    public CreatePeladaPresenter(Context context, ICreatePeladaView view) {

        _context = context;
        _view = view;
        _interactor = new PeladaInteractor();
    }

    @Override
    public void createPelada(Pelada pelada) throws UnsupportedEncodingException, JSONException {

        _interactor.createPelada(_context, _view, pelada);
    }
}
