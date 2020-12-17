/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectorcl;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class AdminEventDescription extends javax.swing.JFrame {

    /**
     * Creates new form AdminEventDescription
     */
    Integer GrpID,UsrID;
    String Grp;
    public void getID(Integer a,Integer b){
        UsrID = b;
        GrpID = a;
        Grp = Integer.toString(a);
        setName();
        ExploreGroup();
    }
    
    public void setName(){
        try{
             String Name = jLabel1.getText();
             Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","18062");
             PreparedStatement statement = con.prepareStatement("SELECT Name FROM Groups WHERE ID='"+GrpID+"'");
             ResultSet resultset = statement.executeQuery();
             

             while(resultset.next()){
                Name += resultset.getString(1);
                jLabel1.setText(Name);
             }          
                 
            
             resultset.close();
             statement.close();
             con.close();
             
            }
         catch(Exception e){
           System.out.println(e); 
        }      
    }
    
    public void ExploreGroup(){
         int i=0;
        Connection conn; String sql1;
        PreparedStatement ps;
        ResultSet rs,rs1;
        int CountRow=0;
        String Tim;
        Date D;
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black,1);
        try{
            int j=210,k=10;
            
             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system" ,"18062");
             sql1 = "select Name,Place,Dat,Time,Duration,ID" +
                    " from Events" +
                    " where Grp_ID='"+GrpID+"'";
             ps = conn.prepareStatement(sql1);
             rs = ps.executeQuery();
            
                    while (rs.next()) {
                      CountRow++;
                    }
                    
             rs1 = ps.executeQuery();
            JLabel l[] = new JLabel[CountRow];
            JButton b[] = new JButton[CountRow];
            JLabel label[] = new JLabel[10];
            
             while(rs1.next())
            {
                l[i] = new JLabel();
                l[i].setBorder(blackline);
                l[i].setBounds(j,k,450,80);
                
                b[i] = new JButton();
                b[i].setText("PARTICIPANTS");
                b[i].setBounds(200,25,120,20);
   
                    
               label[1] =  new JLabel();
               label[2] =  new JLabel();
               label[3] =  new JLabel();
               b[i].setName(Integer.toString(rs1.getInt(6)));
               label[1].setText( rs1.getString(1)); 
               label[2].setText(rs1.getString(2));
               D = rs1.getDate(3);
               Tim = D.toString();
               Tim += " ( ";
               Tim += rs1.getString(4);
               Tim += " )";
               label[3].setText(Tim);
               

               label[1].setBounds(10,0,250,20);
               label[2].setBounds(10,25,250,20);
               label[3].setBounds(10,50,250,20);

               l[i].add(label[1]);
               l[i].add(label[2]);
               l[i].add(label[3]); 
               l[i].add(b[i]); 
               
               b[i].addMouseListener(new MouseAdapter()   {   
                        
                      @Override
                      public void mouseClicked(MouseEvent e)   
                         {   
                             Component c = e.getComponent();                          
                             Participants P = new Participants();
                             P.getID(c.getName(),UsrID,GrpID);
                             P.setVisible(true);
                             dispose();
                         } 
                      
                });
                
                jPanel2.add(l[i]);
                i+=1;
                k+=85;
                //System.out.println(i+"  main");
            }
          conn.close();
        }catch(Exception e){System.out.println(e);}
     }
    
    public AdminEventDescription() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(934, 464));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(823, 464));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EVENTS  OF  GROUP : ");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(823, 500));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GroupDescription G = new GroupDescription();
        G.getID(Grp,UsrID);
        G.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminEventDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEventDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEventDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEventDescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEventDescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

