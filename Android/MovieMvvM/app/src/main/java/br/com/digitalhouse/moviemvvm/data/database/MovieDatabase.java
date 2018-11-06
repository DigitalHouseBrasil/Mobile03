package br.com.digitalhouse.moviemvvm.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.digitalhouse.moviemvvm.interfaces.MovieDao;
import br.com.digitalhouse.moviemvvm.model.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDAO();

    private static volatile MovieDatabase INSTANCE;

    public static MovieDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase.class, "movie_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
