package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class ContaDAOMemoria implements ContaDAO {

    private List<Conta> contas;
    private static ContaDAOMemoria self;

    public ContaDAOMemoria() {
        contas = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        boolean encontrado = false;
        if (contas.isEmpty() == false) {
            for (Conta conta : contas) {
                if (conta.getNumero() == numConta) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }

    public static ContaDAO getInstance() {
        if (self == null) {
            self = new ContaDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int numConta, float quantia) throws SaldoInsuficienteException, ContaInexistenteException{
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                conta.sacar(quantia);
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void depositarConta(int numConta, float quantia) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                conta.depositar(quantia);
            }
        }

    }

    @Override
    public void criarConta(int numConta) {
        Conta aux = new Conta(numConta);
        contas.add(aux);

    }

    @Override
    public void criarContaBonus(int numConta) {

        boolean b = buscarConta(numConta);
        if (!b) {
            Conta c = new Conta(numConta);
            contas.add(c);
        }

    }

    @Override
    public void aplicarBonus(int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                if (conta instanceof ContaBonus) {
                    ((ContaBonus) conta).renderBonus();
                }
                return;
            }
        }
    }

    @Override
    public String Saldo(int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                return conta.toString();
            }
        }
        return "Unexpected Error";

    }

}
