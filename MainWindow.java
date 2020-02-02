/*     */ package policedataapp;
/*     */ 
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class MainWindow extends JFrame {
/*     */   private JButton addnew_b;
/*     */   
/*     */   public MainWindow() {
/*  20 */     initComponents();
/*     */   }
/*     */ 
/*     */   
/*     */   private JButton createcharts_b;
/*     */   
/*     */   private JButton exit_b;
/*     */   private JPanel jPanel1;
/*     */   private JButton viewdata_b;
/*     */   private JButton viewmap_b;
/*     */   
/*     */   private void initComponents() {
/*  32 */     this.jPanel1 = new JPanel();
/*  33 */     this.addnew_b = new JButton();
/*  34 */     this.viewdata_b = new JButton();
/*  35 */     this.createcharts_b = new JButton();
/*  36 */     this.viewmap_b = new JButton();
/*  37 */     this.exit_b = new JButton();
/*     */     
/*  39 */     setDefaultCloseOperation(3);
/*     */     
/*  41 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  43 */     this.addnew_b.setText("Add New Record");
/*  44 */     this.addnew_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  46 */             MainWindow.this.addnew_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  50 */     this.viewdata_b.setText("View Data");
/*  51 */     this.viewdata_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  53 */             MainWindow.this.viewdata_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  57 */     this.createcharts_b.setText("Create Charts");
/*  58 */     this.createcharts_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  60 */             MainWindow.this.createcharts_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  64 */     this.viewmap_b.setText("View Map");
/*  65 */     this.viewmap_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  67 */             MainWindow.this.viewmap_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  71 */     this.exit_b.setText("Exit");
/*  72 */     this.exit_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  74 */             MainWindow.this.exit_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  78 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  79 */     this.jPanel1.setLayout(jPanel1Layout);
/*  80 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(90, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.createcharts_b, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.viewdata_b, -1, -1, 32767).addComponent(this.addnew_b, -1, -1, 32767)).addComponent(this.exit_b, -1, -1, 32767).addComponent(this.viewmap_b, -1, -1, 32767)).addGap(87, 87, 87)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(55, 55, 55).addComponent(this.addnew_b).addGap(18, 18, 18).addComponent(this.viewdata_b).addGap(18, 18, 18).addComponent(this.createcharts_b).addGap(18, 18, 18).addComponent(this.viewmap_b).addGap(18, 18, 18).addComponent(this.exit_b).addContainerGap(89, 32767)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 110 */     getContentPane().setLayout(layout);
/* 111 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     pack();
/*     */   }
/*     */ 
/*     */   
/*     */   private void addnew_bActionPerformed(ActionEvent evt) {
/* 131 */     AddReport ar = new AddReport();
/* 132 */     ar.setVisible(true);
/* 133 */     dispose();
/*     */   }
/*     */   
/*     */   private void viewdata_bActionPerformed(ActionEvent evt) {
/* 137 */     ViewData vd = new ViewData();
/* 138 */     vd.setVisible(true);
/* 139 */     vd.setExtendedState(6);
/* 140 */     dispose();
/*     */   }
/*     */   
/*     */   private void createcharts_bActionPerformed(ActionEvent evt) {
/* 144 */     CreateChart cc = new CreateChart();
/* 145 */     cc.setVisible(true);
/* 146 */     dispose();
/*     */   }
/*     */   
/*     */   private void viewmap_bActionPerformed(ActionEvent evt) {
/* 150 */     ViewMap vm = new ViewMap();
/* 151 */     vm.setVisible(true);
/* 152 */     vm.setExtendedState(6);
/* 153 */     dispose();
/*     */   }
/*     */   
/*     */   private void exit_bActionPerformed(ActionEvent evt) {
/* 157 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 170 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 171 */         if ("Nimbus".equals(info.getName())) {
/* 172 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 176 */     } catch (ClassNotFoundException ex) {
/* 177 */       Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 178 */     } catch (InstantiationException ex) {
/* 179 */       Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 180 */     } catch (IllegalAccessException ex) {
/* 181 */       Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 182 */     } catch (UnsupportedLookAndFeelException ex) {
/* 183 */       Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 188 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 190 */             (new MainWindow()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\MainWindow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */