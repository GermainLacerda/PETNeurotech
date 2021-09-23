package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class ClienteLogin {
//ter adm controller para verificar conta
    public void Login() {
        int id, senha;
        MenuCliente acessoCliente = new MenuCliente();
        
        System.out.println("Informe seu Id de Cliente");
        id = Leitor.getLeitor().nextInt();
        //verificar ID
        /*
        Se nao existe, pedir para inserir novamente ou criar conta
        Criar chama ADMView
        */

        System.out.println("Informe sua Senha");
        senha = Leitor.getLeitor().nextInt();
        //verificar a senha
        /*
        Se nao compativel, pedir para inserir novamente
        */

        acessoCliente.Menu();
        
    }
}
