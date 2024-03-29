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
			String sql = "SELECT Id_produto,Nome,cod_produto FROM Produto where Id_produto='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				produto = new Produto(rs.getInt("Id_produto"),rs.getString("Nome"),rs.getString("cod_produto"));
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
			String sql = "insert into Produto(Nome, Cod_produto) values ('"+ ((Produto) entidade).getNome() +"',"+"'" + ((Produto) entidade).getCodProduto() +"');";
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
	public void excluir(Object idProduto) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from Produto where Id_produto="+idProduto+";";
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
				produto.add(new Produto(rs.getInt("Id_produto"),rs.getString("Nome"),rs.getString("Cod_produto")));
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
			String nome = ((Produto) entidade).getNome();
			String codProduto = ((Produto) entidade).getCodProduto();
			int idProduto = ((Produto) entidade).getIdProduto();
			stmt = con.createStatement();
			String sql = "UPDATE Produto SET Nome ='" + nome + "'," + " Cod_produto ='" + codProduto + "' WHERE Id_produto = " + idProduto + ";";
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
