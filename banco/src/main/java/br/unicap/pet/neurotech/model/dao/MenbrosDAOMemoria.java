package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class MenbrosDAOMemoria implements MenbrosDAO {

    private List<Menbros> Menbros;
    private static MenbrosDAOMemoria self;

    public MenbrosDAOMemoria() {
        Menbros = new ArrayList<Menbros>();
    }

    public static MenbrosDAO getInstance() {
        if (self == null) {
            self = new MenbrosDAOMemoria();
        }
        return self;
    }

    @Override
    public boolean VerificarLogin(int login) {
        boolean encontrado = false;
        if (Menbros.isEmpty() == false) {
            for (Menbros menbro : Menbros) {
                if (menbro.getLogin() == login) {
                    encontrado = true;
                    return encontrado;
                }
            }
        }
        return encontrado;
    }

    @Override
    public boolean ValidarSenha(String senha) {
        boolean confere = false;
        if (Menbros.isEmpty() == false) {
            for (Menbros menbro : Menbros) {
                confere = menbro.ConferirSenha(senha);
                return confere;

            }
        }
        return confere;
    }

    @Override
    public void AlterarSenha(String senhaNova) {
        if (Menbros.isEmpty() == false) {
            for (Menbros menbro : Menbros) {
                menbro.AlterarSenha(senhaNova);
            }
        }
    }
    
    @Override
    public void CriarContaCliente(int login, String senha) {
        Menbros aux = new MenbroCliente(login, senha);
        Menbros.add(aux);

    }

    @Override
    public void CriarContaGerente(int login, String senha) {
        Menbros aux = new MenbroGerente(login, senha);
        Menbros.add(aux);

    }

    @Override
    public boolean VerificarGerente (int login){
        boolean gerente = false;
        if (Menbros.isEmpty() == false) {
            for (Menbros menbro : Menbros) {
                if (menbro.getLogin() == login) {
                    if (menbro instanceof MenbroGerente) {
                        gerente = true;
                        return gerente;
                    }
                    
                }
            }
        }
        return gerente;
    }

}
