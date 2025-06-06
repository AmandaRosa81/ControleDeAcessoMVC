package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaDAO {

    public void inserir(Turma turma) {
        String sql = "INSERT INTO Turma (nome_aula, id_turma, Turma,curso,dataInicio,horarioEntrada,periodo) VALUES (?, ?,?,?,?,?,?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, turma.getNomeTurma());
            stmt.setString(2, turma.getCurso());
            stmt.setString(3, turma.getDataInicio());
            stmt.setString(4, turma.getPeriodo());
            stmt.setString(5, turma.getHorarioEntrada());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Turma turma) {
        String sql = "UPDATE aluno SET nome = ?,login = ?,senha = ?, id_cartao = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, turma.getNomeTurma());
            stmt.setString(2, turma.getCurso());
            stmt.setString(3, turma.getDataInicio());
            stmt.setString(4, turma.getPeriodo());
            stmt.setInt(5, turma.getIdTurma());;
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

    public Optional<Turma> buscarPorId(int id) {
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

    public Optional<Turma> buscarPorRfid(String rfid) {
        String sql = "SELECT * FROM aluno WHERE id_cartao = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rfid);
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

    private Turma mapResultSet(ResultSet rs) throws SQLException {
        return new Turma(rs.getInt("id"), rs.getString("Turma"), rs.getString("Curso"), rs.getString("DataInicio"), rs.getString("periodo"), rs.getString("horarioEntrada"));
    }
}
