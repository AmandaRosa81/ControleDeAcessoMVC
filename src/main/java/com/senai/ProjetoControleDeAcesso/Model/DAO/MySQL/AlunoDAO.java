package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO {
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, login, senha) VALUES (?, ?,?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getLogin());
            stmt.setString(3, aluno.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?,login = ?,senha = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getLogin());
            stmt.setString(3, aluno.getSenha());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Aluno> buscarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Aluno mapResultSet(ResultSet rs) throws SQLException {
        return new Aluno(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("login"),
                rs.getString("senha")
        );
    }
}
