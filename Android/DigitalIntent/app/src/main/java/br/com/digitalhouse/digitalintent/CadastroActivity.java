package br.com.digitalhouse.digitalintent;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

public class CadastroActivity extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final int GET_RESULT = 200;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textInputLayoutName.getEditText().getText().toString();
                String email = textInputLayoutEmail.getEditText().getText().toString();
                String password = textInputLayoutPassword.getEditText().getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(NAME, name);
                bundle.putString(EMAIL, email);
                bundle.putString(PASSWORD, password);

                Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                intent.putExtras(bundle);

                startActivityForResult(intent, GET_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == GET_RESULT) {
            Toast.makeText(this, data.getStringExtra("resultado"), Toast.LENGTH_SHORT).show();
        }
    }
}
