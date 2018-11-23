package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    MediaPlayer md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
    public void amarillo(){
        md = MediaPlayer.create(this,R.raw.amarillo);//direccion
        md.start();

    }
    public void negro(){
        md = MediaPlayer.create(this,R.raw.negro);//direccion
        md.start();

    }
    public void morado(){
        md = MediaPlayer.create(this,R.raw.morado);//direccion
        md.start();

    }
    public void green(){
        md = MediaPlayer.create(this,R.raw.verde);//direccion
        md.start();

    }
    public void azul(){
        md = MediaPlayer.create(this,R.raw.azul);//direccion
        md.start();

    }
    public void naraja(){
        md = MediaPlayer.create(this,R.raw.naranja);//direccion
        md.start();

    }
}
