package models;

public class Pergunta {
    
    public String Questao;
    
    public String RespostaCerta;

    public String getQuestao() {
        return Questao;
    }

    public void setQuestao(String Questao) {
        this.Questao = Questao;
    }

    public String getRespostaCerta() {
        return RespostaCerta;
    }

    public void setRespostaCerta(String RespostaCerta) {
        this.RespostaCerta = RespostaCerta;
    }
        
    public Pergunta(){
    }

    public Pergunta(String Questao, String RespostaCerta) {
        this.Questao = Questao;
        this.RespostaCerta = RespostaCerta;
    }  
}
