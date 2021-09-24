package br.unicap.pet.neurotech.model.Exceptions;

public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException (){
        super("Saldo na conta insuficiente para realizar o saque!");
    }
}
