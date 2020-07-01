package com.fsconsultoria.desafiofleury.model;

import java.util.ArrayList;

public class ListExames {

    private ArrayList<PojoExame> exames;

    public ListExames(ArrayList<PojoExame> exames) {
        this.exames = exames;
    }

    public ArrayList<PojoExame> getExames(){
        return exames;
    }

    public void setExames(ArrayList<PojoExame> exames) {
        this.exames = exames;
    }
}
