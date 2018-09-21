package br.com.digitalhouse.tarefas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.app.R;
import br.com.digitalhouse.app.fragments.CommentsFragment;
import br.com.digitalhouse.app.fragments.PostsFragment;

public class TestActivity extends AppCompatActivity {

    private Button btnFragmentOne;
    private Button btnFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnFragmentOne = findViewById(R.id.btn_fragment_one);
        btnFragmentTwo = findViewById(R.id.btn_fragment_two);

        btnFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new PostsFragment());
            }
        });

        btnFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new CommentsFragment());
            }
        });
    }

    // Adiciona um fragment no lugar do container
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.addToBackStack("Frag");
        transaction.commit();
    }
}
