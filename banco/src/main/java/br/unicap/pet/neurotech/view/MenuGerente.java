package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.view.util.Leitor;

public class MenuGerente {

    public void Menu() {
        GerenteView gv = new GerenteView();
        int op;
        do {
            System.out.println("\n<<MENU GERENTE>>");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Voltar");
            op = Leitor.getLeitor().nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    gv.CriarConta();
                    break;
                case 2:
                    System.out.println("Voltando!!");
                    break;
            }
        } while (op != 2);

    }

}
