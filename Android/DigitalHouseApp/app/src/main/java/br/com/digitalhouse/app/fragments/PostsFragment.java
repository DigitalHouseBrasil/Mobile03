package br.com.digitalhouse.app.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import br.com.digitalhouse.app.R;
import br.com.digitalhouse.app.interfaces.ClickFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    private ClickFragment listener;
    // Imagine que a Activity seja uma empresa
    // onde cada Fragment é um funcionário, situado em andares diferentes
    // do prédio. Para que os funcionários falem um com o outro,
    // a empresa (Activity) implementou uma linha telefônica, que é a equivalente à nossa Interface.
    // Todos os funcionários precisam usar a linha para poder falar um com o outro.
    // A linha não serve para nada sem um telefone para efetivamente
    // permitir a transferência da mensagem. Nessa situação,
    // o objeto listener é o telefone que permitirá que a mensagem
    // se transmitida de um funcionário para outro.

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
