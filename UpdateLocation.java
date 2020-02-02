/*     */ package policedataapp;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
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
/*     */ public class UpdateLocation
/*     */   extends JFrame
/*     */ {
/*     */   private int databaseid;
/*     */   private double point_lat;
/*     */   private double point_long;
/*     */   private double default_lat;
/*     */   private double default_long;
/*     */   private int location_confirm;
/*     */   private JButton exit_b;
/*     */   private JXMapKit jXMapKit1;
/*     */   private JButton reset_b;
/*     */   private JButton submit_b;
/*     */   
/*     */   public UpdateLocation() {
/* 150 */     this.point_lat = 0.0D;
/* 151 */     this.point_long = 0.0D;
/* 152 */     this.default_lat = 0.0D;
/* 153 */     this.default_long = 0.0D;
/* 154 */     this.location_confirm = 0; initComponents(); } public UpdateLocation(Integer x) { this.point_lat = 0.0D; this.point_long = 0.0D; this.default_lat = 0.0D; this.default_long = 0.0D; this.location_confirm = 0; initComponents(); this.databaseid = x.intValue(); EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU"); EntityManager entitymanager = emf.createEntityManager(); entitymanager.getTransaction().begin(); CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(this.databaseid)); if (cr.getLatitude() == null || cr.getLongitude() == null) { this.jXMapKit1.setAddressLocation(new GeoPosition(31.562168D, 74.321956D)); this.jXMapKit1.setAddressLocationShown(false); int z = 3; this.jXMapKit1.setZoom(z); this.location_confirm = 0; getMouseInput(); }
/*     */     else
/*     */     { this.point_lat = cr.getLatitude().doubleValue(); this.point_long = cr.getLongitude().doubleValue(); this.default_lat = cr.getLatitude().doubleValue(); this.default_long = cr.getLongitude().doubleValue(); this.jXMapKit1.setAddressLocation(new GeoPosition(this.point_lat, this.point_long)); this.jXMapKit1.setAddressLocationShown(true); int z = 3; this.jXMapKit1.setZoom(z); this.location_confirm = 0; getMouseInput(); }
/* 157 */      } private void getMouseInput() { this.jXMapKit1.getMainMap().addMouseListener(new MouseInputAdapter()
/*     */         {
/*     */ 
/*     */           
/*     */           public void mouseClicked(MouseEvent e)
/*     */           {
/* 163 */             Point2D mouse_over = e.getPoint();
/*     */ 
/*     */             
/* 166 */             GeoPosition geoPosition = UpdateLocation.this.jXMapKit1.getMainMap().convertPointToGeoPosition(mouse_over);
/*     */             
/* 168 */             UpdateLocation.this.point_lat = geoPosition.getLatitude();
/* 169 */             UpdateLocation.this.point_long = geoPosition.getLongitude();
/*     */             
/* 171 */             UpdateLocation.this.jXMapKit1.setAddressLocation(new GeoPosition(UpdateLocation.this.point_lat, UpdateLocation.this.point_long));
/* 172 */             UpdateLocation.this.jXMapKit1.setAddressLocationShown(true);
/* 173 */             UpdateLocation.this.location_confirm = 1;
/*     */           }
/*     */         }); } private void initComponents() { this.jXMapKit1 = new JXMapKit(); this.reset_b = new JButton(); this.exit_b = new JButton(); this.submit_b = new JButton(); setDefaultCloseOperation(3); setPreferredSize(new Dimension(800, 450)); this.jXMapKit1.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps); this.reset_b.setText("Reset"); this.reset_b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { UpdateLocation.this.reset_bActionPerformed(evt); } }
/*     */       ); this.exit_b.setText("Exit without saving changes"); this.exit_b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { UpdateLocation.this.exit_bActionPerformed(evt); } }
/*     */       ); this.submit_b.setText("Submit"); this.submit_b.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { UpdateLocation.this.submit_bActionPerformed(evt); } }
/*     */       ); GroupLayout layout = new GroupLayout(getContentPane()); getContentPane().setLayout(layout); layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent((Component)this.jXMapKit1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.reset_b).addGap(18, 18, 18).addComponent(this.exit_b).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 419, 32767).addComponent(this.submit_b, -2, 115, -2))).addContainerGap()));
/*     */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent((Component)this.jXMapKit1, -1, 394, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.submit_b).addComponent(this.reset_b).addComponent(this.exit_b)).addContainerGap()));
/*     */     pack(); } private void reset_bActionPerformed(ActionEvent evt) { this.jXMapKit1.setAddressLocation(new GeoPosition(this.default_lat, this.default_long));
/*     */     this.jXMapKit1.setAddressLocationShown(false);
/* 182 */     this.location_confirm = 0; } private void exit_bActionPerformed(ActionEvent evt) { ViewData vd = new ViewData();
/* 183 */     vd.setVisible(true);
/* 184 */     vd.setExtendedState(6);
/* 185 */     dispose(); }
/*     */ 
/*     */ 
/*     */   
/*     */   private void submit_bActionPerformed(ActionEvent evt) {
/* 190 */     if (this.location_confirm == 0) {
/*     */       
/* 192 */       JOptionPane.showMessageDialog(null, "Location not updated.", "Warning!", 2);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 197 */     else if (this.location_confirm == 1) {
/*     */ 
/*     */       
/* 200 */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 201 */       EntityManager entitymanager = emf.createEntityManager();
/* 202 */       entitymanager.getTransaction().begin();
/* 203 */       CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(this.databaseid));
/*     */ 
/*     */       
/* 206 */       cr.setLatitude(Double.valueOf(this.point_lat));
/* 207 */       cr.setLongitude(Double.valueOf(this.point_long));
/*     */ 
/*     */       
/* 210 */       entitymanager.persist(cr);
/* 211 */       entitymanager.getTransaction().commit();
/* 212 */       entitymanager.close();
/* 213 */       emf.close();
/*     */ 
/*     */       
/* 216 */       MainWindow mw = new MainWindow();
/* 217 */       mw.setVisible(true);
/* 218 */       dispose();
/*     */     } 
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
/* 232 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 233 */         if ("Nimbus".equals(info.getName())) {
/* 234 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 238 */     } catch (ClassNotFoundException ex) {
/* 239 */       Logger.getLogger(UpdateLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 240 */     } catch (InstantiationException ex) {
/* 241 */       Logger.getLogger(UpdateLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 242 */     } catch (IllegalAccessException ex) {
/* 243 */       Logger.getLogger(UpdateLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 244 */     } catch (UnsupportedLookAndFeelException ex) {
/* 245 */       Logger.getLogger(UpdateLocation.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 250 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 252 */             (new UpdateLocation()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\UpdateLocation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */