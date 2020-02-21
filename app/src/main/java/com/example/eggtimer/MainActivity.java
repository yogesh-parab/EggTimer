package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar s1;
    TextView t1;
    Button b1;
    int mili=30000;
    boolean isStarted=false;
    CountDownTimer hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=findViewById(R.id.seekBar2);
        t1=findViewById(R.id.textView2);
        b1=findViewById(R.id.button2);
        t1.setText("00:30");
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mili=progress;
                t1.setText(((progress/1000)/60)+":"+(progress/1000)%60);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void start(View view)
    {
        if(isStarted){
            b1.setText("START");
            isStarted=false;
            hello.cancel();
            s1.setEnabled(true);
            mili=30000;
            t1.setText("00:30");

        }
        else {
            hello=new CountDownTimer(mili, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    t1.setText(((millisUntilFinished / 1000) / 60) + ":" + (millisUntilFinished / 1000) % 60);
                }

                @Override
                public void onFinish() {
                    s1.setEnabled(true);
                    MediaPlayer m1 = MediaPlayer.create(getApplicationContext(), R.raw.laugh);
                    m1.start();

                }
            }.start();

            s1.setEnabled(false);
            isStarted = true;
            b1.setText("STOP!");
        }


    }}
