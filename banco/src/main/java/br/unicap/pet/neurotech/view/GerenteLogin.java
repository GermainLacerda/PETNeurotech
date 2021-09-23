package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class GerenteLogin {

    public void Login() {
        int id, senha;
        MenuCliente acessoGerente = new MenuCliente();
        
        System.out.println("Informe seu Id de Cliente");
        id = Leitor.getLeitor().nextInt();
        //verificar ID
        
        System.out.println("Informe sua Senha");
        senha = Leitor.getLeitor().nextInt();
        // verificar a senha
        
        acessoGerente.Menu();
    }
}
