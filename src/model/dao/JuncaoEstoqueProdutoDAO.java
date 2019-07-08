package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.*;
import model.dao.*;

public class JuncaoEstoqueProdutoDAO implements DAO{
	
	@Override
	public Object recuperarPorId(Object id) {
		new ProdutoDAO().recuperarPorId(id);
		new EstoqueDAO().recuperarPorId(id);
		
		return null;
	}
	
	@Override
	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<JuncaoEstoqueProduto> juncao = new ArrayList<JuncaoEstoqueProduto>();
		try {
			stmt = con.createStatement();
			String sql = "select Id_estoque,Quantidade_produto,Nome,Cod_produto,Quantidade_minima,Id_produto from Produto " + 
					"inner join estoque on estoque.Id_produto_fk = produto.Id_produto;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				juncao.add(new JuncaoEstoqueProduto(rs.getInt("Id_estoque"), rs.getInt("Quantidade_produto"), 
						rs.getString("Nome"),rs.getString("Cod_produto"),rs.getInt("Quantidade_minima"),rs.getInt("Id_produto")));
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
	
	@Override
	public void salvar(Object entidade) {
		
		Produto produto = new Produto(((JuncaoEstoqueProduto)entidade).getNome(),
				((JuncaoEstoqueProduto)entidade).getCodProduto());
		new ProdutoDAO().salvar(produto);
		
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		int id = 1;
		try {
			stmt = con.createStatement();
			String sql = "select Id_produto from produto where Nome = '"+((JuncaoEstoqueProduto)entidade).getNome() +"';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				id = rs.getInt("Id_produto");
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
		Estoque estoque = new Estoque(id,((JuncaoEstoqueProduto)entidade).getQuantidadeMinima(),
				((JuncaoEstoqueProduto)entidade).getQuantidade());
		new EstoqueDAO().salvar(estoque);
	}
	
	@Override
	public void excluir(Object id) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from Operacao where Id_operacao="+id;
			String sql2 = "delte from ItemOperacao where Id_operacao_fk";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
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
	}
	
	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int idProduto = ((JuncaoEstoqueProduto) entidade).getIdProduto();
			String nome = ((JuncaoEstoqueProduto) entidade).getNome();
			String codProduto = ((JuncaoEstoqueProduto) entidade).getCodProduto();
			int idEstoque = ((JuncaoEstoqueProduto) entidade).getIdEstoque();
			int quantidade = ((JuncaoEstoqueProduto) entidade).getQuantidade();
			int quantidadeMinima = ((JuncaoEstoqueProduto) entidade).getQuantidadeMinima();
			stmt = con.createStatement();
			String sql = "UPDATE Produto SET Nome ='" + nome + "'," + " Cod_produto ='" + codProduto +
					"' WHERE Id_produto = " + idProduto + ";";
			String sql2 = "update Estoque set Quantidade_minima =" + quantidadeMinima + ", Quantidade_produto = "
					+ quantidade + " where Id_estoque =" + idEstoque + ";";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
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
		
	}
}
