package edu.Desafio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Desafios {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        // Desafio 1 - Mostre a lista na ordem numérica:

        List<Integer> OrdemNumerica = numeros.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(OrdemNumerica);

        // Desafio 2 - Imprima a soma dos números pares da lista:
        int somaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Soma dos números pares: " + somaPares);

        // Desafio 3 - Verifique se todos os números da lista são positivos:
                boolean todosPositivos = numeros.stream()
                        .allMatch(n -> n > 0);
                System.out.println("Todos os números são positivos: " + todosPositivos);

        // Desafio 4 - Remova todos os valores ímpares:
                List<Integer> listaSemImpares = numeros.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());
                System.out.println("Lista sem números ímpares: " + listaSemImpares);
        // Desafio 5 - Calcule a média dos números maiores que 5:
        OptionalDouble media = numeros.stream()
                .filter(n -> n > 5)
                .mapToDouble(Integer::doubleValue)
                .average();
        if (media.isPresent()) {
            System.out.println("Média dos números maiores que 5: " + media.getAsDouble());
        } else {
            System.out.println("Nenhum número maior que 5 encontrado.");
        }

        // Desafio 6 - Verificar se a lista contém algum número maior que 10:
        boolean possuiMaiorQue10 = numeros.stream()
                .anyMatch(n -> n > 10);
        System.out.println("Contém número maior que 10: " + possuiMaiorQue10);

        // Desafio 7 - Encontrar o segundo número maior da lista:
        Optional<Integer> segundoMaior = numeros.stream()
                .distinct()
                .sorted((a, b) -> b.compareTo(a))
                .skip(1)
                .findFirst();
        if (segundoMaior.isPresent()) {
            System.out.println("Segundo número maior: " + segundoMaior.get());
        } else {
            System.out.println("Não há segundo número maior.");
        }

        // Desafio 8 - Somar os dígitos de todos os números da lista:
        int somaDigitos = numeros.stream()
                .mapToInt(n -> {
                    int soma = 0;
                    while (n > 0) {
                        soma += n % 10;
                        n /= 10;
                    }
                    return soma;
                })
                .sum();
        System.out.println("Soma dos dígitos: " + somaDigitos);

        // Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
        boolean saoDistintos = numeros.stream()
                .allMatch(n -> numeros.indexOf(n) == numeros.lastIndexOf(n));
        System.out.println("Todos os números são distintos: " + saoDistintos);

        // Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
        Map<Boolean, List<Integer>> grupos = numeros.stream()
                .filter(n -> n % 2 != 0 && (n % 3 == 0 || n % 5 == 0))
                .collect(Collectors.partitioningBy(n -> n % 2 != 0));

        System.out.println("Valores ímpares múltiplos de 3 ou de 5:");
        System.out.println("Ímpares: " + grupos.get(true));
        System.out.println("Pares: " + grupos.get(false));

        // Desafio 11 - Encontre a soma dos quadrados de todos os números da lista:
        int somaQuadrados = numeros.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Soma dos quadrados: " + somaQuadrados);

        // Desafio 12 - Encontre o produto de todos os números da lista:
        Optional<Integer> produto = numeros.stream()
                .reduce((a, b) -> a * b);
        if (produto.isPresent()) {
            System.out.println("Produto de todos os números: " + produto.get());
        } else {
            System.out.println("A lista está vazia.");
        }

        // Desafio 13 - Filtrar os números que estão dentro de um intervalo:
        int limiteInferior = 5;
        int limiteSuperior = 10;
        List<Integer> numerosNoIntervalo = numeros.stream()
                .filter(n -> n >= limiteInferior && n <= limiteSuperior)
                .collect(Collectors.toList());
        System.out.println("Números no intervalo [" + limiteInferior + ", " + limiteSuperior + "]: " + numerosNoIntervalo);


        // Desafio 14 - Encontre o maior número primo da lista:
        Optional<Integer> maiorPrimo = numeros.stream()
                .filter(Desafios::isPrimo)
                .max(Integer::compareTo);
        if (maiorPrimo.isPresent()) {
            System.out.println("Maior número primo: " + maiorPrimo.get());
        } else {
            System.out.println("Não há números primos na lista.");
        }

        // Desafio 15 - Verifique se a lista contém pelo menos um número negativo:
        boolean contemNegativo = numeros.stream()
                .anyMatch(n -> n < 0);
        System.out.println("Contém número negativo: " + contemNegativo);

        // Desafio 16 - Agrupe os números em pares e ímpares:
        Map<Boolean, List<Integer>> gruposParesImpares = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Números pares: " + gruposParesImpares.get(true));
        System.out.println("Números ímpares: " + gruposParesImpares.get(false));

        // Desafio 17 - Filtrar os números primos da lista:
        List<Integer> numerosPrimos = numeros.stream()
                .filter(Desafios::isPrimo)
                .collect(Collectors.toList());
        System.out.println("Números primos: " + numerosPrimos);

        // Desafio 18 - Verifique se todos os números da lista são iguais:
        boolean todosIguais = numeros.stream()
                .distinct()
                .count() == 1;
        System.out.println("Todos os números são iguais: " + todosIguais);

        // Desafio 19 - Encontre a soma dos números divisíveis por 3 e 5:
        int somaDivisiveisPor3e5 = numeros.stream()
                .filter(n -> n % 3 == 0 && n % 5 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Soma dos números divisíveis por 3 e 5: " + somaDivisiveisPor3e5);
    }

    private static boolean isPrimo(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
    }
}





    }
}
