package com.fahed.developer.md_ejemplo8;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private View rootView;
    private ImageView tickCross;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;
    private boolean tick = true;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        tickCross = (ImageView) rootView.findViewById(R.id.tick_cross);
        tickToCross = (AnimatedVectorDrawable) getActivity().getDrawable(R.drawable.avd_tick_to_cross);
        crossToTick = (AnimatedVectorDrawable) getActivity().getDrawable(R.drawable.avd_cross_to_tick);

        tickCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(rootView);
            }
        });


        return rootView;
    }

    //Iniciamos la animacion de Tick a Cross
    public void animate(View view) {
        AnimatedVectorDrawable drawable = tick ? tickToCross : crossToTick;
        tickCross.setImageDrawable(drawable);
        drawable.start();
        tick = !tick;
    }
}
