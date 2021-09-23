package br.unicap.pet.neurotech.model.dao;
import br.unicap.pet.neurotech.model.Exceptions.*;
public class ContaBonus extends Conta {
    private float bonus; 
    public ContaBonus(int num) {
        super(num);
        this.bonus = 0;
    }

    @Override
    public void depositar(float quantia) {
        this.bonus = (float) (bonus + (quantia*0.01));
        super.depositar(quantia);
    }

    public void renderBonus(){
        super.depositar(bonus);
        this.bonus = 0;
    }

    @Override
    public String toString() {
        String s =  super.toString() + "\nO bonus na conta é: "+this.bonus;
        return s;
    }
    
}
