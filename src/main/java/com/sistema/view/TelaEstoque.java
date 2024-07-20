package main.java.com.sistema.view;

import main.java.com.sistema.modelo.ControllerSistema;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class TelaEstoque {

    private Estoque estoque;

    public TelaEstoque() {
        this.estoque = Estoque.getInstance(); // Obter a instância singleton do Estoque
        JFrame frame = new JFrame("Estoque");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criar o modelo da tabela
        String[] colunas = {"Produto", "Quantidade"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);

        // Preencher o modelo da tabela com os produtos do estoque
        for (Map.Entry<Produto, Integer> entry : estoque.getProdutos().entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            Object[] rowData = {produto.getNome(), quantidade};
            tableModel.addRow(rowData);
        }

        // Criar a tabela com o modelo
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adicionar a tabela ao frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Centralizar a janela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
