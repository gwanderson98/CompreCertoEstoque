package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.*;
import model.dao.*;

public class JuncaoEstoqueProdutoDAO {

	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<JuncaoEstoqueProduto> juncao = new ArrayList<JuncaoEstoqueProduto>();
		try {
			stmt = con.createStatement();
			String sql = "select Id_estoque,Quantidade_produto,Nome,Cod_produto,Id_produto\r\n" + 
					"from Produto \r\n" + 
					"inner join estoque \r\n" + 
					"on estoque.Id_produto_fk = produto.Id_produto;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				juncao.add(new JuncaoEstoqueProduto(rs.getInt("Id_estoque"), rs.getInt("Quantidade_produto"), 
						rs.getString("Nome"),rs.getString("Cod_produto"),rs.getInt("Id_produto")));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return juncao;
	}
	
	public void salvar(Object entidade) {
		new 
		
	}

}
