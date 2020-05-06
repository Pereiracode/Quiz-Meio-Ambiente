package data;

import java.util.*;
import models.Pergunta;
import views.Jogo;

public class Data {
    public String[] listRespostaEasy = {
    "r1", "r2", "r3", "r4",
    "r5", "r6", "r7", "r8", 
    "r9", "r10", "r11", "r12",
    "r13", "r14", "r15", "r16",
    "r17", "r18", "r19", "r20",
    "r21", "r22", "r23", "r24",
    "r25", "r26", "r27", "r28"
    };
    
    Pergunta p1 = new Pergunta("Pergunta 1", listRespostaEasy, listRespostaEasy[0]);
    Pergunta p2 = new Pergunta("Pergunta 2", listRespostaEasy, listRespostaEasy[4]);
    Pergunta p3 = new Pergunta("Pergunta 3", listRespostaEasy, listRespostaEasy[8]);
    Pergunta p4 = new Pergunta("Pergunta 4", listRespostaEasy, listRespostaEasy[12]);
    Pergunta p5 = new Pergunta("Pergunta 5", listRespostaEasy, listRespostaEasy[16]);
    Pergunta p6 = new Pergunta("Pergunta 6", listRespostaEasy, listRespostaEasy[20]);
    Pergunta p7 = new Pergunta("Pergunta 7", listRespostaEasy, listRespostaEasy[24]);
    
    public Pergunta[] listPerguntaEasy = {p1, p2, p3, p4, p5, p6, p7};
    
    public String[] listRespostaMedium = {
    "r1", "r2", "r3", "r4",
    "r5", "r6", "r7", "r8", 
    "r9", "r10", "r11", "r12",
    "r13", "r14", "r15", "r16",
    "r17", "r18", "r19", "r20",
    "r21", "r22", "r23", "r24",
    "r25", "r26", "r27", "r28"
    };
    
    Pergunta p8 = new Pergunta("Pergunta 8", listRespostaMedium, listRespostaMedium[0]);
    Pergunta p9 = new Pergunta("Pergunta 9", listRespostaMedium, listRespostaMedium[4]);
    Pergunta p10 = new Pergunta("Pergunta 10", listRespostaMedium, listRespostaMedium[8]);
    Pergunta p11 = new Pergunta("Pergunta 11", listRespostaMedium, listRespostaMedium[12]);
    Pergunta p12 = new Pergunta("Pergunta 12", listRespostaMedium, listRespostaMedium[16]);
    Pergunta p13 = new Pergunta("Pergunta 13", listRespostaMedium, listRespostaMedium[20]);
    Pergunta p14 = new Pergunta("Pergunta 14", listRespostaMedium, listRespostaMedium[24]);
    
    public Pergunta[] listPerguntaMedium = {p8, p9, p10, p11, p12, p13, p14};
    
    public String[] listRespostaHard = {
    "r1", "r2", "r3", "r4",
    "r5", "r6", "r7", "r8", 
    "r9", "r10", "r11", "r12",
    "r13", "r14", "r15", "r16",
    "r17", "r18", "r19", "r20",
    "r21", "r22", "r23", "r24",
    "r25", "r26", "r27", "r28"
    };
    
    Pergunta p15 = new Pergunta("Pergunta 15", listRespostaHard, listRespostaHard[0]);
    Pergunta p16 = new Pergunta("Pergunta 16", listRespostaHard, listRespostaHard[4]);
    Pergunta p17 = new Pergunta("Pergunta 17", listRespostaHard, listRespostaHard[8]);
    Pergunta p18 = new Pergunta("Pergunta 18", listRespostaHard, listRespostaHard[12]);
    Pergunta p19 = new Pergunta("Pergunta 19", listRespostaHard, listRespostaHard[16]);
    Pergunta p20 = new Pergunta("Pergunta 20", listRespostaHard, listRespostaHard[20]);
    Pergunta p21 = new Pergunta("Pergunta 21", listRespostaHard, listRespostaHard[24]);
    
    public Pergunta[] listPerguntaHard = {p15, p16, p17, p18, p19, p20, p21};
    
    public Data(){
    }
    
}
