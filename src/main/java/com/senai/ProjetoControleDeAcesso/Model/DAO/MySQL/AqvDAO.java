package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AqvDAO {
    public void inserir(Aqv aqv) {
        String sql = "INSERT INTO aqv (nome, login, senha) VALUES (?, ?,?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aqv.getNome());
            stmt.setString(2, aqv.getLogin());
            stmt.setString(3, aqv.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Aqv aqv) {
        String sql = "UPDATE aqv SET nome = ?,login = ?,senha = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aqv.getNome());
            stmt.setString(2, aqv.getLogin());
            stmt.setString(3, aqv.getSenha());
            stmt.setInt(4, aqv.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM aqv WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Aqv> buscarPorId(int id) {
        String sql = "SELECT * FROM aqv WHERE id = ?";
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

    public List<Aqv> listarTodos() {
        List<Aqv> lista = new ArrayList<>();
        String sql = "SELECT * FROM aqv";
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

    private Aqv mapResultSet(ResultSet rs) throws SQLException {
        return new Aqv(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("login"),
                rs.getString("senha")
        );
    }
}
