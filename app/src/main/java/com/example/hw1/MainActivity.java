package com.example.hw1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;
    private myAdapter mAdapter;
    private RecyclerView mNumbersList;
    private Button btn_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbersList =findViewById(R.id.rv_numbers);
        btn_check = findViewById(R.id.btn_check);
        mNumbersList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mAdapter = new myAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> sumItem = mAdapter.sumNumber();
                String sumNumber = String.valueOf(sumItem.size());
                Context context = MainActivity.this;
                Class destinationActivity = NextPage.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startChildActivityIntent.putExtra("sumNumber",sumNumber);
                startChildActivityIntent.putExtra("sumItem",sumItem);
//                startActivity(startChildActivityIntent);
                startActivityForResult(startChildActivityIntent,1);
            }
        });
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK){
//            if (data.getStringExtra("sumItem") != null){
//                String result = data.getStringExtra("sumItem");
//                Log.d("result",result);
//            }
//        }
    }
}


