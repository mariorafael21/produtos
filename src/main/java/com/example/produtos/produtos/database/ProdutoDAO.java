package com.example.produtos.produtos.database;

import com.example.produtos.produtos.controller.Produtos;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private final String DATA_CREATE = "CREATE TABLE loja (" +
            "id SERIAL PRIMARY KEY NOT NULL," +
            "nome varchar(50) NOT NULL," +
            "preco DECIMAL(7, 2) NOT NULL," +
            "cor varchar(50) NOT NULL," +
            "marca varchar(50) NOT NULL," +
            "potenciarms int NOT NULL" +
            ")";
    private final String DATA_INSERT = "INSERT INTO loja (NOME,PRECO," +
            "COR,MARCA,POTENCIARMS) VALUES (?,?,?,?,?)";
    private final String DATA_LIST = "SELECT * FROM loja ORDER BY ID";
    private final String DATA_ID = "SELECT * FROM loja WHERE ID=?";



    public void createTab() throws SQLException, URISyntaxException {
        Connection c = ConectionBase.getConnection();
        Statement s = c.createStatement();
        s.execute(DATA_CREATE);
        System.out.println("CADASTRADO");
        c.close();
    }

    public void insertProduto(Produtos p) throws SQLException, URISyntaxException {
        Connection c = ConectionBase.getConnection();
        PreparedStatement ps = c.prepareStatement(DATA_INSERT);
        ((PreparedStatement) ps).setString(1,p.getNome());
        ps.setDouble(2,p.getPreco());
        ps.setString(3,p.getCor());
        ps.setString(4,p.getMarca());
        ps.setInt(5,p.getPotenciarms());
        ps.execute();
        c.close();
        System.out.println("cadastro funcionou");
    }


    public ArrayList<Produtos> listProduto(){
        ArrayList<Produtos> lista = new ArrayList<>();
        try{
            Connection c = ConectionBase.getConnection();
            PreparedStatement ps = c.prepareStatement(DATA_LIST);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Produtos p = new Produtos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("cor"),
                        rs.getString("marca"),
                        rs.getInt("potenciarms")
                );
                lista.add(p);
            }
            c.close();
            System.out.println("LISTA OK");

        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
            System.out.println("ERRO");
        }
        return lista;
    }

    public Produtos buscar(int id){
        Produtos p = null;
        try {
            Connection c = ConectionBase.getConnection();
            PreparedStatement ps = c.prepareStatement(DATA_ID);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Produtos(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("cor"),
                        rs.getString("marca"),
                        rs.getInt("potenciarms")
                );
            }
            c.close();
        } catch (SQLException | URISyntaxException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }
}
