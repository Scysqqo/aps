package com.aps.aps.Models;

public class Analytic {
    private String url="";
    private String questao1="";
    private String questao2="";
    private String questao3="";
    
    public Analytic() {
    }

    public Analytic(String url, String questao1, String questao2, String questao3) {
        this.url = url;
        this.questao1 = questao1;
        this.questao2 = questao2;
        this.questao3 = questao3;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuestao1() {
        return questao1;
    }

    public void setQuestao1(String questao1) {
        this.questao1 = questao1;
    }

    public String getQuestao2() {
        return questao2;
    }

    public void setQuestao2(String questao2) {
        this.questao2 = questao2;
    }

    public String getQuestao3() {
        return questao3;
    }

    public void setQuestao3(String questao3) {
        this.questao3 = questao3;
    }

    


}
