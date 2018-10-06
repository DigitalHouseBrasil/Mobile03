package br.com.digitalhouse.pageview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.pageview.adapters.PhotoPageAdapter;
import br.com.digitalhouse.pageview.fragments.PhotoFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayoutCategories;
    private LinearLayout linearLayoutDestaques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        linearLayoutCategories = findViewById(R.id.linearCategories);
        linearLayoutDestaques = findViewById(R.id.linearDestaques);

        List<Fragment> fragments = getFragments();

        PhotoPageAdapter pageAdapter = new PhotoPageAdapter(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(pageAdapter);

        for (int i = 0; i < 3; i++) {
            setTextToContainer(linearLayoutCategories, "Texto para a categoria " + i);
        }

        for (int i = 0; i < 3; i++) {
            setTextToContainer(linearLayoutDestaques, "Texto Para o destaque " + i);
        }

    }

    public void setTextToContainer(LinearLayout container, String message) {
        View layout = getLayoutInflater().inflate(R.layout.category_item, null);
        TextView item = layout.findViewById(R.id.category_item_name);
        item.setText(message);

        container.addView(layout);
    }

    @NonNull
    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        Fragment fragment = PhotoFragment.newInstance(R.drawable.android_image_2, "Meu texto para imagem 2");

        fragments.add(fragment);
        fragments.add(PhotoFragment.newInstance(R.drawable.android_image_1, "Meu texto para imagem 1"));
        fragments.add(PhotoFragment.newInstance(R.mipmap.ic_launcher, "Meu texto para imagem 3"));
        return fragments;
    }
}
