import java.util.HashMap;
import java.util.Map;

public class ClienteDAO {
    private Map<String, Cliente> clientes = new HashMap<>(); // Usamos o CPF como chave

    // Método para cadastrar cliente
    public void cadastrar(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            System.out.println("Cliente já cadastrado.");
        } else {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    // Método para buscar cliente por CPF
    public Cliente buscar(String cpf) {
        return clientes.get(cpf);
    }

    // Método para alterar cliente
    public void alterar(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            clientes.put(cliente.getCpf(), cliente);
            System.out.println("Cliente alterado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Método para excluir cliente
    public void excluir(String cpf) {
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Método para listar todos os clientes
    public void listarTodos() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes.values()) {
                System.out.println(cliente);
            }
        }
    }
}
