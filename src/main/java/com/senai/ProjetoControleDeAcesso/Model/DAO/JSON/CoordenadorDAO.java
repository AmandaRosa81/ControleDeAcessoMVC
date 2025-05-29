package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.senai.ProjetoControleDeAcesso.Model.Coordenador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoordenadorDAO {
    private List<Coordenador> coordenadores;
    private final String FILE_PATH = "coordenador.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<Coordenador>carregar(){
        try(FileReader reader = new FileReader(FILE_PATH)){
            Type listType = new TypeToken<ArrayList<Coordenador>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

    public CoordenadorDAO(){
        coordenadores = carregar();
    }

    public void salvar(Coordenador coordenador){
        coordenadores.add(coordenador);
        salvarJson();
    }

    public void salvarJson(){
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(coordenadores, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Coordenador> listar(){
        return coordenadores;
    }

    public void atualizar(Coordenador coordenador){
        coordenadores.forEach(c -> {
            if (c.getId()== coordenador.getId()){
                c.setNome (coordenador.getNome());
                salvarJson();
            }
        });
    }

    public boolean deletar(int id){
        Iterator<Coordenador> iterator = coordenadores.iterator();
        while (iterator.hasNext()){
            Coordenador c = iterator.next();
            if (c.getId() == id){
                iterator.remove();
                salvarJson();
                return true;
            }
        }
        return false;
    }
}
