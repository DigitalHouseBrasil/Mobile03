package br.com.digitalhouse.app.mob3.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import br.com.digitalhouse.app.mob3.R;
import br.com.digitalhouse.app.mob3.interfaces.ClickFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    private ClickFragment listener;

    public PostsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ClickFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity deve implementar ClickFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        Button btnSendMessage = view.findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickButton("Mensagem passada pelo PostFragment...!");
            }
        });

        return view;
    }
}
