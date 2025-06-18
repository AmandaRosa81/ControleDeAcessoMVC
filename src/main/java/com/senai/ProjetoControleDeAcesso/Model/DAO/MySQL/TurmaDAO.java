package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaDAO {

    public void inserir(Turma turma) {
        String sql = "INSERT INTO turma (nome_turma, curso, data_inicio, qtd_semanas, horario_entrada, periodo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, turma.getNomeTurma());
            stmt.setString(2, turma.getCurso());
            stmt.setString(3, turma.getDataInicio());
            stmt.setInt(4, turma.getQtdSemanas());
            stmt.setString(5, turma.getHorarioEntrada());
            stmt.setString(6, turma.getPeriodo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Turma turma) {
        String sql ="UPDATE turma SET nome_turma = ?, curso = ?, data_inicio = ?, qtd_semanas = ?, horario_entrada = ?, periodo = ? WHERE id_turma = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, turma.getNomeTurma());
            stmt.setString(2, turma.getCurso());
            stmt.setString(3, turma.getDataInicio());
            stmt.setInt(4, turma.getQtdSemanas());
            stmt.setString(5, turma.getPeriodo());
            stmt.setInt(6, turma.getIdTurma());;
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM turma WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Turma> buscarPorId(int id) {
        String sql = "SELECT * FROM turma WHERE id = ?";
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

    public List<Turma> listarTodos() {
        List<Turma> lista = new ArrayList<>();
        String sql = "SELECT * FROM turma";
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

    private Turma mapResultSet(ResultSet rs) throws SQLException {
        return new Turma(rs.getInt("id_turma"),
                rs.getString("nome_turma"),
                rs.getString("curso"),
                rs.getString("data_inicio"),
                rs.getInt("qtd_semanas"),
                rs.getString("horario_entrada"),
                rs.getString("periodo")
        );
    }
}
