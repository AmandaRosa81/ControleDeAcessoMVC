package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Justificativa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JustificativaDAO {

    public void inserir(Justificativa justificativa) {
        String sql = "INSERT INTO justificativa (descricao, data, tipo, idAluno) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, justificativa.getDescricao());
            stmt.setString(2, justificativa.getData());
            stmt.setString(3, justificativa.getTipo());
            stmt.setInt(4, justificativa.getIdAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Justificativa justificativa) {
        String sql = "UPDATE justificativa SET descricao = ?, data = ?, tipo = ?, idAluno = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, justificativa.getDescricao());
            stmt.setString(2, justificativa.getData());
            stmt.setString(3, justificativa.getTipo());
            stmt.setInt(4, justificativa.getIdAluno());
            stmt.setInt(5, justificativa.getId());  // ID da justificativa
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM justificativa WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Justificativa> buscarPorId(int id) {
        String sql = "SELECT * FROM justificativa WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSet(rs));  // mapeando para Justificativa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Justificativa> listarTodos() {
        List<Justificativa> lista = new ArrayList<>();
        String sql = "SELECT * FROM justificativa";  // Nome da tabela ajustado
        try (Connection conn = ConexaoMySQL.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapResultSet(rs));  // mapeando para Justificativa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Justificativa mapResultSet(ResultSet rs) throws SQLException {
        return new Justificativa(  // Corrigido para a classe Justificativa
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getString("data"),
                rs.getString("tipo"),
                rs.getInt("idAluno")
        );
    }

}

