package br.com.digitalhouse.mercadolivremvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.data.local.MercadoLivreLocalRepository;
import br.com.digitalhouse.mercadolivremvvm.data.network.MercadoLivreRemoteRepository;
import br.com.digitalhouse.mercadolivremvvm.model.MercadoLivreResponse;
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

    // Ao buscar o item verificamos se estamos conectados ou não
    public void searchItem(String item) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(item);
        } else {
            getFromLocal();
        }
    }

    private void getFromLocal() {
        MercadoLivreLocalRepository localRepository = new MercadoLivreLocalRepository();

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel
        disposable.add(localRepository.getLocalResults(getApplication().getApplicationContext())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    // Chegou aqui então alteramos o live data, assim a View que está observando ele pode atualizar a tela
                    resultLiveData.setValue(results);
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    private void getFromNetwork(String item) {
        MercadoLivreRemoteRepository remoteRepository = new MercadoLivreRemoteRepository();

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel
        disposable.add(remoteRepository.searchItems(item)
                .subscribeOn(Schedulers.newThread())
                .map(this::saveItems) //  Como estamos em background podemos ja salvar os items
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsResponse -> {

                    // Chegou aqui então alteramos o live data, assim a View que está observando ele pode atualizar a tela
                    resultLiveData.setValue(newsResponse.getResults());
                }, throwable -> {
                    // Se deu erro mostramos o log
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    public MercadoLivreResponse saveItems(MercadoLivreResponse mercadoLivreResponse) {
        //Pegamos ums instancia do repositório
        MercadoLivreLocalRepository localRepository = new MercadoLivreLocalRepository();

        // Salvamos no banco de dados os dados que buscamos na api
        localRepository.insertItems(getApplication(), mercadoLivreResponse.getResults());

        // Retornamos o que a api nos mandouo para continuarmos como stream do RX
        return mercadoLivreResponse;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
