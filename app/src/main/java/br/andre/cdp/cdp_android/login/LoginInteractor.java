package br.andre.cdp.cdp_android.login;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import br.andre.cdp.cdp_android.support.URLs;

/**
 * Created by helio on 5/16/17.
 */

public class LoginInteractor implements ILoginInteractor {

    @Override
    public void checkLoginIsValid(final Context context, final ILoginView view, String user, String pass) {


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("email", user);
        params.put("password", pass);

        client.post(context, URLs.loginPost(),
                params, new AsyncHttpResponseHandler() {

                    public void onStart() {

                        super.onStart();
                    }

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        try {

                            JSONObject json = new JSONObject(new String(responseBody));
                            view.returnLoginValidateSuccess(json.get("access_token").toString());

                            //view.returnLoginValidateSuccess(context.getString(R.string.msg_login_validate_success));

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                        view.returnLoginValidateError(error.getMessage());
                    }

                    public void onFinish() {
                        super.onFinish();
                    }
                });




    }
}
