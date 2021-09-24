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
    public void sacarConta(int login, int numConta, float quantia) throws SaldoInsuficienteException, ContaInexistenteException {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                conta.sacar(quantia);
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void depositarConta(int login, int numConta, float quantia) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                conta.depositar(quantia);
            }
        }

    }

    @Override
    public void criarConta(int login, int numConta) {
        Conta aux = new Conta(login, numConta);
        contas.add(aux);

    }

    @Override
    public void criarContaBonus(int login, int numConta) {

        boolean b = buscarConta(numConta);
        if (!b) {
            Conta c = new ContaBonus(login, numConta);
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
    public String Saldo(int login, int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                return conta.toString();
            }
        }
        return "Unexpected Error";

    }

   

}
