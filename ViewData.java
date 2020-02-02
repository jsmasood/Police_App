/*     */ package policedataapp;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.Beans;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.UIManager;
/*     */ import org.jdesktop.beansbinding.BindingGroup;
/*     */ import org.jdesktop.beansbinding.ELProperty;
/*     */ import org.jdesktop.beansbinding.Property;
/*     */ import org.jdesktop.swingbinding.JTableBinding;
/*     */ 
/*     */ public class ViewData extends JFrame {
/*     */   private EntityManager CrimeDataVisPUEntityManager;
/*     */   
/*     */   public ViewData() {
/*  24 */     initComponents();
/*     */   }
/*     */   private JButton Delete; private JButton back_button; private List<CrimeReports2> crimeReports2List;
/*     */   private Query crimeReports2Query;
/*     */   private JTable crimereports_table;
/*     */   private JButton editloc_b;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JButton update_button;
/*     */   private BindingGroup bindingGroup;
/*     */   
/*     */   private void initComponents() {
/*  35 */     this.bindingGroup = new BindingGroup();
/*     */     
/*  37 */     this.CrimeDataVisPUEntityManager = Beans.isDesignTime() ? null : Persistence.createEntityManagerFactory("CrimeDataVisPU").createEntityManager();
/*  38 */     this.crimeReports2Query = Beans.isDesignTime() ? null : this.CrimeDataVisPUEntityManager.createQuery("SELECT c FROM CrimeReports2 c");
/*  39 */     this.crimeReports2List = Beans.isDesignTime() ? Collections.<CrimeReports2>emptyList() : this.crimeReports2Query.getResultList();
/*  40 */     this.update_button = new JButton();
/*  41 */     this.editloc_b = new JButton();
/*  42 */     this.Delete = new JButton();
/*  43 */     this.back_button = new JButton();
/*  44 */     this.jScrollPane2 = new JScrollPane();
/*  45 */     this.crimereports_table = new JTable();
/*     */     
/*  47 */     setDefaultCloseOperation(3);
/*     */     
/*  49 */     this.update_button.setText("Update Entry");
/*  50 */     this.update_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  52 */             ViewData.this.update_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  56 */     this.editloc_b.setText("Edit Location");
/*  57 */     this.editloc_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  59 */             ViewData.this.editloc_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  63 */     this.Delete.setText("Delete Entry");
/*  64 */     this.Delete.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  66 */             ViewData.this.DeleteActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  70 */     this.back_button.setText("Back to Main Menu");
/*  71 */     this.back_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  73 */             ViewData.this.back_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  77 */     this.crimereports_table.setAutoCreateRowSorter(true);
/*     */     
/*  79 */     JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.crimeReports2List, this.crimereports_table);
/*  80 */     JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${compaddress}"));
/*  81 */     columnBinding.setColumnName("Compaddress");
/*  82 */     columnBinding.setColumnClass(String.class);
/*  83 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${compfirstname}"));
/*  84 */     columnBinding.setColumnName("Compfirstname");
/*  85 */     columnBinding.setColumnClass(String.class);
/*  86 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${compsurname}"));
/*  87 */     columnBinding.setColumnName("Compsurname");
/*  88 */     columnBinding.setColumnClass(String.class);
/*  89 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${crimetype}"));
/*  90 */     columnBinding.setColumnName("Crimetype");
/*  91 */     columnBinding.setColumnClass(String.class);
/*  92 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${criminalvehicledetails}"));
/*  93 */     columnBinding.setColumnName("Criminalvehicledetails");
/*  94 */     columnBinding.setColumnClass(String.class);
/*  95 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${dateD}"));
/*  96 */     columnBinding.setColumnName("Date D");
/*  97 */     columnBinding.setColumnClass(Integer.class);
/*  98 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${dateM}"));
/*  99 */     columnBinding.setColumnName("Date M");
/* 100 */     columnBinding.setColumnClass(Integer.class);
/* 101 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${dateY}"));
/* 102 */     columnBinding.setColumnName("Date Y");
/* 103 */     columnBinding.setColumnClass(Integer.class);
/* 104 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${details}"));
/* 105 */     columnBinding.setColumnName("Details");
/* 106 */     columnBinding.setColumnClass(String.class);
/* 107 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${fir}"));
/* 108 */     columnBinding.setColumnName("Fir");
/* 109 */     columnBinding.setColumnClass(Integer.class);
/* 110 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${id}"));
/* 111 */     columnBinding.setColumnName("Id");
/* 112 */     columnBinding.setColumnClass(Integer.class);
/* 113 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${location}"));
/* 114 */     columnBinding.setColumnName("Location");
/* 115 */     columnBinding.setColumnClass(String.class);
/* 116 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${offenceno}"));
/* 117 */     columnBinding.setColumnName("Offenceno");
/* 118 */     columnBinding.setColumnClass(String.class);
/* 119 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${policestation}"));
/* 120 */     columnBinding.setColumnName("Policestation");
/* 121 */     columnBinding.setColumnClass(String.class);
/* 122 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${stolengoods}"));
/* 123 */     columnBinding.setColumnName("Stolengoods");
/* 124 */     columnBinding.setColumnClass(String.class);
/* 125 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${timeH}"));
/* 126 */     columnBinding.setColumnName("Time H");
/* 127 */     columnBinding.setColumnClass(Integer.class);
/* 128 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${timeM}"));
/* 129 */     columnBinding.setColumnName("Time M");
/* 130 */     columnBinding.setColumnClass(Integer.class);
/* 131 */     columnBinding = jTableBinding.addColumnBinding((Property)ELProperty.create("${weapons}"));
/* 132 */     columnBinding.setColumnName("Weapons");
/* 133 */     columnBinding.setColumnClass(String.class);
/* 134 */     this.bindingGroup.addBinding((Binding)jTableBinding);
/* 135 */     jTableBinding.bind();
/* 136 */     this.jScrollPane2.setViewportView(this.crimereports_table);
/*     */     
/* 138 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 139 */     getContentPane().setLayout(layout);
/* 140 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2).addGroup(layout.createSequentialGroup().addComponent(this.update_button).addGap(18, 18, 18).addComponent(this.editloc_b).addGap(18, 18, 18).addComponent(this.Delete).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 440, 32767).addComponent(this.back_button))).addContainerGap()));
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
/* 156 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 432, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.update_button).addComponent(this.editloc_b).addComponent(this.Delete).addComponent(this.back_button)).addContainerGap()));
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
/* 170 */     this.bindingGroup.bind();
/*     */     
/* 172 */     pack();
/*     */   }
/*     */ 
/*     */   
/*     */   private void update_buttonActionPerformed(ActionEvent evt) {
/* 177 */     int[] selectedrows = this.crimereports_table.getSelectedRows();
/*     */     
/* 179 */     if (selectedrows.length == 0) {
/* 180 */       JOptionPane.showMessageDialog(null, "No selection detected.", "Error", 0);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 185 */       int id = ((Integer)this.crimereports_table.getValueAt(selectedrows[0], 17)).intValue();
/* 186 */       UpdateData ud = new UpdateData(Integer.valueOf(id));
/* 187 */       ud.setVisible(true);
/* 188 */       dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void editloc_bActionPerformed(ActionEvent evt) {
/* 194 */     int[] selectedrows = this.crimereports_table.getSelectedRows();
/*     */     
/* 196 */     if (selectedrows.length == 0) {
/* 197 */       JOptionPane.showMessageDialog(null, "No selection detected.", "Error", 0);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 203 */       int id = ((Integer)this.crimereports_table.getValueAt(selectedrows[0], 17)).intValue();
/* 204 */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 205 */       EntityManager entitymanager = emf.createEntityManager();
/* 206 */       entitymanager.getTransaction().begin();
/* 207 */       CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(id));
/*     */       
/* 209 */       if (cr.getLatitude() == null || cr.getLongitude() == null) {
/*     */ 
/*     */         
/* 212 */         int reset = JOptionPane.showConfirmDialog(null, "Location not found in database. Add new location?", "Error", 0, 3);
/*     */         
/* 214 */         if (reset == 0)
/*     */         {
/* 216 */           UpdateLocation ul = new UpdateLocation(Integer.valueOf(id));
/*     */           
/* 218 */           entitymanager.getTransaction().commit();
/* 219 */           entitymanager.close();
/* 220 */           emf.close();
/*     */           
/* 222 */           ul.setExtendedState(6);
/* 223 */           ul.setVisible(true);
/* 224 */           dispose();
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 232 */         UpdateLocation ul = new UpdateLocation(Integer.valueOf(id));
/*     */         
/* 234 */         entitymanager.getTransaction().commit();
/* 235 */         entitymanager.close();
/* 236 */         emf.close();
/*     */         
/* 238 */         ul.setExtendedState(6);
/* 239 */         ul.setVisible(true);
/* 240 */         dispose();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void DeleteActionPerformed(ActionEvent evt) {
/* 248 */     int[] selectedrows = this.crimereports_table.getSelectedRows();
/*     */ 
/*     */     
/* 251 */     if (selectedrows.length == 0) {
/* 252 */       JOptionPane.showMessageDialog(null, "No selection detected.", "Error", 0);
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 259 */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 260 */       EntityManager entitymanager = emf.createEntityManager();
/* 261 */       entitymanager.getTransaction().begin();
/*     */       
/* 263 */       for (int index = 0; index < selectedrows.length; index++) {
/*     */         
/* 265 */         int id = ((Integer)this.crimereports_table.getValueAt(selectedrows[index], 17)).intValue();
/* 266 */         CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(id));
/*     */         
/* 268 */         entitymanager.remove(cr);
/*     */ 
/*     */         
/* 271 */         this.crimereports_table.repaint();
/*     */       } 
/*     */       
/* 274 */       entitymanager.getTransaction().commit();
/* 275 */       entitymanager.close();
/* 276 */       emf.close();
/*     */ 
/*     */       
/* 279 */       MainWindow mw = new MainWindow();
/* 280 */       mw.setVisible(true);
/* 281 */       dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void back_buttonActionPerformed(ActionEvent evt) {
/* 287 */     MainWindow mw = new MainWindow();
/* 288 */     mw.setVisible(true);
/* 289 */     dispose();
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
/* 302 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 303 */         if ("Nimbus".equals(info.getName())) {
/* 304 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 308 */     } catch (ClassNotFoundException ex) {
/* 309 */       Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 310 */     } catch (InstantiationException ex) {
/* 311 */       Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 312 */     } catch (IllegalAccessException ex) {
/* 313 */       Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 314 */     } catch (UnsupportedLookAndFeelException ex) {
/* 315 */       Logger.getLogger(ViewData.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 320 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 322 */             (new ViewData()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\ViewData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */