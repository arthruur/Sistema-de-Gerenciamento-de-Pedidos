package main.java.com.sistema.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import main.java.com.sistema.exception.LoginFalhouException;
import main.java.com.sistema.modelo.ControllerSistema; 

public class TelaLogin {

    private SistemaFacade sf;

    public TelaLogin(SistemaFacade sf) {
        this.sf = sf;
        JFrame jFrame = new JFrame("Sistema Gerenciamento de Pedidos - Login");
        jFrame.setSize(500, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);

        // Título da tela de login
        JLabel titulo = new JLabel("Sistema de Pedidos");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        jFrame.add(titulo, BorderLayout.NORTH);

        // Painel dos campos de login
        JPanel panel_login = new JPanel(new GridBagLayout());

        // Configurações comuns para GridBagConstraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Botão de Cadastrar Usuário
        constraints.gridx = 0; 
        constraints.gridy = 1; 
        constraints.gridwidth = 2; 
        constraints.anchor = GridBagConstraints.CENTER; 
        JButton botaoCadastrar = new JButton("Cadastrar Cliente"); 
        panel_login.add(botaoCadastrar, constraints); 

        // Botão de Login
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton botaoLogin = new JButton("Entrar como cliente");
        panel_login.add(botaoLogin, constraints);

        // Botão de Entrar como Admin 
        constraints.gridx = 0; 
        constraints.gridy = 3; 
        constraints.gridwidth = 3; 
        constraints.anchor = GridBagConstraints.CENTER; 
        JButton botaoEntrarAdmin = new JButton("Entrar como Admin"); 
        panel_login.add(botaoEntrarAdmin, constraints); 

        // Adicionando o painel de login ao frame
        jFrame.add(panel_login, BorderLayout.CENTER);

        // Listener do botão CadastrarUsuario 
        
        botaoCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            new TelaCadastroCliente(sf);
        }});

        // Listener do botão LoginUsuario
        botaoLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new TelaLoginCliente(sf); 
            
        }}); 


        // Listener do botão de EntrarComoAdmin
        botaoEntrarAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaLoginAdmin(sf);
            }
        });


        jFrame.setVisible(true);
    }
}