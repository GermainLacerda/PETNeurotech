package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ContaDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAOMemoria;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class ClienteController {

    private ContaDAO dao = ContaDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void sacar(int numConta, float quantia) throws  SaldoInsuficienteException, ContaInexistenteException{
        dao.sacarConta(numConta, quantia);
    }

    public void depositar(int numConta, float quantia) {
        dao.depositarConta(numConta, quantia);
    }

    public String Saldo(int numConta) {
        return dao.Saldo(numConta);
    }
}
