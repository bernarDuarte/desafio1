package intefaceGrafica;

import admModel.Adm;
import static admView.View.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import usuarioModel.Usuario;
import static usuarioView.View.*;
import intefaceGrafica.*;
import java.security.NoSuchAlgorithmException;
import intefaceGrafica.TelaPrincipal;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class AcessoCadastroAdm extends javax.swing.JFrame {
    
    

    public AcessoCadastroAdm() throws HeadlessException {}
    
    MeuPerfil meuPerfil = null;
    int idAdm =0;
    

    
    public AcessoCadastroAdm(int id,String tipoDeUsuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        initComponents();
        idAdm=id;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioCheckBox = new javax.swing.JCheckBox();
        pesquisaCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        admCheckBox = new javax.swing.JCheckBox();

        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        usuarioCheckBox.setText("Usuarios");

        pesquisaCliente.setText("Pesquisar");
        pesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaClienteActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Usuário", "Nome", "Login", "Email", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaClientes.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tabelaClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        jLabel1.setText("Visualiza Cadastros");

        admCheckBox.setText("Administradores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(admCheckBox)
                .addGap(42, 42, 42)
                .addComponent(usuarioCheckBox)
                .addGap(546, 546, 546))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(pesquisaCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admCheckBox)
                    .addComponent(usuarioCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesquisaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel dtm = new DefaultTableModel();
//    AlteraCadastroAdm alteraCadastroAdm = null;
    
    
    public void verificaAtivo(int id) throws SQLException, ClassNotFoundException{
        Adm adm = new Adm();
        adm = (Adm) pegaAdmController(id);
        if(adm.getAtivo()==0){
            JOptionPane.showMessageDialog(null,"Usuario não esta ativo!");
            this.setVisible(false);
        }
    }
    
    public void pesquisaCadastro() throws SQLException, ClassNotFoundException{
            boolean row = true;
            dtm = (DefaultTableModel) tabelaClientes.getModel();     
            while(row){
                if(dtm.getRowCount()>=1){
                    dtm.removeRow(dtm.getRowCount()-1);
                }else{
                    row=false;
                }
            }
            if(admCheckBox.isSelected()){
               Adm adm = new Adm();
               for(Adm admin :pegaAdmController(0)){
                   Object[] dados ={"Administrador",admin.getNome(),admin.getLogin(),admin.getCpf(),admin.getId()};
                   dtm.addRow(dados);
               }
            }
            if(usuarioCheckBox.isSelected()){
                Usuario usuario = new Usuario();
                for (usuarioModel.Usuario user : pegaUsuarioController(0)) {
                    Object[] dados ={"Usuario",user.getNome(),user.getLogin(),user.getCpf(),user.getId()};
                    dtm.addRow(dados);
                }
            }
    }
    
    public void abreTelaCadastro(int id,String tipoDeUsuario,int idAdm) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(this.meuPerfil!= null){ 
            meuPerfil.setVisible(false);
        }
        meuPerfil= new MeuPerfil(id,tipoDeUsuario,idAdm);
        meuPerfil.setVisible(true);
        
    }
    public void clicaBotaoAbreCadastro(){
        ListSelectionModel model = tabelaClientes.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!model.isSelectionEmpty()){
                    int selectedRow =model.getMinSelectionIndex();
                    int idCadastro = (int) dtm.getValueAt(selectedRow, 4);
                    String tipoCadastro = (String) dtm.getValueAt(selectedRow, 0);
                    try {
                        abreTelaCadastro(idCadastro,tipoCadastro,idAdm);
                    } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException ex) {
                        java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    
                }   
            }
        });
    }
    
    private void pesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaClienteActionPerformed
       
        try {
            pesquisaCadastro();
            clicaBotaoAbreCadastro(); 
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaClienteActionPerformed
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AcessoCadastroAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AcessoCadastroAdm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox admCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pesquisaCliente;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JCheckBox usuarioCheckBox;
    // End of variables declaration//GEN-END:variables
}
