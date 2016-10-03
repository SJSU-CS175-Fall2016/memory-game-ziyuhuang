package com.example.ziyuhuang.memorygame;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class TestFragment extends Fragment {

    @BindView(R.id.exit) Button exit_rules;

    private Unbinder unbinder;

    ViewChangeListener viewChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_test, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        viewChangeListener = (ViewChangeListener) context;
    }

    @OnClick(R.id.exit)
    public void exitRules(View view){
        Log.v("testing", "clicked");
        Fragment fragment = getFragmentManager().findFragmentByTag("rules_fragment");
        if(fragment != null){
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }

        viewChangeListener.showButton();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface ViewChangeListener{
        public void showButton();
    }
}
