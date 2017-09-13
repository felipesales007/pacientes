package felipe.example.com.pacientes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import felipe.example.com.pacientes.R;

public class Intro extends Activity
{
    //////////////////////////////////// TEMP0 DA INTRO DO APP /////////////////////////////////////
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_menu);

        new Handler().postDelayed(new Runnable()
        {
            //////////////////////////////// EXIBINDO NA TELA //////////////////////////////////////
            @Override
            public void run()
            {
                //////////////////// DEPOIS DE MOSTRA A INTRO PULA PRA NOVA TELA ///////////////////
                Intent i = new Intent(Intro.this, MenuPaciente.class);
                startActivity(i);

                finish();
                ///////////////// DEPOIS DE MOSTRA A INTRO PULA PRA NOVA TELA FIM //////////////////
            }
            ////////////////////////////// EXIBINDO NA TELA FIM ////////////////////////////////////
        }, SPLASH_TIME_OUT);
    }
    ///////////////////////////////// TEMPO DA INTRO DO APP FIM ////////////////////////////////////
}
