package br.com.digitalhouse.searchview.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.searchview.MainActivity;
import br.com.digitalhouse.searchview.R;
import br.com.digitalhouse.searchview.adapters.PersonRecyclerViewAdapter;
import br.com.digitalhouse.searchview.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_person);
        SearchView searchView = view.findViewById(R.id.search);
        EditText searchEdit = view.findViewById(R.id.search_edit);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        PersonRecyclerViewAdapter adapter = new PersonRecyclerViewAdapter(getPeople());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //Faz o link da toolbar com a activity
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        setSearchView(searchView);
        setEditTextListener(searchEdit);

        return view;
    }

    private void setEditTextListener(EditText searchEdit) {
        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("LOG", "Texto digitado ao digitar no EditText: " + s.toString());
            }
        });
    }

    private void setSearchView(SearchView searchView) {
        //Implementação do searchVCiew
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Log.i("LOG", "Texto digitado do searchView ao submeter: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("LOG", "Texto digitado do searchView ao digitar: " + newText);
                return false;
            }
        });
    }

    private List<Person> getPeople() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("https://blogthinkbig.com/wp-content/uploads/2017/04/Android.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://www.oficinadanet.com.br/imagens/post/23525/android-torrent_500312.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://blogthinkbig.com/wp-content/uploads/2017/04/Android.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://parentesis.com/imagesPosts/androit%201.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://parentesis.com/imagesPosts/androit%201.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOzekGmWmsitlaHtaCmVX0EInWGnGOCQlJtoGQSATbhU5uJeHnXg", "Tairo", "Professor"));personList.add(new Person("https://blogthinkbig.com/wp-content/uploads/2017/04/Android.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://www.oficinadanet.com.br/imagens/post/23525/android-torrent_500312.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://blogthinkbig.com/wp-content/uploads/2017/04/Android.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://parentesis.com/imagesPosts/androit%201.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://parentesis.com/imagesPosts/androit%201.jpg", "Tairo", "Professor"));
        personList.add(new Person("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOzekGmWmsitlaHtaCmVX0EInWGnGOCQlJtoGQSATbhU5uJeHnXg", "Tairo", "Professor"));
        return personList;
    }
}
