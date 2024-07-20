package main.java.com.sistema.view;

import main.java.com.sistema.modelo.ControllerSistema;
import main.java.com.sistema.modelo.GerenciaClientes;
import main.java.com.sistema.exception.UsuarioNaoCadastrouException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {
    private SistemaFacade sf;

    public TelaCadastroCliente(SistemaFacade sf) {
        this.sf = sf;
        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Campo de Login
        JLabel labelLogin = new JLabel("Login:");
        JTextField textLogin = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelLogin, gbc);
        gbc.gridx = 1;
        add(textLogin, gbc);

        // Campo de Senha
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelSenha, gbc);
        gbc.gridx = 1;
        add(textSenha, gbc);


        // Campo de Nome 
        JLabel labelNome = new JLabel("Nome:");
        JTextField textNome = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelNome, gbc);
        gbc.gridx = 1;
        add(textNome, gbc);


        // Campo de CPF
        JLabel labelCpf = new JLabel("CPF:");
        JTextField textCpf = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelCpf, gbc);
        gbc.gridx = 1;
        add(textCpf, gbc);

        // Campo de Endereço
        JLabel labelEndereco = new JLabel("Endereço:");
        JTextField textEndereco = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelEndereco, gbc);
        gbc.gridx = 1;
        add(textEndereco, gbc);


        // Campo de telefone
        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField textTelefone = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelTelefone, gbc);
        gbc.gridx = 1;
        add(textTelefone, gbc);

        // Botão de cadastro
        JButton botaoCadastrar = new JButton("Cadastrar");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoCadastrar, gbc);

        // Ação do botão de cadastro
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textLogin.getText();
                String senha = new String(textSenha.getPassword());
                String nome = textNome.getText();
                String cpf = textCpf.getText();
                String endereco = textEndereco.getText();
                String telefone = textTelefone.getText();

                try {
                    sf.cadastrarCliente(login, senha, nome, cpf, endereco, telefone);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    dispose(); // Fecha a tela de cadastro
                } catch (UsuarioNaoCadastrouException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
