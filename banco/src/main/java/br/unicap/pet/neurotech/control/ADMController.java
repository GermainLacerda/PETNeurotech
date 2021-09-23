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

    public void CriarConta (int login, String senha){
        dao.CriarConta(login, senha);
    }
}
