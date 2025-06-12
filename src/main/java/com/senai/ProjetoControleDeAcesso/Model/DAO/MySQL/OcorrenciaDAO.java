package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OcorrenciaDAO {

    public void inserir(Ocorrencia ocorrencia) {
        String sql = "INSERT INTO ocorrencia (descricao, data, tipo, idAluno) VALUES (?, ?,?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ocorrencia.getDescricao());
            stmt.setString(2, ocorrencia.getData());
            stmt.setString(3, ocorrencia.getTipo());
            stmt.setInt(4, ocorrencia.getIdAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizar(Ocorrencia ocorrencia) {
        String sql = "UPDATE ocorrencia SET descricao = ?,data = ?,tipo = ?,idAluno = ?  WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ocorrencia.getDescricao());
            stmt.setString(2, ocorrencia.getData());
            stmt.setString(3, ocorrencia.getTipo());
            stmt.setInt(4, ocorrencia.getIdAluno());
            stmt.setInt(5, ocorrencia.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM ocorrencia WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Ocorrencia> buscarPorId(int id) {
        String sql = "SELECT * FROM ocorrencia WHERE id = ?";
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

    public List<Ocorrencia> listarTodos() {
        List<Ocorrencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM ocorrencia";
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

    private Ocorrencia mapResultSet(ResultSet rs) throws SQLException {
        return new Ocorrencia(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getString("data"),
                rs.getString("tipo"),
                rs.getInt("idAluno")
        );
    }
}
