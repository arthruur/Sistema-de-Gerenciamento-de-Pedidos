package main.java.com.sistema.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.Pedido;
import main.java.com.sistema.modelo.Produto; 

public class TelaPedidos {

    private Cliente cliente;

    public TelaPedidos(Cliente cliente) {
        this.cliente = cliente;
        JFrame frame = new JFrame("Meus Pedidos");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Criar o modelo da tabela
        String[] colunas = {"ID do Pedido", "Status", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);

        // Preencher o modelo da tabela com os pedidos do cliente
        List<Pedido> pedidos = cliente.getPedidos();
        for (Pedido pedido : pedidos) {
            String idPedido = pedido.toString(); 
            String status = pedido.getEstado();
            String total = String.format("R$ %.2f", pedido.getPagamento().getValor());

            Object[] rowData = {idPedido, status, total};
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
