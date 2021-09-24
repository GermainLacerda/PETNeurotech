package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ContaDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAOMemoria;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class ClienteController {

    private ContaDAO dao = ContaDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void sacar(int login, int numConta, float quantia) throws  SaldoInsuficienteException, ContaInexistenteException{
        dao.sacarConta(login, numConta, quantia);
    }

    public void depositar(int login, int numConta, float quantia) {
        dao.depositarConta(login, numConta, quantia);
    }

    public String Saldo(int login, int numConta) {
        return dao.Saldo(login, numConta);
    }
}
