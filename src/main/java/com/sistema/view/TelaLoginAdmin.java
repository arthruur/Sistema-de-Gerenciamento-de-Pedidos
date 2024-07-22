package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.modelo.ControllerSistema;

public class TelaLoginAdmin {

    private SistemaFacade sf;

    public TelaLoginAdmin(SistemaFacade sf) {
        this.sf = sf;
        JFrame jFrame = new JFrame("Admin Login");
        jFrame.setSize(400, 400);
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);

        // Título da tela de login
        JLabel titulo = new JLabel("Admin Login");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        jFrame.add(titulo, BorderLayout.NORTH);

        // Painel dos campos de login
        JPanel panel_login = new JPanel(new GridBagLayout());

        // Configurações comuns para GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Campo de senha
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel_login.add(new JLabel("Senha:"), constraints);

        JPasswordField campoSenha = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel_login.add(campoSenha, constraints);

        // Botão de Login
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton botaoLogin = new JButton("Entrar");
        panel_login.add(botaoLogin, constraints);

        // Botão de Voltar
        JButton botaoVoltar = new JButton("Voltar");
        constraints.gridy = 3;
        panel_login.add(botaoVoltar, constraints);

        // Adicionando o painel de login ao frame
        jFrame.add(panel_login, BorderLayout.CENTER);

        // Listener do botão Login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = new String(campoSenha.getPassword());
                try {
                    sf.entrarComoAdmin(senha);
                    new TelaPrincipalAdmin(sf); 
                    jFrame.dispose(); // Fecha a tela de login após o sucesso
                } catch (LoginFalhouException ex) {
                    JOptionPane.showMessageDialog(jFrame, "Login falhou: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Listener do botão Voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLogin(sf); // Volta para a tela de login inicial
                jFrame.dispose(); // Fecha a tela de login do administrador
            }
        });

        jFrame.setVisible(true);
    }
}
