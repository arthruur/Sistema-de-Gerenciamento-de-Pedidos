package main.java.com.sistema.view;

import main.java.com.sistema.modelo.Cliente;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipalCliente extends JFrame {
    private Cliente cliente;

    public TelaPrincipalCliente(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Tela Principal do Cliente");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela em modo fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de boas-vindas
        JLabel labelBemVindo = new JLabel("Bem-vindo, " + cliente.getNome(), SwingConstants.CENTER);
        labelBemVindo.setFont(new Font("Arial", Font.BOLD, 24));
        add(labelBemVindo, BorderLayout.NORTH);

        // Painel com opções para o cliente
        JPanel panelOpcoes = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Botão para acessar perfil
        JButton botaoPerfil = criarBotao("Meu Perfil");
        panelOpcoes.add(botaoPerfil, gbc);

        // Botão para acessar pedidos
        JButton botaoPedidos = criarBotao("Meus Pedidos");
        gbc.gridy++;
        panelOpcoes.add(botaoPedidos, gbc);

        // Botão para acessar produtos
        JButton botaoProdutos = criarBotao("Produtos");
        gbc.gridy++;
        panelOpcoes.add(botaoProdutos, gbc);

        // Botão para acessar o Carrinho 

        JButton botaoCarrinho = criarBotao("Carrinho"); 
        gbc.gridy++; 
        panelOpcoes.add(botaoCarrinho, gbc);

        // Botão para sair
        JButton botaoSair = criarBotao("Sair");
        gbc.gridy++;
        panelOpcoes.add(botaoSair, gbc);

        // Adicionando o painel de opções ao frame
        add(panelOpcoes, BorderLayout.CENTER);

        // Ações dos botões
        botaoPerfil.addActionListener(e -> mostrarMensagem("Acessando perfil do cliente..."));
        botaoPedidos.addActionListener(e -> mostrarMensagem("Acessando pedidos do cliente..."));
        botaoProdutos.addActionListener(e -> mostrarMensagem("Acessando produtos disponíveis..."));
        botaoCarrinho.addActionListener(e -> mostrarMensagem("Acessando carrinho..."));
        botaoSair.addActionListener(e -> dispose());

        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setPreferredSize(new Dimension(200, 50));
        return botao;
    }

    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
