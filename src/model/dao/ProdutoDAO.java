package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Cargo;
import model.javabean.Produto;
import model.javabean.Usuario;
import model.javabean.Cargo;

public class ProdutoDAO implements DAO {

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Produto produto= null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_produto,Nome,cod_produto FROM produto where Id_produto='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				produto = new Produto(rs.getString("Id_produto"),rs.getString("Nome"),rs.getString("cod_produto"));
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
		return produto;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Produto produto= null;
		try {
			stmt = con.createStatement();
			String sql = "insert into Produto(Nome, Cod_produto) values ('"+ ((Produto) entidade).getNome() +"',"+"'" + ((Produto) entidade).getCod_produto() +"');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
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
	public void excluir(Object id) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from produto where Id_produto="+id;
			System.out.println(sql);
			stmt.executeUpdate(sql);
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
	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<Produto> produto = new ArrayList<Produto>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_produto,Nome, Cod_produto FROM Produto;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				produto.add(new Produto(rs.getString("Id_produto"),rs.getString("Nome"),rs.getString("Cod_produto")));
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
		return produto;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String Nome = ((Produto) entidade).getNome();
			String Cod_produto = ((Produto) entidade).getCod_produto();
			String Id_produto = ((Produto) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE produto" + " SET Nome = '" + Nome + "'," + " Cod_produto ='" + Cod_produto + " WHERE id = " + Id_produto;
			stmt.executeUpdate(sql);
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
