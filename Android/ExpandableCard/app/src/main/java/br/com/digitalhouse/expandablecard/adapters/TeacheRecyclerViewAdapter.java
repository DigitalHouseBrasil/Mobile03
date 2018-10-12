package br.com.digitalhouse.expandablecard.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.expandablecard.R;
import br.com.digitalhouse.expandablecard.model.Teacher;

public class TeacheRecyclerViewAdapter extends RecyclerView.Adapter<TeacheRecyclerViewAdapter.ViewHolder> {

    private List<Teacher> teachers;

    public TeacheRecyclerViewAdapter(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.teacher_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Teacher teacher = teachers.get(position);
        viewHolder.bind(teacher);
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewLesson;
        private TextView textViewName;
        private TextView textViewTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLesson = itemView.findViewById(R.id.textview_lesson);
            textViewName = itemView.findViewById(R.id.textview_name);
            textViewTime = itemView.findViewById(R.id.textview_time);
        }

        public void bind(Teacher teacher){
            textViewLesson.setText(teacher.getLesson());
            textViewName.setText(teacher.getName());
            textViewTime.setText(teacher.getTime());
        }
    }
}
