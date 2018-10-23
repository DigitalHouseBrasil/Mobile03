package br.com.digitalhouse.sqliteroom.data.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.digitalhouse.sqliteroom.model.Person;

@Dao
public interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Update()
    void update(Person person);

    @Delete
    void delete(Person person);

    @Query("SELECT * from person ORDER BY name ASC")
    LiveData<List<Person>> getAll();

    @Query("SELECT * from person WHERE id = :id")
    Person getByID(long id);

    @Query("SELECT * from person WHERE name = :name")
    Person getByName(String name);
}
