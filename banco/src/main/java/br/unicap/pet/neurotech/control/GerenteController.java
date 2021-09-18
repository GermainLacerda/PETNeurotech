package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.ContaDAO;
import br.unicap.pet.neurotech.model.dao.ContaDAOMemoria;

public class GerenteController {

    private ContaDAO dao = ContaDAOMemoria.getInstance();

    public boolean buscar(int numConta) {
        return dao.buscarConta(numConta);
    }

    public void criarConta(int numConta, int tipoConta) {
        dao.criarConta(numConta, tipoConta);
    }

    public void aplicarBonus(int numConta) {
        dao.aplicarBonus(numConta);
    }

}
