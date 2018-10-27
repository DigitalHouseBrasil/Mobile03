package br.com.digitalhouse.json;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.json.adapters.RecyclerViewNewsAdapter;
import br.com.digitalhouse.json.model.News;
import br.com.digitalhouse.json.model.NewsResponse;

public class MainActivity extends AppCompatActivity {

    private List<News> newsList = new ArrayList<>();
    private RecyclerViewNewsAdapter adapter;
    private RecyclerView recyclerView;
    private Button btnGetNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        btnGetNews = findViewById(R.id.btn_get_news);

        adapter = new RecyclerViewNewsAdapter(newsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnGetNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    AssetManager assetManager = getAssets();
                    InputStream newJson = assetManager.open("news.json");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(newJson));

                    Gson gson = new Gson();

                    NewsResponse newsResponse = gson.fromJson(bufferedReader, NewsResponse.class);

                    adapter.update(newsResponse.getNewsList());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
