package br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.problemas;

import java.util.LinkedList;

public class ProblemaMapaRomenia implements Problema {

    /* Essas duas vairiaveis sao usadas na funcao de testes */
    public String NomeEstadoInicial;
    public String NomeObjetivo;

    public Estruturas.Estado estadoInicial;
    public Estruturas.Estado objetivo;

    public Estruturas.Estado Arad = new Estruturas.Estado();
    public Estruturas.Estado Timissoara = new Estruturas.Estado();
    public Estruturas.Estado Zerind = new Estruturas.Estado();
    public Estruturas.Estado Sibiu = new Estruturas.Estado();
    public Estruturas.Estado Lugoj = new Estruturas.Estado();
    public Estruturas.Estado Oradea = new Estruturas.Estado();
    public Estruturas.Estado Fagaras = new Estruturas.Estado();
    public Estruturas.Estado Rimnieu_Vilcea = new Estruturas.Estado();
    public Estruturas.Estado Pitesti = new Estruturas.Estado();
    public Estruturas.Estado Bucareste = new Estruturas.Estado();
    public Estruturas.Estado Mehadia = new Estruturas.Estado();
    public Estruturas.Estado Dobreta = new Estruturas.Estado();
    public Estruturas.Estado Craiova = new Estruturas.Estado();
    public Estruturas.Estado Giurgiu = new Estruturas.Estado();
    public Estruturas.Estado Urziceni = new Estruturas.Estado();
    public Estruturas.Estado Hirsova = new Estruturas.Estado();
    public Estruturas.Estado Eforie = new Estruturas.Estado();
    public Estruturas.Estado Vaslui = new Estruturas.Estado();
    public Estruturas.Estado Iasi = new Estruturas.Estado();
    public Estruturas.Estado Neamt = new Estruturas.Estado();

    public LinkedList<Estruturas.Estado> romenia = new LinkedList<Estruturas.Estado>();

    public ProblemaMapaRomenia(String NomeEstadoInicial, String NomeObjetivo) {
        super();
        this.inicializarAcoes();
        this.inicilizarMapa();
        this.NomeEstadoInicial = NomeEstadoInicial;
        this.NomeObjetivo = NomeObjetivo;
        this.estadoInicial = verificaEstadoInicial(NomeEstadoInicial);
        this.objetivo = verificaObjetivo(NomeObjetivo);
    }

    @Override
    public void inicializarAcoes() {

        Arad.nome = "Arad";
        Arad.acoes.add(Sibiu);
        Arad.acoes.add(Zerind);
        Arad.acoes.add(Timissoara);

        Timissoara.nome = "Timissoara";
        Timissoara.acoes.add(Arad);
        Timissoara.acoes.add(Lugoj);

        Oradea.nome = "Oradea";
        Oradea.acoes.add(Zerind);
        Oradea.acoes.add(Sibiu);

        Zerind.nome = "Zerind";
        Zerind.acoes.add(Oradea);
        Zerind.acoes.add(Arad);
        Zerind.acoes.add(Sibiu);

        Sibiu.nome = "Sibiu";
        Sibiu.acoes.add(Fagaras);
        Sibiu.acoes.add(Rimnieu_Vilcea);
        Sibiu.acoes.add(Oradea);
        Sibiu.acoes.add(Arad);

        Fagaras.nome = "Fagaras";
        Fagaras.acoes.add(Bucareste);
        Fagaras.acoes.add(Sibiu);

        Bucareste.nome = "Bucareste";
        Bucareste.acoes.add(Urziceni);
        Bucareste.acoes.add(Fagaras);
        Bucareste.acoes.add(Pitesti);
        Bucareste.acoes.add(Giurgiu);

        Lugoj.nome = "Lugoj";
        Lugoj.acoes.add(Timissoara);
        Lugoj.acoes.add(Mehadia);

        Mehadia.nome = "Mehadia";
        Mehadia.acoes.add(Dobreta);
        Mehadia.acoes.add(Lugoj);

        Dobreta.nome = "Dobreta";
        Dobreta.acoes.add(Craiova);
        Dobreta.acoes.add(Mehadia);

        Craiova.nome = "Craiova";
        Craiova.acoes.add(Pitesti);
        Craiova.acoes.add(Rimnieu_Vilcea);
        Craiova.acoes.add(Dobreta);

        Pitesti.nome = "Pitesti";
        Pitesti.acoes.add(Bucareste);
        Pitesti.acoes.add(Rimnieu_Vilcea);
        Pitesti.acoes.add(Craiova);

        Rimnieu_Vilcea.nome = "Rimnieu_Vilcea";
        Rimnieu_Vilcea.acoes.add(Pitesti);
        Rimnieu_Vilcea.acoes.add(Craiova);
        Rimnieu_Vilcea.acoes.add(Sibiu);

        Giurgiu.nome = "Giurgiu";
        Giurgiu.acoes.add(Bucareste);

        Urziceni.nome = "Urziceni";
        Urziceni.acoes.add(Hirsova);
        Urziceni.acoes.add(Vaslui);
        Urziceni.acoes.add(Bucareste);

        Eforie.nome = "Eforie";
        Eforie.acoes.add(Hirsova);

        Vaslui.nome = "Vaslui";
        Vaslui.acoes.add(Urziceni);
        Vaslui.acoes.add(Iasi);

        Iasi.nome = "Iasi";
        Iasi.acoes.add(Neamt);
        Iasi.acoes.add(Vaslui);

        Neamt.nome = "Neamt";
        Neamt.acoes.add(Iasi);

        Hirsova.nome = "Hirsova";
        Hirsova.acoes.add(Eforie);
        Hirsova.acoes.add(Urziceni);

    }

    public void inicilizarMapa() {
        this.romenia.add(Arad);
        this.romenia.add(Zerind);
        this.romenia.add(Timissoara);
        this.romenia.add(Sibiu);
        this.romenia.add(Lugoj);
        this.romenia.add(Oradea);
        this.romenia.add(Fagaras);
        this.romenia.add(Rimnieu_Vilcea);
        this.romenia.add(Bucareste);
        this.romenia.add(Pitesti);
        this.romenia.add(Craiova);
        this.romenia.add(Mehadia);
        this.romenia.add(Dobreta);
        this.romenia.add(Giurgiu);
        this.romenia.add(Urziceni);
        this.romenia.add(Hirsova);
        this.romenia.add(Eforie);
        this.romenia.add(Vaslui);
        this.romenia.add(Iasi);
        this.romenia.add(Neamt);
    }

    @Override
    public LinkedList<Estruturas.Estado> funcaoSucessora(Estruturas.Estado estado) {
        return estado.acoes;
    }

    @Override
    public boolean testeDeObjetivo(Estruturas.Estado estadoAtual) {
        if (estadoAtual.equals(this.objetivo))
            return true;
        return false;
    }

    @Override
    public Estruturas.Estado verificaEstadoInicial(String estadoInicial) {
        // TODO Auto-generated method stub
        for (int i = 0; i < romenia.size(); i++) {
            if (estadoInicial.equals(romenia.get(i).nome)) {
                return romenia.get(i);
            }
        }
        System.err.println("NAO FOI POSSIVEL ENCONTRAR O ESTADO INICIAL NO MAPA");
        return null;
    }

    @Override
    public Estruturas.Estado verificaObjetivo(String objetivo) {
        for (int i = 0; i < romenia.size(); i++) {
            if (objetivo.equals(romenia.get(i).nome)) {
                return romenia.get(i);
            }
        }
        System.err.println("NAO FOI POSSIVEL ENCONTRAR O OBJETIVO NO MAPA");
        return null;
    }

    @Override
    public Estruturas.Estado getEstadoInicial() {
        return this.estadoInicial;
    }

    @Override
    public Estruturas.Estado getObejetivo() {
        return this.objetivo;
    }

    @Override
    public String getNomeEstadoInicial() {
        return this.NomeEstadoInicial;
    }

    @Override
    public String getNomeObjetivo() {
        return this.NomeObjetivo;
    }
}
