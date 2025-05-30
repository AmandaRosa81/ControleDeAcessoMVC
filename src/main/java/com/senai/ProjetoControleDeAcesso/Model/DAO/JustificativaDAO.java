package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class JustificativaDAO {

    private final String caminho = "justificativas.json";

    private final Gson gson = new GsonBuilder().create();

    private final List<Justificativa> justificativas;

    public JustificativaDAO(){justificativas = carregar();}

    public void anexarJustificativa () {

            for (int j = 0; j <justificativas.size() ; j++) {
                if(justificativas.get(j).getAnexar().equals(justificativa.getAnexar())){
                    justificativas.set(j,justificativa);
                    break;
                }
            }

        salvar(justificativas);

    }


    private List<Justificativa> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Justificativa>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Erro xxxxxxxxxxxxxxxxxxxxx Erro");
            return new ArrayList<>();
        }
    }

    private void salvar(List<Justificativa> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void remover(String anexo) {
        justificativas.removeIf(j -> j.getAnexar().equals(anexo));
        salvar(justificativas);
    }


    public List<Justificativa> listarTodos() {
        return justificativas;
    }


}
