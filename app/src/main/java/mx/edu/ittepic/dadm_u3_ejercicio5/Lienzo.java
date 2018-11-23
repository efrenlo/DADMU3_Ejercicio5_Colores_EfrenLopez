package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;


public class Lienzo extends View {

    String mensaje;
    MediaPlayer md;
    Circulo amarillo, negro, morado, verde, azul, naranja,puntero;
    Main2Activity puntero2;

    public Lienzo(Context context) {
        super(context);
        mensaje = "No Has tocado ningun color";

        naranja = new Circulo(R.drawable.naranja, 100, 150, this);
        morado = new Circulo(R.drawable.purpura, 650, 1100, this);
        negro = new Circulo(R.drawable.negra, 650, 150, this);
        amarillo = new Circulo(R.drawable.amarillo, 100, 600, this);
        azul = new  Circulo(R.drawable.azul, 650, 600, this);
        verde = new Circulo(R.drawable.verde, 100, 1100, this);


        puntero = null;
        puntero2 = (Main2Activity) context;

    }

   public void onDraw(Canvas c){
        super.onDraw(c);
       //crear el media player


       Paint p = new Paint();

       p.setTextSize(80);
       p.setColor(Color.RED);
       c.drawText(mensaje, 50, 65, p);
       //canvas.drawColor(Color.CYAN);
       //canvas.draw
       amarillo.pintar(c, p);
       negro.pintar(c, p);
       morado.pintar(c, p);
       verde.pintar(c, p);
       azul.pintar(c, p);
       naranja.pintar(c, p);
   }

  public boolean onTouchEvent(MotionEvent e){
      float xtoque = e.getX();
      float ytoque = e.getY();
      switch (e.getAction()) {

          case MotionEvent.ACTION_DOWN:
              //Entra si e.getAction esta presionado

              if(amarillo.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Amarillo";
                  puntero=amarillo;//puntero apunta a icono1
                  puntero2.amarillo();
              }
             /* if (xtoque <= 400 && ytoque <= 400) {

                  mensaje = "Color Amarillo";
                  puntero2.amarillo();



              }*/
              if(negro.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Negro";
                  puntero=negro;//puntero apunta a icono1
                  puntero2.negro();
              }

              if(morado.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Morado";
                  puntero=morado;//puntero apunta a icono1
                  puntero2.morado();
              }
              if(verde.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Verde";
                  puntero=verde;//puntero apunta a icono1
                  puntero2.green();
              }

              if(azul.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Azul";
                  puntero=azul;//puntero apunta a icono1
                  puntero2.azul();
              }

              if(naranja.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                  //mensaje="se toco icono1";
                  mensaje = "Color Naranja";
                  puntero=naranja;//puntero apunta a icono1
                  puntero2.naraja();
              }

              break;

      }
      invalidate();//manda llamar a onDraw
      return true;
  }

}
