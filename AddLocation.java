/*     */ package policedataapp;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import javax.swing.event.MouseInputAdapter;
/*     */ import org.jdesktop.swingx.JXMapKit;
/*     */ import org.jdesktop.swingx.mapviewer.GeoPosition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AddLocation
/*     */   extends JFrame
/*     */ {
/*     */   private int databaseid;
/*     */   private double point_lat;
/*     */   private double point_long;
/*     */   private int location_confirm;
/*     */   private JXMapKit jXMapKit1;
/*     */   private JButton reset_b;
/*     */   private JButton reset_b1;
/*     */   private JButton reset_b2;
/*     */   private JButton submit_b;
/*     */   
/*     */   public AddLocation() {
/* 169 */     this.point_lat = 0.0D;
/* 170 */     this.point_long = 0.0D;
/* 171 */     this.location_confirm = 0; initComponents(); } public AddLocation(Integer x) { this.point_lat = 0.0D; this.point_long = 0.0D; this.location_confirm = 0;
/*     */     initComponents();
/*     */     this.databaseid = x.intValue();
/*     */     this.jXMapKit1.setAddressLocation(new GeoPosition(31.562168D, 74.321956D));
/*     */     this.jXMapKit1.setAddressLocationShown(false);
/*     */     this.location_confirm = 0;
/*     */     int z = 3;
/*     */     this.jXMapKit1.setZoom(z);
/*     */     getMouseInput(); }
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 183 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 184 */         if ("Nimbus".equals(info.getName())) {
/* 185 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 189 */     } catch (ClassNotFoundException ex) {
/* 190 */       Logger.getLogger(AddLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 191 */     } catch (InstantiationException ex) {
/* 192 */       Logger.getLogger(AddLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 193 */     } catch (IllegalAccessException ex) {
/* 194 */       Logger.getLogger(AddLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 195 */     } catch (UnsupportedLookAndFeelException ex) {
/* 196 */       Logger.getLogger(AddLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 201 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 203 */             (new AddLocation()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void initComponents() {
/*     */     this.jXMapKit1 = new JXMapKit();
/*     */     this.reset_b2 = new JButton();
/*     */     this.submit_b = new JButton();
/*     */     setDefaultCloseOperation(3);
/*     */     this.jXMapKit1.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
/*     */     this.reset_b2.setText("Reset");
/*     */     this.reset_b2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             AddLocation.this.reset_b2ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     this.submit_b.setText("Submit");
/*     */     this.submit_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             AddLocation.this.submit_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     GroupLayout layout = new GroupLayout(getContentPane());
/*     */     getContentPane().setLayout(layout);
/*     */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.jXMapKit1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.reset_b2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 589, 32767).addComponent(this.submit_b, -2, 115, -2))).addContainerGap()));
/*     */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent((Component)this.jXMapKit1, -1, 444, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.submit_b).addComponent(this.reset_b2)).addContainerGap()));
/*     */     pack();
/*     */   }
/*     */   
/*     */   private void reset_b2ActionPerformed(ActionEvent evt) {
/*     */     this.jXMapKit1.setAddressLocation(new GeoPosition(31.562168D, 74.321956D));
/*     */     this.jXMapKit1.setAddressLocationShown(false);
/*     */     this.location_confirm = 0;
/*     */   }
/*     */   
/*     */   private void submit_bActionPerformed(ActionEvent evt) {
/*     */     if (this.location_confirm == 0) {
/*     */       JOptionPane.showMessageDialog(null, "No location specified.", "Warning!", 2);
/*     */     } else if (this.location_confirm == 1) {
/*     */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/*     */       EntityManager entitymanager = emf.createEntityManager();
/*     */       entitymanager.getTransaction().begin();
/*     */       CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(this.databaseid));
/*     */       cr.setLatitude(Double.valueOf(this.point_lat));
/*     */       cr.setLongitude(Double.valueOf(this.point_long));
/*     */       entitymanager.persist(cr);
/*     */       entitymanager.getTransaction().commit();
/*     */       entitymanager.close();
/*     */       emf.close();
/*     */       MainWindow mw = new MainWindow();
/*     */       mw.setVisible(true);
/*     */       dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void getMouseInput() {
/*     */     this.jXMapKit1.getMainMap().addMouseListener(new MouseInputAdapter() {
/*     */           public void mouseClicked(MouseEvent e) {
/*     */             Point2D mouse_over = e.getPoint();
/*     */             GeoPosition geoPosition = AddLocation.this.jXMapKit1.getMainMap().convertPointToGeoPosition(mouse_over);
/*     */             AddLocation.this.point_lat = geoPosition.getLatitude();
/*     */             AddLocation.this.point_long = geoPosition.getLongitude();
/*     */             AddLocation.this.jXMapKit1.setAddressLocation(new GeoPosition(AddLocation.this.point_lat, AddLocation.this.point_long));
/*     */             AddLocation.this.jXMapKit1.setAddressLocationShown(true);
/*     */             AddLocation.this.location_confirm = 1;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\AddLocation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */