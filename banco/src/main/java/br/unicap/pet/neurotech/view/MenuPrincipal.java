package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuPrincipal {

    public static void main(String[] args) {
        int op;
        ClienteLogin loginCliente = new ClienteLogin();
        GerenteLogin loginGerente = new GerenteLogin();

        do {
            System.out.println("<<MENU PRINCIPAL>>");
            System.out.println("1 - Cliente");
            System.out.println("2 - Gerente");
            System.out.println("3 - Sair");
            op = Leitor.getLeitor().nextInt();
            switch (op) {
                case 1:
                    loginCliente.Login();
                    break;
                case 2:
                    loginGerente.Login();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (op != 3);

    }

}
