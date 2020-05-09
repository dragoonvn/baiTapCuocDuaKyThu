package com.example.baitapcuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    ImageButton ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        final CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                skOne.setProgress(skOne.getProgress() + getRandom(10));
                skTwo.setProgress(skTwo.getProgress() + getRandom(10));
                skThree.setProgress(skThree.getProgress() + getRandom(10));
            }
            @Override
            public void onFinish() {
                if (skOne.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, "Xe 1 hạng I", Toast.LENGTH_SHORT).show();
                    return;
                } else if (skTwo.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, "Xe 2 hạng I", Toast.LENGTH_SHORT).show();
                    return;
                } else if (skThree.getProgress() >= 100) {
                    Toast.makeText(MainActivity.this, "Xe 3 hạng I", Toast.LENGTH_SHORT).show();
                    return;
                }
               this.start();
            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });

    }
    private int getRandom(int bound) {
        return new Random().nextInt(bound);
    }
    private void AnhXa() {
        skOne       = findViewById(R.id.seekbarOne);
        skTwo       = findViewById(R.id.seekbarTwo);
        skThree     = findViewById(R.id.seekbarThree);
        cbOne       = findViewById(R.id.checkboxOne);
        cbTwo       = findViewById(R.id.checkboxTwo);
        cbThree     = findViewById(R.id.checkboxThree);
        txtDiem     = findViewById(R.id.textviewDiem);
        ibtnPlay    = findViewById(R.id.imgbuttonPlay);
    }

}
