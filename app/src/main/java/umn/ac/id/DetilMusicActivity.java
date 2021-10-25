package umn.ac.id;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetilMusicActivity extends AppCompatActivity {
    private TextView tvJudul;
    private TextView tvKeterangan;
    private EditText etUri;
    private Button btnKembali;
    MediaPlayer mediaPlayer;
    private Resources identifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_music);
        tvJudul = (TextView) findViewById(R.id.detilJudul);
        tvKeterangan = (TextView) findViewById(R.id.detilKeterangan);
        btnKembali = (Button) findViewById(R.id.btnBack);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberMusic sv = (SumberMusic) bundle.getSerializable(
                "DetilMusic");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(sv.getJudul());
        tvJudul.setText(sv.getJudul());
        tvKeterangan.setText(sv.getKeterangan());
        int ambilMusic = sv.getMusicURI();
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               identifier = getResources();
               int ambilIden = identifier.getIdentifier(String.valueOf(ambilMusic), "raw", getPackageName());
               mediaPlayer = MediaPlayer.create(getApplicationContext(), ambilIden);
               mediaPlayer.setOnCompletionListener(mediaPlayer1 -> stopMusic());
               mediaPlayer.start();
            }
        });
    }
        public void stopMusic(){
        mediaPlayer.release();
    }
        @Override
        public void onStop(){
        super.onStop();
        try {
            mediaPlayer.release();
        }catch (Exception e){
        }
    }
}
