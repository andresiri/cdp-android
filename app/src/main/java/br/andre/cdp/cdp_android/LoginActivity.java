package br.andre.cdp.cdp_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

/**
 * Created by andremiranda on 15/05/17.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLoginSignin) Button btnLoginSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("password", "andre");
        params.put("email", "andremirannda@gmail.com");

        client.post(this, "http://10.0.2.2:5000/api/token",
                params, new AsyncHttpResponseHandler() {

                    public void onStart() {

                        super.onStart();
                    }

                    @Override
                    public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {

                        try {

                            JSONObject json = new JSONObject(new String(arg2));
                            Toast.makeText(LoginActivity.this, json.get("access_token").toString(), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                    }
                    @Override
                    public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

                        Toast.makeText(LoginActivity.this, "xico", Toast.LENGTH_SHORT).show();

                    }

                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }
}
