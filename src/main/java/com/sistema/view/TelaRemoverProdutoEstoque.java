package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

public class TelaRemoverProdutoEstoque {

    private Estoque estoque;

    public TelaRemoverProdutoEstoque(Estoque estoque) {
        this.estoque = estoque;
        JFrame frame = new JFrame("Remover Produto do Estoque");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Painel para a lista de produtos
        JPanel panelProdutos = new JPanel();
        panelProdutos.setLayout(new BoxLayout(panelProdutos, BoxLayout.Y_AXIS));

        // Preenche a lista de produtos
        preencherListaProdutos(panelProdutos);

        // ScrollPane para a lista de produtos
        JScrollPane scrollPane = new JScrollPane(panelProdutos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botão Remover
        JButton botaoRemover = new JButton("Remover Produtos Selecionados");
        botaoRemover.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(botaoRemover, BorderLayout.SOUTH);

        // Listener do botão Remover
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(frame, "Deseja remover os produtos selecionados?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    removerProdutosSelecionados(panelProdutos);
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para preencher a lista de produtos
    private void preencherListaProdutos(JPanel panelProdutos) {
        Iterator<Map.Entry<Produto, Integer>> iterator = estoque.listarProdutos();
        while (iterator.hasNext()) {
            Map.Entry<Produto, Integer> entry = iterator.next();
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();

            JCheckBox checkBox = new JCheckBox(produto.getNome() + " (Qtd: " + quantidade + ")");
            checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelProdutos.add(checkBox);
        }
    }

    // Método para remover os produtos selecionados
    private void removerProdutosSelecionados(JPanel panelProdutos) {
        Component[] componentes = panelProdutos.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) componente;
                if (checkBox.isSelected()) {
                    String nomeProduto = checkBox.getText().split(" ")[0]; // Pega o nome do produto antes do espaço
                    Produto produto = estoque.getProduto(nomeProduto);
                    if (produto != null) {
                        estoque.removerProduto(produto);
                    }
                }
            }
        }
        // Limpar e atualizar a lista após a remoção
        panelProdutos.removeAll();
        preencherListaProdutos(panelProdutos);
        panelProdutos.revalidate();
        panelProdutos.repaint();
    }
}
