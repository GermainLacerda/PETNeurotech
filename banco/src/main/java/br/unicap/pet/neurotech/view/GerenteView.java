package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.GerenteController;
import br.unicap.pet.neurotech.view.util.Leitor;

public class GerenteView {

    GerenteController acesso = new GerenteController();

    public void CriarConta() {
        int numConta;

        System.out.println("Informe o número da conta:");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);

        if (haConta) {
            System.out.println("Essa conta ja existe!");
        } else {
            acesso.criarConta(numConta);
        }
    }
}
