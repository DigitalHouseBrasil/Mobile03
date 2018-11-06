package br.com.digitalhouse.moviemvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.moviemvvm.R;
import br.com.digitalhouse.moviemvvm.adapters.RecyclerViewMovieAdapter;
import br.com.digitalhouse.moviemvvm.model.Movie;
import br.com.digitalhouse.moviemvvm.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    // Declara os componentes que serão usados
    private RecyclerView recyclerViewMovies;
    private RecyclerViewMovieAdapter adapter;
    private List<Movie> movies = new ArrayList<>();
    private MovieViewModel viewModel;
    private int pag = 1;
    private int totalPages = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        // TODO setar LayoutManager no recyclerview
        // TODO setar adapter no recyclerview
        // TODO chamar api para buscar os filmes
        // TODO implementar paginação
        // TODO add observer para o liveData movies do viewmodel
    }

    // Inicializa as Views
    private void initViews() {
        recyclerViewMovies = findViewById(R.id.recyclerview_movies);
        adapter = new RecyclerViewMovieAdapter(movies);
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
    }
}
