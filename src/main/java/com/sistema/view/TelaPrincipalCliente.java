package main.java.com.sistema.view;

import main.java.com.sistema.modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import main.java.com.sistema.modelo.Estoque; 

public class TelaPrincipalCliente extends JFrame {
    private Cliente cliente;
    private SistemaFacade sf; 

    public TelaPrincipalCliente(Cliente cliente, SistemaFacade sf) {
        this.cliente = cliente;
        this.sf = sf; 
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

        // Criando a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuNavegacao = new JMenu("Navegação");
        JMenuItem menuItemVoltar = new JMenuItem("Voltar para a Tela Inicial");

        // Adicionando ação ao item de menu "Voltar para a Tela Inicial"
        menuItemVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new TelaLogin(sf); // Abre a tela de login
            }
        });

        menuNavegacao.add(menuItemVoltar);
        menuBar.add(menuNavegacao);
        setJMenuBar(menuBar);
        
        
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

        // Adicionando o painel de opções ao frame
        add(panelOpcoes, BorderLayout.CENTER);

        // Ações dos botões
        botaoPedidos.addActionListener(e -> new TelaPedidos(cliente));
        botaoProdutos.addActionListener(e -> new TelaAdicionarProdutoCarrinho(Estoque.getInstance(), cliente));
        botaoCarrinho.addActionListener(e -> new TelaCarrinho(cliente, sf));

        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setPreferredSize(new Dimension(200, 50));
        return botao;
    }

}
