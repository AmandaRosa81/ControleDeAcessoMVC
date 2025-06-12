package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.LoginController;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;
import com.senai.ProjetoControleDeAcesso.Util.CriptografiaUtil;

import java.util.Optional;
import java.util.Scanner;

public class LoginView  {

    private final Scanner scanner = new Scanner(System.in);
    private final LoginController controller = new LoginController();

    public Optional<Usuario> exibirLogin(){
        System.out.println("\n_____ LOGIN DO SISTEMA_____");
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("___Senha:  ___");
        String senha = scanner.nextLine();

        Optional<Usuario> usuario = controller.autenticar(login, CriptografiaUtil.hash(senha));
        if (usuario.isEmpty()){
            System.out.println("____\nCredenciais invalidas. Tente novamente.\n____");
        }
        return usuario;
    }

    }
