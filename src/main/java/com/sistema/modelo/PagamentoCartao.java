package main.java.com.sistema.modelo;
import java.util.Date;

public class PagamentoCartao extends Pagamento {
    
    private int numero;
    private String nomeTitular;
    private Date vencimento;
    private int cvc;
    private double valor;


    public PagamentoCartao(int numero, String nomeTitular, Date vencimento, int cvc){
        super("Cartão");
    }

    public void pagar(){
    //fazer algo rs
    }

}
