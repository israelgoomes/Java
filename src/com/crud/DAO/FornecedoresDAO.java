package com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crud.domain.TbFornecedores;
import com.crud.factory.ConexaoFactory;

public class FornecedoresDAO {
	public void salvar(TbFornecedores f){
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores");
		sql.append("(descricao)");
		sql.append("VALUES (?)");
		try{
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		}catch(SQLException e){
			
		}
		}
}
