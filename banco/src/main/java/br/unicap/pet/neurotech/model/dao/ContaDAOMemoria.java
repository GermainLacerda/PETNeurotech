package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;

public class ContaDAOMemoria implements ContaDAO {

    private List<Conta> clientes;
    private static ContaDAOMemoria self;

    public ContaDAOMemoria() {
        clientes = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        boolean encontrado = false;
        if (clientes.isEmpty() == false) {
            for (Conta conta : clientes) {
                if (conta.getNumero() == numConta) {
                    encontrado = true;
                    return encontrado;
                }
            }
        }
        return encontrado;
    }

    @Override
    public void criarConta(int numConta, int tipoConta) {
        Conta aux = new Conta(numConta, tipoConta);
        clientes.add(aux);

    }

    public static ContaDAO getInstance() {
        if (self == null) {
            self = new ContaDAOMemoria();
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
        double result;
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                if (conta.getTipo() == 1) {
                    conta.depositar(quantia);
                    result = quantia * 0.01;
                    conta.AddBonus(result);
                } else {
                    conta.depositar(quantia);
                }

            }
        }
    }

    @Override
    public void aplicarBonus(int numConta) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                conta.bonificar();
            }
        }

    }

    @Override
    public void Saldo(int numConta) {
        for (Conta conta : clientes) {
            if (conta.getNumero() == numConta) {
                  System.out.println(conta.toString());
            }
        }
        
    }
}
