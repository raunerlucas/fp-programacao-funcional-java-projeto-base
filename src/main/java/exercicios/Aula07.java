package exercicios;

import exercicios.base.Aula;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public class Aula07 extends Aula {
    public Aula07(){
        System.out.println("Exercício 7 - Optional");

        System.out.println("\nmaiorNotaOptional => ");
        maiorNotaOptional();
        System.out.println("\nmaiorNotaOptionalOrElseGet => ");
        maiorNotaOptionalOrElseGet();
        System.out.println("\nmaiorNotaOptionalThrow => ");
        maiorNotaOptionalThrow();

        System.out.println("\nImprime nota => ");
        imprimeNota(null);
    }


    private void imprimeNota(@Nullable Estudante e){
//        Objects.requireNonNull(e, "Estudante não pode ser nulo.");
        if (e == null) {
            System.out.println("Estudante não pode ser nulo.");
            return;
        }
        System.out.println("Nome: " + e.getNome() + ", Nota: " + e.getNota());
    }

    private void maiorNotaOptionalThrow() {
        OptionalDouble maxOptional = estudantes.stream()
                .filter(e -> e.getSexo() == 'M')
                .mapToDouble(Estudante::getNota)
                .max();

        double maiorNota = maxOptional.orElseThrow(() -> new NoSuchElementException("Nenhum estudante encontrado."));
        System.out.println("A maior nota é: " + maiorNota);
    }

    private void maiorNotaOptionalOrElseGet() {
//        OptionalDouble maxOptional = estudantes.stream()
        estudantes.stream()
                .filter(e -> e.getSexo() == 'X')
                .mapToDouble(Estudante::getNota)
                .max()
//                .ifPresent(System.out::println);
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nenhum estudante encontrado."));

//        double maiorNota = maxOptional.orElseGet(() -> {
//            System.out.println("Nenhum estudante encontrado.");
//            return 0.0;
//        });
//        System.out.println("A maior nota é: " + maiorNota);
    }

    private void maiorNotaOptional() {
        OptionalDouble maxOptional = estudantes.stream()
                .mapToDouble(Estudante::getNota)
                .max();

        double maiorNota = maxOptional.orElse(Double.NaN);
        System.out.println("A maior nota é: " + maiorNota);
    }

    public static void main(String[] args) {
     new Aula07();
    }
}
