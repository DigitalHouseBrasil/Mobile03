package br.com.digitalhouse.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLogin = findViewById(R.id.textinput_user_login);
        textInputPassword = findViewById(R.id.textinput_password_login);
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
}
