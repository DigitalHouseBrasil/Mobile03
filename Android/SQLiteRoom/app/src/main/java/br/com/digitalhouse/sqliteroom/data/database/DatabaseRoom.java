package br.com.digitalhouse.sqliteroom.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.digitalhouse.sqliteroom.data.Dao.PersonDAO;
import br.com.digitalhouse.sqliteroom.model.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class DatabaseRoom extends RoomDatabase {
    public abstract PersonDAO personDAO();
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
