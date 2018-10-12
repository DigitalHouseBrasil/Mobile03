package br.com.digitalhouse.expandablecard.adapters;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.expandablecard.R;
import br.com.digitalhouse.expandablecard.model.ColearningDay;

public class ColearnigWeekRecyclerViewAdapter extends RecyclerView.Adapter<ColearnigWeekRecyclerViewAdapter.ViewHolder> {

    private List<ColearningDay> colearningDays;

    public ColearnigWeekRecyclerViewAdapter(List<ColearningDay> colearningDays) {
        this.colearningDays = colearningDays;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.colearning_week_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ColearningDay colearningDay = colearningDays.get(position);
        viewHolder.bind(colearningDay);
    }

    @Override
    public int getItemCount() {
        return colearningDays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private RecyclerView recyclerViewTeachers;
        private ImageView imageArrow;
        private TextView textviewWeek;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            recyclerViewTeachers = itemView.findViewById(R.id.recyclerview_teachers);
            imageArrow = itemView.findViewById(R.id.imageArrow);
            textviewWeek = itemView.findViewById(R.id.textview_week);
        }

        public void bind(ColearningDay colearningDay) {
            textviewWeek.setText(colearningDay.getTitle());

            TeacheRecyclerViewAdapter teacheRecyclerViewAdapter = new TeacheRecyclerViewAdapter(colearningDay.getTeachers());
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerViewTeachers.setLayoutManager(layoutManager);
            recyclerViewTeachers.setAdapter(teacheRecyclerViewAdapter);

            imageArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    collapseExpandTextView();
                }
            });
        }

        void collapseExpandTextView() {
            if (recyclerViewTeachers.getVisibility() == View.GONE) {
                // it's collapsed - expand it
                recyclerViewTeachers.setVisibility(View.VISIBLE);
                imageArrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            } else {
                // it's expanded - collapse it
                recyclerViewTeachers.setVisibility(View.GONE);
                imageArrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(cardView);
            }
        }
    }
}
