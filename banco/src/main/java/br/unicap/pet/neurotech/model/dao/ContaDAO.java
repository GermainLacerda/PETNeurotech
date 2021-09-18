package br.unicap.pet.neurotech.model.dao;

public interface ContaDAO {

    boolean buscarConta(int numConta);

    void sacarConta(int numConta, float quantia);

    void depositarConta(int numConta, float quantia);

    void criarConta(int numConta, int tipoConta);

    void aplicarBonus(int numConta);

    void Saldo (int numConta);
}
