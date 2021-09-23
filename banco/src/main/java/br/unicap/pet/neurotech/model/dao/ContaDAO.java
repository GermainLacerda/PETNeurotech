package br.unicap.pet.neurotech.model.dao;
import br.unicap.pet.neurotech.model.Exceptions.*;

public interface ContaDAO {

    boolean buscarConta(int numConta);

    void sacarConta(int numConta, float quantia)throws SaldoInsuficienteException, ContaInexistenteException;

    void depositarConta(int numConta, float quantia);

    void criarConta(int numConta);

    void criarContaBonus(int numConta);

    void aplicarBonus(int numConta);

    String Saldo (int numConta);
}
