package com.fahed.developer.md_ejemplo2;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public Typeface Capture;
    private View rootView;
    private TextView tvNombre;
    private TextView tvDev;

    static int white;
    static int lightblue;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_main, container, false);

        tvNombre=(TextView)rootView.findViewById(R.id.tvNombre);
        tvDev=(TextView)rootView.findViewById(R.id.tvDev);

        //Se obtienen los colores del Text View
        if (white == 0)
            white = tvDev.getContext().getResources().getColor(R.color.background_material_light);
        if (lightblue == 0)
            lightblue = tvDev.getContext().getResources().getColor(R.color.lightblue);

        tvNombre.setTypeface(Capture);

        tvDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isVeggie = ((ColorDrawable)v.getBackground()) != null && ((ColorDrawable)v.getBackground()).getColor() == lightblue;

                int finalRadius = (int)Math.hypot(v.getWidth()/2, v.getHeight()/2);
                if (isVeggie) {
                    tvDev.setText("Android Developer");
                    tvDev.setBackgroundColor(white);

                } else {
                    //Configuracion de la animación
                    Animator anim = ViewAnimationUtils.createCircularReveal(v, (int) v.getWidth() / 2, (int) tvDev.getHeight() / 2, 0, finalRadius);
                    tvDev.setText("Fahed Hermoza Salcedo");
                    tvDev.setBackgroundColor(lightblue);
                    anim.start();
                }

            }
        });

        return rootView;
    }

    //Tipo de letra externo
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Capture= Typeface.createFromAsset(getActivity().getAssets(),"Capture_it_2.ttf");
    }
}
