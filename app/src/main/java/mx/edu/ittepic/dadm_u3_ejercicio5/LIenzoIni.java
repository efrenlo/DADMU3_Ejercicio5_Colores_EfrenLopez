package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LIenzoIni extends View {
    ImaInicio star,game,puntero;
    String mensaje="Empieza a Jugar con los Colores";
    MainActivity puntero2;
    public LIenzoIni(Context context) {
        super(context);

        star = new ImaInicio(R.drawable.start, 300, 200, this);
        game = new ImaInicio(R.drawable.playgame, 300, 800, this);
        puntero = null;

        puntero2 = (MainActivity) context;
    }

    public void onDraw(Canvas c){
        super.onDraw(c);
        //crear el media player


        Paint p = new Paint();

        c.drawColor(Color.CYAN);

        p.setTextSize(70);
        c.drawText(mensaje, 10, 80, p);
        //canvas.draw
        star.pintar(c, p);
        game.pintar(c, p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xtoque = e.getX();
        float ytoque = e.getY();
        switch (e.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //Entra si e.getAction esta presionado

                if(star.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                    //mensaje="se toco icono1";

                    Intent otra = new Intent(puntero2,Main2Activity.class);
                    puntero2.startActivity(otra);
                }
                if(game.estaEnArea(xtoque,ytoque)){//si el toque esta en el area
                    //mensaje="se toco icono1";

                    Intent otra = new Intent(puntero2,Main3Activity.class);
                    puntero2.startActivity(otra);
                }





                break;

        }
        invalidate();//manda llamar a onDraw
        return true;
    }
}
