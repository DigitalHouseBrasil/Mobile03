package br.com.digitalhouse.searchview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.searchview.R;
import br.com.digitalhouse.searchview.model.Person;

public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonRecyclerViewAdapter.ViewHolder> {

    private List<Person> personList;

    public PersonRecyclerViewAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewProfession;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circleImageView3);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewProfession = itemView.findViewById(R.id.textViewProfession);
        }

        public void bind(Person person) {
            Picasso.get()
                    .load(person.getImage())
                    .placeholder(R.drawable.android_image)
                    .error(android.R.drawable.stat_notify_error)
                    .into(imageView);
            textViewName.setText(person.getName());
            textViewProfession.setText(person.getProfession());
        }
    }

    public void update(List<Person> newList){
        personList = newList;
        notifyDataSetChanged();
    }
}
