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
import br.com.digitalhouse.app.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.app.model.Person;

import java.util.List;

public class RecyclerViewPersonAdapter extends RecyclerView.Adapter<RecyclerViewPersonAdapter.ViewHolder> {

    // Lista de pessoas
    private List<Person> personList;
    // Evento de click
    private RecyclerViewOnItemClickListener listener;

    public RecyclerViewPersonAdapter(List<Person> personList, RecyclerViewOnItemClickListener listener) {
        this.personList = personList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_person_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Pego a pessoa na posição enviada
        final Person person = personList.get(position);

        //Preenche os dados da pessoa nas views
        holder.bind(person);

        //Seta a animação para cada item
        setAnimation(holder.itemView);

        // Vincula o evento de click do item e repassa para o listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Vinculamos o click no item
                listener.onItemClick(person);
            }
        });
    }

    // Set a animação em uma view
    private void setAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.bounce);
        animation.setDuration(1000);
        view.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos para usar no preenchimento de dados
        private TextView textViewName;
        private TextView textViewProfession;

        public ViewHolder(View itemView) {
            super(itemView);

            //Pega a refencia no XML
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewProfession = itemView.findViewById(R.id.textViewProfession);
        }

        // Preenche os dados da pessoa
        public void bind(Person person) {
            textViewName.setText(person.getName());
            textViewProfession.setText(person.getProfession());
        }
    }
}
