package umn.ac.id;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.LinkedList;


public class Library extends AppCompatActivity {
    RecyclerView rvDaftarMusic;
    DaftarMusicAdapter mAdapter;
    LinkedList<SumberMusic> daftarMusic = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        isiDaftarVideo();
        rvDaftarMusic = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarMusicAdapter(this, daftarMusic);
        rvDaftarMusic.setAdapter(mAdapter);
        rvDaftarMusic.setLayoutManager(new LinearLayoutManager(this));

        Intent getData = getIntent();
        String inputData = getData.getStringExtra("Input");
        ActionBar actionBar = getSupportActionBar();
        // providing title for the ActionBar
        actionBar.setTitle(inputData);
    }

    public void isiDaftarVideo() {
        daftarMusic.add(new SumberMusic("Cabs Pake Motor",
                "Cabs Pake Motor - Young lex",
                R.raw.cabspakemotor));
        daftarMusic.add(new SumberMusic("Feel Good Inc",
                "Feel Good Inc - Gorillaz",
                R.raw.feelgoodinc));
        daftarMusic.add(new SumberMusic("Kopi Dangdut",
                "Kopi Dangdut - Fahmi Sahab",
                R.raw.kopidangdut));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                Intent profileIntent = new Intent(Library.this,
                        Profile.class);
                startActivity(profileIntent);
                return true;
            case R.id.action_back:
                Intent homeIntent = new Intent(Library.this,
                        MainActivity.class);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}