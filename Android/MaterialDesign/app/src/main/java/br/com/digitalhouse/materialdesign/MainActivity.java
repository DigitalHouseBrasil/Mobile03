package br.com.digitalhouse.materialdesign;

import android.net.http.SslError;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutName = findViewById(R.id.text_input_name);
    }

    public void validar(View view) {
        if (textInputLayoutName.getEditText().getText().toString().equals("")){
            textInputLayoutName.setError("Não pode ser vazio");
        }

        final Snackbar snackbar = Snackbar.make(view, "Texto do SnackBar....", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Click", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast na tela", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}
