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
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.border.Border;


public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    Integer ID;
    
    public void getID(Integer a){
        ID = a;
        JoinedDisplay(ID);
        CreatedDisplay(ID);
        ExploreGroup(ID);
        Events(ID);
    }
    
    public void JoinedDisplay(Integer A){
        int i=0;
        Connection conn; String sql1;
        PreparedStatement ps;
        ResultSet rs,rs1;
        int CountRow=0;
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black,1);
        try{
            int j=10,k=10;
            
             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system" ,"18062");
             sql1 = "select J.Grp_ID,G.Name" +
                    " from Users U,Joins J,Groups G" +
                    " where U.ID=J.User_ID" +
                    " and G.ID=J.Grp_ID" +
                    " and U.ID='"+A+"'";
             ps = conn.prepareStatement(sql1);
             rs = ps.executeQuery();
            
                    while (rs.next()) {
                      CountRow++;
                    }
      
             rs1 = ps.executeQuery();
            JLabel l[] = new JLabel[CountRow];
            JLabel label[] = new JLabel[10];
            
             while(rs1.next())
            {
                l[i] = new JLabel();
                l[i].setBorder(blackline);
                l[i].setBounds(j,k,100,80);
   
                    
               label[1] =  new JLabel();
               l[i].setName(Integer.toString(rs1.getInt(1)));
               label[1].setText( rs1.getString(2)); 

                label[1].setBounds(2,0,200,20);

                 l[i].add(label[1]);
               
                
                l[i].addMouseListener(new MouseAdapter()   {   
                        
                      @Override
                      public void mouseClicked(MouseEvent e)   
                         {   
                             Component c = e.getComponent();
                             GroupDescription D = new GroupDescription();
                             D.getID(c.getName(),ID);
                             D.setVisible(true);
                             dispose();
                         } 
                      
                });
                
                jPanel6.add(l[i]);
                i+=1;
                j+=105;
                //System.out.println(i+"  main");
            }
          conn.close();
        }catch(Exception e){System.out.println(e);}
    }
    
     public void CreatedDisplay(Integer A){
         int i=0;
        Connection conn; String sql1;
        PreparedStatement ps;
        ResultSet rs,rs1;
        int CountRow=0;
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black,1);
        try{
            int j=10,k=10;
            
             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system" ,"18062");
             sql1 = "select Name,ID" +
                    " from Groups" +
                    " where CRTR_ID='"+A+"'";
             ps = conn.prepareStatement(sql1);
             rs = ps.executeQuery();
            
                    while (rs.next()) {
                      CountRow++;
                    }
                 
             rs1 = ps.executeQuery();
            JLabel l[] = new JLabel[CountRow];
            JLabel label[] = new JLabel[10];
            
             while(rs1.next())
            {
                l[i] = new JLabel();
                l[i].setBorder(blackline);
                l[i].setBounds(j,k,100,80);
   
                    
               label[1] =  new JLabel();
               l[i].setName(Integer.toString(rs1.getInt(2)));
               label[1].setText( rs1.getString(1)); 

                label[1].setBounds(2,0,200,20);

                 l[i].add(label[1]);
               
                
                l[i].addMouseListener(new MouseAdapter()   {   
                        
                      @Override
                      public void mouseClicked(MouseEvent e)   
                         {   
                             Component c = e.getComponent();
                             GroupDescription D = new GroupDescription();
                             D.getID(c.getName(),ID);
                             D.setVisible(true);
                             dispose();
                         } 
                      
                });
                
                jPanel8.add(l[i]);
                i+=1;
                j+=105;
                //System.out.println(i+"  main");
            }
          conn.close();
        }catch(Exception e){System.out.println(e);}
     }
     
     public void ExploreGroup(Integer A){
         int i=0;
        Connection conn; String sql1;
        PreparedStatement ps;
        ResultSet rs,rs1;
        int CountRow=0;
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black,1);
        try{
            int j=240,k=10;
            
             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system" ,"18062");
             sql1 = "SELECT Name,Description,Location,ID FROM Groups Where ID NOT IN (SELECT G.ID FROM Groups G,Joins J Where J.User_ID = '"+A+"' and J.Grp_ID = G.ID) and CRTR_ID NOT IN '"+A+"' ";
             ps = conn.prepareStatement(sql1);
             rs = ps.executeQuery();
            
                    while (rs.next()) {
                      CountRow++;
                    }
                    
             rs1 = ps.executeQuery();
            JLabel l[] = new JLabel[CountRow];
            JLabel label[] = new JLabel[10];
            
             while(rs1.next())
            {
                l[i] = new JLabel();
                l[i].setBorder(blackline);
                l[i].setBounds(j,k,500,80);
   
                    
               label[1] =  new JLabel();
               label[2] =  new JLabel();
               label[3] =  new JLabel();
               l[i].setName(Integer.toString(rs1.getInt(4)));
               label[1].setText( rs1.getString(1)); 
               label[2].setText(rs1.getString(2));
               label[3].setText(rs1.getString(3));

               label[1].setBounds(200,0,200,20);
               label[2].setBounds(200,25,200,20);
               label[3].setBounds(200,50,200,20);

               l[i].add(label[1]);
               l[i].add(label[2]);
               l[i].add(label[3]); 
                
                l[i].addMouseListener(new MouseAdapter()   {   
                        
                      @Override
                      public void mouseClicked(MouseEvent e)   
                         {   
                             Component c = e.getComponent();
                             GroupDescription D = new GroupDescription();
                             D.getID(c.getName(),ID);
                             D.setVisible(true);
                             dispose();
                         } 
                      
                });
                
                jPanel7.add(l[i]);
                i+=1;
                k+=85;
                //System.out.println(i+"  main");
            }
          conn.close();
        }catch(Exception e){System.out.println(e);}
     }
     
     public void Events(Integer A){
        int i=0;
        Connection conn; String sql1;
        PreparedStatement ps;
        ResultSet rs,rs1;
        int CountRow=0;
        Date D;
        String Tim;
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black,1);
        try{
            int j=240,k=10;
            
             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system" ,"18062");
             sql1 = "SELECT E.Name,E.Place,E.Dat,E.Time" +
"                    from Events E,Participates P" +
"                    where E.ID = P.Event_ID" +
"                    and P.User_ID='"+A+"'";
             ps = conn.prepareStatement(sql1);
             rs = ps.executeQuery();
            
                    while (rs.next()) {
                      CountRow++;
                    }
                    
             rs1 = ps.executeQuery();
            JLabel l[] = new JLabel[CountRow];
            JLabel label[] = new JLabel[10];
            
             while(rs1.next())
            {
                l[i] = new JLabel();
                l[i].setBorder(blackline);
                l[i].setBounds(j,k,500,80);
   
                    
               label[1] =  new JLabel();
               label[2] =  new JLabel();
               label[3] =  new JLabel();
               D = rs1.getDate(3);
               Tim = D.toString();
               Tim += " ( ";
               Tim += rs1.getString(4);
               Tim += " )";
               label[3].setText(Tim);
               label[1].setText( rs1.getString(1)); 
               label[2].setText(rs1.getString(2));
               label[3].setText(Tim);

               label[1].setBounds(180,0,200,20);
               label[2].setBounds(180,25,200,20);
               label[3].setBounds(180,50,200,20);

               l[i].add(label[1]);
               l[i].add(label[2]);
               l[i].add(label[3]); 
                
                jPanel12.add(l[i]);
                i+=1;
                k+=85;
                //System.out.println(i+"  main");
            }
          conn.close();
        }catch(Exception e){System.out.println(e);}
     }
     
    public MainPage() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN PAGE");

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane1.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  GROUPS JOINED");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton1.setText("+ CREATE  GROUP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(915, 237));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("   GROUPS CREATED");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(" HOME ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" JOIN GROUPS YOU LIKE");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(10, 1000));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" EXPLORE ", jPanel2);

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   EVENTS ");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setPreferredSize(new java.awt.Dimension(10, 1000));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel12);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(515, 515, 515))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" PARTICIPATING EVENTS ", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
             Integer ID1,ID2;
             ID2 = ID;
             Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","18062");
             PreparedStatement statement = con.prepareStatement("SELECT MAX(ID) FROM Groups");
             ResultSet resultset = statement.executeQuery();
             

             while(resultset.next()){
                ID1 = resultset.getInt("MAX(ID)");
                GroupCreation G = new GroupCreation();
                G.getID(ID1,ID2);
                G.setVisible(true);
             }          
                 
            
             resultset.close();
             statement.close();
             con.close();
             
             
             
             dispose();
             
            }
         catch(Exception e){
           System.out.println(e); 
        }
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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
