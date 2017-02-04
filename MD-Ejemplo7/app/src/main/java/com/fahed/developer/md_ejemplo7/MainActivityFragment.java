package com.fahed.developer.md_ejemplo7;

import android.app.ActivityOptions;
import android.content.Intent;
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

    private ImageView ivLibro1;
    private ImageView ivLibro2;
    private ImageView ivLibro3;
    private ImageView ivLibro4;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        ivLibro1 = (ImageView) rootView.findViewById(R.id.ivLibro1);
        ivLibro2 = (ImageView) rootView.findViewById(R.id.ivLibro2);
        ivLibro3 = (ImageView) rootView.findViewById(R.id.ivLibro3);
        ivLibro4 = (ImageView) rootView.findViewById(R.id.ivLibro4);

        ivLibro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarDetalle(rootView,0,ivLibro1);
            }
        });

        ivLibro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarDetalle(rootView,1,ivLibro2);
            }
        });

        ivLibro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarDetalle(rootView,2,ivLibro3);
            }
        });

        ivLibro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarDetalle(rootView,3,ivLibro4);
            }
        });

        return rootView;
    }

    //Abre la actividad Principal
    public void lanzarDetalle(View rootView,int NroLibro, View view) {
        Intent i = new Intent(rootView.getContext(), DetailBook.class);
        i.putExtra("NroLibro", NroLibro);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity(),view,
                view.getTransitionName()).toBundle();
        startActivity(i, bundle);
    }
}
