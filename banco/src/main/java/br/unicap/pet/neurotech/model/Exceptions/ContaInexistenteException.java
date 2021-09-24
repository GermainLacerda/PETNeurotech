package br.unicap.pet.neurotech.model.Exceptions;

public class ContaInexistenteException extends Exception {
    public ContaInexistenteException (){
        super("A conta solicitada não existe, peça para um gerente cria-la");
    }
}