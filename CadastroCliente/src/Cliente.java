import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;
    private String tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    // Construtor que aceita todos os campos
    public Cliente(String nome, String cpf, String tel, String end, Integer numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.end = end;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Construtor padrão (sem argumentos)
    public Cliente() {
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // equals e hashCode usando CPF como chave
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // toString para representar o cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + tel + '\'' +
                ", endereco='" + end + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
