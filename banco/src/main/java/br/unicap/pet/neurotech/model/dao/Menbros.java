package br.unicap.pet.neurotech.model.dao;

import br.unicap.pet.neurotech.model.Exceptions.*;

public class Menbros {
    private int login;
    private String senha;

    public Menbros(int login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void AlterarSenha(String senhaAntiga, String senhaNova) {

    }

    public int getLogin() {
        return this.login;
    }

    public Boolean ConferirSenha(String senhaPassada) {
        boolean confere = false;
        if (this.senha.equals(senhaPassada) == true) {
            confere = true;
        }
        return confere;
    }

    public void AlterarSenha(String senhaPassada) {
        this.senha = senhaPassada;
        
    }

}
