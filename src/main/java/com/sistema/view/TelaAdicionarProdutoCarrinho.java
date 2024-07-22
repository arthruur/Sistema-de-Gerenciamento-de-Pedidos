package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

public class TelaAdicionarProdutoCarrinho {

    private Estoque estoque;
    private Cliente cliente;

    public TelaAdicionarProdutoCarrinho(Estoque estoque, Cliente cliente) {
        this.estoque = estoque;
        this.cliente = cliente;
        JFrame frame = new JFrame("Adicionar Produto ao Carrinho");
        frame.setSize(500, 400);
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

        // Botão Adicionar ao Carrinho
        JButton botaoAdicionar = new JButton("Adicionar ao Carrinho");
        botaoAdicionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(botaoAdicionar, BorderLayout.SOUTH);

        // Listener do botão Adicionar ao Carrinho
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProdutosAoCarrinho(panelProdutos);
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

            JPanel produtoPanel = new JPanel();
            produtoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JCheckBox checkBox = new JCheckBox(produto.getNome() 
                + " (Qtd: " + quantidade 
                + ", Preço: R$ " + produto.getPreco() + ")");
            produtoPanel.add(checkBox);

            JTextField quantidadeField = new JTextField(5);
            quantidadeField.setToolTipText("Quantidade");
            produtoPanel.add(quantidadeField);

            panelProdutos.add(produtoPanel);
        }
    }

    // Método para adicionar os produtos selecionados ao carrinho do cliente
    private void adicionarProdutosAoCarrinho(JPanel panelProdutos) {
        Component[] componentes = panelProdutos.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JPanel) {
                JPanel produtoPanel = (JPanel) componente;
                Component[] subComponentes = produtoPanel.getComponents();
                JCheckBox checkBox = null;
                JTextField quantidadeField = null;
                for (Component subComponente : subComponentes) {
                    if (subComponente instanceof JCheckBox) {
                        checkBox = (JCheckBox) subComponente;
                    } else if (subComponente instanceof JTextField) {
                        quantidadeField = (JTextField) subComponente;
                    }
                }
                if (checkBox != null && quantidadeField != null && checkBox.isSelected()) {
                    String nomeProduto = checkBox.getText().split(" ")[0]; // Pega o nome do produto antes do espaço
                    Produto produto = estoque.getProduto(nomeProduto);
                    if (produto != null) {
                        try {
                            int quantidade = Integer.parseInt(quantidadeField.getText().trim());
                            if (quantidade > 0) {
                                cliente.getCarrinho().adicionarProduto(produto, quantidade); // Adiciona o produto ao carrinho do cliente
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Quantidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        // Mensagem de sucesso após adicionar os produtos ao carrinho
        JOptionPane.showMessageDialog(null, "Produtos adicionados ao carrinho com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
