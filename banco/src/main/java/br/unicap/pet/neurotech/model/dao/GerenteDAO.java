package br.unicap.pet.neurotech.model.dao;

public interface GerenteDAO {

    boolean buscarConta(int numConta);

    void criarConta(int numConta);
}
