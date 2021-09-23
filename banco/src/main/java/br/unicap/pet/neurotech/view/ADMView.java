package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.view.util.Leitor;

public class ADMView {
    ADMController acesso = new ADMController();

    public void CriarContaCliente(int login) {
        String resp, senha;
        System.out.println("Deseja usar o ID inserido anteriormente, Responda com sim ou nao");
        resp = Leitor.getLeitor().next();
        while (resp != "sim" || resp != "nao") {
            System.out.println("Responda apenas com 'sim' ou 'nao'");
            resp = Leitor.getLeitor().next();
        }
        if (resp == "sim") {
            System.out.println("Insira sua senha");
            senha = Leitor.getLeitor().next();
            acesso.CriarConta(login, senha);
        } else {
            System.out.println("Insira o seu ID:");
            login = Leitor.getLeitor().nextInt();
            System.out.println("Insira sua senha:");
            senha = Leitor.getLeitor().next();
            acesso.CriarConta(login, senha);
        }

    }

    public void CriarContaGerente(int id) {
        String resp, senha;
        System.out.println("Deseja usar o ID inserido anteriormente, Responda com sim ou nao");
        resp = Leitor.getLeitor().next();
        while (resp != "sim" || resp != "nao") {
            System.out.println("Responda apenas com 'sim' ou 'nao'");
            resp = Leitor.getLeitor().next();
        }
        if (resp == "sim") {
            System.out.println("Insira sua senha");
            senha = Leitor.getLeitor().next();
            acesso.CriarConta(id, senha);
        } else {
            System.out.println("Insira o seu ID:");
            id = Leitor.getLeitor().nextInt();
            System.out.println("Insira sua senha:");
            senha = Leitor.getLeitor().next();
            acesso.CriarConta(id, senha);
        }

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
