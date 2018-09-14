package br.com.digitalhouse.tarefas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.com.digitalhouse.app.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    private TextView textViewDivide;
    private TextView textViewMultiply;
    private TextView textViewMinus;
    private TextView textViewPlus;
    private TextView textViewEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textViewResult = findViewById(R.id.textview_result);
        textViewDivide = findViewById(R.id.btnDivide);
        textViewMultiply = findViewById(R.id.btnMutitly);
        textViewMinus = findViewById(R.id.btnMinus);
        textViewPlus = findViewById(R.id.btnPlus);
        textViewEquals = findViewById(R.id.btnEquals);


        textViewDivide.setOnClickListener(this);
        textViewMultiply.setOnClickListener(this);
        textViewMinus.setOnClickListener(this);
        textViewPlus.setOnClickListener(this);
        textViewEquals.setOnClickListener(this);
    }

    public void calculate(View view) {
        String newText = ((TextView) view).getText().toString();
        String oldText = textViewResult.getText().toString();
        textViewResult.setText(oldText + newText);
    }

    public void cleanNumbers(View view) {
        textViewResult.setText("0");
    }

    public void putMinusPlus(View view) {
        Character signal = textViewResult.getText().toString().charAt(0);
        CharSequence result;

        if (signal.equals('-')){
            result = textViewResult.getText().subSequence(1, textViewResult.getText().length()).toString();
        }else {
            result = "-" + textViewResult.getText().toString();
        }

        textViewResult.setText(result);
    }

    @Override
    public void onClick(View v) {
        calculate(v);
    }
}
