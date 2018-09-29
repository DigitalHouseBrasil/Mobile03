package br.com.digitalhouse.app.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.digitalhouse.app.R;
import br.com.digitalhouse.app.adapters.RecyclerViewPersonAdapter;
import br.com.digitalhouse.app.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.app.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment implements RecyclerViewOnItemClickListener {

    private List<Person> list = new ArrayList<>();

    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerViewPersonAdapter adapter = new RecyclerViewPersonAdapter(getListPerson(),this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    //Carrega a lista de  pessoas
    private List<Person> getListPerson() {

        // Limpo a lista para adicionar mais pessoas e evitar
        // Duplicar as pessoas
        list.clear();
        list.add(new Person("Tairo", "Professor"));
        list.add(new Person("Jessica", "Professora"));
        list.add(new Person("Rosana", "Aluna"));
        list.add(new Person("Celso", "Aluno"));
        list.add(new Person("Sérgio", "Aluno"));
        list.add(new Person("Guilherme", "Aluno"));
        list.add(new Person("Erich", "Aluno"));
        list.add(new Person("Leehendry", "Aluno"));
        list.add(new Person("Lyandra", "Aluno"));
        list.add(new Person("Roberto", "Aluno"));
        list.add(new Person("Fulano", "Aluno"));
        list.add(new Person("Ciclano", "Aluno"));
        list.add(new Person("Beltrano", "Aluno"));
        list.add(new Person("Aluno nome", "Aluno"));
        list.add(new Person("Aluno nome", "Aluno"));

        return list;
    }

    @Override
    public void onItemClick(Person person) {
        Toast.makeText(getContext(), "Nome: " + person.getName(), Toast.LENGTH_SHORT).show();
    }
}
