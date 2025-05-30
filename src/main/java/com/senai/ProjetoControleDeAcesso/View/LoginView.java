package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Controller.CoordenadorController;
import com.senai.ProjetoControleDeAcesso.Controller.ProfessorController;
import com.senai.ProjetoControleDeAcesso.LoginController;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.Optional;
import java.util.Scanner;

public class LoginView {

    private final Scanner scanner = new Scanner(System.in);
    private final LoginController Controller = new LoginController();

    public Optional<Usuario> exibirLogin(){
        System.out.println("\n==== LOGIN DO SISTEMA====");
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Optional<Usuario> usuario = Controller.autenticar(login, CriptografiUtil.hash(senha));
        if (usuario.isEmpty()){
            System.out.println("\nCredenciais invalidas. Tente novamente.\n");
        }
        return usuario;
    }

    }
