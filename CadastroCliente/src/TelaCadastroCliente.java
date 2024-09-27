import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField telefoneField;
    private JTextField enderecoField;
    private JTextField numeroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private ClienteDAO clienteDAO;

    public TelaCadastroCliente() {
        clienteDAO = new ClienteDAO();
        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Usando GridBagLayout para organizar os componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Campos de texto e rótulos
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);
        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);
        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField(20);
        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField(20);
        JLabel numeroLabel = new JLabel("Número:");
        numeroField = new JTextField(20);
        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeField = new JTextField(20);
        JLabel estadoLabel = new JLabel("Estado:");
        estadoField = new JTextField(20);

        // Botões
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton listarButton = new JButton("Listar Todos");
        JButton consultarButton = new JButton("Consultar por CPF");
        JButton alterarButton = new JButton("Alterar Cliente");
        JButton excluirButton = new JButton("Excluir Cliente");

        // Adicionando os componentes com o layout ajustado
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(nomeLabel, gbc);
        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cpfLabel, gbc);
        gbc.gridx = 1;
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(telefoneLabel, gbc);
        gbc.gridx = 1;
        add(telefoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(enderecoLabel, gbc);
        gbc.gridx = 1;
        add(enderecoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(numeroLabel, gbc);
        gbc.gridx = 1;
        add(numeroField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(cidadeLabel, gbc);
        gbc.gridx = 1;
        add(cidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(estadoLabel, gbc);
        gbc.gridx = 1;
        add(estadoField, gbc);

        // Adicionando os botões
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cadastrarButton, gbc);

        gbc.gridy = 8;
        add(listarButton, gbc);

        gbc.gridy = 9;
        add(consultarButton, gbc);

        gbc.gridy = 10;
        add(alterarButton, gbc);

        gbc.gridy = 11;
        add(excluirButton, gbc);

        // Ação do botão Cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    String cpf = cpfField.getText();
                    String telefone = telefoneField.getText();
                    String endereco = enderecoField.getText();
                    String numeroTexto = numeroField.getText();
                    Integer numero = Integer.parseInt(numeroTexto);
                    String cidade = cidadeField.getText();
                    String estado = estadoField.getText();

                    Cliente cliente = new Cliente(nome, cpf, telefone, endereco, numero, cidade, estado);
                    clienteDAO.cadastrar(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    limparCampos(); // Limpa os campos após o cadastro
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão Listar Todos
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteDAO.listarTodos();
            }
        });

        // Ação do botão Consultar por CPF
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                Cliente cliente = clienteDAO.buscar(cpf);
                if (cliente != null) {
                    nomeField.setText(cliente.getNome());
                    telefoneField.setText(cliente.getTel());
                    enderecoField.setText(cliente.getEnd());
                    numeroField.setText(String.valueOf(cliente.getNumero()));
                    cidadeField.setText(cliente.getCidade());
                    estadoField.setText(cliente.getEstado());
                    JOptionPane.showMessageDialog(null, "Cliente encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                    limparCampos();
                }
            }
        });

        // Ação do botão Alterar Cliente
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    String cpf = cpfField.getText();
                    String telefone = telefoneField.getText();
                    String endereco = enderecoField.getText();
                    String numeroTexto = numeroField.getText();
                    Integer numero = Integer.parseInt(numeroTexto);
                    String cidade = cidadeField.getText();
                    String estado = estadoField.getText();

                    Cliente cliente = new Cliente(nome, cpf, telefone, endereco, numero, cidade, estado);
                    clienteDAO.alterar(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                    limparCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação do botão Excluir Cliente
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                clienteDAO.excluir(cpf);
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                limparCampos();
            }
        });
    }

    // Método para limpar os campos
    private void limparCampos() {
        nomeField.setText("");
        cpfField.setText("");
        telefoneField.setText("");
        enderecoField.setText("");
        numeroField.setText("");
        cidadeField.setText("");
        estadoField.setText("");
    }

    public static void main(String[] args) {
        TelaCadastroCliente tela = new TelaCadastroCliente();
        tela.setVisible(true);
    }
}
