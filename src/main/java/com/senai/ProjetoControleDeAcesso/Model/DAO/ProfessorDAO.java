package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.senai.ProjetoControleDeAcesso.Model.Professor;

import java.util.List;

public class ProfessorDAO {
        private List<Professor> professores;

        private List<Professor> carregar() {
            try (FileReader reader = new FileReader(FILE_PATH)) {
                Type listType = new TypeToken<ArrayList<Professor>>(){}.getType();
                return gson.fromJson(reader, listType);
            }catch (IOException e){
                return new ArrayList<>();
            }
        }

        public ProfessorDAO (){
            professores= carregar();
        }
        public  void salvar(Professor professor){
            professores.add(professor);
            salvarJson();
        }
        public void salvarJson(){
            try(FileWriter writer = new FileWriter(FILE_PATH)){
                gson.toJson(professores,writer);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        public List<Professor> listar(){
            return professores;
        }
        public void atualizar (Professor professor){
            professores.forEach(s-> {
                if (s.getId() == professor.getId()) {
                    s.setNome(professor.getNome());
                    s.setArea(professor.getArea());
                    salvarJson();
                }
            });
        }
        public boolean deletar(int id) {
            Iterator<Professor> iterator = professores.iterator();
            while (iterator.hasNext()) {
                Supervisor s = iterator.next();
                if (s.getId() == id) {
                    iterator.remove();
                    salvarJson();
                    return true;
                }
            }
            return false;
        }
    }