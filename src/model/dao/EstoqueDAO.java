package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Estoque;


public class EstoqueDAO implements DAO{

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Estoque estoque= null;
		try {
			stmt = con.createStatement();
			String sql = "select Id_estoque, Quantidade_minima, Quantidade_produto from Estoque where Id_estoque ="+id+";";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				estoque = new Estoque(rs.getInt("Id_estoque"),rs.getInt("Quantidade_minima"),rs.getInt("Quantidade_produto"));
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
		return estoque;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Estoque estoque= null;
		try {
			stmt = con.createStatement();
			String sql = "insert into Estoque( Quantidade_minima, Quantidade_produto) values (" 
								   +((Estoque) entidade).getQuantidadeMinima()+", "
								   +((Estoque) entidade).getQuantidade()+");";
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<Estoque> estoque = new ArrayList<Estoque>();
		try {
			stmt = con.createStatement();
			String sql = "select Id_estoque, Id_produto_fk, Quantidade_minima, Quantidade_produto from Estoque;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				estoque.add(new Estoque(rs.getInt("Id_estoque"),rs.getInt("Id_produto_fk"),rs.getInt("Quantidade_minima"),rs.getInt("Quantidade_produto")));
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
		return estoque;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
				Connection con = FabricaDeConexoes.getConnection();
				// montar a consulta
				Statement stmt = null;
				try {
					int idEstoque = ((Estoque) entidade).getId_estoque();
					int quantidadeMinima = ((Estoque) entidade).getQuantidadeMinima();
					int quantidade = ((Estoque) entidade).getQuantidade();
					stmt = con.createStatement();
					String sql = "update Estoque set Quantidade_minima ="+quantidadeMinima+", Quantidade_produto = "+quantidade+" where Id_estoque ="+idEstoque+";";
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
