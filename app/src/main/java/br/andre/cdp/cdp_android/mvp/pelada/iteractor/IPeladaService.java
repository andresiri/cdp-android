package br.andre.cdp.cdp_android.mvp.pelada.iteractor;

import java.util.List;

import br.andre.cdp.cdp_android.domain.Pelada;

/**
 * Created by helio on 7/11/17.
 */

public interface IPeladaService {

    List<Pelada> getPeladas(int peladaId);

}
