package br.com.digitalhouse.mercadolivremvvm.data.network;

import br.com.digitalhouse.mercadolivremvvm.model.MercadoLivreResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("sites/MLA/search")
    Observable<MercadoLivreResponse> searchItem(@Query("q") String item);
}

