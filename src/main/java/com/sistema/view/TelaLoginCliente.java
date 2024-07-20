package main.java.com.sistema.view;

import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.ControllerSistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginCliente extends JFrame {
    private SistemaFacade sf;

    public TelaLoginCliente(SistemaFacade sf) {
        this.sf = sf;
        setTitle("Login do Cliente");
        setSize(400, 200);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels e campos de texto
        JLabel labelLogin = new JLabel("Login:");
        JTextField textLogin = new JTextField(20);
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField(20);

        // Adicionando componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelLogin, gbc);
        gbc.gridx = 1;
        add(textLogin, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labelSenha, gbc);
        gbc.gridx = 1;
        add(textSenha, gbc);

        // Botão de login
        JButton botaoLogin = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botaoLogin, gbc);

        // Ação do botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textLogin.getText();
                String senha = new String(textSenha.getPassword());

                try {
                    Cliente cliente = sf.getClientes().getCliente(login);
                    if (cliente != null && cliente.getSenha().equals(senha)) {
                        JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                        new TelaPrincipalCliente(cliente); 
                    } else {
                        throw new LoginFalhouException("Login ou senha incorretos.");
                    }
                } catch (LoginFalhouException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
