package felipe.example.com.pacientes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import felipe.example.com.pacientes.DAO.BD;
import felipe.example.com.pacientes.R;
import felipe.example.com.pacientes.Domain.Paciente;

public class VisualizarPaciente extends Activity
{
    private Paciente usuario = new Paciente();

    private EditText cpf;
    private EditText nome;
    private EditText telefone;
    private EditText doenca;
    private EditText medicacao;
    private EditText data;
    private EditText valor;
    private EditText detalhes;

    public Button visualizar_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_paciente);

        try
        {
            cpf = (EditText) findViewById(R.id.cpf_cadastro);
            nome = (EditText) findViewById(R.id.nome_cadastro);
            telefone = (EditText) findViewById(R.id.telefone_cadastro);
            doenca = (EditText) findViewById(R.id.doenca_cadastro);
            medicacao = (EditText) findViewById(R.id.medicacao_cadastro);
            data = (EditText) findViewById(R.id.data_cadastro);
            valor = (EditText) findViewById(R.id.valor_cadastro);
            detalhes = (EditText) findViewById(R.id.detalhes_cadastro);

            visualizar_paciente = (Button) findViewById(R.id.btn_visualizar_paciente);

            /////////////////////////////////// MATEM O TECLADO OCULTO /////////////////////////////////
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(cpf.getWindowToken(), 0);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            ////////////////////////////////////////////////////////////////////////////////////////////

            Intent intent = getIntent();
            if(intent != null)
            {
                Bundle bundle = intent.getExtras();
                if(bundle != null)
                {
                    usuario.setId(bundle.getLong("id"));
                    usuario.setCpf(bundle.getString("cpf"));
                    usuario.setNome(bundle.getString("nome"));
                    usuario.setTelefone(bundle.getString("telefone"));
                    usuario.setDoenca(bundle.getString("doenca"));
                    usuario.setMedicacao(bundle.getString("medicacao"));
                    usuario.setData(bundle.getString("data"));
                    usuario.setValor(bundle.getString("valor"));
                    usuario.setDetalhes(bundle.getString("detalhes"));

                    cpf.setText(usuario.getCpf());
                    nome.setText(usuario.getNome());
                    telefone.setText(usuario.getTelefone());
                    doenca.setText(usuario.getDoenca());
                    medicacao.setText(usuario.getMedicacao());
                    data.setText(usuario.getData());
                    valor.setText(usuario.getValor());
                    detalhes.setText(usuario.getDetalhes());
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void visualizar_paciente(View view)
    {
        try
        {
            usuario.setCpf(cpf.getText().toString());
            usuario.setNome(nome.getText().toString());
            usuario.setTelefone(telefone.getText().toString());
            usuario.setDoenca(doenca.getText().toString());
            usuario.setMedicacao(medicacao.getText().toString());
            usuario.setData(data.getText().toString());
            usuario.setValor(valor.getText().toString());
            usuario.setDetalhes(detalhes.getText().toString());

            BD bd = new BD(this);
            bd.atualizar(usuario);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
