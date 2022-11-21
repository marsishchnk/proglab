package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayerdog, mPlayercat, mPlayerbird;
    ImageButton dogbutton, catbutton, birdbutton;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayerdog= MediaPlayer.create(this, R.raw.gav);
        mPlayercat= MediaPlayer.create(this, R.raw.miau);
        mPlayerbird= MediaPlayer.create(this, R.raw.tsvirin);

        mPlayerdog.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        mPlayercat.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        mPlayerbird.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        dogbutton = findViewById(R.id.dogbutton);
        catbutton = findViewById(R.id.catbutton);
        birdbutton = findViewById(R.id.birdbutton);
        dogbutton.setEnabled(true);
        catbutton.setEnabled(true);
        birdbutton.setEnabled(true);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    private void stopPlay(){
        mPlayerdog.stop();
        mPlayercat.stop();
        mPlayerbird.stop();
        try {
            mPlayerdog.prepare();
            mPlayercat.prepare();
            mPlayerbird.prepare();
            mPlayerdog.seekTo(0);
            mPlayercat.seekTo(0);
            mPlayerbird.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void playcat(View view){
        mPlayercat.start();
    }
    public void playdog(View view){
        mPlayerdog.start();
    }
    public void playbird(View view){
        mPlayerbird.start();
    }
}