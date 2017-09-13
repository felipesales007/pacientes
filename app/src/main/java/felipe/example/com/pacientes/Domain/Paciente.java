package felipe.example.com.pacientes.Domain;

public class Paciente
{
    private String cpf;
    private String nome;
    private String telefone;
    private String doenca;
    private String medicacao;
    private String data;
    private String valor;
    private String detalhes;
    private long id;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDoenca() {
        return doenca;
    }
    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }
    public String getMedicacao() {
        return medicacao;
    }
    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
