package br.unicap.pet.neurotech.model.dao;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import br.unicap.pet.neurotech.model.Exceptions.ContaInexistenteException;
import br.unicap.pet.neurotech.model.Exceptions.SaldoInsuficienteException;

public class ContaDAODataBase implements ContaDAO {
    public ContaDAODataBase() {
    }

    private static ContaDAODataBase self;
    private AdministradorDeConexoes CDB = new AdministradorDeConexoes();

    @Override
    public boolean buscarConta(int numConta) {

        boolean encontrado = false;
        String busca;
        busca = "Select num from sql10439832.ContaGermain where num = " + numConta + ";";
        String result = CDB.Select(busca, 1);
        if (result.equals("") == false) {
            encontrado = true;
            return encontrado;
        } else {
            return encontrado;
        }

    }

    public static ContaDAO getInstance() {
        if (self == null) {
            self = new ContaDAODataBase();
        }
        return self;
    }

    @Override
    public void sacarConta(int login, int numConta, float quantia)
            throws SaldoInsuficienteException, ContaInexistenteException {

        String busca;
        String atualizar;
        float saldo;
        busca = "SELECT num FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca, 1).isEmpty() == false) {

            busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
            if (CDB.Select(busca, 1).isEmpty() == true) {
                saldo = 0;
            } else {
                saldo = Float.parseFloat(CDB.Select(busca, 1));
            }

            if (saldo < quantia) {
                throw new SaldoInsuficienteException();
            } else {
                saldo = saldo - quantia;
                atualizar = "UPDATE sql10439832.ContaGermain SET saldo = " + saldo + " WHERE num = " + numConta + ";";
                CDB.Update(atualizar);
            }

        } else {
            throw new ContaInexistenteException();
        }

    }

    @Override
    public void depositarConta(int login, int numConta, float quantia) throws ContaInexistenteException {
        String busca;
        String atualizar;
        float saldo;
        busca = "SELECT num FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca, 1).isEmpty() == false) {
            busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
            if (CDB.Select(busca, 1).isEmpty() == true) {
                saldo = 0 + quantia;
            } else {
                saldo = Float.parseFloat(CDB.Select(busca, 1)) + quantia;
            }

            busca = "SELECT tipo FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";
            if (busca.equals("normal")) {
                busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
                saldo += Float.parseFloat(CDB.Select(busca, 1));

                atualizar = "UPDATE sql10439832.ContaGermain SET saldo = " + saldo + " WHERE num = " + numConta + ";";
                CDB.Update(atualizar);
            } else {
                // atualizar o salario
                busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
                saldo += Float.parseFloat(CDB.Select(busca, 1));

                atualizar = "UPDATE sql10439832.ContaGermain SET saldo = " + saldo + " WHERE num = " + numConta + ";";
                CDB.Update(atualizar);

                // rendimento do bonus
                busca = "SELECT bonus FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
                String bns = CDB.Select(busca, 1);

                float bonus = Float.parseFloat(bns);

                bonus = (float) (bonus + (quantia * 0.01));

                atualizar = "UPDATE sql10439832.ContaGermain SET bonus = " + bonus + " WHERE num = " + numConta + ";";
                CDB.Update(atualizar);
            }

        } else {
            throw new ContaInexistenteException();
        }

    }

    @Override
    public void criarConta(int login, int numConta) {
        String busca= "SELECT num FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";;
        String inserir;
        String tipo = "'normal'";
        float saldo = (float) 0.0;
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca, 1).equals("")) {

            inserir = "INSERT INTO sql10439832.ContaGermain (num, saldo, login, tipo, bonus) VALUES ( null, " + saldo + ", " + login + ", " + tipo + ", " + 0.0 +");";
                    
            CDB.Insert(inserir);

        } else {
            System.out.println("Conta já existente!!");
        }

    }

    @Override
    public void criarContaBonus(int login, int numConta) {
        String busca = "SELECT num FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";
        String inserir;
        String tipo = "'bonus'";
        float saldo = (float) 0.0;
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca, 1).equals(null)) {
            inserir = "INSERT INTO sql10439832.ContaGermain (num, saldo, login, tipo, bonus) VALUES ( null, " + saldo + ", " + login + ", " + tipo + ", " + 0.0 + ");";
            CDB.Update(inserir);

        } else {
            System.out.println("Conta já existente!!");
        }

    }

    @Override
    public void aplicarBonus(int numConta) throws ContaInexistenteException {

        String busca;
        String atualizar;
        float saldo;
        float bonus;
        busca = "SELECT num FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
        // busca para achar a conta e se a mesma está atrelada ao Cliente.
        if (CDB.Select(busca, 1) != null) {
            busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
            saldo = Float.parseFloat(CDB.Select(busca, 1));
            busca = "SELECT saldo FROM sql10439832.ContaGermain WHERE num = " + numConta + ";";
            bonus = Float.parseFloat(CDB.Select(busca, 1));

            saldo = saldo + bonus;
            atualizar = "UPDATE sql10439832.ContaGermain SET saldo = " + saldo + " WHERE num = " + numConta + ";";
            CDB.Update(atualizar);

            atualizar = "UPDATE sql10439832.ContaGermain SET bonus = " + 0 + " WHERE num = " + numConta + ";";
            CDB.Update(atualizar);
        }

        throw new ContaInexistenteException();
    }

    @Override
    public String Saldo(int login, int numConta) {
        String busca;
        busca = "SELECT * FROM sql10439832.ContaGermain WHERE num = " + numConta + " AND login =" + login + ";";
        if (CDB.Select(busca, 1).isEmpty() == false) {
            return CDB.Select(busca, 5);
        }
        return "Unexpected Error";

    }

}
