package br.com.digitalhouse.app.mob3.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.app.mob3.LoginActivity;
import br.com.digitalhouse.app.mob3.R;
import br.com.digitalhouse.app.mob3.adapters.SpinnerAdapter;
import br.com.digitalhouse.app.mob3.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {

    private String message;

    public CommentsFragment() {
        // Required empty public constructor
    }

    //Retorna uma instancia do fragment
    public static Fragment newInstance(String value) {

        // Cria a instancia do fragmento
        CommentsFragment fragment = new CommentsFragment();

        // Preeenche o bundle
        Bundle bundle = new Bundle();
        bundle.putString("VALUE", value);

        //Seta os argumento
        fragment.setArguments(bundle);

        // devolve o fragmet
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getString("VALUE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        final Spinner spinner = view.findViewById(R.id.spinner);
        Button button = view.findViewById(R.id.button);

        final String[] nomes = getResources().getStringArray(R.array.nomes);
        final List<Person> personList = new ArrayList<>();

        for (String nome : nomes) {
            personList.add(new Person(nome));
        }

        //ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, nomes);
        SpinnerAdapter adapter = new SpinnerAdapter(personList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0){
                    Person person = personList.get(position);

                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.putExtra("PERSON", person);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return view;
    }
}
