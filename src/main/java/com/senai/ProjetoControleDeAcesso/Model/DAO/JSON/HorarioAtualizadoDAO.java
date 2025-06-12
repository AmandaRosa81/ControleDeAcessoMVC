package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;
    import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioAtualizado;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

    public class HorarioAtualizadoDAO {

        private final String arquivo = "horarios_atualizados.json";
        private final Gson gson = new Gson();
        private final List<HorarioAtualizado> horarios = carregar();

        private List<HorarioAtualizado> carregar() {
            try (FileReader reader = new FileReader(arquivo)) {
                Type listType = new TypeToken<List<HorarioAtualizado>>() {}.getType();
                return gson.fromJson(reader, listType);
            } catch (IOException e) {
                return new ArrayList<>();
            }
        }

        private void salvar() {
            try (FileWriter writer = new FileWriter(arquivo)) {
                gson.toJson(horarios, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void adicionar(HorarioAtualizado horario) {
            horarios.add(horario);
            salvar();
        }

        public List<HorarioAtualizado> listarTodos() {
            return horarios;
        }
    }

