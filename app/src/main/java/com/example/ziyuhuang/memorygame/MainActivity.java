package com.example.ziyuhuang.memorygame;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.play) Button playButton;
    @BindView(R.id.rules) Button rulesButton;
    @BindView(R.id.textView) TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void rulesPage(View view){

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
