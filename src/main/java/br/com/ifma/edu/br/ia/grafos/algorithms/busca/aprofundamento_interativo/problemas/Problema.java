package br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.problemas;

import br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.estruturas.Estado;

import java.util.LinkedList;

public interface Problema {

    void inicializarAcoes();

    LinkedList<Estado> funcaoSucessora(Estado estado);

    boolean testeDeObjetivo(Estado estadoAtual);

    Estado verificaEstadoInicial(String nomeEstadoInicial);

    Estado verificaObjetivo(String nomeOjetivo);

    Estado getEstadoInicial();

    Estado getObejetivo();

    String getNomeEstadoInicial();

    String getNomeObjetivo();
}
