package com.aps.aps.Models;

import javax.persistence.Embeddable;

@Embeddable
public class Campo {
    float number;
    String label;
    String name;
    String type;
    public Campo() {
    }
    public Campo(float number, String label, String name, String type) {
        this.number = number;
        this.label = label;
        this.name = name;
        this.type = type;
    }
    public float getNumber() {
        return number;
    }
    public void setNumber(float number) {
        this.number = number;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
   
    public boolean isAnswer(){
        if(name.equalsIgnoreCase("questao1Status")) return true;
        if(name.equalsIgnoreCase("questao2Status")) return true;
        if(name.equalsIgnoreCase("questao3Status")) return true;
        if(name.equalsIgnoreCase("urlpdf")) return true;
        
        

        return false;
    }

     public boolean isAnswerProfessor(){
        if(name.equalsIgnoreCase("urlpdfStatus")) return true;
        
        

        return false;
    }
}
