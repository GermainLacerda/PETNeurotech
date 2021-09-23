package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ClienteController;
import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class ClienteView {

    ClienteController acesso = new ClienteController();

    public void sacar() {
        int numConta;
        try {
            System.out.println("numero da conta ");
            numConta = Leitor.getLeitor().nextInt();
            System.out.println("Informe a quantia a Sacar: ");
            float quantia = Leitor.getLeitor().nextFloat();
            acesso.sacar(numConta, quantia);
            System.out.println("Saque realizado com sucesso");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo Insuficiente para o saque");
        } catch (ContaInexistenteException e) {
            System.out.println("Número de conta não existe");
        }
    }

    public void depositar() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);

        if (haConta) {
            System.out.println("Informe a quantia a Depositar: ");
            float quantia = Leitor.getLeitor().nextFloat();
            acesso.depositar(numConta, quantia);
        } else {
            System.out.println("Conta Inexistente");
        }
    }

    public void Saldo() {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);
        if (haConta) {
            System.out.println(acesso.Saldo(numConta));
            // imprime o saldo aki, nao no toString
        } else {
            System.out.println("Conta Inexistente");
        }
    }
}
