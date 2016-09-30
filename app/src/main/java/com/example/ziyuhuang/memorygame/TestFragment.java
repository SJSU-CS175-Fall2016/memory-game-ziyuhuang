package com.example.ziyuhuang.memorygame;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TestFragment extends Fragment {

    Button playButton;
    Button rulesButton;
    TextView textView;


    Button exit_rules;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        playButton = (Button) getActivity().findViewById(R.id.play);
        rulesButton = (Button) getActivity().findViewById(R.id.rules);
        textView = (TextView) getActivity().findViewById(R.id.textView);

        exit_rules = (Button) getActivity().findViewById(R.id.exit_rules);
        exit_rules.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               Fragment fragment = getFragmentManager().findFragmentByTag("rules_fragment");
                if(fragment != null){
                    getFragmentManager().beginTransaction().remove(fragment).commit();
                }

                textView.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
                rulesButton.setVisibility(View.VISIBLE);
            }
        });
    }
}
