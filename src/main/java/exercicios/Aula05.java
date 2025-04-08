package exercicios;

import exercicios.base.Aula;

public class Aula05 extends Aula {

    public Aula05() {
        System.out.printf("\nMenor notas Estudante aprovado => %.2f", menorNota());
        System.out.printf("\nTotal de Estados que tem Estudantes => %d", totalEstados());
    }

    private long totalEstados() {
        return estudantes.stream()
                .map(Estudante::getCidade)
                .map(Cidade::getEstado)
                .distinct()
                .count();
    }

    private double menorNota() {
        return estudantes.stream()
                .filter(estudante -> estudante.isHomem() && estudante.isAprovado())
                .mapToDouble(Estudante::getNota)
                .min()
                .orElse(0.0);
    }

    public static void main(String[] args) {new Aula05();}
}
