package br.com.digitalhouse.moviemvvm.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.moviemvvm.R;
import br.com.digitalhouse.moviemvvm.model.Movie;

public class RecyclerViewMovieAdapter extends RecyclerView.Adapter<RecyclerViewMovieAdapter.ViewHolder> {

    private List<Movie> movies;

    public RecyclerViewMovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar(popular)
        LayoutInflater view = LayoutInflater.from(parent.getContext());
        return new ViewHolder(view.inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //setar os dados com a view
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        //verificar se o movies já tem informação
        if (movies.size() == 0) {
            this.movies = movies;
        } else {
            this.movies.addAll(movies);
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.textViewTitle);
            this.txtDescription = itemView.findViewById(R.id.textViewDescription);
            this.imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(Movie movie) {
            this.txtTitle.setText(movie.getTitle());
            this.txtDescription.setText(movie.getOverview());

            // Carrega a imagem do filme com a lib do Picasso
            Picasso.get().load("http://image.tmdb.org/t/p/w500/" + movie.getPosterPath()).into(imageView);
        }
    }
}

