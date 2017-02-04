package com.fahed.developer.md_ejemplo7;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailBookFragment extends Fragment {
    private View rootView;

    private ImageView ivCover;
    private TextView tvTitulo;
    private TextView tvAutor;
    private TextView tvDescipcion;


    private String [] Titulo;
    private String [] Autor;
    private String [] Descipcion;

    public DetailBookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail_book, container, false);
        ivCover = (ImageView) rootView.findViewById(R.id.ivCoverLibro);
        tvTitulo = (TextView) rootView.findViewById(R.id.tvTitulo);
        tvAutor = (TextView) rootView.findViewById(R.id.tvAutor);
        tvDescipcion = (TextView) rootView.findViewById(R.id.tvDescripcion);

        //Obtener datos Bundle
        Bundle bundle = getActivity().getIntent().getExtras();
        int NroLibro = bundle.getInt("NroLibro");

        Titulo=new String[]{getResources().getString(R.string.tv_libro1),getResources().getString(R.string.tv_libro2),getResources().getString(R.string.tv_libro3),getResources().getString(R.string.tv_libro4)};
        Autor=new String[]{getResources().getString(R.string.tv_autor1),getResources().getString(R.string.tv_autor2),getResources().getString(R.string.tv_autor3),getResources().getString(R.string.tv_autor4)};
        Descipcion=new String[]{getResources().getString(R.string.tv_descripcion1),getResources().getString(R.string.tv_descripcion2),getResources().getString(R.string.tv_descripcion3),getResources().getString(R.string.tv_descripcion4)};


        tvTitulo.setText(Titulo[NroLibro]);
        tvAutor.setText("Autor: "+Autor[NroLibro]);
        tvDescipcion.setText("Descripcion: "+Descipcion[NroLibro]);

        switch (NroLibro){
            case 0:
                ivCover.setImageDrawable(getResources().getDrawable(R.mipmap.ic_book_one));
                break;

            case 1:
                ivCover.setImageDrawable(getResources().getDrawable(R.mipmap.ic_book_two));
                break;

            case 2:
                ivCover.setImageDrawable(getResources().getDrawable(R.mipmap.ic_book_three));
                break;

            case 3:
                ivCover.setImageDrawable(getResources().getDrawable(R.mipmap.ic_book_four));
                break;

        }

        return rootView;
    }
}
