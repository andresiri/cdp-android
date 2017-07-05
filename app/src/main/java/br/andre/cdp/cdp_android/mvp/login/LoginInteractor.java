package br.andre.cdp.cdp_android.mvp.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import br.andre.cdp.cdp_android.R;
import br.andre.cdp.cdp_android.domain.model.NewUserModel;
import br.andre.cdp.cdp_android.support.URLs;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

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

        client.post(context, URLs.LOGIN, params,
            new AsyncHttpResponseHandler() {
                public void onStart() { super.onStart(); }

                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {

                    try {

                        JSONObject json = new JSONObject(new String(responseBody));
                        String accessToken = json.get("access_token").toString();

                        SharedPreferences.Editor editor = context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
                        editor.putString(context.getString(R.string.sp_access_token), accessToken);
                        editor.apply();

                        view.returnLoginValidateSuccess(accessToken);

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
            }
        );
    }

    @Override
    public void registerUser(Context context, final ISignupView view, NewUserModel newUser) throws JSONException, UnsupportedEncodingException {

        AsyncHttpClient client = new AsyncHttpClient();

        JSONObject json = new JSONObject();
        json.put("email", newUser.email);
        json.put("password", newUser.password);
        json.put("firstName", newUser.firstName);
        json.put("lastName", newUser.lastName);

        StringEntity entity = new StringEntity(json.toString());

        client.post(context, URLs.USER_CREATE, entity, "application/json", new AsyncHttpResponseHandler() {

            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONObject json = null;

                try {
                    json = new JSONObject(new String(responseBody));
                    view.returnSignupSuccess(json.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                view.returnSignupError(error.getMessage());
            }

            public void onFinish() {
                super.onFinish();
            }
        });
    }
}
