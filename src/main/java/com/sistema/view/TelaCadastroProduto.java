package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.com.sistema.exception.ProdutoNaoCadastrou;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

public class TelaCadastroProduto {

    private Estoque estoque;

    public TelaCadastroProduto(Estoque estoque) {
        this.estoque = estoque;
        JFrame frame = new JFrame("Cadastro de Produto");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Painel para os campos de cadastro
        JPanel panelCadastro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de texto para nome, preço e descrição
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCadastro.add(new JLabel("Nome:"), gbc);

        JTextField campoNome = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelCadastro.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCadastro.add(new JLabel("Preço:"), gbc);

        JTextField campoPreco = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCadastro.add(campoPreco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCadastro.add(new JLabel("Descrição:"), gbc);

        JTextField campoDescricao = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelCadastro.add(campoDescricao, gbc);

        // Botão Cadastrar
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botaoCadastrar = new JButton("Cadastrar");
        panelCadastro.add(botaoCadastrar, gbc);

        // Listener do botão Cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                String descricao = campoDescricao.getText();

                // Aqui você deve chamar o método do estoque para cadastrar o produto
                Produto produto;
                try {
                    produto = estoque.cadastrarProduto(nome, preco, descricao, 0);
                    JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso!");
                    // Limpar campos após o cadastro (opcional)
                    campoNome.setText("");
                    campoPreco.setText("");
                    campoDescricao.setText("");

                } catch (ProdutoNaoCadastrou e1) {
                    JOptionPane.showMessageDialog(frame, "Erro ao cadastrar o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
                } // 0 ou a quantidade inicial desejada

            }
        });

        frame.add(panelCadastro, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
