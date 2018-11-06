package br.com.digitalhouse.moviemvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import br.com.digitalhouse.moviemvvm.model.Movie;
import io.reactivex.disposables.CompositeDisposable;

public class MovieViewModel extends AndroidViewModel {

    public MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> moviesLiveDataError = new MutableLiveData<>();
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMovies(Context context, String category, String language, int page, String country) {
        // TODO fazer chamada da api
        // TODO se tiver conectado buscar na api, senão pegar da base de dados "Use o método isConnected da classe AppUtil"
        // TODO Salvar filmes buscados no banco de dados
    }
}
