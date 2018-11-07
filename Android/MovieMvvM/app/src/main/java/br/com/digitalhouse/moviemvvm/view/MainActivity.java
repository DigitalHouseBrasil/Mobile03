package br.com.digitalhouse.moviemvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.moviemvvm.R;
import br.com.digitalhouse.moviemvvm.adapters.RecyclerViewMovieAdapter;
import br.com.digitalhouse.moviemvvm.model.Movie;
import br.com.digitalhouse.moviemvvm.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    // Declara os componentes que serão usados
    private RecyclerView recyclerViewMovies;
    private ProgressBar progressBar;
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
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMovies.setAdapter(adapter);
        viewModel.getMovies("top_rated", "pt-BR", pag, "BR");
        viewModel.moviesLiveData.observe(this, movies -> adapter.setMovies(movies));
        viewModel.isLoading.observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }
        });

        recyclerViewMovies.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;

                if (totalItemCount > 0 && endHasBeenReached && pag <= totalPages) {
                    pag++;
                    viewModel.getMovies("top_rated", "pt-BR", pag, "BR");
                }
            }
        });
    }

    // Inicializa as Views
    private void initViews() {
        recyclerViewMovies = findViewById(R.id.recyclerview_movies);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewMovieAdapter(movies);
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
    }
}
