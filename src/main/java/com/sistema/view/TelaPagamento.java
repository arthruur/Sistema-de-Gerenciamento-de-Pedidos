package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.Estoque;
import main.java.com.sistema.modelo.Pagamento;
import main.java.com.sistema.modelo.Pedido;
import main.java.com.sistema.modelo.Produto;

public class TelaPagamento {

    private Cliente cliente;
    private SistemaFacade sf; 

    public TelaPagamento(Cliente cliente, SistemaFacade sf) {
        this.cliente = cliente;
        this.sf = sf; 
        JFrame frame = new JFrame("Tela de Pagamento");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Painel para selecionar o método de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setLayout(new GridLayout(4, 1, 10, 10)); // Layout com 4 linhas e 1 coluna

        // Opções de pagamento
        JRadioButton opcaoCartaoCredito = new JRadioButton("Cartão de Crédito");
        JRadioButton opcaoPix = new JRadioButton("Pix");
        JRadioButton opcaoPayPal = new JRadioButton("PayPal");
        JRadioButton opcaoTransferencia = new JRadioButton("Transferência Bancária");

        // Agrupando os botões de rádio
        ButtonGroup grupoPagamentos = new ButtonGroup();
        grupoPagamentos.add(opcaoCartaoCredito);
        grupoPagamentos.add(opcaoPix);
        grupoPagamentos.add(opcaoPayPal);
        grupoPagamentos.add(opcaoTransferencia);

        // Adicionando os botões ao painel
        panelPagamento.add(opcaoCartaoCredito);
        panelPagamento.add(opcaoPix);
        panelPagamento.add(opcaoPayPal);
        panelPagamento.add(opcaoTransferencia);

        // Botão para confirmar o pagamento
        JButton botaoConfirmar = new JButton("Confirmar Pagamento");
        frame.add(panelPagamento, BorderLayout.CENTER);
        frame.add(botaoConfirmar, BorderLayout.SOUTH);

        // Listener do botão Confirmar Pagamento
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica qual método de pagamento foi selecionado
                String metodoPagamento = "";
                if (opcaoCartaoCredito.isSelected()) {
                    metodoPagamento = "Cartão de Crédito";
                } else if (opcaoPix.isSelected()) {
                    metodoPagamento = "Pix";
                } else if (opcaoPayPal.isSelected()) {
                    metodoPagamento = "PayPal";
                } else if (opcaoTransferencia.isSelected()) {
                    metodoPagamento = "Transferência Bancária";
                }

                if (metodoPagamento.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione um método de pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Cria o objeto Pagamento
                    Pagamento pagamento = new Pagamento(metodoPagamento, cliente.getCarrinho().getValorTotal());

                    // Cria o objeto Pedido
                    Pedido pedido = new Pedido(cliente.getCarrinho(), cliente, pagamento);
                    cliente.adicionarPedido(pedido);
                    sf.getController().getAdmin().adicionarPedido(pedido); 

                    // Remover os itens do carrinho e atualizar o estoque
                    for (Map.Entry<Produto, Integer> entry : cliente.getCarrinho().getItens().entrySet()) {
                        Produto produto = entry.getKey();
                        int quantidade = entry.getValue();

                        // Atualiza o estoque
                        try {
                            Estoque.getInstance().diminuirQuantidade(produto, quantidade);
                        } catch (QuantidadeNaoAlteradaException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    // Limpa o carrinho do cliente
                    cliente.getCarrinho().esvaziar();

                    // Aqui você pode implementar a lógica para processar o pedido
                    JOptionPane.showMessageDialog(frame, "Pagamento realizado com sucesso via " + metodoPagamento, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose(); // Fecha a tela de pagamento após o sucesso
                }
            }
        });

        frame.setVisible(true);
    }
}
