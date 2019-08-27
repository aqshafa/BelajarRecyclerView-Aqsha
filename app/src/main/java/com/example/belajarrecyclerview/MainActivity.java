package com.example.belajarrecyclerview;

import android.content.Intent;
import android.location.SettingInjectorService;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    RecyclerView rvMain;
    Toolbar toolbar;
    ArrayList<ModelMovie> arrayList;
    private String[] id = {"1001", "Gunung", "Pantai"};
    private String[] judul = {"Seribu satu kisah di tanah Jawa", "Ini gunung", "Ini pantai"};
    private String[] subJudul = {"KOK OK", "Bukan sawah", "Buat berenang"};
    private int[] gambar = {R.drawable.download, R.drawable.downloada, R.drawable.downloadi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMain = findViewById(R.id.rvMain);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        arrayList = new ArrayList<>();
        setData();
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setHasFixedSize(true);
        movieAdapter = new MovieAdapter(arrayList);
        rvMain.setAdapter(movieAdapter);

    }

    private void setData(){
        int count = 0;
        for(String id : id){
            arrayList.add(new ModelMovie(id,judul[count],subJudul[count],gambar[count]));
            count++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        search(searchView);
        return true;
    }

    private void search(SearchView searchView){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.changeLanguage:
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
