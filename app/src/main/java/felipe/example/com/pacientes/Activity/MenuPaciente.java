package felipe.example.com.pacientes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import felipe.example.com.pacientes.R;

public class MenuPaciente extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_paciente);
    }

    public void getActivity(View view)
    {
        Button botao = (Button) view;
        Intent intent;

        if(botao.getText().toString().equalsIgnoreCase("Novo"))
        {
            intent = new Intent(this, NovoPaciente.class);
        }
        else
        {
            intent = new Intent(this, ListaPaciente.class);
        }
        startActivity(intent);
    }
}
