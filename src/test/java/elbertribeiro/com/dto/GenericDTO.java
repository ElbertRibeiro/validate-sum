package elbertribeiro.com.dto;

import elbertribeiro.com.validatesum.SomaValida;

import javax.validation.constraints.NotNull;

public class GenericDTO {

    @NotNull
    private Double valor1;

    @NotNull
    private Double valor2;

    @SomaValida(message = "A soma dos valores não é válida", valor1 = "valor1", valor2 = "valor2")
    private Double soma;

    // Getters e setters

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }
}

