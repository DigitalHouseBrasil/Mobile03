package br.com.digitalhouse.app.mob3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalhouse.app.mob3.utils.StringUtils;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewRegisterNow;
    private Button btnLogin;
    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewRegisterNow = findViewById(R.id.textview_register_now);
        btnLogin = findViewById(R.id.btn_login);
        inputEmail = findViewById(R.id.text_input_email);
        inputPassword = findViewById(R.id.text_input_password);

        // Direciona para a tela de Registro
        textViewRegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


        // Direciona para a tela de Home
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getEditText().getText().toString();
                String password = inputPassword.getEditText().getText().toString();

                if (StringUtils.validateEmail(email) && StringUtils.validatePassword(password)) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Email ou senha invalidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
