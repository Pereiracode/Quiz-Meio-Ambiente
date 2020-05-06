package views;

import data.Data;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.ImageIcon;
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
        this.getContentPane().setBackground(new Color(50,205,50));
        ImageIcon icon = new ImageIcon("src/imagens/vidas.png");
        icon.setImage(icon.getImage().getScaledInstance(lblVidas.getWidth(), lblVidas.getHeight(), 1));
        lblVidas.setIcon(icon);
        ImageIcon icon1 = new ImageIcon("src/imagens/pontos.png");
        icon1.setImage(icon1.getImage().getScaledInstance(lblPontos.getWidth(), lblPontos.getHeight(), 1));
        lblPontos.setIcon(icon1);
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
            this.getContentPane().setBackground(new Color(255,215,0));
        }
        else{
            lblNivel.setText("Hard");
            this.getContentPane().setBackground(new Color(255,69,0));
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
        lblPontos = new javax.swing.JLabel();
        lblVidas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNivel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNumeroPergunta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNumeroPergunta.setText("PERGUNTA X / 7");

        lblNivel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNivel.setText("---");

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

        lblVidas.setText("vidas");

        lblNivel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblNivel1.setText("Nível:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jpPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblVidas)
                            .addGap(166, 166, 166)
                            .addComponent(lblNumeroPergunta)
                            .addGap(174, 174, 174)
                            .addComponent(lblNivel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblNivel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPontuacao)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnD)
                            .addComponent(btnC)
                            .addComponent(btnB)
                            .addComponent(btnA))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPontuacao)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblPontos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroPergunta)
                            .addComponent(lblNivel)
                            .addComponent(lblVidas)
                            .addComponent(lblNivel1))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jpPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnB)
                .addGap(16, 16, 16)
                .addComponent(btnC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnD)
                .addGap(20, 20, 20))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpPergunta;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNivel1;
    private javax.swing.JLabel lblNumeroPergunta;
    private javax.swing.JLabel lblPergunta;
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lblPontuacao;
    private javax.swing.JLabel lblVidas;
    // End of variables declaration//GEN-END:variables
}