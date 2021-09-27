package br.unicap.pet.neurotech.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class AdministradorDeConexoes {

    public String Select(String select, int i) {
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10439832";
        String user = "sql10439832";
        String password = "zAzLrhmaiF";
        String query = select;
        String tabela = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                tabela += rs.getString(i);
            }

            con.close();
            return tabela;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return "ERRO NO SELECT";
        }
    }

    public void Insert(String select) {
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10439832";
        String user = "sql10439832";
        String password = "zAzLrhmaiF";
        String query = select;
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeQuery(query);
            System.out.println("INSERIDO COM SUCESSO");
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO NO INSERT");
        }
    }

    public void Update(String select) {
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10439832";
        String user = "sql10439832";
        String password = "zAzLrhmaiF";
        String query = select;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeQuery(query);
            System.out.println("ATUALIZADO COM SUCESSO");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERRO NO UPDATE");
        }
    }
}
