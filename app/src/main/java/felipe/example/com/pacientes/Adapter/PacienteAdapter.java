package felipe.example.com.pacientes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import felipe.example.com.pacientes.Activity.NovoPaciente;
import felipe.example.com.pacientes.Activity.VisualizarPaciente;
import felipe.example.com.pacientes.DAO.BD;
import felipe.example.com.pacientes.R;
import felipe.example.com.pacientes.Domain.Paciente;

public class PacienteAdapter extends BaseAdapter
{
    private Context context;
    private List<Paciente> list;

    public PacienteAdapter(Context context, List<Paciente> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0)
    {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0)
    {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2)
    {
        final int auxPosition = position;

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_opcoes_paciente, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome_paciente);
        tv.setText(list.get(position).getNome());

        Button visualizar_paciente = (Button) layout.findViewById(R.id.btn_visualizar_paciente);
        visualizar_paciente.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(context, VisualizarPaciente.class);

                intent.putExtra("cpf", list.get(auxPosition).getCpf());
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("telefone", list.get(auxPosition).getTelefone());
                intent.putExtra("doenca", list.get(auxPosition).getDoenca());
                intent.putExtra("medicacao", list.get(auxPosition).getMedicacao());
                intent.putExtra("data", list.get(auxPosition).getData());
                intent.putExtra("valor", list.get(auxPosition).getValor());
                intent.putExtra("detalhes", list.get(auxPosition).getDetalhes());

                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });


        Button editar_paciente = (Button) layout.findViewById(R.id.btn_editar_paciente);
        editar_paciente.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                Intent intent = new Intent(context, NovoPaciente.class);

                intent.putExtra("cpf", list.get(auxPosition).getCpf());
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("telefone", list.get(auxPosition).getTelefone());
                intent.putExtra("doenca", list.get(auxPosition).getDoenca());
                intent.putExtra("medicacao", list.get(auxPosition).getMedicacao());
                intent.putExtra("data", list.get(auxPosition).getData());
                intent.putExtra("valor", list.get(auxPosition).getValor());
                intent.putExtra("detalhes", list.get(auxPosition).getDetalhes());

                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.btn_deletar_paciente);
        deletarBt.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));
                layout.setVisibility(View.GONE);
            }
        });
        return layout;
    }
}
