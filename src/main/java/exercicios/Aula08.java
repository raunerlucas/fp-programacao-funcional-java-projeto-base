package exercicios;

import exercicios.base.Aula;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aula08 extends Aula {
    private final Map<String, Double> mapPessoaComanda = new HashMap<>(Map.of("Lucas", 10.0, "João", 20.0, "Maria", 30.0, "Ana", 40.0, "Pedro", 50.0, "Carlos", 60.0, "Fernanda", 70.0, "Juliana", 80.0, "Roberto", 90.0, "Patrícia", 110.0));

    public Aula08() {
//        useReduce();
//        workFromMaps();
//        mapWhifiEstudante();

    }

    private void mapWhifiEstudante() {
        Map<String, Double> mapNomeNotaEst = estudantes.stream()
                .collect(Collectors.toMap(Estudante::getNome, Estudante::getNota));
        mapNomeNotaEst.forEach((nome, nota) -> {
            System.out.println("Nome -> "+nome + " Nota -> " + nota);
        });
    }

    private void workFromMaps() {
    /*
    mapPessoaComanda.putIfAbsent("Rauner", getValue()); // Adiciona o valor 100.0 para a chave "Rauner" se ela não existir
    // Oq esse metodo faz é verificar se a chave existe, se não existir ele adiciona, caso contrario. Ele seta o valor para a existente.

    mapPessoaComanda.computeIfAbsent("Rauner", nome -> getValue()); // Adiciona o valor 100.0 para a chave "Lucas" se ela não existir
    // Oq esse metodo faz é verificar se a chave existe, se não existir ele adiciona, e o valor for igual, ele não chama o getValue().
*/
        mapPessoaComanda.merge("Rauner", 100.0, (vOld, vNew) -> vNew + vOld); // Adiciona o valor 100.0 para a chave "Lucas" se ela não existir)
        mapPessoaComanda.merge("Rauner", 50.0, Double::sum); // Adiciona o valor 100.0 para a chave "Lucas" se ela não existir)

        mapPessoaComanda.replaceAll((_, valor) -> valor >= 50.0 ? valor * 0.9 : valor); // Aplica um desconto de 10% para valores maiores ou iguais a 50.0

        mapPessoaComanda
                .entrySet()
                .stream()
                .forEach(entry -> {
                    var novoValor = entry.getValue() >= 50.0 ? entry.getValue() * 0.9 : entry.getValue();
                    System.out.println(entry.getKey() + " : " + novoValor);
                });
        // Aplica um desconto de 10% para valores maiores ou iguais a 50.0 (PELA SEGUNDA VEZ)

//        mapPessoaComanda.entrySet().removeIf(entry -> entry.getValue() < 50.0); // Remove entradas com valor menor que 50.0

        mapPessoaComanda.forEach((k, v) -> System.out.printf("%s: %.2f%n", k, v));
    }

    // Metodo para obter o valor 100.0
    private static double getValue() {
        System.out.println("getValue() chamado");
        return 100.0;
    }

    private void useReduce() {
        // Reduzir a lista de estudantes para encontrar o estudante com a maior nota
        // O metodo reduce() recebe um acumulador e um valor inicial
        // O acumulador é uma função que recebe dois parâmetros: o acumulador atual e o próximo elemento da lista
        // O valor inicial neste caso esta sendo o primeiro elemento da lista
        // Caso não tenha, nada na lista ele ira retorna o valor inical.

        Estudante estudantesFirst = estudantes.getFirst();
//        Estudante estudantesFirst = new Estudante(Integer.MAX_VALUE, "Estudante erro no reduce aula08 linha 20", 'M',0.0,2, generator.CURSOS[1], generator.CIDADES[1]);
        Estudante estudante = estudantes.stream().reduce(estudantesFirst, (e1, e2) -> e1.compareTo(e2) > 0 ? e1 : e2);
        System.out.println("Estudante com maior nota --> " + estudante.getNome() + " <--  Nota [ " + estudante.getNota() + " ]");
    }

    public static void main(String[] args) {
        new Aula08();
    }
}
