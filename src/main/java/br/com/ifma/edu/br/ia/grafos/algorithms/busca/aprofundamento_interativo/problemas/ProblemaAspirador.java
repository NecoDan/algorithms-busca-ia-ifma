package br.com.ifma.edu.br.ia.grafos.algorithms.busca.aprofundamento_interativo.problemas;


import java.util.LinkedList;

public class ProblemaAspirador implements Problema {

    public String NomeEstadoInicial;
    public String NomeObjetivo = "DLL ou ELL";

    public Estruturas.Estado estadoInicial;

    public Estruturas.Estado ESS = new Estruturas.Estado();
    public Estruturas.Estado DSS = new Estruturas.Estado();
    public Estruturas.Estado ELL = new Estruturas.Estado();
    public Estruturas.Estado DLL = new Estruturas.Estado();
    public Estruturas.Estado ESL = new Estruturas.Estado();
    public Estruturas.Estado DSL = new Estruturas.Estado();
    public Estruturas.Estado ELS = new Estruturas.Estado();
    public Estruturas.Estado DLS = new Estruturas.Estado();

    public LinkedList<Estruturas.Estado> aspirador = new LinkedList<Estruturas.Estado>();

    public ProblemaAspirador(String nomeEstadoInicial) {
        super();
        this.inicializarAcoes();
        this.inicializarAspirador();
        this.NomeEstadoInicial = nomeEstadoInicial;
        this.estadoInicial = verificaEstadoInicial(nomeEstadoInicial);
    }

    @Override
    public void inicializarAcoes() {
        ESS.nome = "ESS";
        ESS.acoes.add(ELS);
        ESS.acoes.add(DSS);

        DSS.nome = "DSS";
        DSS.acoes.add(ESS);
        DSS.acoes.add(DSL);

        ELL.nome = "ELL";
        ELL.acoes.add(DLL);

        DLL.nome = "DLL";
        DLL.acoes.add(ELL);

        ELS.nome = "ELS";
        ELS.acoes.add(DLS);

        DSL.nome = "DSL";
        DSL.acoes.add(ESL);

        ESL.nome = "ESL";
        ESL.acoes.add(ELL);
        ESL.acoes.add(DSL);

        DLS.nome = "DLS";
        DLS.acoes.add(DLL);
        DLS.acoes.add(ELS);

    }

    public void inicializarAspirador() {
        aspirador.add(ESS);
        aspirador.add(DSS);
        aspirador.add(ELL);
        aspirador.add(DLL);
        aspirador.add(ESL);
        aspirador.add(DSL);
        aspirador.add(ELS);
        aspirador.add(DLS);
    }

    @Override
    public LinkedList<Estruturas.Estado> funcaoSucessora(Estruturas.Estado estado) {
        return estado.acoes;
    }

    @Override
    public boolean testeDeObjetivo(Estruturas.Estado estadoAtual) {
        if (estadoAtual.equals(DLL) || estadoAtual.equals(ELL))
            return true;
        return false;
    }

    @Override
    public Estruturas.Estado verificaEstadoInicial(String nomeEstadoInicial) {
        for (int i = 0; i < aspirador.size(); i++) {
            if (nomeEstadoInicial.equals(aspirador.get(i).nome))
                return aspirador.get(i);
        }
        System.err.println("ESTADO INICIAL INVALIDO");
        return null;
    }

    @Override
    public Estruturas.Estado verificaObjetivo(String nomeOjetivo) {
        return null;
    }

    @Override
    public Estruturas.Estado getEstadoInicial() {
        return this.estadoInicial;
    }

    @Override
    public Estruturas.Estado getObejetivo() {
        return null;
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
