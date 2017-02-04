package com.fahed.developer.md_ejemplo5;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
    private View cvScrim;
    private Boolean varFoto=true;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(varFoto){
                    //Modificamos la proteccion
                    cvScrim = (View) rootView.findViewById(R.id.cvScrim);
                    cvScrim.setVisibility(View.GONE);

                    varFoto=false;

                    Snackbar.make(view, " Sin Protección Background", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }else{

                    //Modificamos la proteccion
                    cvScrim = (View) rootView.findViewById(R.id.cvScrim);
                    cvScrim.setVisibility(View.VISIBLE);

                    varFoto=true;

                    Snackbar.make(view, " Con Protección Background", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            }
        });

        return rootView;
    }
}
