package com.example.xorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static ImageView imgview;
    private static Button buttonnext;
    private static Button buttonback;
    private int current_image;
    int[] images = {R.drawable.listaone, R.drawable.listatwo, R.drawable.listathree, R.drawable.listafour, R.drawable.listafive,
            R.drawable.listasix, R.drawable.listaseven, R.drawable.listaeight, R.drawable.gracias};// Creación de una lista que contiene las imágenes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();
    }
    /**
     * El método se encarga de realizar las acciones de los botones al ser presionados.
     */
    public void buttonClick(){

        imgview = (ImageView)findViewById(R.id.imageView); //Creación del objeto con el cual se pueda visualizar el comportamiento la estructura de datos.
        buttonnext = (Button)findViewById(R.id.button2); // Creación del objeto del botón siguiente
        buttonback = (Button)findViewById(R.id.button1);// Creación del objeto del botón anterior

        buttonnext.setOnClickListener( //Acción del botón siguiente
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        current_image++;
                        current_image=current_image%images.length;
                        imgview.setImageResource(images[current_image]);

                    }
                }
        );
        buttonback.setOnClickListener(//Acción del botón anterior
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        current_image--;
                        if (current_image == -1){//Evalúa que el indice de la lista no se exceda.
                            current_image=8;
                        }
                        current_image=current_image%images.length;
                        imgview.setImageResource(images[current_image]);
                    }
                }
        );
    }



}