package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen {
    private Bitmap icono;
    private float x,y;
    private boolean visible;

    public Imagen(int resource,float _x,float _y,Lienzo2 i){
        icono = BitmapFactory.decodeResource(i.getResources(),resource);
        x = _x;
        y = _y;
        visible = true;
    }

    public void pintar(Canvas c, Paint p){
        if(visible)c.drawBitmap(icono,x,y,p);
    }

    public void hacerVisible(boolean v){
        visible = v;
    }


    public boolean estaEnArea(float xp, float yp){ //xp y yp son del toque

        if (!visible) return false;

        float x2,y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if(yp>=y &&yp<=y2){
                return true;
            }
        }


        //metodo mover

        return false;
    }
    //para saber si se movio ocupamos eiste metodo

    public void mover(float xp,float yp){
        x=xp-(icono.getWidth()/2);
        y=yp-(icono.getHeight()/2);

    }

    public boolean colision(Imagen objetoB){
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();

        if(objetoB.estaEnArea(x2, y)){
            //revisando caso 1
            return true;
        }
        if (objetoB.estaEnArea(x,y)){
            //caso 2
            return true;
        }
        //caso2 x,y
        //caso4 x y2

        if (objetoB.estaEnArea(x2,y2)){
            //revisando caso 3
            return true;
        }

        if (objetoB.estaEnArea(x,y2)){
            //revisando casoo4
            return true;
        }

        return false;

    }
}
