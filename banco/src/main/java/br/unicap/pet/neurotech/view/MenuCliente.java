package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class MenuCliente {

    public void Menu(int login) throws ContaInexistenteException{
        ClienteView cv = new ClienteView();
        int op;
        do {
            System.out.println("\n<<MENU CLIENTE>>");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    cv.sacar(login);
                    break;
                case 2:
                    cv.depositar(login);
                    break;
                case 3:
                    cv.Saldo(login);
                    break;
                case 4:
                	System.out.println("Voltando!!");
                    break;
                default:
                System.out.println("Opção invalida!!");
            }
        } while (op != 4);

    }

}
