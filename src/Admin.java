public class Admin {
    private Estoque estoque;

    public void gerenciarEstoqueDeProdutos() {
        // Implementação para gerenciar o estoque
    }

    public void processarEAprovarPedido(Pedido pedido) {
        pedido.proximoEstado();
    }

    public String acompanharStatusDoPedido(Pedido pedido) {
        return pedido.getEstado();
    }

    // Construtor, getters e setters
}
