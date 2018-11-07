package br.com.digitalhouse.moviemvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalhouse.moviemvvm.model.Movie;
import br.com.digitalhouse.moviemvvm.model.MovieResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.moviemvvm.data.database.MovieDatabase.getDatabase;
import static br.com.digitalhouse.moviemvvm.data.network.RetrofitService.API_KEY;
import static br.com.digitalhouse.moviemvvm.data.network.RetrofitService.getApiService;
import static br.com.digitalhouse.moviemvvm.util.AppUtil.isConnected;

public class MovieViewModel extends AndroidViewModel {

    public MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    MutableLiveData<Throwable> moviesLiveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMovies(String category, String language, int page, String country) {

        if (isConnected(getApplication())) {

            disposable.add(
                    getApiService().getMovies(category, API_KEY, language, page, country)
                            .map(response -> saveMovies(response))
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe(disposable -> {
                                isLoading.setValue(true);
                            })
                            .doOnTerminate(() -> {
                                isLoading.setValue(false);
                            })
                            .subscribe(response ->
                                            moviesLiveData.setValue(response.getMovies())
                                    , throwable -> {
                                        Log.i("LOG", "Error: " + throwable.getMessage());
                                    })

            );

        } else {

            disposable.add(
                    getDatabase(getApplication()).movieDAO().getAll()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe(disposable -> {
                                isLoading.setValue(true);
                            })
                            .doOnTerminate(() -> {
                                isLoading.setValue(false);
                            })
                            .subscribe(movies ->
                                            moviesLiveData.setValue(movies)
                                    , throwable -> {
                                        Log.i("LOG", "Error: " + throwable.getMessage());
                                    })

            );
        }
    }

    private MovieResponse saveMovies(MovieResponse response) {
        getDatabase(getApplication()).movieDAO().insert(response.getMovies());
        return response;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
