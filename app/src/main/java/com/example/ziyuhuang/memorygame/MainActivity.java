package com.example.ziyuhuang.memorygame;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button playButton;
    Button rulesButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (Button) findViewById(R.id.play);
        rulesButton = (Button) findViewById(R.id.rules);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void rulesPage(View view){
//        Intent intent = new Intent(this, Rules.class);
//        startActivity(intent);
        textView.setVisibility(View.GONE);
        playButton.setVisibility(View.GONE);
        rulesButton.setVisibility(View.GONE);
        TestFragment fragment = new TestFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main,fragment, "rules_fragment");
        transaction.commit();
        
    }

    public void playPage(View view){
        Intent intent = new Intent(this,Play.class);
        startActivity(intent);
    }

}
