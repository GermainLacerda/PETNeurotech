package br.unicap.pet.neurotech.control;

import br.unicap.pet.neurotech.model.dao.MenbrosDAO;
import br.unicap.pet.neurotech.model.dao.MenbrosDAOMemoria;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class ADMController {
    private MenbrosDAO dao = MenbrosDAOMemoria.getInstance();

    public boolean VerificarLogin (int Login){
        return dao.VerificarLogin(Login);
    }

    public boolean ValidarSenha (String senha){
        return dao.ValidarSenha(senha);
    }

    public void AlterarSenha (String senhaNova){
        dao.AlterarSenha(senhaNova);
    }

    public void CriarContaCliente (int login, String senha){
        dao.CriarContaCliente(login, senha);
    }
    public void CriarContaGerente (int login, String senha){
        dao.CriarContaGerente(login, senha);
    }

    public boolean VerificarGerente (int login){
        return dao.VerificarGerente(login);
    }
}
