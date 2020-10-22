package br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.busca;
import br.com.ifma.edu.br.ia.grafos.algorithms.busca.largura.grafo.Vertice;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuscaEmLargura {
    private Vertice inicial, destino;
    private Stack<Vertice> listaVisitados = new Stack<>();
    private List<Vertice> caminho = new ArrayList<>();

    public Vertice busca(Vertice inicial, Vertice destino){
        this.inicial = inicial;
        this.destino = destino;
        //Define o vertice inicial
        this.inicial.setPai(null);
        this.inicial.setDistancia(0);
        listaVisitados.add(this.inicial);

        Vertice verticeAtual;
        while(!listaVisitados.isEmpty()){
            verticeAtual = listaVisitados.pop(); //Remove elemento no topo da pilha
            caminho.add(verticeAtual); //Armazena o caminho
            //Se chegou no destino
            if(this.destino.equals(verticeAtual)) {
                imprimeCaminho(caminho); //Exibe o caminho percorrido
                return verticeAtual; //Retorna o destino
            }
            //Caso não, percorre os vertices adjacentes
            for(int i=0; i < verticeAtual.getVizinhos().size(); i++) {
                if(!foiExpandido(verticeAtual.getVizinhos().get(i)) &&
                   !foiVisitado(listaVisitados, verticeAtual.getVizinhos().get(i))) {

                    verticeAtual.getVizinhos().get(i).setCor(Color.GRAY);
                    verticeAtual.getVizinhos().get(i).setDistancia(verticeAtual.getDistancia() + 1);
                    listaVisitados.add(verticeAtual.getVizinhos().get(i));
                }
            }
            verticeAtual.setCor(Color.BLACK);
        }
        return null;
    }

    private boolean foiExpandido(Vertice vertice) {
        return (vertice.getCor() == Color.BLACK);
    }

    private boolean foiVisitado(Stack<Vertice> listaVisitados, Vertice vertice) {
        for (Vertice verticeAtual : listaVisitados) {
            if (vertice.equals(verticeAtual)) {
                System.out.println("Pesquisa visitado: " + vertice.getValor());
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
    private void imprimeCaminho(List<Vertice> c){
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
