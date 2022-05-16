package intefaceGrafica;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    TelaDeCadastro telaDeCadastro = null;
    MeuPerfil meuPerfil = null;
    AcessoCadastroAdm acessoCadastroAdm = null;
    
    public TelaPrincipal() {
    }
    public TelaPrincipal(int id,String tipoDeUsuario) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        initComponents();
        
        meuPerfil = new MeuPerfil(id,tipoDeUsuario);
        telaDeCadastro = new TelaDeCadastro(tipoDeUsuario);
        acessoCadastroAdm = new AcessoCadastroAdm(id,tipoDeUsuario);
        if(tipoDeUsuario=="Usuario"){
            menuCadastros.setVisible(false);
            menuTelaDeCadastro.setVisible(false);
            acessoCadastroAdm.setVisible(false);
        }
    }
    
//    public static String voltaTelaPrincipal(){
//
//        TelaPrincipal.this.setVisible(true);
//
//        return " ";
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrar = new javax.swing.JMenu();
        menuTelaDeCadastro = new javax.swing.JMenuItem();
        menuMeuPerfil = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        jPanel.setFocusTraversalPolicyProvider(true);
        jPanel.setName(""); // NOI18N

        jLabel1.setText("Olá, você esta no menu, acesse os cadastros para ser feliz!");

        jLabel2.setText("Avalie o meu trabalho para ser feliz!");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(564, 564, 564)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(662, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(680, Short.MAX_VALUE))
        );

        jMenuBar1.setMaximumSize(new java.awt.Dimension(2000, 2000));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(2000, 2000));

        jMenu2.setText("Home");
        jMenuBar1.add(jMenu2);

        menuCadastrar.setText("Usuarios");

        menuTelaDeCadastro.setText("Cadastrar");
        menuTelaDeCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTelaDeCadastroActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuTelaDeCadastro);

        menuMeuPerfil.setText("Meu Perfil");
        menuMeuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMeuPerfilActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuMeuPerfil);

        menuCadastros.setText("Cadastros");
        menuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuCadastros);

        jMenuBar1.add(menuCadastrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuTelaDeCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTelaDeCadastroActionPerformed
        telaDeCadastro.setVisible(true);
        
        
    }//GEN-LAST:event_menuTelaDeCadastroActionPerformed

    private void menuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosActionPerformed
        acessoCadastroAdm.setVisible(true);
    }//GEN-LAST:event_menuCadastrosActionPerformed

    private void menuMeuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMeuPerfilActionPerformed
        meuPerfil.setVisible(true);
    }//GEN-LAST:event_menuMeuPerfilActionPerformed
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuCadastros;
    private javax.swing.JMenuItem menuMeuPerfil;
    private javax.swing.JMenuItem menuTelaDeCadastro;
    // End of variables declaration//GEN-END:variables
}
