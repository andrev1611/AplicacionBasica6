package aplicacionbasica.app.andrevera.com.aplicacionbasica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //EMPTY ACTIVITY
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //AHORA DESPUES DE ESOS 4 SEGUNDOS APARECERÁ LA ACTIVIDAD MAIN
                Intent intento=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intento);
            }
        },4000);//4 SEGUNDOS
    }
}
