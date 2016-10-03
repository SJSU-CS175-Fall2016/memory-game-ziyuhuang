package com.example.ziyuhuang.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import butterknife.BindDrawable;
import butterknife.BindView;

public class Play extends AppCompatActivity {

    class Pair{
        ImageButton pre_button;
        int button_location;

        Pair(ImageButton btn, int location){
            pre_button = btn;
            button_location = location;
        }
    }

    ArrayList<Integer> images;
    ArrayList<Integer> btn_list = new ArrayList<>();
    Pair pre_btn;
//    ImageButton pre_button;

    //count if if two button are flip
    int count = 0;

    //record the amounts of images are gone.
    int image_gone_counter;

    //list to store the matched pictures
    ArrayList<Integer> list;

    //store 20 image buttons
    ImageButton[] btns;


    //points to record how many pairs of image matches
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        btns = new ImageButton[20];
        images = new ArrayList<>();
        image_gone_counter = 0;
        loadImages();
        getImagesToButton();

        for(int i = 0; i < 20; i++){
            Log.v("id", btn_list.get(i).toString());
        }

        pre_btn = null;


//        map = new HashMap<>();
        list = new ArrayList<>();
        
        btns[0] = (ImageButton) findViewById(R.id.imageButton1);
        btns[1] = (ImageButton) findViewById(R.id.imageButton2);
        btns[2] = (ImageButton) findViewById(R.id.imageButton3);
        btns[3] = (ImageButton) findViewById(R.id.imageButton4);
        btns[4] = (ImageButton) findViewById(R.id.imageButton5);
        btns[5] = (ImageButton) findViewById(R.id.imageButton6);
        btns[6] = (ImageButton) findViewById(R.id.imageButton7);
        btns[7] = (ImageButton) findViewById(R.id.imageButton8);
        btns[8] = (ImageButton) findViewById(R.id.imageButton9);
        btns[9] = (ImageButton) findViewById(R.id.imageButton10);
        btns[10] = (ImageButton) findViewById(R.id.imageButton11);
        btns[11] = (ImageButton) findViewById(R.id.imageButton12);
        btns[12] = (ImageButton) findViewById(R.id.imageButton13);
        btns[13] = (ImageButton) findViewById(R.id.imageButton14);
        btns[14] = (ImageButton) findViewById(R.id.imageButton15);
        btns[15] = (ImageButton) findViewById(R.id.imageButton16);
        btns[16] = (ImageButton) findViewById(R.id.imageButton17);
        btns[17] = (ImageButton) findViewById(R.id.imageButton18);
        btns[18] = (ImageButton) findViewById(R.id.imageButton19);
        btns[19] = (ImageButton) findViewById(R.id.imageButton20);

        for (int i = 0; i < 20; i++) {
            btns[i].setVisibility(View.VISIBLE);
        }
    }

    public void check(String str) {
        String btnNum = str.substring(11);
        int btn_num = Integer.parseInt(btnNum) - 1;
        btns[btn_num].setImageResource(btn_list.get(btn_num));
        Log.v("button is pressed", String.valueOf(btn_num));
        btns[btn_num].setTag(btn_list.get(btn_num));

        if (pre_btn == null || btns[btn_num] != pre_btn.pre_button)
            count++;
        if (count == 1) {
            pre_btn = new Pair(btns[btn_num], btn_num);
            YoYo.with(Techniques.Wobble)
                    .duration(2000)
                    .playOn(btns[btn_num]);
        }
        if (count == 2) {
            count = 0;
            if (btns[btn_num].getTag().equals(pre_btn.pre_button.getTag())) {
                YoYo.with(Techniques.Wobble)
                        .duration(2000)
                        .playOn(btns[btn_num]);
                btns[btn_num].setVisibility(View.INVISIBLE);
                pre_btn.pre_button.setVisibility(View.INVISIBLE);

                list.add(btn_list.get(btn_num));
                list.add(btn_list.get(pre_btn.button_location));

                image_gone_counter += 2;
                points++;
                updatePoints();
            } else {
                btns[btn_num].setImageResource(R.drawable.cover);
                YoYo.with(Techniques.Wobble)
                        .duration(2000)
                        .playOn(btns[btn_num]);
                pre_btn.pre_button.setImageResource(R.drawable.cover);
                pre_btn.pre_button = null;
            }
        }
    }

    public void updatePoints() {
        TextView tv = (TextView) findViewById(R.id.points);
        tv.setText(String.valueOf(points));
    }

    public void onClick(View view) {
        String str = "";
        switch (view.getId()) {
            case R.id.imageButton1:
                str = getResources().getResourceEntryName(R.id.imageButton1);
                check(str);
                break;
            case R.id.imageButton2:
                str = getResources().getResourceEntryName(R.id.imageButton2);
                check(str);
                break;
            case R.id.imageButton3:
                str = getResources().getResourceEntryName(R.id.imageButton3);
                check(str);
                break;

            case R.id.imageButton4:
                str = getResources().getResourceEntryName(R.id.imageButton4);
                check(str);
                break;

            case R.id.imageButton5:
                str = getResources().getResourceEntryName(R.id.imageButton5);
                check(str);
                break;

            case R.id.imageButton6:
                str = getResources().getResourceEntryName(R.id.imageButton6);
                check(str);
                break;

            case R.id.imageButton7:
                str = getResources().getResourceEntryName(R.id.imageButton7);
                check(str);
                break;

            case R.id.imageButton8:
                str = getResources().getResourceEntryName(R.id.imageButton8);
                check(str);
                break;

            case R.id.imageButton9:
                str = getResources().getResourceEntryName(R.id.imageButton9);
                check(str);
                break;

            case R.id.imageButton10:
                str = getResources().getResourceEntryName(R.id.imageButton10);
                check(str);
                break;

            case R.id.imageButton11:
                str = getResources().getResourceEntryName(R.id.imageButton11);
                check(str);
                break;

            case R.id.imageButton12:
                str = getResources().getResourceEntryName(R.id.imageButton12);
                check(str);
                break;

            case R.id.imageButton13:
                str = getResources().getResourceEntryName(R.id.imageButton13);
                check(str);
                break;

            case R.id.imageButton14:
                str = getResources().getResourceEntryName(R.id.imageButton14);
                check(str);
                break;

            case R.id.imageButton15:
                str = getResources().getResourceEntryName(R.id.imageButton15);
                check(str);
                break;

            case R.id.imageButton16:
                str = getResources().getResourceEntryName(R.id.imageButton16);
                check(str);
                break;

            case R.id.imageButton17:
                str = getResources().getResourceEntryName(R.id.imageButton17);
                check(str);
                break;

            case R.id.imageButton18:
                str = getResources().getResourceEntryName(R.id.imageButton18);
                check(str);
                break;

            case R.id.imageButton19:
                str = getResources().getResourceEntryName(R.id.imageButton19);
                check(str);
                break;

            case R.id.imageButton20:
                str = getResources().getResourceEntryName(R.id.imageButton20);
                check(str);
                break;
        }
    }

    public void loadImages() {
        images.add(R.drawable.image1);
        images.add(R.drawable.image2);
        images.add(R.drawable.image3);
        images.add(R.drawable.image4);
        images.add(R.drawable.image5);
        images.add(R.drawable.image6);
        images.add(R.drawable.image7);
        images.add(R.drawable.image8);
        images.add(R.drawable.image9);
        images.add(R.drawable.image10);
        Collections.shuffle(images);
    }

    public void getImagesToButton() {
        btn_list.addAll(images);
        btn_list.addAll(images);
        Collections.shuffle(btn_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_game:
                finish();
                Intent intent = new Intent(this, Play.class);
                startActivity(intent);
                return true;
            case R.id.shuffle:
                count = 0;
                pre_btn = null;
                shuffleGame();
        }

        return true;
    }

    public void shuffleGame(){

        for(int i = 0; i < list.size(); i++){
            btn_list.remove(new Integer(list.get(i)));
        }

        list = new ArrayList<>();
        Log.d("size of btnlist", String.valueOf(btn_list.size()));
        Collections.shuffle(btn_list);

        reArrangeButtonView();
    }

    public void reArrangeButtonView(){
        for(int i = 0; i < 20 - image_gone_counter; i++){
            btns[i].setVisibility(View.VISIBLE);
            btns[i].setImageResource(R.drawable.cover);

        }
        for(int i = 0; i < image_gone_counter; i++){
            btns[20 - image_gone_counter + i].setVisibility(View.INVISIBLE);
        }

    }

}
