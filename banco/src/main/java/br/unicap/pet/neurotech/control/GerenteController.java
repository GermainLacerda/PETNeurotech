package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ContaDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAOMemoria;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class GerenteController {

    private ContaDAO dao = ContaDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void criarConta(int login, int numConta) {
        dao.criarConta(login, numConta);
    }

    public void criarContaBonus(int login, int numConta) {
        dao.criarContaBonus(login, numConta);
    }

    public void aplicarBonus(int numConta) {
        dao.aplicarBonus(numConta);
    }

    

}
