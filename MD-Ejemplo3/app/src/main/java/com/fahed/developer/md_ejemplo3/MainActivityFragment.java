package com.fahed.developer.md_ejemplo3;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private View rootView;
    private LinearLayout lyContenido;

    private String [] Version={"7.0","6.0","5.0 - 5.1","4.4","4.1 - 4.3","4.0","2.3","2.2","2.0 - 2.1","1.6","1.5"};
    private String [] NombreEnCodigo={"Nougat","Marshmallow","Lollipop","Kit Kat","Jelly Bean","Ice Cream Sandwich","Gingerbread","Froyo","Éclair","Donut","Cupcake"};



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);


        lyContenido = (LinearLayout) rootView.findViewById(R.id.lyContenido);

        //Agregar Tarjeta Promocion Dinamicamente
        for (int j = 0; j < 9; j++) {


            //Obtener el layout FilaGrid
            LayoutInflater inflaterFila = LayoutInflater.from(rootView.getContext());
            int id = R.layout.list_item;
            LinearLayout linearLayoutFila = (LinearLayout) inflaterFila.inflate(id, null, false);

            //Rellenar los TextView con los datos Obtenidos
            final TextView tvTitulo = (TextView) linearLayoutFila.findViewById(R.id.text1);
            tvTitulo.setText(NombreEnCodigo[j]);

            TextView tvSubtitulo = (TextView) linearLayoutFila.findViewById(R.id.text2);
            tvSubtitulo.setText("Version: "+ Version[j]);

            lyContenido.addView(linearLayoutFila);
        }



        return rootView;
    }


}
