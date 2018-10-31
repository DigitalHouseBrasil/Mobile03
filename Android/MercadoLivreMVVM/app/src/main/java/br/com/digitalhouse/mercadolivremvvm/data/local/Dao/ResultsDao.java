package br.com.digitalhouse.mercadolivremvvm.data.local.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.Observable;

@Dao
public interface ResultsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Result> results);

    @Update
    void update(Result result);

    @Delete
    void delete(Result result);

    @Query("Select * from result limit 30")
    List<Result> getAll();
}
