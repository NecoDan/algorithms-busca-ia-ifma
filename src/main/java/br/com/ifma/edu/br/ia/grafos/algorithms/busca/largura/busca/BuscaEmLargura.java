package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.busca;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo.Vertice;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class BuscaEmLargura {
    private Vertice inicial, destino;
    private Stack<Vertice> listaVisitados = new Stack<>();
    private ArrayList<Vertice> caminho = new ArrayList();

    public Vertice busca(Vertice inicial, Vertice destino){
        this.inicial = inicial;
        this.destino = destino;

        this.inicial.setPai(null);
        this.inicial.setDistancia(0);
        listaVisitados.add(this.inicial);

        Vertice verticeAtual;
        while(!listaVisitados.isEmpty()){
            verticeAtual = listaVisitados.pop();
            caminho.add(verticeAtual);
            if(this.destino.equals(verticeAtual)){
                this.imprimeCaminho(caminho);
                return verticeAtual;
            }
            for(int i=0;i<verticeAtual.getVizinhos().size();i++){
                if(!foiVisitado(verticeAtual.getVizinhos().get(i)) &&
                        !pesquisaVisitados(listaVisitados,verticeAtual.getVizinhos().get(i))) {
                    verticeAtual.getVizinhos().get(i).setCor(Color.GRAY);
                    verticeAtual.getVizinhos().get(i).setDistancia(verticeAtual.getDistancia() + 1);
                    listaVisitados.add(verticeAtual.getVizinhos().get(i));
                }
            }
            verticeAtual.setCor(Color.BLACK);
        }
        return null;
    }

    public boolean foiVisitado(Vertice vertice) {
        return (vertice.getCor() == Color.BLACK);
    }

    private boolean pesquisaVisitados(Stack<Vertice> listaVisitados, Vertice vertice) {
        for (int i=0;i<listaVisitados.size();i++){
            if(vertice.equals(listaVisitados.get(i))){
                System.out.println(vertice.getValor());
                return true;
            }
        }
        return false;
    }

    //imprime busca
    public void imprimeBusca(Vertice v) {
        System.out.println(
            "Início: " + this.inicial.getValor()+
            "\nDestino: " + this.destino.getValor()//+
            //"\nPai: " + v.getPai().getValor()+
            //"\nDistancia: " + calculaDistancia() +"\n"
        );
    }
    //imprime o caminho em razão da marcação de preto no vertice visitado
    public void imprimeCaminho(ArrayList<Vertice> c){
        for(int i=0;i<c.size();i++){
            System.out.print("("+c.get(i).getValor()+")");
            if(i<caminho.size()-1){
                System.out.print(">>");
            }
        }
        System.out.print("\n");
    }
    //Calcula a distancia percorrida em razÃ£o do caminho feito
    public int calculaDistancia(){
        int i;
        int cont = 0;
        for(i=0;i<caminho.size();i++){
            cont+=caminho.get(i).getDistancia();
        }
        return cont;
    }
}
