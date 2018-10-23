package com.example.samir.entregavel3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.samir.entregavel3.Fragments.FragmentoDoisReceita;
import com.example.samir.entregavel3.Fragments.FragmentoUmImagemFragment;
import com.example.samir.entregavel3.Interface.Comunicador;

public class MainActivity extends AppCompatActivity implements Comunicador {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new FragmentoUmImagemFragment());


    }
    public void replaceFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.action_container,fragment);
        transaction.addToBackStack("Fragmento");
        transaction.commit();
    }
    @Override
    public void receber(String mensagem){
        Fragment fragment = FragmentoDoisReceita.newInstance(mensagem);

        replaceFragment(fragment);
    }

}
