package br.com.digitalhouse.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.app.R;
import br.com.digitalhouse.app.adapters.PeopleListAdapter;
import br.com.digitalhouse.app.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    private List<Person> list = new ArrayList<>();

    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        ListView listView = view.findViewById(R.id.list);

        //Preenche a lista de Pessoas
        getListPerson();

        // Cria o adapter para usar no listview
        PeopleListAdapter adapter = new PeopleListAdapter(getContext(), list);

        // Seta o adapeter no listview patra inflar a lista
        listView.setAdapter(adapter);

        //Seta o evento de click no listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Mostro uma mensagem quando clico no item do listview mostrando o nome
                Toast.makeText(getContext(), list.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    //Carrega a lista de  pessoas
    private void getListPerson() {
        list.add(new Person("Tairo", "Professor"));
        list.add(new Person("Jessica", "Professora"));
        list.add(new Person("Rosana", "Aluna"));
        list.add(new Person("Celso", "Aluno"));
        list.add(new Person("Sergio", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
    }
}
