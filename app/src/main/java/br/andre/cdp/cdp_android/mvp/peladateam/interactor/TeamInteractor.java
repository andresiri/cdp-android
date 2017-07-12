package br.andre.cdp.cdp_android.mvp.peladateam.interactor;

import android.content.Context;
import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.domain.model.NewTeam;
import br.andre.cdp.cdp_android.mvp.peladateam.createteam.ITeamView;
import br.andre.cdp.cdp_android.support.URLs;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by helio on 7/10/17.
 */

public class TeamInteractor implements ITeamInteractor {

    public TeamInteractor() {

    }

    @Override
    public void saveTeam(final Context context, final ITeamView view, NewTeam team) throws JSONException, UnsupportedEncodingException {

        AsyncHttpClient client = new AsyncHttpClient();

        JSONObject json = new JSONObject();
        json.put("name", team.getName());

        StringEntity entity = new StringEntity(json.toString());

        client.post(context, URLs.TEAM_CREATE, entity, "application/json", new AsyncHttpResponseHandler() {

            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONObject json = null;

                try {

                    json = new JSONObject(new String(responseBody));
                    if (json.get("type") != null) {

                        if (json.get("type").equals("CUSTOM_ERROR")) {

                            view.returnError(json.get("message").toString());

                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                view.returnError(error.getMessage());
            }

            public void onFinish() {
                super.onFinish();
            }
        });

    }

    @Override
    public void getPeladas(Context context, final ITeamView view) {


        final List<Pelada> peladaList = new ArrayList<>();
        peladaList.add(new Pelada(1, 0, "TUSDAY", "Pelada da Massa"));
        peladaList.add(new Pelada(2, 0, "MONDAY", "Pelada de Seu Diran"));
        peladaList.add(new Pelada(3, 0, "SATURDAY", "Pelada da Sinuca"));


        SharedPreferences sharedPref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String defaultValue = context.getResources().getString(R.string.sp_access_token);
        String accessToken = sharedPref.getString(context.getString(R.string.sp_access_token), defaultValue);

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", "Bearer " + accessToken);

        client.get(context, URLs.PELADAS, null, "application/json", new AsyncHttpResponseHandler() {

            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {



                view.loadPeladaSpinner(peladaList);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                view.returnError(error.getMessage());
            }

            public void onFinish() {
                super.onFinish();
            }
        });
    }

}
