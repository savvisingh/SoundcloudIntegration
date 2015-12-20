package com.example.savvisingh.soundcloudexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.savvisingh.soundcloudexample.prefrences.ZPreferences;

import lubecki.soundcloud.webapi.android.SoundCloudAuthenticator;
import lubecki.soundcloud.webapi.android.models.AuthenticationResponse;
import lubecki.soundcloud.webapi.android.models.Authenticator;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Savvi Singh on 10/29/2015.
 */
public class ReceivingActivity extends AppCompatActivity {

    private  Intent intent;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intent = getIntent();

        if(intent.getDataString().startsWith("com.example.savvisingh.soundcloudexample://soundcloud/redirect")) {
            Authenticator auth =
                    SoundCloudAuthenticator.handleResponse(intent, "com.example.savvisingh.soundcloudexample://soundcloud/redirect", "3594d5ad2a219ca13c5f75d771a5515e", "53fb5ecf8a114bb96c314951ba55a10f");

            SoundCloudAuthenticator.AuthService service = SoundCloudAuthenticator.getAuthService();
            service.authorize2(auth.client_id, auth.client_secret, auth.code, auth.grant_type, auth.redirect_uri, new Callback<AuthenticationResponse>() {
                @Override
                public void success(AuthenticationResponse authResponse, Response response) {
                    Log.v("AUTH SUCCESS", "TOKEN: " + authResponse.access_token);
                    // Save the token
                    ZPreferences.setIsUserLogin(ReceivingActivity.this, true);
                    ZPreferences.setUserToken(ReceivingActivity.this, authResponse.access_token);

                    Intent intent = new Intent(ReceivingActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    finish();

                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("AUTH FAILED", "ERROR: " + error.getMessage());
                    // See what went wrong
                }
            });
        } else {
            // handle other new intents
        }

    }


//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//
//
//        Log.d("MyApp", "Activity Receiving Activity");
//        if(intent.getDataString().startsWith("com.example.savvisingh.soundcloudexample://soundcloud/redirect")) {
//            Authenticator auth =
//                    SoundCloudAuthenticator.handleResponse(intent, "com.example.savvisingh.soundcloudexample://soundcloud/redirect", "3594d5ad2a219ca13c5f75d771a5515e", "53fb5ecf8a114bb96c314951ba55a10f");
//
//            SoundCloudAuthenticator.AuthService service = SoundCloudAuthenticator.getAuthService();
//            service.authorize(auth, new Callback<AuthenticationResponse>() {
//                @Override
//                public void success(AuthenticationResponse authResponse, Response response) {
//                    Log.v("AUTH SUCCESS", "TOKEN: " + authResponse.access_token);
//                    // Save the token
//                }
//
//                @Override
//                public void failure(RetrofitError error) {
//                    Log.e("AUTH FAILED", "ERROR: " + error.getMessage());
//                    // See what went wrong
//                }
//            });
//        } else {
//            // handle other new intents
//        }
//    }
}
