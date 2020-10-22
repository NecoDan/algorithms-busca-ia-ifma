package br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.estruturas;

import java.util.LinkedList;

public class Estado {

    public String nome;

    // Podemos inicializar essa lista no arquivo do problema
    public LinkedList<Estado> acoes = new LinkedList<>();
}
