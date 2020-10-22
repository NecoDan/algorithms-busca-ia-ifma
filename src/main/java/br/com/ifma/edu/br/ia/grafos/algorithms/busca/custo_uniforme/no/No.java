package br.com.ifma.edu.br.ia.grafos.algorithms.busca.custo_uniforme.no;

import java.util.Comparator;

public class No implements Comparator<No> {
    private int no;
    private int custo;

    @Override
    public int compare(No no1, No no2) {
        if (no1.custo < no2.custo)
            return -1;
        if (no1.custo > no2.custo)
            return 1;
        if (no1.no < no2.no)
            return -1;
        return 0;
    }

    public No() {
    }

    public No(int no, int custo) {
        this.no = no;
        this.custo = custo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof No)) return false;
        No no1 = (No) o;
        return no == no1.no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
}
