package com.example.samir.entregavel3.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.samir.entregavel3.Interface.Comunicador;
import com.example.samir.entregavel3.R;

import static com.example.samir.entregavel3.R.id.strogonoff_frango;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoUmImagemFragment extends Fragment {

    private Comunicador listener;


    public FragmentoUmImagemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (Comunicador) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragmento_um_imagem, container, false);
        ImageButton imgEnviar = view.findViewById(R.id.strogonoff_frango);
        ImageButton imgEnviar2 = view.findViewById(R.id.panqueca);

        imgEnviar.setOnClickListener(new View.OnClickListener()

         {
            @Override
            public void onClick(View view) {
                listener.receber("Mensagemxxxxx");
            }
        });

        return view;
    }



}
