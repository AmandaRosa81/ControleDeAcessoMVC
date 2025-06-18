package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO {
    public void inserir(Curso curso) {
        String sql = "INSERT INTO curso (nomeCurso, cargaHoraria, tipo, tolerancia) VALUES (?, ?,?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getCargaHoraria());
            stmt.setString(3, curso.getTipo());
            stmt.setString(4, curso.getTolerancia());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Curso curso) {
        String sql = "UPDATE curso SET nomeCurso = ?,cargaHoraria = ?,tipo = ?,tolerancia = ? WHERE idCurso = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getCargaHoraria());
            stmt.setString(3, curso.getTipo());
            stmt.setString(4, curso.getTolerancia());
            stmt.setInt(5, curso.getIdCurso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int idCurso) {
        String sql = "DELETE FROM curso WHERE idCurso = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCurso);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Curso> buscarPorId(int idCurso) {
        String sql = "SELECT * FROM curso WHERE idCurso = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCurso);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Curso> listarTodos() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM curso";
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

    private Curso mapResultSet(ResultSet rs) throws SQLException {
        return new Curso(
                rs.getInt("idCurso"),
                rs.getString("nomeCurso"),
                rs.getString("cargaHoraria"),
                rs.getString("tipo"),
                rs.getString("tolerancia")
        );
    }
}
