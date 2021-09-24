package br.unicap.pet.neurotech.model.Exceptions;

public class ClienteInexistenteException extends Exception{
    public ClienteInexistenteException (){
        super("O criente solicitado não existente");
    }
}
