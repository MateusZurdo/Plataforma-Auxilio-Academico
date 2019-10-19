package br.com.plataformaacademica.bean;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 *
 * @author macmini3
 */
public class ConexaoFactory {

//dados de acesso ao banco
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String NOME_BANCO = "plataformaacademica";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + NOME_BANCO;

    private static final boolean DEV = true;

    public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }

//    public static void main(String[] args) {
//        try {
//            Connection conexao = ConexaoFactory.conectarSGMD();
//            System.out.println("Conexão realizada");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Não foi possivel realizar a conexão!");
//        }
//    }
}