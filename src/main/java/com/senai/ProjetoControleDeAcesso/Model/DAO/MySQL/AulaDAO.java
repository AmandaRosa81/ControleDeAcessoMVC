package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aula.Aula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AulaDAO {

    public void inserir(Aula aula) {
        String sql = "INSERT INTO aluno (nome, login, senha, id_cartao) VALUES (?, ?,?,?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aula.getNomeAula());
            stmt.setString(2, aula.getLogin());
            stmt.setString(3, aula.getSenha());
            stmt.setString(4, aula.getIdCartaoRfid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Aula aula) {
        String sql = "UPDATE aluno SET nome = ?,login = ?,senha = ?, id_cartao = ? WHERE id = ?";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getLogin());
            stmt.setString(3, aula.getSenha());
            stmt.setString(4, aula.getIdCartaoRfid());
            stmt.setInt(5, aula.getId());
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

    public Optional<Aula> buscarPorId(int id) {
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

    public Optional<Aula> buscarPorRfid(String rfid) {
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

    public List<Aula> listarTodos() {
        List<Aula> lista = new ArrayList<>();
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

    private Aula mapResultSet(ResultSet rs) throws SQLException {
        return new Aula(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("id_cartao"),
                rs.getString("login"),
                rs.getString("senha")
        );
    }
}

