package com.example.toki.checkbox_home;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView Name,Time,scoreN,scoreT;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        databaseHelper=new DatabaseHelper(this);
        Name=findViewById(R.id.name);
        Time=findViewById(R.id.time);
        scoreN=findViewById(R.id.recodeName);
        scoreT=findViewById(R.id.recodeTime);
        button=findViewById(R.id.btnback);

        Name.setText(getIntent().getStringExtra("toki"));
        Time.setText(getIntent().getStringExtra("abhi"));

        cursor=databaseHelper.show();
        if(cursor!=null){
            cursor.moveToFirst();
            do{
                String n=cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String t=cursor.getString(cursor.getColumnIndexOrThrow("time"));
                scoreN.append(n+"\n");
                scoreT.append(t+"\n");
            }while (cursor.moveToNext());
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
//                databaseHelper.erase();
            }
        });
    }

}
