package br.com.digitalhouse.app.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import br.com.digitalhouse.app.R;
import br.com.digitalhouse.app.model.Person;

import java.util.List;

public class RecyclerViewPersonAdapter extends RecyclerView.Adapter<RecyclerViewPersonAdapter.ViewHolder> {

    private List<Person> personList;

    public RecyclerViewPersonAdapter(List<Person> personList) {
        this.personList = personList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_person_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.bind(person);
        setAnimation(holder.itemView);
        }

    private void setAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewProfession;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewProfession = itemView.findViewById(R.id.textViewProfession);
        }

        public void bind(Person person) {
            textViewName.setText((person.getName()));
            textViewProfession.setText(person.getProfession());
        }
    }
}
