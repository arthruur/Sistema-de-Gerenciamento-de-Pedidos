package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.com.sistema.modelo.Pedido;

public class TelaPedidoAdmin {

    private List<Pedido> pedidos; // Lista de pedidos para exibir e atualizar
    private Map<Pedido, JCheckBox> checkboxes; // Mapeia pedidos para suas checkboxes

    public TelaPedidoAdmin(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        this.checkboxes = new HashMap<>();
        JFrame frame = new JFrame("Pedidos do Sistema");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel para a lista de checkboxes
        JPanel panelPedidos = new JPanel();
        panelPedidos.setLayout(new BoxLayout(panelPedidos, BoxLayout.Y_AXIS));

        // Adicionar checkboxes para cada pedido
        for (Pedido pedido : pedidos) {
            JCheckBox checkBox = new JCheckBox("Pedido ID: " + pedido.toString() + " - Status: " + pedido.getEstado());
            checkboxes.put(pedido, checkBox);
            panelPedidos.add(checkBox);
        }

        // ScrollPane para a lista de checkboxes
        JScrollPane scrollPane = new JScrollPane(panelPedidos);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Painel para o botão de atualizar status
        JPanel panelBotao = new JPanel();
        panelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botão para atualizar o status
        JButton botaoAtualizarStatus = new JButton("Atualizar Status");
        botaoAtualizarStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarStatusPedidos();
            }
        });
        panelBotao.add(botaoAtualizarStatus);
        frame.add(panelBotao, BorderLayout.SOUTH);

        // Configurações finais da janela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Método para atualizar o status dos pedidos selecionados
    private void atualizarStatusPedidos() {
        for (Map.Entry<Pedido, JCheckBox> entry : checkboxes.entrySet()) {
            Pedido pedido = entry.getKey();
            JCheckBox checkBox = entry.getValue();

            if (checkBox.isSelected()) {
                pedido.proximoEstado(); // Atualiza o pedido para o próximo estado
            }
        }
        JOptionPane.showMessageDialog(null, "Status dos pedidos selecionados atualizado.");
        atualizarLabelsCheckboxes(); // Atualiza os labels das checkboxes
    }

    // Método para atualizar os labels das checkboxes com o novo status
    private void atualizarLabelsCheckboxes() {
        for (Map.Entry<Pedido, JCheckBox> entry : checkboxes.entrySet()) {
            Pedido pedido = entry.getKey();
            JCheckBox checkBox = entry.getValue();
            checkBox.setText("Pedido ID: " + pedido.toString() + " - Status: " + pedido.getEstado());
        }
    }
}
