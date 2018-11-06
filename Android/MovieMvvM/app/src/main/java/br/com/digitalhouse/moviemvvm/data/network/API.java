package br.com.digitalhouse.moviemvvm.data.network;

import br.com.digitalhouse.moviemvvm.model.MovieResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    // Buscar uma lista de filmes de uma categoria
    @GET("movie/{category}")
    Observable<MovieResponse> getMovies(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page,
            @Query("origin") String origin
    );
}
