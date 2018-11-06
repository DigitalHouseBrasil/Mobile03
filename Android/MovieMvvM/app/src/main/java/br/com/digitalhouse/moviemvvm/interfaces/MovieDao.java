package br.com.digitalhouse.moviemvvm.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.moviemvvm.model.Movie;
import io.reactivex.Flowable;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Movie> movies);

    @Update
    void update(Movie movie);

    @Delete
    void delete(Movie movie);

    @Query("Select * from movie limit 30")
    Flowable<List<Movie>> getAll(); // Flowable é um observavel que podemos usar com RoomDatabase
}
