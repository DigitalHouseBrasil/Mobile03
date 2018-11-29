package br.com.digitalhouse.loginfacebook.tairo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {

    private static final String EMAIL = "email";
    private static final String PUBLIC_PROFILE = "public_profile";

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;
    private CircleImageView imageViewProfile;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList(EMAIL, PUBLIC_PROFILE));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("LOG", "onSuccess: " + loginResult);
                getUserProfile();
            }

            @Override
            public void onCancel() {
                Log.i("LOG", "onCancel: Cancelei");
            }

            @Override
            public void onError(FacebookException error) {
                Log.i("LOG", "onError: " + error.getMessage());
            }
        });


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        if (isLoggedIn){
            //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Toast.makeText(this, "Já está logado", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initViews() {
        textInputLogin = findViewById(R.id.textinput_user_login);
        textInputPassword = findViewById(R.id.textinput_password_login);
        loginButton = findViewById(R.id.btn_login_facebook_default);
        imageViewProfile = findViewById(R.id.imageview_user_login);
    }

    private void getUserProfile() {
        ProfileTracker profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

                // Agora que temos o token do usuario podemos requisitar os dados
                Profile.fetchProfileForCurrentAccessToken();
                if (currentProfile != null) {
                    String fbUserId = currentProfile.getId();
                    String profileUrl = currentProfile.getProfilePictureUri(200, 200).toString();
                    Log.d("FB profile", "got new/updated profile from thread " + fbUserId);
                    Picasso.get().load(profileUrl).into(imageViewProfile);
                    //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        };
    }
}
