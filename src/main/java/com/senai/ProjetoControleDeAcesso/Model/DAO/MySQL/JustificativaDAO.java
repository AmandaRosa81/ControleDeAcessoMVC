package com.senai.ProjetoControleDeAcesso.Model.DAO.MySQL;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JustificativaDAO {
    public void inserir(Justificativa justificativa) {
        String sql = "INSERT INTO justificativa (id) VALUES (?)";
        try (Connection conn = ConexaoMySQL.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, justificativa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
