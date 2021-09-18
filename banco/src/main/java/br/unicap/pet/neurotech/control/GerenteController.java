package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.GerenteDAO;
import br.unicap.pet.neurotech.model.dao.GerenteDAOMemoria;

public class GerenteController {
    
    private GerenteDAO dao = GerenteDAOMemoria.getInstance();

    public boolean buscar (int numConta){
        return dao.buscarConta(numConta);
    }

    public void criarConta(int numConta) {
        dao.criarConta(numConta);
    }
    
    

}
