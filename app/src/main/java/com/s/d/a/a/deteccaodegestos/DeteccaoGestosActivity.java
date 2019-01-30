package com.s.d.a.a.deteccaodegestos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.support.v4.view.GestureDetectorCompat;

public class DeteccaoGestosActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
    private TextView txvGesto;
    private GestureDetectorCompat detectorDeGestos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deteccao_gestos);

        txvGesto = findViewById(R.id.statusDoGesto);

        this.detectorDeGestos = new GestureDetectorCompat(this, this);
        detectorDeGestos.setOnDoubleTapListener(this);
    }

    //Observem que todos os metodos booleanos sobrecarregados abaixo retornam verdadeiro.
    //Isso indica ao S.O que os eventos são consumidos nesses metodos e que não será necessário
    //passa-los p/ o proximo gerenciador de eventos na pilha p/ serem tratados.

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        txvGesto.setText("onDownGesture");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2,
                           float velocidadeX, float velocidadeY) {
        txvGesto.setText("onFlingGesture");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        txvGesto.setText("onLongPressGesture");
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent1, MotionEvent motionEvent2,
                            float distanciaX, float distanciaY) {
        txvGesto.setText("onScrollGesture");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        txvGesto.setText("onShowPressGesture");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        txvGesto.setText("onSingleTapUpGesture");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        txvGesto.setText("onDoubleTapGesture");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        txvGesto.setText("onDoubleTapEventGesture");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        txvGesto.setText("onSingletapConfirmedGesture");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.detectorDeGestos.onTouchEvent(event);

        //Necessaro chamar o metodo da superclasse
        return super.onTouchEvent(event);
    }
}
