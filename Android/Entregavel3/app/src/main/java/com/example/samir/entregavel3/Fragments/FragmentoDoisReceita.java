package com.example.samir.entregavel3.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.samir.entregavel3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoDoisReceita extends Fragment {


    private String mensagem;





    public FragmentoDoisReceita() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_dois_receita, container, false);
    }

    public static Fragment newInstance(String mensagem) {
        FragmentoDoisReceita fragment = new FragmentoDoisReceita();

        Bundle bundle = new Bundle();
        bundle.putString("A Receita é ",mensagem);

        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            mensagem = getArguments().getString("Mensagem");
        }
    }
}
