package com.crud.factory;

import java.sql.*;

public class ConexaoFactory {
private static final String USUARIO = "root";
private static final String SENHA = "88096672";
private static final String URL = "jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC";

public static Connection conectar() throws SQLException{
	Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
	return conexao;
}

public static void main(String[] args){
	
	try {
	Connection conexao = ConexaoFactory.conectar();
	System.out.println("Conectado com sucesso!");
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println("Falha na conexão");
	
	}
	
	}
	

}
