package br.unicap.pet.neurotech.model.dao;

import br.unicap.pet.neurotech.model.Exceptions.*;

public class Conta {

    private int numConta;
    private int login;
    private float saldo;

    // a conta possui um cliente atribuido a ela, private menbro id instanceof !=
    // menbroGerente
    public Conta(int login, int num) {
        this.saldo = 0;
        this.numConta = num;
        this.login = login;
    }

    public int getNumero() {
        return this.numConta;
    }
    public int getLogin (){
        return this.login;
    }

    public void sacar(float quantia) throws SaldoInsuficienteException {
        if (this.saldo > quantia) {
            this.saldo = this.saldo - quantia;
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void depositar(float quantia) {
        this.saldo = this.saldo + quantia;
        ;
    }

    @Override
    public String toString() {
        String s = "O numero da conta é: " + this.numConta + "\nO saldo da conta é: " + this.saldo;
        return s;
    }
}
