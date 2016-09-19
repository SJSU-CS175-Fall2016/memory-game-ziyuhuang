package com.example.ziyuhuang.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rulesPage(View view){
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }

    public void playPage(View view){
        Intent intent = new Intent(this,Play.class);
        startActivity(intent);
    }
}
