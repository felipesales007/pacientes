package felipe.example.com.pacientes.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import felipe.example.com.pacientes.Domain.Paciente;

public class BD
{
    private SQLiteDatabase bd;

    public BD(Context context)
    {
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Paciente usuario)
    {
        ContentValues valores = new ContentValues();
        valores.put("cpf", usuario.getCpf());
        valores.put("nome", usuario.getNome());
        valores.put("telefone", usuario.getTelefone());
        valores.put("doenca", usuario.getDoenca());
        valores.put("medicacao", usuario.getMedicacao());
        valores.put("data", usuario.getData());
        valores.put("valor", usuario.getValor());
        valores.put("detalhes", usuario.getDetalhes());

        bd.insert("usuario", null, valores);
    }


    public void atualizar(Paciente usuario)
    {
        ContentValues valores = new ContentValues();
        valores.put("cpf", usuario.getCpf());
        valores.put("nome", usuario.getNome());
        valores.put("telefone", usuario.getTelefone());
        valores.put("doenca", usuario.getDoenca());
        valores.put("medicacao", usuario.getMedicacao());
        valores.put("data", usuario.getData());
        valores.put("valor", usuario.getValor());
        valores.put("detalhes", usuario.getDetalhes());

        bd.update("usuario", valores, "_id = ?", new String[]{""+usuario.getId()});
    }


    public void deletar(Paciente usuario)
    {
        bd.delete("usuario", "_id = "+usuario.getId(), null);
    }


    public List<Paciente> buscar()
    {
        List<Paciente> list = new ArrayList<Paciente>();
        String[] colunas = new String[]{"_id", "cpf", "nome", "telefone", "doenca", "medicacao", "data", "valor", "detalhes"};

        Cursor cursor = bd.query("usuario", colunas, null, null, null, null, "nome DESC");

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do{

                Paciente u = new Paciente();

                u.setId(cursor.getLong(0));
                u.setCpf(cursor.getString(1));
                u.setNome(cursor.getString(2));
                u.setTelefone(cursor.getString(3));
                u.setDoenca(cursor.getString(4));
                u.setMedicacao(cursor.getString(5));
                u.setData(cursor.getString(6));
                u.setValor(cursor.getString(7));
                u.setDetalhes(cursor.getString(8));
                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}
