package br.com.digitalhouse.mercadolivremvvm.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.digitalhouse.mercadolivremvvm.data.local.Dao.ResultsDao;
import br.com.digitalhouse.mercadolivremvvm.model.Result;

@Database(entities = {Result.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DatabaseRoom extends RoomDatabase {

    public abstract ResultsDao resultsDAO();

    private static volatile DatabaseRoom INSTANCE;

    public static DatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseRoom.class, "sqlite_room_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
