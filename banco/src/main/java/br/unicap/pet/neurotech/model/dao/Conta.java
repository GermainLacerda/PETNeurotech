package br.unicap.pet.neurotech.model.dao;

public class Conta {

    private int numConta, tipoConta;
    private float saldo;
    private double bonus;

    public Conta(int num, int tipo) {
        this.saldo = 0;
        this.bonus = 0;
        this.numConta = num;
        this.tipoConta = tipo;
    }

    public int getNumero() {
        return this.numConta;
    }


    public int getTipo() {
        return this.tipoConta;
    }

    public void sacar(float quantia) {
        if (this.saldo > quantia) {
            this.saldo -= quantia;
        }
    }

    public void depositar(float quantia) {
        this.saldo += quantia;
    }

    public void AddBonus(double porcentagem) {
        this.bonus = this.bonus+porcentagem;
    }

    public void bonificar() {
        this.saldo += this.bonus;
        this.bonus = 0;
    }

    @Override
    public String toString() {
        String s = "O numero da conta é: " + this.numConta + "\nO saldo da conta é: " + this.saldo + "\nO bonus na conta é: "+this.bonus;
        return s;
    }
}
