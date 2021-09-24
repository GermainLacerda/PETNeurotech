package br.unicap.pet.neurotech.model.dao;
import br.unicap.pet.neurotech.model.Exceptions.*;
public interface MenbrosDAO {
    boolean VerificarLogin (int login);
    boolean ValidarSenha(String senha);
    void AlterarSenha(String senhaNova);
    void CriarContaCliente (int lodin, String senha);
    void CriarContaGerente (int lodin, String senha);
    boolean VerificarGerente (int login);
}
