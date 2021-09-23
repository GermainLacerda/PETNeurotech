package br.unicap.pet.neurotech.model.dao;
import br.unicap.pet.neurotech.model.Exceptions.*;
public interface MenbrosDAO {
    boolean VerificarLogin (int login);
    boolean ValidarSenha(String senha);
    void AlterarSenha(String senhaNova);
    void CriarConta (int lodin, String senha);
}
