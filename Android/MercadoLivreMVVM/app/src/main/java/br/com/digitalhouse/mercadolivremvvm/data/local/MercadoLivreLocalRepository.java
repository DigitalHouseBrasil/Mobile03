package br.com.digitalhouse.mercadolivremvvm.data.local;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.data.local.database.DatabaseRoom;
import br.com.digitalhouse.mercadolivremvvm.data.local.Dao.ResultsDao;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.Observable;

public class MercadoLivreLocalRepository {

    public Observable<List<Result>> getLocalResults(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        return Observable.just(resultsDao.getAll());
    }
}
