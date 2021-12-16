package Dades;

public class Node {
    private Recurso r;
    private Node seguent;

    public Node(Recurso r) {
        this.r = r;
        this.seguent = null;
    }


    public Recurso getR() {
        return r;
    }

    public void setR(Recurso r) {
        this.r = r;
    }

    public Node getSeguent() {
        return seguent;
    }

    public void setSeguent(Node seguent) {
        this.seguent = seguent;
    }

}