package com.senai.ProjetoControleDeAcesso.Model;

public class Justificativa extends JustificativaUser{

    String id;

    public Justificativa(String anexar) {
        super(anexar);
    }

    public String getId() {
        return id;
    }
    public String setId(){
        return id;
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
