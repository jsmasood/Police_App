/*     */ package policedataapp;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Hashtable;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.persistence.Query;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import org.jdesktop.beansbinding.AutoBinding;
/*     */ import org.jdesktop.beansbinding.BeanProperty;
/*     */ import org.jdesktop.beansbinding.Binding;
/*     */ import org.jdesktop.beansbinding.BindingGroup;
/*     */ import org.jdesktop.beansbinding.Bindings;
/*     */ import org.jdesktop.beansbinding.ELProperty;
/*     */ import org.jdesktop.beansbinding.Property;
/*     */ import org.jdesktop.swingx.JXMapKit;
/*     */ import org.jdesktop.swingx.JXMapViewer;
/*     */ import org.jdesktop.swingx.mapviewer.GeoPosition;
/*     */ import org.jdesktop.swingx.mapviewer.Waypoint;
/*     */ import org.jdesktop.swingx.mapviewer.WaypointPainter;
/*     */ import org.jdesktop.swingx.painter.CompoundPainter;
/*     */ import org.jdesktop.swingx.painter.Painter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ViewMap
/*     */   extends JFrame
/*     */ {
/*     */   int count;
/*     */   private Set<Waypoint> waypoints;
/*     */   private JButton back_b;
/*     */   private JCheckBox crimetype_check;
/*     */   private JComboBox crimetype_in;
/*     */   private JLabel crimetype_l;
/*     */   private JCheckBox date_check;
/*     */   private JSpinner date_in;
/*     */   private JLabel date_l;
/*     */   private JButton filter_b;
/*     */   private JLabel filter_l;
/*     */   private JSpinner hour1_in;
/*     */   private JSpinner hour2_in;
/*     */   private JPanel jPanel1;
/*     */   private JXMapKit jXMapKit1;
/*     */   private JCheckBox month_check;
/*     */   private JSpinner month_in;
/*     */   private JCheckBox policestation_check;
/*     */   private JComboBox policestation_in;
/*     */   private JLabel ps_label;
/*     */   private JCheckBox time_check;
/*     */   private JLabel time_l;
/*     */   private JLabel to_label;
/*     */   private JCheckBox weapon_check;
/*     */   private JComboBox weapons_in;
/*     */   private JLabel weapons_l;
/*     */   private JCheckBox year_check;
/*     */   private JSpinner year_in;
/*     */   private BindingGroup bindingGroup;
/*     */   
/*     */   public ViewMap() {
/* 539 */     this.count = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 563 */     this.waypoints = new HashSet<>();
/*     */     initComponents();
/*     */     this.jXMapKit1.setAddressLocation(new GeoPosition(31.562168D, 74.321956D));
/*     */     this.jXMapKit1.setAddressLocationShown(false);
/*     */     int z = 3;
/*     */     this.jXMapKit1.setZoom(z);
/*     */     getCrimeSpots();
/*     */     drawPoints();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 575 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 576 */         if ("Nimbus".equals(info.getName())) {
/* 577 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 581 */     } catch (ClassNotFoundException ex) {
/* 582 */       Logger.getLogger(ViewMap.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 583 */     } catch (InstantiationException ex) {
/* 584 */       Logger.getLogger(ViewMap.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 585 */     } catch (IllegalAccessException ex) {
/* 586 */       Logger.getLogger(ViewMap.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 587 */     } catch (UnsupportedLookAndFeelException ex) {
/* 588 */       Logger.getLogger(ViewMap.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 593 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 595 */             (new ViewMap()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*     */     this.bindingGroup = new BindingGroup();
/*     */     this.jPanel1 = new JPanel();
/*     */     this.ps_label = new JLabel();
/*     */     this.policestation_in = new JComboBox();
/*     */     this.date_in = new JSpinner();
/*     */     this.time_l = new JLabel();
/*     */     this.crimetype_in = new JComboBox();
/*     */     this.hour1_in = new JSpinner();
/*     */     this.hour2_in = new JSpinner();
/*     */     this.filter_b = new JButton();
/*     */     this.month_in = new JSpinner();
/*     */     this.crimetype_l = new JLabel();
/*     */     this.back_b = new JButton();
/*     */     this.date_l = new JLabel();
/*     */     this.year_in = new JSpinner();
/*     */     this.date_check = new JCheckBox();
/*     */     this.crimetype_check = new JCheckBox();
/*     */     this.policestation_check = new JCheckBox();
/*     */     this.filter_l = new JLabel();
/*     */     this.month_check = new JCheckBox();
/*     */     this.year_check = new JCheckBox();
/*     */     this.to_label = new JLabel();
/*     */     this.time_check = new JCheckBox();
/*     */     this.weapons_in = new JComboBox();
/*     */     this.weapons_l = new JLabel();
/*     */     this.weapon_check = new JCheckBox();
/*     */     this.jXMapKit1 = new JXMapKit();
/*     */     setDefaultCloseOperation(3);
/*     */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     this.ps_label.setText("Police Station:");
/*     */     this.policestation_in.setModel(new DefaultComboBoxModel<>(new String[] { 
/*     */             "Muslim Town", "Wahdat Colony", "Iqbal Town", "Gulshan Iqbal", "Samanabad", "Millat Park", "Gulshan-e-Ravi", "Sanda", "Nawan Kot", "Shera Kot", 
/*     */             "Raiwand City", "Police Post Jia Bagga", "Manga Mandi", "Police Post Adda Sundar", "Chung", "Satto Katla", "Sabzazar", "Hanjarwal", "Town Ship", "Johar Town", 
/*     */             "Green Town", "Defence Area A", "Defence Area B", "Factory Area", "Sarwar Road", "Police Post Air Port", "South Cantt", "North Cantt", "Police Post Guldisht Town", "Mustafa Abad", 
/*     */             "Ghazi Abad", "Barki", "Police Post Hair", "Hadiara", "Police Post Minhala", "Baghbanpura", "Harbance Pura", "Manawan", "Bata Pur", "Police Post Wagha", 
/*     */             "Model Town", "Liaqat Abad", "Naseerabad", "Police Post Firdous Market", "Garden Town", "Police Post Raja Market", "Faisal Town", "Ichhra", "Shadman", "Gulberg", 
/*     */             "Ghalib Market", "Police Post Main Market", "Kahna", "Police Post Sua Assal", "Kot Lakhpat", "Police Post Rakh Chandrai", "Nishter Colony", "Islampura", "New Anarkali", "Lower Mall", 
/*     */             "Bhatti Gate", "Tibbi City", "Masti Gate", "Yakki Gate", "Rang Mehal", "Lohari Gate", "Naulakha", "Akbari Gate", "Gowalmandi", "Mochi Gate", 
/*     */             "Shahdara", "Shahdara Town", "Shafiq Abad", "Ravi Road", "Badamibagh", "Lorry Adda", "Missri Shah", "Shadbagh", "Race Course", "Civil Lines", 
/*     */             "Qilla Gujjar Singh", "Garhi Shahu", "Old Anarkali", "Lytton Road", "Mozang", "Shalimar", "Gujjar Pura", " Mughalpura", "Women Police Station Race Course" }));
/*     */     AutoBinding autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.policestation_check, (Property)ELProperty.create("${selected}"), this.policestation_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.date_in.setModel(new SpinnerNumberModel(1, 1, 31, 1));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.date_check, (Property)ELProperty.create("${selected}"), this.date_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.time_l.setText("Time Range (HH to HH)");
/*     */     this.crimetype_in.setModel(new DefaultComboBoxModel<>(new String[] { 
/*     */             "Robbery", "Burglary", "Motor Vehicle Theft", "Motor Vehicle Snatching", "Murder", "Attempted Murder", "Injury", "Kidnapping/Abduction", "Kidnapping/Ransom", "Rape", 
/*     */             "Gang-rape" }));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.crimetype_check, (Property)ELProperty.create("${selected}"), this.crimetype_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.hour1_in.setModel(new SpinnerNumberModel(0, 0, 23, 1));
/*     */     this.hour1_in.setEditor(new JSpinner.NumberEditor(this.hour1_in, "00"));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.time_check, (Property)ELProperty.create("${selected}"), this.hour1_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.hour2_in.setModel(new SpinnerNumberModel(0, 0, 23, 1));
/*     */     this.hour2_in.setEditor(new JSpinner.NumberEditor(this.hour2_in, "00"));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.time_check, (Property)ELProperty.create("${selected}"), this.hour2_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.filter_b.setText("Filter");
/*     */     this.filter_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             ViewMap.this.filter_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.month_in.setModel(new SpinnerNumberModel(1, 1, 12, 1));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.month_check, (Property)ELProperty.create("${selected}"), this.month_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.crimetype_l.setText("Crime Type:");
/*     */     this.back_b.setText("Back to Main Menu");
/*     */     this.back_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             ViewMap.this.back_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.date_l.setText("Date (DD:MM:YYYY)");
/*     */     this.year_in.setModel(new SpinnerNumberModel(2015, 2000, 2020, 1));
/*     */     this.year_in.setEditor(new JSpinner.NumberEditor(this.year_in, "0000"));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.year_check, (Property)ELProperty.create("${selected}"), this.year_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.date_check.setText("Date");
/*     */     this.date_check.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             ViewMap.this.date_checkActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.crimetype_check.setText("Crime Type");
/*     */     this.policestation_check.setText("Police Station");
/*     */     this.filter_l.setText("Filter by:");
/*     */     this.month_check.setText("Month");
/*     */     this.year_check.setText("Year");
/*     */     this.year_check.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             ViewMap.this.year_checkActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.to_label.setText("to");
/*     */     this.time_check.setText("Time");
/*     */     this.time_check.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             ViewMap.this.time_checkActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.weapons_in.setModel(new DefaultComboBoxModel<>(new String[] { "No weapons", "Personal Weapons (Hands, Fists, Feet, etc)", "Knife/Blade", "Small Firearms", "Automatic", "Explosives" }));
/*     */     autoBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.weapon_check, (Property)ELProperty.create("${selected}"), this.weapons_in, (Property)BeanProperty.create("enabled"));
/*     */     this.bindingGroup.addBinding((Binding)autoBinding);
/*     */     this.weapons_l.setText("Weapons");
/*     */     this.weapon_check.setText("Weapons");
/*     */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*     */     this.jPanel1.setLayout(jPanel1Layout);
/*     */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ps_label).addComponent(this.crimetype_l)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.crimetype_in, 0, -1, 32767).addComponent(this.policestation_in, 0, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.date_l, -1, -1, 32767).addComponent(this.time_l, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.date_in, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.month_in, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.hour1_in, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.to_label))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.year_in, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.filter_l)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.hour2_in, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.weapons_l))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.policestation_check).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.date_check)).addComponent(this.weapons_in, -2, 140, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.year_check).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.crimetype_check).addGap(18, 18, 18).addComponent(this.time_check).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.filter_b, -2, 121, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.month_check).addGap(18, 18, 18).addComponent(this.weapon_check).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.back_b))).addContainerGap()));
/*     */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ps_label).addComponent(this.policestation_in, -2, -1, -2).addComponent(this.date_l).addComponent(this.date_in, -2, -1, -2).addComponent(this.month_in, -2, -1, -2).addComponent(this.year_in, -2, -1, -2).addComponent(this.filter_b).addComponent(this.policestation_check).addComponent(this.filter_l).addComponent(this.date_check).addComponent(this.year_check).addComponent(this.crimetype_check).addComponent(this.time_check)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.back_b).addComponent(this.hour2_in, -2, -1, -2).addComponent(this.hour1_in, -2, -1, -2).addComponent(this.time_l).addComponent(this.crimetype_in, -2, -1, -2).addComponent(this.crimetype_l).addComponent(this.to_label).addComponent(this.month_check).addComponent(this.weapons_l).addComponent(this.weapons_in, -2, -1, -2).addComponent(this.weapon_check)).addContainerGap(-1, 32767)));
/*     */     this.jXMapKit1.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
/*     */     GroupLayout layout = new GroupLayout(getContentPane());
/*     */     getContentPane().setLayout(layout);
/*     */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent((Component)this.jXMapKit1, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent((Component)this.jXMapKit1, -1, 178, 32767).addGap(17, 17, 17).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
/*     */     this.bindingGroup.bind();
/*     */     pack();
/*     */   }
/*     */   
/*     */   private void drawPoints() {
/*     */     WaypointPainter painter = new WaypointPainter();
/*     */     painter.setWaypoints(this.waypoints);
/*     */     Painter<JXMapViewer> textOverlay = new Painter<JXMapViewer>() {
/*     */         public void paint(Graphics2D g, JXMapViewer map, int w, int h) {
/*     */           g.setPaint(new Color(0, 0, 0, 100));
/*     */           g.fillRoundRect(10, 10, 300, 30, 15, 15);
/*     */           g.setPaint(Color.YELLOW);
/*     */           g.setFont(new Font("Verdana", 0, 16));
/*     */           g.drawString("Number of crimes displayed:" + ViewMap.this.count, 25, 30);
/*     */         }
/*     */       };
/*     */     CompoundPainter cp = new CompoundPainter();
/*     */     cp.setPainters(new Painter[] { textOverlay, (Painter)painter });
/*     */     cp.setCacheable(false);
/*     */     this.jXMapKit1.getMainMap().setOverlayPainter((Painter)cp);
/*     */   }
/*     */   
/*     */   private void filter_bActionPerformed(ActionEvent evt) {
/*     */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/*     */     EntityManager entitymanager = emf.createEntityManager();
/*     */     int ps_id = this.policestation_in.getSelectedIndex() + 1;
/*     */     String police_station = (String)this.policestation_in.getSelectedItem();
/*     */     String crime_type = (String)this.crimetype_in.getSelectedItem();
/*     */     String weapon = (String)this.weapons_in.getSelectedItem();
/*     */     int date = ((Integer)this.date_in.getValue()).intValue();
/*     */     int month = ((Integer)this.month_in.getValue()).intValue();
/*     */     int year = ((Integer)this.year_in.getValue()).intValue();
/*     */     int hour1 = ((Integer)this.hour1_in.getValue()).intValue();
/*     */     int hour2 = ((Integer)this.hour2_in.getValue()).intValue() + 1;
/*     */     this.waypoints.clear();
/*     */     this.jXMapKit1.repaint();
/*     */     boolean[] array_ischecked = new boolean[7];
/*     */     ArrayList<Integer> ischecked_chosen = new ArrayList();
/*     */     Hashtable<Object, Object> parameters = new Hashtable<>();
/*     */     array_ischecked[0] = this.policestation_check.isSelected();
/*     */     array_ischecked[1] = this.crimetype_check.isSelected();
/*     */     array_ischecked[2] = this.date_check.isSelected();
/*     */     array_ischecked[3] = this.month_check.isSelected();
/*     */     array_ischecked[4] = this.year_check.isSelected();
/*     */     array_ischecked[5] = this.weapon_check.isSelected();
/*     */     array_ischecked[6] = this.time_check.isSelected();
/*     */     String start = "SELECT c FROM CrimeReports2 c WHERE";
/*     */     StringBuilder builder = new StringBuilder(start);
/*     */     String and = "AND";
/*     */     String between = "BETWEEN";
/*     */     String q_object = null;
/*     */     String q_value = null;
/*     */     String q_value2 = null;
/*     */     String p_object = null;
/*     */     String p_object2 = null;
/*     */     Object p_value = null;
/*     */     Object p_value2 = null;
/*     */     String q_add = null;
/*     */     String q_add2 = null;
/*     */     for (int index = 0; index < array_ischecked.length; index++) {
/*     */       if (array_ischecked[index] == true)
/*     */         ischecked_chosen.add(Integer.valueOf(index)); 
/*     */     } 
/*     */     if (ischecked_chosen.isEmpty()) {
/*     */       Query query0 = entitymanager.createNamedQuery("CrimeReports2.findAll");
/*     */       List<CrimeReports2> list0 = query0.getResultList();
/*     */       this.count = 0;
/*     */       for (CrimeReports2 cr : list0) {
/*     */         try {
/*     */           this.waypoints.add(new Waypoint(cr.getLatitude().doubleValue(), cr.getLongitude().doubleValue()));
/*     */           this.count++;
/*     */         } catch (NullPointerException e) {
/*     */           System.out.println(e);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       for (int index_al = 0; index_al < ischecked_chosen.size(); index_al++) {
/*     */         int index_value = ((Integer)ischecked_chosen.get(index_al)).intValue();
/*     */         switch (index_value) {
/*     */           case 0:
/*     */             q_object = "c.policestationid";
/*     */             q_value = ":policestationid";
/*     */             p_object = "policestationid";
/*     */             p_value = Integer.valueOf(ps_id);
/*     */             break;
/*     */           case 1:
/*     */             q_object = "c.crimetype";
/*     */             q_value = ":crimetype";
/*     */             p_object = "crimetype";
/*     */             p_value = crime_type;
/*     */             break;
/*     */           case 2:
/*     */             q_object = "c.dateD";
/*     */             q_value = ":dateD";
/*     */             p_object = "dateD";
/*     */             p_value = Integer.valueOf(date);
/*     */             break;
/*     */           case 3:
/*     */             q_object = "c.dateM";
/*     */             q_value = ":dateM";
/*     */             p_object = "dateM";
/*     */             p_value = Integer.valueOf(month);
/*     */             break;
/*     */           case 4:
/*     */             q_object = "c.dateY";
/*     */             q_value = ":dateY";
/*     */             p_object = "dateY";
/*     */             p_value = Integer.valueOf(year);
/*     */             break;
/*     */           case 5:
/*     */             q_object = "c.weapons";
/*     */             q_value = ":weapons";
/*     */             p_object = "weapons";
/*     */             p_value = weapon;
/*     */             break;
/*     */           case 6:
/*     */             q_object = "c.timeH";
/*     */             q_value = ":hour1";
/*     */             q_value2 = ":hour2";
/*     */             p_object = "hour1";
/*     */             p_object2 = "hour2";
/*     */             p_value = Integer.valueOf(hour1);
/*     */             p_value2 = Integer.valueOf(hour2);
/*     */             break;
/*     */         } 
/*     */         if (index_al == 0) {
/*     */           if (index_value == 6) {
/*     */             q_add = " " + q_object + " " + between + " " + q_value + " " + and + " " + q_value2 + " ";
/*     */             parameters.put(p_object, p_value);
/*     */             parameters.put(p_object2, p_value2);
/*     */           } else {
/*     */             q_add = " " + q_object + " = " + q_value + " ";
/*     */             parameters.put(p_object, p_value);
/*     */           } 
/*     */         } else if (index_value == 6) {
/*     */           q_add = " " + and + " " + q_object + " " + between + " " + q_value + " " + and + " " + q_value2 + " ";
/*     */           parameters.put(p_object, p_value);
/*     */           parameters.put(p_object2, p_value2);
/*     */         } else {
/*     */           q_add = " " + and + " " + q_object + " = " + q_value + " ";
/*     */           parameters.put(p_object, p_value);
/*     */         } 
/*     */         builder.append(q_add);
/*     */       } 
/*     */       Query query = entitymanager.createQuery(builder.toString());
/*     */       Enumeration<String> p_keys = parameters.keys();
/*     */       while (p_keys.hasMoreElements()) {
/*     */         String str = p_keys.nextElement();
/*     */         query.setParameter(str, parameters.get(str));
/*     */       } 
/*     */       List<CrimeReports2> list = query.getResultList();
/*     */       this.count = 0;
/*     */       for (CrimeReports2 cr : list) {
/*     */         try {
/*     */           this.waypoints.add(new Waypoint(cr.getLatitude().doubleValue(), cr.getLongitude().doubleValue()));
/*     */           this.count++;
/*     */         } catch (NullPointerException e) {
/*     */           System.out.println(e);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     if (this.waypoints.isEmpty() == true)
/*     */       JOptionPane.showMessageDialog(null, "No crime activities matched your criteria.", "Note", 1); 
/*     */     drawPoints();
/*     */   }
/*     */   
/*     */   private void back_bActionPerformed(ActionEvent evt) {
/*     */     MainWindow mw = new MainWindow();
/*     */     mw.setVisible(true);
/*     */     dispose();
/*     */   }
/*     */   
/*     */   private void date_checkActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void year_checkActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void time_checkActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void getCrimeSpots() {
/*     */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/*     */     EntityManager entitymanager = emf.createEntityManager();
/*     */     Query query = entitymanager.createNamedQuery("CrimeReports2.findAll");
/*     */     List<CrimeReports2> list = query.getResultList();
/*     */     for (CrimeReports2 cr : list) {
/*     */       try {
/*     */         this.waypoints.add(new Waypoint(cr.getLatitude().doubleValue(), cr.getLongitude().doubleValue()));
/*     */         this.count++;
/*     */       } catch (NullPointerException e) {
/*     */         System.out.println(e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\ViewMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */