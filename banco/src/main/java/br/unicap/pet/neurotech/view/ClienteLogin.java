package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class ClienteLogin {
    public void Login() {
        int login;
        String senha;


        MenuCliente acessoCliente = new MenuCliente();
        ADMController acesso = new ADMController();
        ADMView acessoAdmView = new ADMView();


        System.out.println("Informe seu Id de Cliente");
        login = Leitor.getLeitor().nextInt();
        while (acesso.VerificarLogin(login) == false) {
            String CConta = " ";
            System.out.println("Informe novamente o seu Id de Cliente, se desejar criar uma conta digite 'criar'");
            login = Leitor.getLeitor().nextInt();
            CConta = Leitor.getLeitor().next();
            if (CConta == "criar") {
                acessoAdmView.CriarContaCliente(login);
                break;
            }
        }
        System.out.println("Informe sua Senha");
        senha = Leitor.getLeitor().next();
        while (acesso.ValidarSenha(senha) == false) {
            String CConta = " ";
            System.out.println("Informe novamente sua Senha, se desejar alterar sua senha digite 'alterar'");
            senha = Leitor.getLeitor().next();
            CConta = Leitor.getLeitor().next();
            if (CConta == "alterar") {
                acessoAdmView.AlterarSenha();
                break;
            }
        }        

        if(acesso.VerificarLogin(login)==true||acesso.ValidarSenha(senha)==true){
            acessoCliente.Menu();
        }
        

    }
}
