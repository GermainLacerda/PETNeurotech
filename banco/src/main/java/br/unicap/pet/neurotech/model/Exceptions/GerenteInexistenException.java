package br.unicap.pet.neurotech.model.Exceptions;

public class GerenteInexistenException extends Exception{
    public GerenteInexistenException (){
        super("O gerente solicitado não existe!");
    }
}
