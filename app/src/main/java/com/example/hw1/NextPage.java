package com.example.hw1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class NextPage  extends AppCompatActivity {

    private Button btn_back_nothing,btn_keep;
    private TextView tv_number;
    private String sumItem,sumNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);
        btn_back_nothing = findViewById(R.id.btn_back_nothing);
        btn_keep=findViewById(R.id.btn_keep);
        tv_number = findViewById(R.id.tv_number);
        Intent intent = getIntent();
        sumItem = intent.getStringExtra("sumItem");
        sumNumber = intent.getStringExtra("sumNumber");
        tv_number.setText("你總共選了"+ sumNumber+"個項目");
        btn_back_nothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextPage.this, MainActivity.class);
                intent.putExtra("sumItem",sumItem);
                NextPage.this.setResult(RESULT_OK,intent);
                NextPage.this.finish();
//                startActivity(startChildActivityIntent);
            }
        });
    }


}
