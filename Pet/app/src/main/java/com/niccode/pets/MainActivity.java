package com.niccode.pets;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.niccode.pets.adaptador.PageAdapter;
import com.niccode.pets.fragments.Fg_principal;
import com.niccode.pets.fragments.grid;
import com.niccode.pets.menu.Bio;
import com.niccode.pets.menu.contacto;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    private Toolbar     toolbar;
    private TabLayout   tabLayout;
    private ViewPager   viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setViewPager();


        if(toolbar !=   null ){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fg_principal());
        fragments.add(new grid());
        return fragments;
    }
    private void setViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gato);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_gato_coco);


    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorite:
                Intent i = new Intent(this, Favorites.class);
                startActivity(i);
                return true;

            case R.id.contacto:
                Intent i1 = new Intent(MainActivity.this, contacto.class);
                startActivity(i1);
                finish();
                return true;


            case R.id.about:
                Intent i2 = new Intent(MainActivity.this, Bio.class);
                startActivity(i2);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.file, menu);
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }


}