package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.javabean.Funcionario;

public class FuncionarioDAO implements DAO {

	@Override
	public Object recuperarPorId(Object id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM Funcionario where CPF='" + (String) id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				funcionario = new Funcionario(rs.getInt("Id_func"),rs.getString("Telefone"), rs.getString("CPF"), rs.getString("Senha"),
						rs.getString("Nome_func"), rs.getString("Email"), rs.getInt("Cargo"));
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
			//((Funcionario) entidade).getCargo()
			String sql = "insert into Funcionario(Email, Nome_func, Senha, Cargo, CPF, Telefone) values('" + ((Funcionario) entidade).getEmail() + "','"
					+ ((Funcionario) entidade).getNomeFuncionario() + "','" + ((Funcionario) entidade).getSenha() + "','" + ((Funcionario) entidade).getCargo()+"','"
					+ ((Funcionario) entidade).getCpf() + "','"+ ((Funcionario) entidade).getTelefone()+ "');";
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
			String excluirId_func = "delete from Funcionario where Id_func='" + id+"';";
			System.out.println(excluirId_func);
			stmt.executeUpdate(excluirId_func);
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
				funcionario.add(new Funcionario(rs.getInt("Id_func"),rs.getString("Telefone"), rs.getString("CPF"), rs.getString("Senha"),
						rs.getString("Nome_func"), rs.getString("Email"),rs.getInt("Cargo")));
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
			int Id = ((Funcionario) entidade).getId();
			String Telefone = ((Funcionario) entidade).getTelefone();
			String CPF = ((Funcionario) entidade).getCpf();
			String Senha = ((Funcionario) entidade).getSenha();
			String Nome_func = ((Funcionario) entidade).getNomeFuncionario();
			String Email = ((Funcionario) entidade).getEmail();
			int cargo = ((Funcionario) entidade).getCargo();
			stmt = con.createStatement();
			String sql = "UPDATE Funcionario" + " SET Nome_func = '" + Nome_func + "'," + " Senha ='" + Senha + "'," + "Email = '" + Email + "'," + " Telefone = '" + Telefone + "'," + "cargo = " + cargo + " WHERE Id_func = '" + Id+"';";
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
	
	public Funcionario busca(String email, String senha) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Funcionario funcionario = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT Id_func,Telefone,CPF,Senha, Nome_func, Email, Cargo FROM Funcionario where Email ='" + email + "' and Senha='" + senha + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int Id = rs.getInt("Id_func");
				String Telefone = rs.getString("Telefone");
				String CPF = rs.getString("CPF");
				String Senha = rs.getString("Senha");
				String Nome_func = rs.getString("Nome_func");
				String Email = rs.getString("Email");
				int cargo = rs.getInt("Cargo");
				funcionario = new Funcionario(Id,Telefone,CPF,Senha,Nome_func,Email,cargo);
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
