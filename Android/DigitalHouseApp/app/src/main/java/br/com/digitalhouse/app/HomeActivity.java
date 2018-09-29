package br.com.digitalhouse.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.digitalhouse.app.fragments.CommentsFragment;
import br.com.digitalhouse.app.fragments.PeopleFragment;
import br.com.digitalhouse.app.fragments.PostsFragment;
import br.com.digitalhouse.app.interfaces.ClickFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ClickFragment {

    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inicializa as vieww que serão usadas
        initViews();

        // Configura a toolbar na tela
        setSupportActionBar(toolbar);

        // Configura o drawer layout na toolbar
        configDrawerLayout(toolbar);

        replaceFragment(new PeopleFragment());

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
    }

    private void configDrawerLayout(Toolbar toolbar) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        //Se o Drawer estiver aberto fechamos ele, senão proseguimos com o click no back button
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    // manipulamos os eventod de click nos itens do menu do Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //pegamos o Id do item clicado para fazer-mos a validação
        int id = item.getItemId();

        // Se clicou no POSTS adicionamos o fragment de POSTS
        if (id == R.id.nav_posts) {
            replaceFragment(new PostsFragment());

            // Se clicou no COMMENTS adicionamos o fragment de Comments
        } else if (id == R.id.nav_commets) {
            replaceFragment(new CommentsFragment());

            // Se clicou no PEOPLE adicionamos o fragment de PeopleFragment
        } else if (id == R.id.nav_people) {
            replaceFragment(new PeopleFragment());
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // Adiciona um fragment no lugar do container
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack("Frag");
        transaction.commit();
    }

    @Override
    public void onClickButton(String message) {
        CommentsFragment fragment = new CommentsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("VALUE", message);
        replaceFragment(fragment);
    }
}
