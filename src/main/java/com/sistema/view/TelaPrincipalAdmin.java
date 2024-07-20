package main.java.com.sistema.view;

import javax.swing.*;

import main.java.com.sistema.modelo.ControllerSistema;
import main.java.com.sistema.modelo.Estoque;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalAdmin {

    private SistemaFacade sf;

    public TelaPrincipalAdmin(SistemaFacade sf) {
        this.sf = sf;
        JFrame frame = new JFrame("Gerenciamento de Pedidos - Administrador");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Configura a tela para fullscreen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definindo a tela principal
        frame.setLayout(new BorderLayout());
        JLabel labelBemVindo = new JLabel("Acesso do Administrador", SwingConstants.CENTER);
        labelBemVindo.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(labelBemVindo, BorderLayout.NORTH);

        // Painel para os botões
        JPanel panelBotoes = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Botão Cadastrar Produto
        JButton botaoCadastrarProduto = criarBotao("Cadastrar produto no sistema", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroProduto(Estoque.getInstance()); 
            }
        });
        panelBotoes.add(botaoCadastrarProduto, gbc);
        
        // Botão Remover Produto
        JButton botaoRemoverProduto = criarBotao("Remover produto do sistema", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRemoverProdutoEstoque(Estoque.getInstance()); 
            }
        });
        gbc.gridx++;
        panelBotoes.add(botaoRemoverProduto, gbc);

        // Botão Aumentar Estoque 
        JButton botaoAdicionarProduto = criarBotao("Aumentar quantidade de um produto", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new TelaAumentarEstoque(Estoque.getInstance()); 
            }
        });
        gbc.gridx = 0; 
        gbc.gridy++;
        panelBotoes.add(botaoAdicionarProduto, gbc);
        // Botão Diminuir Estoque 
        JButton botaoDiminuirProduto = criarBotao("Diminuir quantidade de um produto", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new TelaDiminuirEstoque(Estoque.getInstance()); 
            }
        });
        gbc.gridx++; 
        panelBotoes.add(botaoDiminuirProduto, gbc);

        // Botão Acessar Estoque
        JButton botaoAcessarEstoque = criarBotao("Acessar estoque", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaEstoque();
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        panelBotoes.add(botaoAcessarEstoque, gbc);

        // Botão Acessar Pedidos
        JButton botaoAcessarPedidos = criarBotao("Acessar pedidos", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Acessando Pedidos...");
            }
        });
        gbc.gridx++;
        panelBotoes.add(botaoAcessarPedidos, gbc);

        // Adicionando o painel de botões ao frame
        frame.add(panelBotoes, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Método para criar botões quadrados com o texto e listener fornecidos
    private JButton criarBotao(String texto, ActionListener listener) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.PLAIN, 20));
        botao.setPreferredSize(new Dimension(400, 200)); // Define tamanho quadrado
        botao.addActionListener(listener);
        return botao;
    }
}
