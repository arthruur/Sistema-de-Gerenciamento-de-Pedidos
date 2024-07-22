package main.java.com.sistema.view;

import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class TelaAumentarEstoque extends JFrame {

    private Estoque estoque;
    private JComboBox<Produto> comboProdutos;
    private JTextField campoQuantidade;

    public TelaAumentarEstoque(Estoque estoque) {
        this.estoque = estoque;

        setTitle("Aumentar Quantidade de Produto");
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
        JLabel labelQuantidade = new JLabel("Quantidade a aumentar:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(labelQuantidade, gbc);

        campoQuantidade = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(campoQuantidade, gbc);

        // Botão para confirmar o aumento de quantidade
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarQuantidade();
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

    // Método para aumentar a quantidade do produto selecionado
    private void aumentarQuantidade() {
        Produto produtoSelecionado = (Produto) comboProdutos.getSelectedItem();
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um produto!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String strQuantidade = campoQuantidade.getText().trim();
        if (strQuantidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a quantidade a aumentar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantidade = Integer.parseInt(strQuantidade);
            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean sucesso = estoque.adicionarQuantidade(produtoSelecionado, quantidade);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Quantidade aumentada com sucesso!");
                campoQuantidade.setText(""); // Limpa o campo de quantidade
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao aumentar quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (QuantidadeNaoAlteradaException ex) {
            JOptionPane.showMessageDialog(this,"Digite uma quantidade válida.");
        }
    }

    // Método principal para testar a tela
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Estoque estoque = Estoque.getInstance(); // Obtém a instância do estoque
            new TelaAumentarEstoque(estoque);
        });
    }
}
