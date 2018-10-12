package br.com.digitalhouse.expandablecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.expandablecard.adapters.ColearnigWeekRecyclerViewAdapter;
import br.com.digitalhouse.expandablecard.model.ColearningDay;
import br.com.digitalhouse.expandablecard.model.Teacher;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_colearnig_week);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ColearnigWeekRecyclerViewAdapter adapter = new ColearnigWeekRecyclerViewAdapter(getColearnigDays());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<ColearningDay> getColearnigDays() {

        List<ColearningDay> colearningDays = new ArrayList<>();
        List<Teacher> teachersMonday = new ArrayList<>();
        teachersMonday.add(new Teacher("Jessica", "14hs - 16hs", "Mobile Android"));
        teachersMonday.add(new Teacher("Guilherme", "16hs - 18hs", "Mobile Android"));

        colearningDays.add(new ColearningDay("Segunda",teachersMonday ));
        colearningDays.add(new ColearningDay("Terça",teachersMonday ));
        colearningDays.add(new ColearningDay("Quarta",teachersMonday ));
        colearningDays.add(new ColearningDay("Quinta",teachersMonday ));
        colearningDays.add(new ColearningDay("Sexta",teachersMonday ));

        return colearningDays;
    }
}
