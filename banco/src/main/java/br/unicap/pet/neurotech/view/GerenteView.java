package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ADMController;
import br.unicap.pet.neurotech.control.GerenteController;
import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class GerenteView {

    GerenteController acesso = new GerenteController();
    ADMController acessoadm = new ADMController();

    public void CriarConta() {
        int numConta;
        int tipoConta;
        int login;

        System.out.println("Informe o número da conta:");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);
        while (haConta) {
            System.out.println("Essa conta ja existe! Informe novamente o número da conta:");
            numConta = Leitor.getLeitor().nextInt();
            haConta = acesso.buscar(numConta);
        }

        System.out.println("Informe o login do cliente para vincular a conta");
        login = Leitor.getLeitor().nextInt();
        while (acessoadm.VerificarLogin(login) != false) {
            System.out.println("Cliente não encontrado, informe novamente para vincular a conta");
            login = Leitor.getLeitor().nextInt();
        }

        System.out.println("Informe o tipo da conta(0 para normal 1 para bonificada): ");
        tipoConta = Leitor.getLeitor().nextInt();
        while (tipoConta != 0 && tipoConta != 1) {
            System.out.println("Informe o tipo da conta novamente(0 para normal 1 para bonificada): ");
            tipoConta = Leitor.getLeitor().nextInt();
        }
        if (tipoConta == 1) {
            acesso.criarContaBonus(login, numConta);
        } else {
            acesso.criarConta(login, numConta);
        }

    }

    public void bonificarConta() {
        int numConta;
        System.out.println("Informe o número da conta:");
        numConta = Leitor.getLeitor().nextInt();
        acesso.aplicarBonus(numConta);
    }
}
