package br.com.digitalhouse.app.mob3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.app.mob3.R;
import br.com.digitalhouse.app.mob3.model.Person;

public class SpinnerAdapter extends BaseAdapter {

    private List<Person> people;

    public SpinnerAdapter(List<Person> people) {
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
        Person person = people.get(position);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_spinner, parent, false);
        TextView txtName = view.findViewById(R.id.textview_title);
        txtName.setText(person.getName());
        return view;
    }
}
