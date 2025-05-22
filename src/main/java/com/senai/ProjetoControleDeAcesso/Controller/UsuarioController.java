package com.senai.ProjetoControleDeAcesso.Controller;

public class UsuarioController {
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final AQVDAO aqvDAO = new AQVDAO();
    private final CoordenadorDAO coordenadorDAO = new CoordenadorDAO();

    public String cadastrarUsuario(String tipo, String nome, String dadoExtra, String login, String senha) {
        if (tipo.equals("1")) {
            alunoDAO.inserir(new Aluno(0, nome, dadoExtra,login,senha));
            return "Aluno cadastrado com sucesso.";
        } else if (tipo.equals("2")) {
            professorDAO.inserir(new Professor(0, nome, dadoExtra,login,senha));
            return "Professor cadastrado com sucesso.";
        } else if (tipo.equals("3")) {
            aqvDAO.inserir(new AQV (0, nome, dadoExtra,login,senha));
            return "AQV cadastrado com sucesso.";
        } else if (tipo.equals("4")) {
            coordenadorDAO.inserir(new Coordenador(0, nome, dadoExtra,login,senha));
            return "Coordenador cadastrado com sucesso.";
        } else {
            return "Tipo inválido.";
        }
    }

    public String atualizarUsuario(String tipo, int id, String nome, String dadoExtra, String login, String senha) {
        if (tipo.equals("1")) {
            alunoDAO.atualizar(new Aluno(id, nome, dadoExtra,login,senha));
            return "Aluno atualizado.";
        } else if (tipo.equals("2")) {
            professorDAO.atualizar(new Professor(id, nome, dadoExtra,login,senha));
            return "Professor atualizado.";
        } else if (tipo.equals("3")) {
            aqvDAO.atualizar(new AQV (id, nome, dadoExtra,login,senha));
            return "AQV atualizado.";
        } else if (tipo.equals("4")) {
            coordenadorDAO.atualizar(new Coordenador(id, nome, dadoExtra,login,senha));
            return "Coordenador atualizado.";
        } else {
            return "Tipo inválido.";
        }
    }

    public String removerUsuario(String tipo, int id) {
        if (tipo.equals("1")) {
            alunoDAO.remover(id);
            return "Aluno removido.";
        } else if (tipo.equals("2")) {
            professorDAO.remover(id);
            return "Professor removido.";
        } else if (tipo.equals("3")) {
            aqvDAO.remover(id);
            return "AQV removido.";
        }else if (tipo.equals("4")) {
            coordenadorDAO.remover(id);
            return "Coordenador removido.";
        } else {
            return "Tipo inválido.";
        }
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listarTodos();
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listarTodos();
    }

    public List<AQV> listarAQV() {
        return aqvDAO.listarTodos();
    }

    public List<Coordenador> listarCoordenador() {
        return coordenadorDAO.listarTodos();
    }
}
