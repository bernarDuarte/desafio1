package intefaceGrafica;

import admModel.Adm;
import static admView.View.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import usuarioModel.Usuario;
import static usuarioView.View.*;
import static encryptPass.EncryptPass.*;
import static intefaceGrafica.AcessoCadastroAdm.*;
import intefaceGrafica.TelaPrincipal;

public class MeuPerfil extends javax.swing.JFrame {

    TelaDeLogin telaDeLogin = null;
    int idAdministrador = 1;
    public MeuPerfil(int id, String tipoDeUsuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        initComponents();
        
        if(tipoDeUsuario=="Usuario"){
            Usuario user = new Usuario();
            user = pegaUsuarioController(id).get(0);
            campoFuncao.setVisible(false);
            labelFuncao.setVisible(false);
            campoId.setText(String.valueOf(user.getId()));
            campoNome.setText(user.getNome());
            campoLogin.setText(user.getLogin());
            campoEndereco.setText(user.getEndereco());
            campoIdade.setText(String.valueOf(user.getIdade()));
            campoCpf.setText(user.getCpf());
            campoNome_pai.setText(user.getNome_pai());
            campoNome_mae.setText(user.getNome_mae());
            campoEmail.setText(user.getEmail());
            tipoUsuario.setVisible(false);
            tipoUsuario.setText("Usuario");
        }else{
            Adm user = new Adm();
            user = pegaAdmController(id).get(0);
            
            campoId.setText(String.valueOf(user.getId()));
            campoNome.setText(user.getNome());
            campoLogin.setText(user.getLogin());
            campoEndereco.setText(user.getEndereco());
            campoIdade.setText(String.valueOf(user.getIdade()));
            campoCpf.setText(user.getCpf());
            campoNome_pai.setText(user.getNome_pai());
            campoNome_mae.setText(user.getNome_mae());
            campoFuncao.setText(user.getFuncao());
            campoEmail.setText(user.getEmail());
            tipoUsuario.setVisible(false);
            tipoUsuario.setText("Adm");
        }
    }
    public MeuPerfil(int id, String tipoDeUsuario, int idAdm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        initComponents();
        System.out.println("idAdm: " + idAdm);
        idAdministrador =idAdm;
        System.out.println("idAdministrador: "+idAdministrador);
        
        
        
        if(tipoDeUsuario=="Usuario"){
            Usuario user = new Usuario();
            user = pegaUsuarioController(id).get(0);
            campoFuncao.setVisible(false);
            labelFuncao.setVisible(false);
            campoId.setText(String.valueOf(user.getId()));
            campoNome.setText(user.getNome());
            campoLogin.setText(user.getLogin());
            campoEndereco.setText(user.getEndereco());
            campoIdade.setText(String.valueOf(user.getIdade()));
            campoCpf.setText(user.getCpf());
            campoNome_pai.setText(user.getNome_pai());
            campoNome_mae.setText(user.getNome_mae());
            campoEmail.setText(user.getEmail());
            tipoUsuario.setVisible(false);
            tipoUsuario.setText("Adm");
        }else{
            Adm user = new Adm();
            user = pegaAdmController(id).get(0);
            
            campoId.setText(String.valueOf(user.getId()));
            campoNome.setText(user.getNome());
            campoLogin.setText(user.getLogin());
            campoEndereco.setText(user.getEndereco());
            campoIdade.setText(String.valueOf(user.getIdade()));
            campoCpf.setText(user.getCpf());
            campoNome_pai.setText(user.getNome_pai());
            campoNome_mae.setText(user.getNome_mae());
            campoFuncao.setText(user.getFuncao());
            campoEmail.setText(user.getEmail());
            tipoUsuario.setVisible(false);
            tipoUsuario.setText("Adm");
        }
    }
    
    
    
    public void alteraCadastro() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        String outPut ="";
        if(labelFuncao.isVisible()==false){
            outPut = enviaCadastroAlteradoControllerUsuario(campoNome.getText(),Integer.valueOf(campoId.getText()),campoLogin.getText(),campoSenha.getText(),campoEndereco.getText(),Integer.valueOf(campoIdade.getText()),campoCpf.getText(),campoNome_pai.getText(),campoNome_mae.getText(),campoEmail.getText(),textoConfimaSenha.getText());
            JOptionPane.showMessageDialog(null,outPut);
        }else{
            outPut =enviaCadastroAlteradoControllerAdm(campoFuncao.getText(),Integer.valueOf(campoId.getText()),campoNome.getText(),campoLogin.getText(),campoSenha.getText(),campoEndereco.getText(),Integer.valueOf(campoIdade.getText()),campoCpf.getText(),campoNome_pai.getText(),campoNome_mae.getText(),campoEmail.getText(),textoConfimaSenha.getText());
            JOptionPane.showMessageDialog(null,outPut);
        }
    }
    
    
    
    public void inativaCadastro() throws SQLException, ClassNotFoundException{
        String outPut ="";
        if(labelFuncao.isVisible()==false){
            outPut = inativaIdUsuarioEnviada(Integer.valueOf(campoId.getText()));
            JOptionPane.showMessageDialog(null,outPut);
            System.out.println(tipoUsuario.getText());
            if("Usuario".equals(tipoUsuario.getText())){
                MeuPerfil.this.setVisible(false);
                TelaDeLogin telaDeLogin = new TelaDeLogin();
                telaDeLogin.setVisible(true);
            }
        }else{
            outPut = inativaIdAdmEnviada(Integer.valueOf(campoId.getText()));
            if(campoId.getText().equals(String.valueOf(idAdministrador))){
                JOptionPane.showMessageDialog(null,outPut);
                this.setVisible(false);
                telaDeLogin = new TelaDeLogin();
                telaDeLogin.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,outPut);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        campoId = new javax.swing.JTextField();
        campoNome_pai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoIdade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoEndereco = new javax.swing.JTextField();
        alteraCadastro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        inativaCadastro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoCpf = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labelFuncao = new javax.swing.JLabel();
        campoNome_mae = new javax.swing.JTextField();
        campoFuncao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        textoConfimaSenha = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        tipoUsuario = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        campoId.setEditable(false);

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        jLabel4.setText("Endereco");

        jLabel9.setText("Altere seu cadastro como quiser!");

        alteraCadastro.setText("Alterar");
        alteraCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraCadastroActionPerformed(evt);
            }
        });

        jLabel5.setText("Idade");

        inativaCadastro.setText("Inativar usuario");
        inativaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativaCadastroActionPerformed(evt);
            }
        });

        jLabel6.setText("Cpf");

        jLabel7.setText("Nome Da Mãe");

        labelFuncao.setText("Função");

        jLabel8.setText("Nome do Pai");

        jLabel1.setText("Nome");

        jLabel10.setText("Confirma senha");

        jLabel11.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)
                        .addComponent(jLabel9)
                        .addGap(160, 160, 160)
                        .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(298, 298, 298)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(campoNome)
                                                .addComponent(campoIdade)
                                                .addComponent(campoNome_mae)
                                                .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                                            .addComponent(textoConfimaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                            .addComponent(campoEndereco)
                                            .addComponent(campoLogin)
                                            .addComponent(campoNome_pai)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(campoFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(alteraCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(inativaCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(labelFuncao)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoConfimaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoNome_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome_mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(labelFuncao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alteraCadastro)
                    .addComponent(inativaCadastro))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alteraCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraCadastroActionPerformed
        try {
            alteraCadastro();
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException ex) {
            Logger.getLogger(MeuPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alteraCadastroActionPerformed

    private void inativaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativaCadastroActionPerformed
        try {
            inativaCadastro();
        } catch (SQLException ex) {
            Logger.getLogger(MeuPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MeuPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inativaCadastroActionPerformed
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MeuPerfil().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteraCadastro;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoFuncao;
    private javax.swing.JTextField campoId;
    private javax.swing.JFormattedTextField campoIdade;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNome_mae;
    private javax.swing.JTextField campoNome_pai;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JButton inativaCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelFuncao;
    private javax.swing.JPasswordField textoConfimaSenha;
    private javax.swing.JTextField tipoUsuario;
    // End of variables declaration//GEN-END:variables
}
