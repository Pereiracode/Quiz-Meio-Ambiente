package views;

import data.Data;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JButton;
import models.Pergunta;


public class Jogo extends javax.swing.JFrame {    
    
    Data dados = new Data();
    Random random = new Random();
    int aux = 0;
    String[] selecionadaResposta;
    Pergunta[] selecionadaPergunta;
    int acertos, erros, pontos, vidas;
    
    public Jogo() {
        initComponents();
        CarregarInicial();
    }
    

    public void SetarFase(){
        if(lblNivel.getText().equals("Easy")){
            selecionadaResposta = dados.listRespostaEasy;
            selecionadaPergunta = dados.listPerguntaEasy;
        }
        else if(lblNivel.getText().equals("Medium")){
            selecionadaResposta = dados.listRespostaMedium;
            selecionadaPergunta = dados.listPerguntaMedium;
        }
        else{
            selecionadaResposta = dados.listRespostaHard;
            selecionadaPergunta = dados.listPerguntaHard;
        }
    }
    
    
    public JButton[] ListaBotao(){
        JButton[] list = {btnA, btnB, btnC, btnD};    
        return list;
    }
    
    public void MisturaResposta(){
        int a = random.nextInt(4);
        int b = random.nextInt(4);    
        int c = random.nextInt(4);
        int d = random.nextInt(4);
       
        
        // Obrigando os 4 numeros serem diferentes !
        while(a == b || a == c || a == d || b == c || b == d || c == d){
            b = random.nextInt(4);    
            c = random.nextInt(4);
            d = random.nextInt(4);
        }
        
        ListaBotao()[a].setText(selecionadaResposta[aux]);
        ListaBotao()[b].setText(selecionadaResposta[aux + 1]);
        ListaBotao()[c].setText(selecionadaResposta[aux + 2]);
        ListaBotao()[d].setText(selecionadaResposta[aux + 3]);
        
        aux += 4;
    }
    
    public int NumeroQuestao(){
        int n = 0;
        for(int x = 0; x <= selecionadaPergunta.length - 1; x++){
            if(lblPergunta.getText().equals(selecionadaPergunta[x].Questao)){
                n = x + 1;
                break;
            }
        }
        if(n == 0){
            JOptionPane.showMessageDialog(this, "Erro !!!");
        }
        return n;
    }
    
    public void SetarPergunta(){
        lblNumeroPergunta.setText("Pergunta: " + NumeroQuestao() + " / 7");
    }
    
    public void AdicionarPontuacao(){
        pontos = Integer.parseInt(lblPontuacao.getText());
        lblPontuacao.setText(Integer.toString(pontos + 20));
    }
    
    public void RemoverPontuacao(){
        pontos = Integer.parseInt(lblPontuacao.getText());
        if(pontos >= 20){
            lblPontuacao.setText(Integer.toString(pontos - 20));
        }
        vidas = Integer.parseInt(lblVidas.getText());
        if(vidas == 1){
            lblVidas.setText("0");
            JOptionPane.showMessageDialog(this, "Fim de jogo, Tente novamente !");
            this.dispose();
        }
        else{
            vidas --;
            lblVidas.setText(Integer.toString(vidas));
        }
        
    }
    
    public void CarregarInicial(){
        lblPontuacao.setText("0");
        lblNivel.setText("Easy");
        SetarFase();
        lblPergunta.setText(selecionadaPergunta[0].Questao);
        SetarPergunta();
        MisturaResposta();
        lblVidas.setText("3");
    }
    
    
    public void ProximaPergunta(){
        for(int i = 0; i <= selecionadaPergunta.length - 1; i++){
            if(lblPergunta.getText().equals(selecionadaPergunta[i].Questao)){
                lblPergunta.setText(selecionadaPergunta[i + 1].Questao);
                SetarPergunta();
                MisturaResposta();
                break;
            }
        }
    }
    
    public void MudarFase(){
        if(lblNivel.getText().equals("Easy")){
            lblNivel.setText("Medium");
        }
        else{
            lblNivel.setText("Hard");
        }
        aux = 0;
        lblVidas.setText("3");
    }
    
    public void VerificarResposta(JButton b){
        if(b.getText().equals(selecionadaPergunta[NumeroQuestao() - 1].RespostaCerta)){
            JOptionPane.showMessageDialog(this, "Resposta Correta !");
            AdicionarPontuacao();
            acertos++;
        }
        else{
            JOptionPane.showMessageDialog(this, "Resposta Errada !");
            RemoverPontuacao();
            erros++;
        }
        
        if(!lblPergunta.getText().equals(selecionadaPergunta[6].Questao)){
            ProximaPergunta();
        }
        else{
            if(lblNivel.getText().equals("Hard")){
                JOptionPane.showMessageDialog(this, "Parabéns !");
                pontos = Integer.parseInt(lblPontuacao.getText());
                Resultados r = new Resultados(acertos, erros, Integer.parseInt(lblPontuacao.getText()));
                r.setVisible(true);
                r.setLocationRelativeTo(null);
                r.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE); // Janelas independentes
                this.dispose(); // fecha a tela de jogo !
                // Fim de jogo
                // Redirecionar para uma tela com os resultados
            }
            else{
                JOptionPane.showMessageDialog(this, "Fim de fase !");
                MudarFase();
                SetarFase();     
                lblPergunta.setText(selecionadaPergunta[0].Questao);
                SetarPergunta();
                MisturaResposta();
            }
        }
        
        
        // Se resposta certa, abrir joptionpane dando ok,
        // somar pontuação e ir pra próxima pergunta
        // Se resposta errada abrir joptionpane dando erro,
        // descontar pontuação e/ou retirar uma vida e ir pra próxima pergunta
    }
   
   /*
    ESPAÇO PARA CODAR A VONTADE ! ! !
    */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumeroPergunta = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        jpPergunta = new javax.swing.JPanel();
        lblPergunta = new javax.swing.JLabel();
        btnB = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        lblPontuacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblVidas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNumeroPergunta.setText("PERGUNTA X / 7");

        lblNivel.setText("nivel");

        lblPergunta.setText("TEXTO DA PERGUNTA");

        javax.swing.GroupLayout jpPerguntaLayout = new javax.swing.GroupLayout(jpPergunta);
        jpPergunta.setLayout(jpPerguntaLayout);
        jpPerguntaLayout.setHorizontalGroup(
            jpPerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPerguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPerguntaLayout.setVerticalGroup(
            jpPerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPerguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnB.setText("B - RESPOSTA2");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnC.setText("C - RESPOSTA3");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnD.setText("D - RESPOSTA4");
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        btnA.setText("A - RESPOSTA1");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        lblPontuacao.setText("---");

        jLabel1.setText("Pontuação:");

        lblVidas.setText("vidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblVidas)
                                .addGap(42, 42, 42)
                                .addComponent(lblNivel)
                                .addGap(89, 89, 89)
                                .addComponent(lblNumeroPergunta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPontuacao)
                                .addGap(88, 88, 88))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnD)
                            .addComponent(btnC)
                            .addComponent(btnB)
                            .addComponent(btnA))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroPergunta)
                    .addComponent(lblNivel)
                    .addComponent(lblPontuacao)
                    .addComponent(jLabel1)
                    .addComponent(lblVidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnB)
                .addGap(16, 16, 16)
                .addComponent(btnC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnD)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        VerificarResposta(btnA);
    }//GEN-LAST:event_btnAActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        VerificarResposta(btnB);
    }//GEN-LAST:event_btnBActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        VerificarResposta(btnC);
    }//GEN-LAST:event_btnCActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        VerificarResposta(btnD);
    }//GEN-LAST:event_btnDActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpPergunta;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNumeroPergunta;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JLabel lblPontuacao;
    private javax.swing.JLabel lblVidas;
    // End of variables declaration//GEN-END:variables
}