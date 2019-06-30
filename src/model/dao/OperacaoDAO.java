package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Cargo;
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
				
				Operacao.setListaOperacao(listaItem);				
				
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
			String sql2 = "insert into item_operacao(Id_operacao_fk,Id_produto_fk,Quantidade_produto) values('" + ((ItemOperacao) entidade).getId_item_opereacao() + "','"+ ((ItemOperacao) entidade).getId_operacao_fk() +"','"+ ((ItemOperacao) entidade).getId_produto_fk()+"','"+ ((ItemOperacao) entidade).getQuantidadeProduto()+ "');";
			System.out.println(sql);
			System.out.println(sql2);
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
			String sql = "delete from funcionarios where id_func="+id;
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
		List<Funcionario> funcionario = new ArrayList<Funcionario>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_func,Telefone,CPF,Senha,Nome_func,Email,Cargo FROM funcionario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				funcionario.add(new Funcionario(rs.getInt("Id_func"),rs.getString("Telefone"), rs.getString("CPF"), rs.getString("Senha"),
						rs.getString("Nome_func"), rs.getString("Email"),Cargo.values()[rs.getInt("Cargo")]));
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
		return funcionario;
	}

	@Override
	public void atualizar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			String Telefone = ((Funcionario) entidade).getTelefone();
			String CPF = ((Funcionario) entidade).getCPF();
			String Senha = ((Funcionario) entidade).getSenha();
			String Nome_func = ((Funcionario) entidade).getNomeFuncionario();
			String Email = ((Funcionario) entidade).getEmail();
			int cargo = ((Funcionario) entidade).getCargo().getIndice();
			int id = ((Funcionario) entidade).getId();
			stmt = con.createStatement();
			String sql = "UPDATE funcionario" + " SET Nome_func = '" + Nome_func + "'," + " Senha ='" + Senha + "'," + " CPF = '"
					+ CPF + " SET Email = '" + Email + "'," + " SET Telefone = '" + Telefone + "'," + " SET cargo = " + cargo + " WHERE id = " + id;
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
	
	public Funcionario busca(String nomeFuncionario, String senha) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_func,Telefone,CPF,Senha, Nome_func, Email, Cargo FROM funcionario where Nome_func ='" + nomeFuncionario + "' and Senha='" + senha + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				
				String Telefone = rs.getString("Telefone");
				String CPF = rs.getString("CPF");
				String Senha = rs.getString("Senha");
				String Nome_func = rs.getString("Nome_func");
				String Email = rs.getString("Email");
				int cargo = rs.getInt("Cargo");
				int id = rs.getInt("Id_func");
				funcionario = new Funcionario(id,Telefone,CPF,Senha,Nome_func,Email, Cargo.values()[cargo]);
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
		return funcionario;
	}

}