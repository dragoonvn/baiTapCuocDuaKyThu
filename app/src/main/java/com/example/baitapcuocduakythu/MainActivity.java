package com.example.baitapcuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        txtDiem.setText(soDiem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                skOne.setProgress(skOne.getProgress() + getRandom(5));
                skTwo.setProgress(skTwo.getProgress() + getRandom(5));
                skThree.setProgress(skThree.getProgress() + getRandom(5));
            }

            @Override
            public void onFinish() {
                if (skOne.getProgress() >= skOne.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Xe 1 hạng I", Toast.LENGTH_SHORT).show();
                    if (cbOne.isChecked()) {
                        if (soDiem < 100) {
                            soDiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán đúng được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai bị trừ 10 điểm", Toast.LENGTH_SHORT).show();

                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                    return;
                } else if (skTwo.getProgress() >= skTwo.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Xe 2 hạng I", Toast.LENGTH_SHORT).show();
                    if (cbTwo.isChecked()) {
                        if (soDiem < 100) {
                            soDiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán đúng được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai bị trừ 10 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                    return;
                } else if (skThree.getProgress() >= skThree.getMax()) {
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Xe 3 hạng I", Toast.LENGTH_SHORT).show();
                    if (cbThree.isChecked()) {
                        if (soDiem < 100) {
                            soDiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán đúng được cộng 10 điểm", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai bị trừ 10 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                    return;
                }
                this.start();
            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisableCheckBox();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn 1 xe", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });

    }

    private int getRandom(int bound) {
        return new Random().nextInt(bound);
    }

    private void EnableCheckBox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisableCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void AnhXa() {
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        cbOne = findViewById(R.id.checkboxOne);
        cbTwo = findViewById(R.id.checkboxTwo);
        cbThree = findViewById(R.id.checkboxThree);
        txtDiem = findViewById(R.id.textviewDiem);
        ibtnPlay = findViewById(R.id.imgbuttonPlay);
    }

}
