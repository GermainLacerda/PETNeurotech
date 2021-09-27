package br.unicap.pet.neurotech.model.dao;

import java.util.ArrayList;
import java.util.List;
import br.unicap.pet.neurotech.model.Exceptions.*;

public class ContaDAOMemoria implements ContaDAO {

    private List<Conta> contas;
    private static ContaDAOMemoria self;
    private AdministradorDeConexoes CDB = new AdministradorDeConexoes();

    public ContaDAOMemoria() {
        contas = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {
        /*boolean encontrado = false;
        if (contas.isEmpty() == false) {
            for (Conta conta : contas) {
                if (conta.getNumero() == numConta) {
                    encontrado = true;
                    return encontrado;
                }
            }
        }
        */
        boolean encontrado = false;
        String busca;
        busca = "Select num from ContaGermain where num = "+numConta+";";
        CDB.Select(busca, 1);
        if (CDB.Select(busca, 1)!=null){
            encontrado = true;
            return encontrado;
        }
        return encontrado;
    }

    public static ContaDAO getInstance() {
        if (self == null) {
            self = new ContaDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int login, int numConta, float quantia) throws SaldoInsuficienteException, ContaInexistenteException {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                conta.sacar(quantia);
            }
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void depositarConta(int login, int numConta, float quantia) throws ContaInexistenteException{
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                conta.depositar(quantia);
            }
        }
        throw new ContaInexistenteException();

    }

    @Override
    public void criarConta(int login, int numConta) {
        Conta aux = new Conta(login, numConta);
        contas.add(aux);

    }

    @Override
    public void criarContaBonus(int login, int numConta) {

        boolean b = buscarConta(numConta);
        if (!b) {
            Conta c = new ContaBonus(login, numConta);
            contas.add(c);
        }

    }

    @Override
    public void aplicarBonus(int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                if (conta instanceof ContaBonus) {
                    ((ContaBonus) conta).renderBonus();
                }
                return;
            }
        }
    }

    @Override
    public String Saldo(int login, int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                return conta.toString();
            }
        }
        return "Unexpected Error";

    }

   

}

/*
private List<Conta> contas;
    private static ContaDAOMemoria self;
    private AdministradorDeConexoes CDB = new AdministradorDeConexoes();

    public ContaDAODataBase() {
        contas = new ArrayList<Conta>();
    }

    @Override
    public boolean buscarConta(int numConta) {

        boolean encontrado = false;
        String busca;
        busca = "Select num from ContaGermain where num = " + numConta + ";";
        CDB.Select(busca);
        if (CDB.Select(busca) != null) {
            encontrado = true;
            return encontrado;
        }
        return encontrado;
    }

    public static ContaDAO getInstance() {
        if (self == null) {
            self = new ContaDAOMemoria();
        }
        return self;
    }

    @Override
    public void sacarConta(int login, int numConta, float quantia)
            throws SaldoInsuficienteException, ContaInexistenteException {

        String busca;
        String atualizar;
        float saldo;
        busca = "SELECT num FROM ContaGermain WHERE num = " + numConta + " AND Login =" + login + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca) != null) {
            busca = "SELECT saldo FROM ContaGermain WHERE num = " + numConta + ";";
            saldo = Float.parseFloat(CDB.Select(busca));
            if (saldo < quantia) {
                throw new SaldoInsuficienteException();
            } else {
                saldo = saldo - quantia;
                atualizar = "UPDATE ContaGermain SET quantia = " + saldo + " WHERE num = " + numConta + ";";
                CDB.Update(atualizar);
            }
            
             * UPDATE Alunos SET nome='Germain Lacerda' WHERE ident=5;
             
        }
        throw new ContaInexistenteException();
    }

    @Override
    public void depositarConta(int login, int numConta, float quantia) throws ContaInexistenteException {
        String busca;
        String atualizar;
        float saldo;
        busca = "SELECT num FROM ContaGermain WHERE num = " + numConta + " AND Login =" + login + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca) != null) {
            busca = "SELECT saldo FROM ContaGermain WHERE num = " + numConta + ";";
            saldo = Float.parseFloat(CDB.Select(busca))+ quantia;
            atualizar = "UPDATE ContaGermain SET quantia = " + saldo + " WHERE num = " + numConta + ";";
            CDB.Update(atualizar);

        }else{
            throw new ContaInexistenteException();
        }
        
    }

    @Override
    public void criarConta(int login, int numConta) {
        String busca;
        String inserir;
        float saldo = (float) 0.0;
        busca = "SELECT num FROM ContaGermain WHERE num = " + numConta + " AND Login =" + login + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca) == null) {
            inserir = "INSERT INTO ContaGermain (saldo, Login) VALUES ("+saldo+", "+login+");";
            CDB.Update(inserir);

        }else{
            System.out.println("Conta já existente!!");
        }

    }

    @Override
    public void criarContaBonus(int login, int numConta) {

        boolean b = buscarConta(numConta);
        if (!b) {
            Conta c = new ContaBonus(login, numConta);
            contas.add(c);
        }

    }

    @Override
    public void aplicarBonus(int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta) {
                if (conta instanceof ContaBonus) {
                    ((ContaBonus) conta).renderBonus();
                }
                return;
            }
        }
    }

    @Override
    public String Saldo(int login, int numConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numConta && conta.getLogin() == login) {
                return conta.toString();
            }
        }
        return "Unexpected Error";

    }
*/