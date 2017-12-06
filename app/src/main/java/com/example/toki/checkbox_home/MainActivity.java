package com.example.toki.checkbox_home;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
        Button Stop,Start,Reset;
        CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24;
        EditText editText;
        String name,time;
        ArrayList<String> counter;

        private Timer timer;
        private long count=0;
        Handler handler=new Handler();

        DatabaseHelper databaseHelper;

        private InputMethodManager inputMethodManager;
        private LinearLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        c1 = findViewById(R.id.check1);
        c2 = findViewById(R.id.check2);
        c3 = findViewById(R.id.check3);
        c4 = findViewById(R.id.check4);
        c5 = findViewById(R.id.check5);
        c6 = findViewById(R.id.check6);
        c7 = findViewById(R.id.check7);
        c8 = findViewById(R.id.check8);
        c9 = findViewById(R.id.check9);
        c10 = findViewById(R.id.check10);
        c11 = findViewById(R.id.check11);
        c12 = findViewById(R.id.check12);
        c13 = findViewById(R.id.check13);
        c14 = findViewById(R.id.check14);
        c15 = findViewById(R.id.check15);
        c16 = findViewById(R.id.check16);
        c17 = findViewById(R.id.check17);
        c18 = findViewById(R.id.check18);
        c19 = findViewById(R.id.check19);
        c20 = findViewById(R.id.check20);
        c21 = findViewById(R.id.check21);
        c22 = findViewById(R.id.check22);
        c23 = findViewById(R.id.check23);
        c24 = findViewById(R.id.check24);

        Stop = findViewById(R.id.stop);
        Start = findViewById(R.id.start);
        Reset = findViewById(R.id.reset);

        editText = findViewById(R.id.name);
        mainlayout = findViewById(R.id.mainlayout);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        counter = new ArrayList<>();

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                count = 0;
                editText.setText("00:00.00");
                c1.setChecked(false);
                c5.setChecked(false);
                c9.setChecked(false);
                c13.setChecked(false);
                c16.setChecked(false);
                c19.setChecked(false);
                c22.setChecked(false);
                c2.setChecked(false);
                c6.setChecked(false);
                c10.setChecked(false);
                c14.setChecked(false);
                c17.setChecked(false);
                c20.setChecked(false);
                c23.setChecked(false);
                c3.setChecked(false);
                c7.setChecked(false);
                c11.setChecked(false);
                c15.setChecked(false);
                c18.setChecked(false);
                c21.setChecked(false);
                c24.setChecked(false);
                c4.setChecked(false);
                c8.setChecked(false);
                c12.setChecked(false);

            }
        });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                long mm = count * 10 / 1000 / 60;
                                long ss = count * 10 / 1000 % 60;
                                long ms = (count * 10 - ss * 1000 - mm * 1000 * 60) / 10;
                                editText.setText(String.format("%1$02d:%2$02d.%3$02d", mm, ss, ms));
                            }
                        });

                    }
                }, 0, 10);
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c1.isChecked()) {
                    counter.add("counter");
                }
                if (c2.isChecked()) {
                    counter.add("counter");
                }
                if (c3.isChecked()) {
                    counter.add("counter");
                }
                if (c4.isChecked()) {
                    counter.add("counter");
                }
                if (c5.isChecked()) {
                    counter.add("counter");
                }
                if (c6.isChecked()) {
                    counter.add("counter");
                }
                if (c7.isChecked()) {
                    counter.add("counter");
                }
                if (c8.isChecked()) {
                    counter.add("counter");
                }
                if (c9.isChecked()) {
                    counter.add("counter");
                }
                if (c10.isChecked()) {
                    counter.add("counter");
                }
                if (c11.isChecked()) {
                    counter.add("counter");
                }
                if (c12.isChecked()) {
                    counter.add("counter");
                }
                if (c13.isChecked()) {
                    counter.add("counter");
                }
                if (c14.isChecked()) {
                    counter.add("counter");
                }
                if (c15.isChecked()) {
                    counter.add("counter");
                }
                if (c16.isChecked()) {
                    counter.add("counter");
                }
                if (c17.isChecked()) {
                    counter.add("counter");
                }
                if (c18.isChecked()) {
                    counter.add("counter");
                }
                if (c19.isChecked()) {
                    counter.add("counter");
                }
                if (c20.isChecked()) {
                    counter.add("counter");
                }
                if (c21.isChecked()) {
                    counter.add("counter");
                }
                if (c22.isChecked()) {
                    counter.add("counter");
                }
                if (c23.isChecked()) {
                    counter.add("counter");
                }
                if (c24.isChecked()) {
                    counter.add("counter");
                }

                if (counter.size() == 24) {
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                        time = editText.getText().toString();
                    }
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    Toast.makeText(MainActivity.this, "here id the results", Toast.LENGTH_SHORT).show();
                    intent.putExtra("toki", name);
                    intent.putExtra("abhi", time);
                    intent.putExtra("sinzi", count);
                    startActivity(intent);
                    databaseHelper.insert(name, count, time);


                } else {
                    Toast.makeText(MainActivity.this, "FILL ALL THE CHECK BOX", Toast.LENGTH_SHORT).show();
                    counter.clear();
                }

            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        inputMethodManager.hideSoftInputFromInputMethod(mainlayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        mainlayout.requestFocus();
        return false;

    }
}
