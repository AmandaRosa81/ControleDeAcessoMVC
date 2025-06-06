package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Coordenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class CoordenadorDAO {

        public void inserir(Coordenador coordenador) {
            String sql = "INSERT INTO coordenador (nome, login, senha) VALUES (?, ?, ?)";
            try (Connection conn = ConexaoMySQL.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, coordenador.getNome());
                stmt.setString(2, coordenador.getLogin());
                stmt.setString(3, coordenador.getSenha());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void atualizar(Coordenador coordenador) {
            String sql = "UPDATE coordenador SET nome = ?, login = ?, senha = ? WHERE id = ?";
            try (Connection conn = ConexaoMySQL.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, coordenador.getNome());
                stmt.setString(2, coordenador.getLogin());
                stmt.setString(3, coordenador.getSenha());
                stmt.setInt(4, coordenador.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void remover(int id) {
            String sql = "DELETE FROM coordenador WHERE id = ?";
            try (Connection conn = ConexaoMySQL.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Optional<Coordenador> buscarPorId(int id) {
            String sql = "SELECT * FROM coordernador WHERE id = ?";
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

        public List<Coordenador> listarTodos() {
            List<Coordenador> lista = new ArrayList<>();
            String sql = "SELECT * FROM coordenador";
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

        private Coordenador mapResultSet(ResultSet rs) throws SQLException {
            return new Coordenador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("login"),
                    rs.getString("senha")
            );
        }
    }
