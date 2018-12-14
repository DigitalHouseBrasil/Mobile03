package digitalhouse.com.br.digitalhousekotlin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import digitalhouse.com.br.digitalhousekotlin.adapters.PersonAdapter
import digitalhouse.com.br.digitalhousekotlin.model.Person
import digitalhouse.com.br.digitalhousekotlin.model.Person2
import digitalhouse.com.br.digitalhousekotlin.util.jessicaLinda
import kotlinx.android.synthetic.main.activity_person.*

class PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        recyclerview_person.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerview_person.adapter = PersonAdapter(getListPerson(), this::clickItem)
    }

    private fun clickItem(person: Person) {
        Snackbar.make(recyclerview_person, "Nome da pessoa ${person.name}", Snackbar.LENGTH_SHORT).show()
    }

    private fun getListPerson(): List<Person> {
        val listPerson: MutableList<Person> = ArrayList()
        val listPerson2: MutableList<Person2> = ArrayList()

        for (i in 0..20) {
            listPerson.add(Person("Pessoa: $i ".jessicaLinda(), "Profissão: $i"))
            listPerson2.add(Person2("Pessoa: $i ".jessicaLinda(), "Profissão: $i"))
        }

        return listPerson
    }
}
