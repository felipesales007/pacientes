package felipe.example.com.pacientes.Activity;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.List;

import felipe.example.com.pacientes.Adapter.PacienteAdapter;
import felipe.example.com.pacientes.DAO.BD;
import felipe.example.com.pacientes.Domain.Paciente;

public class ListaPaciente extends ListActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_paciente);

        try
        {
            BD bd = new BD(this);
            List<Paciente> list = bd.buscar();
            setListAdapter(new PacienteAdapter(this, list));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
