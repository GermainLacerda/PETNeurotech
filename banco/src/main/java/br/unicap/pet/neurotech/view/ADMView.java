package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.view.util.Leitor;

public class ADMView {
    ADMController acesso = new ADMController();

    public void CriarContaCliente() {
        String senha;
        int login;
        System.out.println("Insira o seu ID:");
        login = Leitor.getLeitor().nextInt();
        System.out.println("Insira sua senha:");
        senha = Leitor.getLeitor().next();
        acesso.CriarContaCliente(login, senha);

    }

    public void CriarContaGerente() {
        String senha;
        int login;
        System.out.println("Insira o seu ID:");
        login = Leitor.getLeitor().nextInt();
        System.out.println("Insira sua senha:");
        senha = Leitor.getLeitor().next();
        acesso.CriarContaGerente(login, senha);

    }

    public void AlterarSenha() {
        String senhaNova, ConfirmacaosenhaNova;
        System.out.println("Informe uma nova senha:");
        senhaNova = Leitor.getLeitor().next();
        System.out.println("Repita a nova senha:");
        ConfirmacaosenhaNova = Leitor.getLeitor().next();
        while (senhaNova.equals(ConfirmacaosenhaNova) == false) {
            System.out.println("As senhas não coincidem");
            System.out.println("Por favor repita a nova senha:");
            ConfirmacaosenhaNova = Leitor.getLeitor().next();
        }

        acesso.AlterarSenha(senhaNova);

    }

}
