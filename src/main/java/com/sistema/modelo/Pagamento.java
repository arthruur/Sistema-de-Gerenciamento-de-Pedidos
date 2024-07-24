package main.java.com.sistema.modelo;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private String metodoPagamento;
    private double valor; 

    public Pagamento(String metodoPagamento, double valor) {
        this.metodoPagamento = metodoPagamento;
        this.valor = valor; 
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getValor(){
        return valor; 
    }
}
