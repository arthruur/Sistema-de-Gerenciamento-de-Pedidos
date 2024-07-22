package main.java.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.Carrinho;
import main.java.com.sistema.modelo.Produto;

public class TelaCarrinho {

    private Cliente cliente;
    private SistemaFacade sf; 

    public TelaCarrinho(Cliente cliente, SistemaFacade sf) {
        this.cliente = cliente;
        this.sf = sf; 
        JFrame frame = new JFrame("Carrinho de Compras");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Painel para a lista de itens no carrinho
        JPanel panelCarrinho = new JPanel();
        panelCarrinho.setLayout(new BoxLayout(panelCarrinho, BoxLayout.Y_AXIS));

        // Preencher a lista de itens do carrinho
        preencherListaItens(panelCarrinho);

        // ScrollPane para a lista de itens do carrinho
        JScrollPane scrollPane = new JScrollPane(panelCarrinho);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Painel para o botão de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botão para ir ao pagamento
        JButton botaoPagamento = new JButton("Ir para Pagamento");
        panelPagamento.add(botaoPagamento);
        frame.add(panelPagamento, BorderLayout.SOUTH);

        // Listener do botão de pagamento
        botaoPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaPagamento(cliente, sf); 
                frame.dispose(); // Fecha a tela do carrinho
            }
        });

        frame.setVisible(true);
    }

    // Método para preencher a lista de itens no carrinho
    private void preencherListaItens(JPanel panelCarrinho) {
        Carrinho carrinho = cliente.getCarrinho();
        Map<Produto, Integer> itens = carrinho.getItens();

        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            Integer quantidade = entry.getValue();
            double precoTotal = produto.getPreco() * quantidade;

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            // Adicionando informações do item
            String textoItem = String.format("%s (Qtd: %d) - R$ %.2f",
                produto.getNome(),
                quantidade,
                precoTotal);
            itemPanel.add(new JLabel(textoItem));

            panelCarrinho.add(itemPanel);
        }
    }
}
