package digitalhouse.com.br.digitalhousekotlin.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import digitalhouse.com.br.digitalhousekotlin.R
import digitalhouse.com.br.digitalhousekotlin.model.Person

class PersonAdapter(val listPerson: List<Person>, val clickItem: (person: Person) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = listPerson[position]
        holder.bind(person)

        holder.itemView.setOnClickListener {
            clickItem(person)
        }
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.textview_name)

        fun bind(person: Person) {
            txtName.text = person.name
        }
    }
}