package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class MenuGerente {

    public void Menu() {
        GerenteView gv = new GerenteView();
        int op;
        do {
            System.out.println("\n<<MENU GERENTE>>");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Bonificar Conta");
            System.out.println("3 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    gv.CriarConta();
                    break;
                case 2:
                    gv.bonificarConta();
                    break;
                case 3:
                    System.out.println("Voltando!!");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (op != 3);

    }

}
