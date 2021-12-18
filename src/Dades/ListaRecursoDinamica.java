package Dades;

import java.util.ArrayList;

import interfaces.TADcjtRecurso;

public class ListaRecursoDinamica implements TADcjtRecurso{
    
    private Node primer;
    private int numElem;
    
    public ListaRecursoDinamica() {
        primer = null;
        numElem = 0;
    }
    
    public boolean afegirRecurs(Recurso r) {        // mètode que afegeix un recurs
        if (!pertany(r)) {
            Node aux=new Node(r);
            aux.setSeguent(primer);
            primer=aux;
            numElem++;
            return true; // el Recurs s'ha afegit correctament
        } else {
            return false; // el Recurs ja hi era a la llista
        }
    }

    private boolean pertany(Recurso r) {        // mètode que busca si existeix el Recurs
        boolean hiEs = false;
        Node aux=primer;
        while (aux != null && hiEs ) {
            if (aux.getR() == r) {
                hiEs = true;
            } else {
            aux = aux.getSeguent();    
            }
        }
        return hiEs;
    }

    @Override
    public boolean consultarAlumne(String alum) {
        int i=0;
        boolean trobat =false;
        while (!trobat && i < numElem) {
            int j=0;
            while (!trobat && j < primer.getR().getNumVisita()) {
                if (primer.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
                    trobat = true;
                }
                j++;
            }
            i++;
        }
        return trobat;
    }

    @Override
    public String[] llistatUsers(Data d) {
        String [] aux= new String[100];
        int c=0;
        for (int i=0; i< numElem; i++) {
            for (int j=0; j< primer.getR().getNumVisita(); j++) {
                if (primer.getR().getListaVisita()[j].getData().esIgual(d)) {
                    aux [c] = primer.getR().getListaVisita()[j].getAliesAlum();
                    c++;
                }
            }
        }
        return aux;
    }

    @Override
    public String[] llistatUsersFranja(Data d1, Data d2) {
        if (!(d1.esDataInferiorOigual(d2))) {
            Data aux = d1;
            d1=d2;
            d2=aux;
        }
        
        String [] aux = new String[100];
        int c=0;
        for (int i=0; i< numElem; i++) {
            for (int j=0; j< primer.getR().getNumVisita(); j++) {
                if (primer.getR().getListaVisita()[j].getData().esDataInferiorOigual(d2) && !(primer.getR().getListaVisita()[j].getData().esDataInferiorOigual(d1))) {
                    aux [c]=primer.getR().getListaVisita()[j].getAliesAlum();
                    c++;
                }
            }
        }
        return aux;
    }

    @Override
    public Recurso[] ConsultarRecursAlumne(String alum) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean EsborrarDadesConsulta(Recurso r) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String[] LlistatUserConsultaRecurs(String recurs) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] LlistatUserConsultaRecursData(String recurs, Data d) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Recurso mesConsultat() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Recurso[] LlistaRecursosConsultatsAlies(String alies) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public boolean afegirVisita(String r, Visita v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumRecursos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Recurso[] getListaRecurso() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
