package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuPrincipal {

    public static void main(String[] args) {
        int op;
        MenuCliente acessoCliente = new MenuCliente();
        MenuGerente acessoGerente = new MenuGerente();
        do {

            System.out.println("<<MENU PRINCIPAL>>");
            System.out.println("1 - Cliente");
            System.out.println("2 - Gerente");
            System.out.println("3 - Sair");
            op = Leitor.getLeitor().nextInt();
            switch (op) {
                case 1:
                    acessoCliente.Menu();
                    //no view pedir o login caso nn tenha, fazer com que o gerente faça o cadastro do cliente e 
                    //abra a sua conta
                    break;
                case 2:
                    acessoGerente.Menu();
                    //no view pedir o login caso nn tenha, abrir para criar conta gerente
                    break;
                case 3:
                    System.exit(0);
            }
        } while (op != 3);

    }

}
