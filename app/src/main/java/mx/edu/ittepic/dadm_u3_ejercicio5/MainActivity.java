package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Button boton1,boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LIenzoIni(this));
       /* boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(otraVentana);
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVentana = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(otraVentana);

            }
        });*/


    }

}
