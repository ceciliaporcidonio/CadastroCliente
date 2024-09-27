public class BancoDeDados {
    private static ClienteDAO clienteDAO = new ClienteDAO();

    public static ClienteDAO getClienteDAO() {
        return clienteDAO;
    }
}
