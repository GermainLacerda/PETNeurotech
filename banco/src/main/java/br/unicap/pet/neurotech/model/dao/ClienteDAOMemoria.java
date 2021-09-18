package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOMemoria implements ClienteDAO {

    private List<Conta> clientes;
    private static ClienteDAOMemoria self;
    
    public ClienteDAOMemoria(){
        clientes = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        boolean encontrado = false;
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static ClienteDAO getInstance() {
        if (self == null) {
            self = new ClienteDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int numConta, float quantia) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.sacar(quantia);
            }
        }
    }

    @Override
    public void depositarConta(int numConta, float quantia) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.depositar(quantia);
            }
        }
    }
}
