package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class ADMView {
    
    public void CriarConta (){
        int Id;
        String resp, senha;
        System.out.println("Deseja usar o id inserido anteriormente, Responda com sim ou nao");
        resp = Leitor.getLeitor().next();
        while (resp != "sim" || resp != "nao"){
            System.out.println("Responda apenas com 'sim' ou 'nao'");
            resp = Leitor.getLeitor().next();
        }
        if (resp == "sim"){
            System.out.println("insira sua senha");
            senha = Leitor.getLeitor().next();
        }else{
            System.out.println("Insira o seu id:");
            Id = Leitor.getLeitor().nextInt();
            System.out.println("insira sua senha:");
            senha = Leitor.getLeitor().next();
        }

    }

}
