package mx.edu.ittepic.dadm_u3_ejercicio5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Imagen icono1,icono2,icono3,icono4,icono5,icono6,puntero;
    String mensaje;

    public Lienzo2(Context context) {
        super(context);
        mensaje = "Toca los colores correctos";
        //se instancia un objeto de bit map primerpaso
        icono2 = new Imagen(R.drawable.amarillo,100,400,this);
        icono1 = new Imagen(R.drawable.imayel,600,1200,this);

        icono4 = new Imagen(R.drawable.azul,100,800,this);
        icono3 = new Imagen(R.drawable.imablu,600,400,this);

        icono6 = new Imagen(R.drawable.purpura,100,1200,this);
        icono5 = new Imagen(R.drawable.imapur,600,800,this);
        puntero = null;

    }
    public void onDraw(Canvas c){

        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(70);
        p.setColor(Color.RED);
        c.drawText(mensaje,100,100,p);


        icono1.pintar(c,p);
        icono2.pintar(c,p);

        icono3.pintar(c,p);
        icono4.pintar(c,p);

        icono5.pintar(c,p);
        icono6.pintar(c,p);


    }

    public boolean onTouchEvent(MotionEvent e){
        float xp= e.getX();
        float yp=e.getY();
        //mensaje="no se ha tocado onjeto";

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(icono1.estaEnArea(xp,yp)){//si el toque esta en el area
                    //mensaje="se toco icono1";
                    puntero=icono1;//puntero apunta a icono1
                }
                if (icono2.estaEnArea(xp,yp)){
                    //mensaje="Tocaste el inoco 2";
                    puntero=icono2;
                }
                //////////////////////////////////////
                if(icono3.estaEnArea(xp,yp)){//si el toque esta en el area
                    //mensaje="se toco icono1";
                    puntero=icono3;//puntero apunta a icono1
                }
                if (icono4.estaEnArea(xp,yp)){
                    //mensaje="Tocaste el inoco 2";
                    puntero=icono4;
                }
                //////////////////////////////////////
                if(icono5.estaEnArea(xp,yp)){//si el toque esta en el area
                    //mensaje="se toco icono1";
                    puntero=icono5;//puntero apunta a icono1
                }
                if (icono6.estaEnArea(xp,yp)){
                    //mensaje="Tocaste el inoco 2";
                    puntero=icono6;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if(puntero!=null){
                    puntero.mover(xp,yp);
                    ////////////// por si icono 1 toca primero
                    if(puntero.colision(icono2)&&puntero==icono1){
                        mensaje="Los amarillos se tocaron";
                        icono2.hacerVisible(false);
                    }
                    ////////////icono2 toca primero
                    if(puntero.colision(icono1)&&puntero==icono2){
                        mensaje="Los amarillos se tocaron";
                        icono1.hacerVisible(false);
                    }

                    //////////////////////////////icono 3 toca primero
                    if(puntero.colision(icono4)&&puntero==icono3){
                        mensaje="Los azules se tocaron";
                        icono4.hacerVisible(false);
                    }
                    ///////////////////icono 4  a 3
                    if(puntero.colision(icono3)&&puntero==icono4){
                        mensaje="Los azules Se tocaron";
                        icono3.hacerVisible(false);
                    }
                    ////////////////////////////////////////// si tocan uno oh el otro de 5 0 6
                    if(puntero.colision(icono6)&&puntero==icono5){
                        mensaje="los morados se tocaron";
                        icono6.hacerVisible(false);
                    }
                    if(puntero.colision(icono5)&&puntero==icono6){
                        mensaje="los morados se tocaron";
                        icono5.hacerVisible(false);
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                puntero=null;//para que se desactive la seleccion anterior
                break;
        }
        invalidate();
        return true;
    }
}
