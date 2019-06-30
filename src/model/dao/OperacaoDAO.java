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

public class OperacaoDAO implements DAO {
	
	public List<ItemOperacao> listaItem = new ArrayList<ItemOperacao>();
	
	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Operacao operacao = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM operacao where Id_operacao='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				operacao = new Operacao(rs.getInt("Id_operacao"),(char)rs.getInt("Tipo_operacao"),rs.getString("Data_operacao"),rs.getInt("Id_func_fk"));
				
				String sql2 = "SELECT * FROM itemoperacao where Id_operacao='" + (String) id + "'";
				
				ResultSet rs2 = stmt.executeQuery(sql2);
				
				while (rs2.next()) {
					listaItem.add(new ItemOperacao(rs.getInt("Id_item_opereacao"),rs.getInt("Id_operacao_fk"),rs.getInt("Id_produto_fk"),rs.getInt("quantidadeProduto")));
				}
				
				operacao.setListaOperacao(listaItem);				
				
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
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Operacao operacao = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into operacao(Tipo_operacao,Data_produto_fk,Id_funk_fk) values('" + ((Operacao) entidade).getTipo() + "','"+ ((Operacao) entidade).getData() + "','"+ ((Operacao) entidade).getId_func_fk()+ "');";
			for (ItemOperacao itemOperacao : listaItem) {
				String sql2 = "insert into item_operacao(Id_operacao_fk,Id_produto_fk,Quantidade_produto) values('" + ((ItemOperacao) entidade).getId_item_opereacao() + "','"+ ((ItemOperacao) entidade).getId_operacao_fk() +"','"
				+ ((ItemOperacao) entidade).getId_produto_fk()+"','"+ ((ItemOperacao) entidade).getQuantidadeProduto()+ "');";
				System.out.println(sql2);
				stmt.executeUpdate(sql2);
			}
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
	public List listarTodos() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<Operacao> operacao = new ArrayList<Operacao>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_operacao,Tipo_operacao,Data_produto_fk,Id_funk_fk Cargo FROM funcionario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				operacao.add(new Operacao(rs.getInt("Id_operacao"),(char)rs.getInt("Tipo_operacao"), rs.getString("Data_produto_fk"), rs.getInt("Id_funk_fk")));
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
			int Id_operacao = ((Operacao) entidade).getId_operacao();
			char Tipo_operacao = ((Operacao) entidade).getTipo();
			String Data_operacao = ((Operacao) entidade).getData();
			int Id_func_fk = ((Operacao) entidade).getId_func_fk();
			stmt = con.createStatement();
			String sql = "UPDATE Operacao" + " SET Tipo_operacao = " + Tipo_operacao + "," + " Data_operacao = '"
					+ Data_operacao + ","+ "Id_func_fk = " + Id_func_fk +" WHERE id = " + Id_operacao;
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