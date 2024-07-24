package main.java.com.sistema.view;

import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class TelaDiminuirEstoque extends JFrame {

    private Estoque estoque;
    private JComboBox<Produto> comboProdutos;
    private JTextField campoQuantidade;
    private SistemaFacade sf; 

    public TelaDiminuirEstoque(Estoque estoque, SistemaFacade sf) {
        this.estoque = estoque;
        this.sf = sf; 

        setTitle("Diminuir Quantidade de Produto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel para seleção de produto e quantidade
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ComboBox para selecionar o produto
        JLabel labelProduto = new JLabel("Selecione o produto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelProduto, gbc);

        comboProdutos = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        carregarProdutos();
        panel.add(comboProdutos, gbc);

        // Campo de texto para especificar a quantidade
        JLabel labelQuantidade = new JLabel("Quantidade a diminuir:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(labelQuantidade, gbc);

        campoQuantidade = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(campoQuantidade, gbc);

        // Botão para confirmar a diminuição de quantidade
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    diminuirQuantidade();
                } catch (QuantidadeNaoAlteradaException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(botaoConfirmar, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Método para carregar os produtos disponíveis no estoque no ComboBox
    private void carregarProdutos() {
        Map<Produto, Integer> produtos = estoque.getProdutos();
        for (Produto produto : produtos.keySet()) {
            comboProdutos.addItem(produto);
        }
    }

    // Método para diminuir a quantidade do produto selecionado
    private void diminuirQuantidade() throws QuantidadeNaoAlteradaException {
        Produto produtoSelecionado = (Produto) comboProdutos.getSelectedItem();
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String strQuantidade = campoQuantidade.getText().trim();
        if (strQuantidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a quantidade a diminuir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantidade = Integer.parseInt(strQuantidade);
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean sucesso = estoque.diminuirQuantidade(produtoSelecionado, quantidade);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Quantidade diminuída com sucesso!");
                campoQuantidade.setText(""); // Limpa o campo de quantidade
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao diminuir quantidade! Verifique o estoque disponível.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    }

