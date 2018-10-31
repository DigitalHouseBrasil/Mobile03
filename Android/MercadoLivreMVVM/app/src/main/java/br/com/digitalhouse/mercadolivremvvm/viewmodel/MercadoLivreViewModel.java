package br.com.digitalhouse.mercadolivremvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.data.local.MercadoLivreLocalRepository;
import br.com.digitalhouse.mercadolivremvvm.data.local.database.DatabaseRoom;
import br.com.digitalhouse.mercadolivremvvm.data.network.MercadoLivreRemoteRepository;
import br.com.digitalhouse.mercadolivremvvm.data.local.Dao.ResultsDao;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.mercadolivremvvm.util.AppUtil.isNetworkConnected;

public class MercadoLivreViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public MercadoLivreViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getResultLiveData() {
        return resultLiveData;
    }

    public void searchItem(String item) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(item);
        } else {
            getFromLocal();
        }
    }

    private void getFromLocal() {
        MercadoLivreLocalRepository localRepository = new MercadoLivreLocalRepository();

        disposable.add(localRepository.getLocalResults(getApplication().getApplicationContext())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    resultLiveData.setValue(results);
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    private void getFromNetwork(String item) {
        MercadoLivreRemoteRepository remoteRepository = new MercadoLivreRemoteRepository();

        disposable.add(remoteRepository.searchItems(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsResponse -> {

                    new Thread(() -> {
                        DatabaseRoom room = DatabaseRoom.getDatabase(getApplication());
                        ResultsDao resultsDao = room.resultsDAO();
                        resultsDao.insert(newsResponse.getResults());
                    }).start();

                    resultLiveData.setValue(newsResponse.getResults());
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
