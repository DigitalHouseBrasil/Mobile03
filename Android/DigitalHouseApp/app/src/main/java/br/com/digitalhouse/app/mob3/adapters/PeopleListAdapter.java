package br.com.digitalhouse.app.mob3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.app.mob3.R;
import br.com.digitalhouse.app.mob3.model.Person;

public class PeopleListAdapter extends BaseAdapter {

    //Contexto par aser usado ao inflar o layout
    private Context context;

    // Lista de pessoas
    private List<Person> people;

    //Contrutor para inicializar o adapter
    public PeopleListAdapter(Context context, List<Person> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Infla o layout do list_item
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        //Pega a referencia das views para usa-las
        TextView textViewTitle = view.findViewById(R.id.textview_title);
        TextView textViewSubTitle = view.findViewById(R.id.textview_subtitle);

        // Captura a pessoa da posição
        Person person = people.get(position);

        // Seta os dados da pessoa  na view
        textViewTitle.setText(person.getName());
        textViewSubTitle.setText(person.getProfession());

        //Retorna a view preenchida
        return view;
    }
}
