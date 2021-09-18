package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

public class GerenteDAOMemoria implements GerenteDAO{

    private List<Conta> clientes;
    private static GerenteDAOMemoria self;
    
    public GerenteDAOMemoria(){
        clientes = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {    	
        boolean encontrado = false;
        if(clientes.isEmpty()==false) {
        	for (Conta conta : clientes) {
                if (conta.getNumero() == numConta) {
                    encontrado = true;
                    return encontrado;
                }
            }	
        }
        return encontrado;
    }

    public static GerenteDAO getInstance() {
        if (self == null) {
            self = new GerenteDAOMemoria();
        }
        return self;
    }

    @Override
    public void criarConta(int numConta) {
        Conta aux = new Conta (numConta);
        clientes.add(aux);
        
    }
    
}
