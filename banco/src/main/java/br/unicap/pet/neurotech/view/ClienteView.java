package br.unicap.pet.neurotech.view;

import br.unicap.pet.neurotech.control.ClienteController;
import br.unicap.pet.neurotech.view.util.Leitor;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class ClienteView {

    ClienteController acesso = new ClienteController();

    public void sacar(int login) {
        int numConta;
        try {
            System.out.println("numero da conta ");
            numConta = Leitor.getLeitor().nextInt();
            System.out.println("Informe a quantia a Sacar: ");
            float quantia = Leitor.getLeitor().nextFloat();
            acesso.sacar(login, numConta, quantia);
            System.out.println("Saque realizado com sucesso");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo Insuficiente para o saque");
        } catch (ContaInexistenteException e) {
            System.out.println("Número de conta não existe");
        }
    }

    public void depositar(int login) {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);

        if (haConta) {
            System.out.println("Informe a quantia a Depositar: ");
            float quantia = Leitor.getLeitor().nextFloat();
            acesso.depositar(login, numConta, quantia);
        } else {
            System.out.println("Conta Inexistente");
        }
    }

    public void Saldo(int login) {
        int numConta;

        System.out.println("numero da conta ");
        numConta = Leitor.getLeitor().nextInt();
        boolean haConta = acesso.buscar(numConta);
        if (haConta) {
            System.out.println(acesso.Saldo(login, numConta));
        } else {
            System.out.println("Conta Inexistente");
        }
    }
}
