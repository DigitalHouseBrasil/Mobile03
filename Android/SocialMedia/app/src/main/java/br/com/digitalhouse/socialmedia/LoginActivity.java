package br.com.digitalhouse.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;
    private CircleImageView imageViewProfile;
    private CallbackManager callbackManager;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLogin = findViewById(R.id.textinput_user_login);
        textInputPassword = findViewById(R.id.textinput_password_login);
        loginButton = findViewById(R.id.btn_login_facebook_default);
        imageViewProfile = findViewById(R.id.imageview_user_login);
        callbackManager = CallbackManager.Factory.create();

        loginButton.setReadPermissions(Arrays.asList("public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("LOG", "LoginResult:" + loginResult);
                getUserProfile();
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Log.i("LOG", "Login Error: " + exception.getMessage());
            }
        });
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
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        };
    }

    public void login(View view) {
        String login = textInputLogin.getEditText().getText().toString();
        String password = textInputPassword.getEditText().getText().toString();

        if (login.isEmpty()) {
            textInputLogin.setError("Campo não pode ser vazio");
            return;
        }
        if (password.isEmpty()) {
            textInputPassword.setError("Campo não pode ser vazio");
            return;
        }

        if (login.equalsIgnoreCase("tairo") && password.equals("123")) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    public void loginWithMyFacebookButtom(View view) {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.i("LOG", "LoginResult:" + loginResult);
                        getUserProfile();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.i("LOG", "Login Error: " + exception.getMessage());
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
