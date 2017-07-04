package br.andre.cdp.cdp_android.mvp.pelada.iteractor;

import android.content.Context;
import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.Pelada;
import br.andre.cdp.cdp_android.mvp.pelada.createpelada.ICreatePeladaView;
import br.andre.cdp.cdp_android.support.URLs;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

/**
 * Created by andremiranda on 03/07/17.
 */

public class PeladaInteractor implements IPeladaInteractor {

    @Override
    public void createPelada(Context context, final ICreatePeladaView view, Pelada pelada) throws JSONException, UnsupportedEncodingException {

        SharedPreferences sharedPref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String defaultValue = context.getResources().getString(R.string.sp_access_token);
        String accessToken = sharedPref.getString(context.getString(R.string.sp_access_token), defaultValue);

        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("Authorization", "Bearer " + accessToken);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", pelada.name);
        StringEntity entity = new StringEntity(jsonObject.toString());

        client.post(context, URLs.PELADA_CREATE, entity, "application/json",
            new AsyncHttpResponseHandler() {

                public void onStart() { super.onStart(); }

                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {

                    try {

                        JSONObject json = new JSONObject(new String(responseBody));

                        view.returnSuccess(json.toString());

                    } catch (JSONException e) {

                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                    view.returnError(error.getMessage());
                }

                public void onFinish() {
                    super.onFinish();
                }
            }
        );
    }
}
