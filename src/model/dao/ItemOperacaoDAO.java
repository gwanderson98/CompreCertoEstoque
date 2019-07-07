package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Cargo;
import model.javabean.Funcionario;
import model.javabean.ItemOperacao;
import model.javabean.Operacao; 

public class ItemOperacaoDAO implements DAO {

public List<ItemOperacao> listaItem = new ArrayList<ItemOperacao>();
	
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		ItemOperacao item = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM itemoperacao where Id_operacao='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {				
				item = new ItemOperacao(rs.getInt("Id_item_opereacao"),rs.getInt("Id_operacao_fk"),
						rs.getInt("Id_produto_fk"),rs.getInt("quantidadeProduto"));
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
		return item;
	}

	@Override
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Operacao operacao = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into item_operacao(Id_operacao_fk,Id_produto_fk,Quantidade_produto) values('" + 
					((ItemOperacao) entidade).getIdItemOperacao() + "','"+ ((ItemOperacao) entidade).getIdOperacaoFk() +"','"
					+ ((ItemOperacao) entidade).getIdProdutoFk()+"','"+ ((ItemOperacao) entidade).getQuantidadeProduto()+ "');";
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
			String sql = "delte from ItemOperacao where Id_operacao_fk = " + id +";";
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
		List<ItemOperacao> operacao = new ArrayList<ItemOperacao>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_item_operacao,Id_operacao_fk,Id_produto_fk,Quantidade_produto FROM item_operacao;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				operacao.add(new ItemOperacao(rs.getInt("Id_item_operacao"),(char)rs.getInt("Id_operacao_fk"), 
						rs.getInt("Id_produto_fk"), rs.getInt("Quantidade_produto")));
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
		return operacao;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			int IdItemOperacao = ((ItemOperacao) entidade).getIdItemOperacao();
			int IdOperacaoFk = ((ItemOperacao) entidade).getIdOperacaoFk();
			int IdProdutoFk = ((ItemOperacao) entidade).getIdProdutoFk();
			int QuantidadeProduto = ((ItemOperacao) entidade).getQuantidadeProduto();
			stmt = con.createStatement();
			String sql = "UPDATE item_operacao SET Quantidade_produto = " + QuantidadeProduto +" WHERE id = " + IdItemOperacao;
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


