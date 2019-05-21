package com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crud.domain.TbFornecedores;
import com.crud.factory.ConexaoFactory;

public class FornecedoresDAO {
	public void salvar(TbFornecedores f) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
		
			
		
		}
	
	public void excluir (TbFornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ?");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}
	
	public void editar (TbFornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE FORNECEDORES ");
		sql.append("SET DESCRICAO = ? ");
		sql.append("WHERE CODIGO = ?");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}
	
	public TbFornecedores find(TbFornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ?");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		ResultSet resultado = comando.executeQuery();
		TbFornecedores retorno = null;
		
		if(resultado.next()){
			retorno = new TbFornecedores();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));

		}
		
		
		return retorno;
	}
	
	
	public static void main(String[] args) {
		/*
		TbFornecedores f1 = new TbFornecedores();
		f1.setDescricao("Descrição 1");
		
		TbFornecedores f2 = new TbFornecedores();
		f2.setDescricao("Descrição 2");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		try {
			fdao.salvar(f2);
			fdao.salvar(f1);
			System.out.println("Salvo com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao salvar");

		}

		TbFornecedores f1 = new TbFornecedores();
		f1.setCodigo(1);
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			fdao.excluir(f1);
			System.out.println("Excluido com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao excluir!!");
		}
*/
		
		
	/*	
		TbFornecedores f1 = new TbFornecedores();
		f1.setCodigo(2);
		f1.setDescricao("Descrição 1");
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			fdao.editar(f1);
			System.out.println("Editado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao editar!!");
		}

		*/
		
		TbFornecedores f1 = new TbFornecedores();
		f1.setCodigo(2);
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {
			TbFornecedores f2 = fdao.find(f1);
			System.out.println("Resultado 1: " + f2 );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao salvar!!");
		}
		
	}
	

	
}
