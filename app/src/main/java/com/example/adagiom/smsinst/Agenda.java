package com.example.adagiom.smsinst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Agenda{

    private Contacto contacto;
    private List<Contacto> list;

    public Agenda() {
        this.list = new ArrayList();
    }

    public List getList(){
        return list;
    }
    public void setList(Contacto cont){
        this.contacto = cont;
        this.list.add(this.contacto);
    }
}
