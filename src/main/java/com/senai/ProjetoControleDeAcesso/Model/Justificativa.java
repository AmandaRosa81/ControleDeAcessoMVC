package com.senai.ProjetoControleDeAcesso.Model;

public class Justificativa extends JustificativaUser{

    public Justificativa(String anexar) {
        super(anexar);
    }

    @Override
    public String getAnexar() {
        return super.getAnexar();
    }

    @Override
    public void setAnexar(String anexar) {
        super.setAnexar(anexar);
    }

    @Override
    public String toString() {
        return "Justificativa" +
                "Anexar" + Anexar;
    }
}
