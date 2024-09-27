import java.util.List;

public interface IClienteDAO {
    void cadastrar(Cliente cliente);
    Cliente consultar(String cpf);
    void alterar(Cliente cliente);
    void excluir(String cpf);
    List<Cliente> listarTodos();
}
