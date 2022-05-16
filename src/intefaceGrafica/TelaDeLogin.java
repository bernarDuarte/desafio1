package intefaceGrafica;

import admModel.Adm;
import static admView.View.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import usuarioModel.Usuario;
import static usuarioView.View.*;
public class TelaDeLogin extends javax.swing.JFrame {

    
   
    public TelaDeLogin() {
        initComponents();
        
        labelPai.setVisible(false);
        textoPai.setVisible(false);
        enviarEmail.setVisible(false);
        labelMae.setVisible(false);
        textoMae.setVisible(false);
        labelCpf.setVisible(false);
        textoCpf.setVisible(false);
        textoLogin2.setVisible(false);
        labelLogin.setVisible(false);
        labelIncorreto.setVisible(false);
        labelSenhaLogin.setVisible(false);
    }
   
    
    public boolean encontraUsuario() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(abrirSistemaUsuario(caixaLogin.getText(),caixaSenha.getText())==true){
            return true;
        }else{
            return false;
        }
    }
    public String encontraClientes(String pai,String mae,String cpf,String login) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String outPut=abrirSistemaUsuario(pai,mae,cpf,login);
        
        if(outPut =="Bem vindo !!"){
            Usuario usuario = new Usuario();
            usuario = pegaUsuarioController(login);
            TelaPrincipal telaPrincipal = new TelaPrincipal(usuario.getId(),"Usuario");
            telaPrincipal.setVisible(true);
            TelaDeLogin.this.setVisible(false);
        }else{
            outPut = abrirSistemaAdm(pai,mae,cpf,login);
            if(outPut =="Bem vindo !!"){
                Adm adm = new Adm();
                adm = pegaAdmController(login);
                TelaPrincipal telaPrincipal = new TelaPrincipal(adm.getId(),"Administrador");
                telaPrincipal.setVisible(true);
                TelaDeLogin.this.setVisible(false);
            }
        }
        labelIncorreto.setVisible(true);
        return "";
    }
    public boolean encontraAdm() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(abrirSistemaAdm(caixaLogin.getText(),caixaSenha.getText())==true){
            return true;
        }else{
            return false;
        }
    }
    public void abreTelaUsuario() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Usuario usuario = pegaUsuarioController(caixaLogin.getText());
        TelaPrincipal telaPrincipal = new TelaPrincipal(usuario.getId(),"Usuario");
        telaPrincipal.setVisible(true);
        TelaDeLogin.this.setVisible(false);
    }
    public void abreTelaAdm() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        Adm adm = pegaAdmController(caixaLogin.getText());
        TelaPrincipal telaPrincipal = new TelaPrincipal(adm.getId(),"Administrador");
        telaPrincipal.setVisible(true);
        TelaDeLogin.this.setVisible(false);
    }
    public void abreTelaDeCadastro(){
        TelaDeCadastro telaDeCadastro = new TelaDeCadastro("Usuario");
        telaDeCadastro.setVisible(true);
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        caixaLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JButton();
        caixaSenha = new javax.swing.JPasswordField();
        cadastraLogin = new javax.swing.JButton();
        esqueciMinhaSenha = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        textoMae = new javax.swing.JTextField();
        textoCpf = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        textoLogin2 = new javax.swing.JTextField();
        labelPai = new javax.swing.JLabel();
        textoPai = new javax.swing.JTextField();
        enviarEmail = new javax.swing.JButton();
        labelMae = new javax.swing.JLabel();
        labelIncorreto = new javax.swing.JLabel();
        labelSenhaLogin = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        cadastraLogin.setText("Cadastre-se");
        cadastraLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraLoginActionPerformed(evt);
            }
        });

        esqueciMinhaSenha.setText("Esqueci minha senha");
        esqueciMinhaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esqueciMinhaSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(480, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(caixaLogin)
                    .addComponent(caixaSenha)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botaoEntrar)
                        .addGap(30, 30, 30)
                        .addComponent(esqueciMinhaSenha)
                        .addGap(18, 18, 18)
                        .addComponent(cadastraLogin)))
                .addGap(175, 175, 175))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(caixaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEntrar)
                    .addComponent(cadastraLogin)
                    .addComponent(esqueciMinhaSenha))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel3.setText("Desafio Saks");

        labelCpf.setText("Digite o seu Cpf");

        labelLogin.setText("Digete o login");

        labelPai.setText("Digite o do seu pai.");

        enviarEmail.setText("Enviar");
        enviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarEmailActionPerformed(evt);
            }
        });

        labelMae.setText("Digite o nome de sua mãe.");

        labelIncorreto.setText("Há informações incorretas, tente novamente.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIncorreto)
                .addGap(388, 388, 388))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCpf)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoPai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelPai))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelMae)
                                            .addComponent(textoMae, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labelLogin)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(enviarEmail)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPai)
                    .addComponent(labelMae)
                    .addComponent(labelCpf))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enviarEmail)
                .addGap(18, 18, 18)
                .addComponent(labelIncorreto)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        labelSenhaLogin.setText("Senha ou login incorretos, tente novamente.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(830, 830, 830)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(748, 748, 748)
                        .addComponent(labelSenhaLogin)))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(labelSenhaLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        try {
            if(encontraUsuario()==true){
                abreTelaUsuario();
            }else if(encontraAdm()==true){
                abreTelaAdm();
            }else{
                labelSenhaLogin.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void cadastraLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraLoginActionPerformed
            abreTelaDeCadastro();
    }//GEN-LAST:event_cadastraLoginActionPerformed

    private void esqueciMinhaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esqueciMinhaSenhaActionPerformed
        labelPai.setVisible(true);
        textoPai.setVisible(true);
        enviarEmail.setVisible(true);
        labelMae.setVisible(true);
        textoMae.setVisible(true);
        labelCpf.setVisible(true);
        textoCpf.setVisible(true);
        textoLogin2.setVisible(true);
        labelLogin.setVisible(true);
        
    }//GEN-LAST:event_esqueciMinhaSenhaActionPerformed

    private void enviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarEmailActionPerformed
        try {
            encontraClientes(textoPai.getText(),textoMae.getText(),textoCpf.getText(),textoLogin2.getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_enviarEmailActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton cadastraLogin;
    private javax.swing.JTextField caixaLogin;
    private javax.swing.JPasswordField caixaSenha;
    private javax.swing.JButton enviarEmail;
    private javax.swing.JButton esqueciMinhaSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelIncorreto;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelMae;
    private javax.swing.JLabel labelPai;
    private javax.swing.JLabel labelSenhaLogin;
    private javax.swing.JTextField textoCpf;
    private javax.swing.JTextField textoLogin2;
    private javax.swing.JTextField textoMae;
    private javax.swing.JTextField textoPai;
    // End of variables declaration//GEN-END:variables
}
