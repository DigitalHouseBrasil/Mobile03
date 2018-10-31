package br.com.digitalhouse.mercadolivremvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.adapters.RecyclerViewMercadoLivreAdapter;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import br.com.digitalhouse.mercadolivremvvm.viewmodel.MercadoLivreViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editTextSearch;
    private RecyclerViewMercadoLivreAdapter adapter;
    private List<Result> results = new ArrayList<>();
    private MercadoLivreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 5) {
                    viewModel.searchItem(editable.toString());
                }
            }
        });

        viewModel.getResultLiveData().observe(this, results1 -> adapter.update(results1));
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        editTextSearch = findViewById(R.id.edit_search);
        viewModel = ViewModelProviders.of(this).get(MercadoLivreViewModel.class);
        adapter = new RecyclerViewMercadoLivreAdapter(results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
