package models;

public class Pergunta {
    
    public String Questao;
    
    public String[] Respostas;
    
    public String RespostaCerta;

    public String getQuestao() {
        return Questao;
    }

    public void setQuestao(String Questao) {
        this.Questao = Questao;
    }

    public String[] getRespostas() {
        return Respostas;
    }

    public void setRespostas(String [] Respostas) {
        this.Respostas = Respostas;
    }

    public String getRespostaCerta() {
        return RespostaCerta;
    }

    public void setRespostaCerta(String RespostaCerta) {
        this.RespostaCerta = RespostaCerta;
    }
        
    public Pergunta(){
    }

    public Pergunta(String Questao, String[] Respostas, String RespostaCerta) {
        this.Questao = Questao;
        this.Respostas = Respostas;
        this.RespostaCerta = RespostaCerta;
    }  
}
