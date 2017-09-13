package felipe.example.com.pacientes.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import felipe.example.com.pacientes.DAO.BD;
import felipe.example.com.pacientes.R;
import felipe.example.com.pacientes.Domain.Paciente;

public class NovoPaciente extends Activity
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

    private Button salvar_paciente;
    private Button editar_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_paciente);

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

            salvar_paciente = (Button) findViewById(R.id.btn_salvar_paciente);
            editar_paciente = (Button) findViewById(R.id.btn_editar_paciente);

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

                    salvar_paciente.setVisibility(View.GONE);
                    editar_paciente.setVisibility(View.VISIBLE);
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void salvar_paciente(View view)
    {
        try
        {
            if(cpf.getText().length()== 0 || nome.getText().length()== 0 || telefone.getText().length()== 0 || doenca.getText().length()== 0 || medicacao.getText().length()== 0 || data.getText().length()== 0 || valor.getText().length()== 0)
            {
                Toast.makeText(NovoPaciente.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
            }
            else
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
                bd.inserir(usuario);

                Toast.makeText(this, "Paciente salvo com sucesso!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(NovoPaciente.this, MenuPaciente.class);
                startActivity(i);
                finish();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editar_paciente(View view)
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

            editar_paciente.setVisibility(View.VISIBLE);

            BD bd = new BD(this);
            bd.atualizar(usuario);

            Toast.makeText(this, "Paciente '"+usuario.getNome()+"' atuailizado com sucesso.", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(NovoPaciente.this, ListaPaciente.class);
            startActivity(i);
            finish();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}