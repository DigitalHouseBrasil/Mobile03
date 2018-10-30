package br.com.digitalhouse.mercadolivremvvm.data.network;

import br.com.digitalhouse.mercadolivremvvm.model.MercadoLivreResponse;
import io.reactivex.Observable;

public class MercadoLivreRemoteRepository {

    public Observable<MercadoLivreResponse> searchItems(String item) {
        return RetrofitService.getApiService().searchItem(item);
    }
}
