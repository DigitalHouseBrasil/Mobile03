package br.com.digitalhouse.mercadolivremvvm.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.model.MercadoLivreResponse;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.Observable;

public class MercadoLivreLocalRepository {

    public Observable<List<Result>> getLocalNews(Context context) {
        try {

            AssetManager assetManager = context.getAssets();
            InputStream newJson = assetManager.open("response.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(newJson));

            Gson gson = new Gson();

            MercadoLivreResponse newsResponse = gson.fromJson(bufferedReader, MercadoLivreResponse.class);

            return Observable.just(newsResponse.getResults());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
