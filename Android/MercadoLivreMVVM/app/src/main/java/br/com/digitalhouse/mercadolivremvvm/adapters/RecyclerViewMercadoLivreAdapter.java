package br.com.digitalhouse.mercadolivremvvm.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.R;
import br.com.digitalhouse.mercadolivremvvm.model.Result;

public class RecyclerViewMercadoLivreAdapter extends RecyclerView.Adapter<RecyclerViewMercadoLivreAdapter.ViewHolder> {

    private List<Result> newsList;

    public RecyclerViewMercadoLivreAdapter(List<Result> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result results = newsList.get(position);
        holder.bind(results);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescripotion);
        }

        public void bind(Result result) {
            textViewTitle.setText(result.getTitle());
            textViewDescription.setText(result.getAddress().getStateName());
        }
    }

    public void update(List<Result> results) {
        this.newsList = results;
        notifyDataSetChanged();
    }
}

