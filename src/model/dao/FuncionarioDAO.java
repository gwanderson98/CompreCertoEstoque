package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Cargo;
import model.javabean.Funcionario;
import model.javabean.Usuario;
import model.javabean.Cargo;

public class FuncionarioDAO implements DAO {

	@Override
	public Object recuperarPorId(Object CPF) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM Funcionario where CPF='" + (String) CPF + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				funcionario = new Funcionario(rs.getString("Telefone"), rs.getString("CPF"), rs.getString("Senha"),
						rs.getString("Nome_func"), rs.getString("Email"));
				//,Cargo.values()[rs.getInt("Cargo")]
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
	public void salvar(Object entidade) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into funcionario(Email, Nome_func, Senha, Cargo, CPF, Telefone) values('" + ((Funcionario) entidade).getEmail() + "','"
					+ ((Funcionario) entidade).getNomeFuncionario() + "','" + ((Funcionario) entidade).getSenha() + "','" + ((Funcionario) entidade).getCargo()+"','"
					+ ((Funcionario) entidade).getCPF() + "','"+ ((Funcionario) entidade).getTelefone()+ "');";
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
	public void excluir(Object CPF) {
		// conectar com sgbd
		Connection con = FabricaDeConexoes.getConnection();
		// montar a consulta
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String Id_func = "select Id_func from funcionario where CPF='" + CPF+"';";
			System.out.println(Id_func);
			ResultSet resultId_func = stmt.executeQuery(Id_func);
			String Id_operacao = "select Id_operacao from operacao where Id_func_fk =" +resultId_func.getString("Id_func")+"';";
			System.out.println(Id_operacao);
			ResultSet rs = stmt.executeQuery(Id_operacao);
			while (rs.next()) {
				String excluirItem_operacao = "delete from item_operacao where Id_operacao_fk = " + rs.getString("Id_operacao") +";";
				System.out.println(excluirItem_operacao);
				stmt.executeQuery(excluirItem_operacao);
			}
			while (rs.next()) {
				String excluirId_operacao = "delete from operacao where Id_func_fk =" +resultId_func.getString("Id_func")+"';";
				System.out.println(excluirId_operacao);
				stmt.executeQuery(excluirId_operacao);
			}
			String excluirId_func = "delete from funcionario where CPF='" + CPF+"';";
			System.out.println(excluirId_func);
			stmt.executeQuery(excluirId_func);
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
			String sql = "SELECT Id_func,Telefone,CPF,Senha,Nome_func,Email,Cargo FROM Funcionario;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				funcionario.add(new Funcionario(rs.getString("Telefone"), rs.getString("CPF"), rs.getString("Senha"),
						rs.getString("Nome_func"), rs.getString("Email")));
				//Cargo.values()[rs.getInt("Cargo")];
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
			int cargo = 1; //((Funcionario) entidade).getCargo().getIndice()
			stmt = con.createStatement();
			String sql = "UPDATE Funcionario" + " SET Nome_func = '" + Nome_func + "'," + " Senha ='" + Senha + "'," + "Email = '" + Email + "'," + " Telefone = '" + Telefone + "'," + "cargo = " + cargo + " WHERE CPF = '" + CPF+"';";
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
				funcionario = new Funcionario(Telefone,CPF,Senha,Nome_func,Email);
				//, Cargo.values()[cargo]
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
