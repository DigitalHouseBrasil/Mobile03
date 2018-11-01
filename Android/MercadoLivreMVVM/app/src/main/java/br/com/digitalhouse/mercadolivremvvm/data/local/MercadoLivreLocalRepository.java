package br.com.digitalhouse.mercadolivremvvm.data.local;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.data.local.Dao.ResultsDao;
import br.com.digitalhouse.mercadolivremvvm.data.local.database.DatabaseRoom;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.Flowable;

public class MercadoLivreLocalRepository {

    // Pega os dados da base de dados
    public Flowable<List<Result>> getLocalResults(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        return resultsDao.getAll();
    }

    // Insere uma lista reults na base de dados
    public void insertItems(Context context, List<Result> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        resultsDao.insert(items);
    }
}
