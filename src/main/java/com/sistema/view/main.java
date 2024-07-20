package main.java.com.sistema.view;

import main.java.com.sistema.modelo.ControllerSistema;

public class main {
    public static void main(String[] args) {
        ControllerSistema cs = new ControllerSistema();

        SistemaFacade sf = new SistemaFacade(cs); 
        
        new TelaLogin(sf);  
    }
    
}
