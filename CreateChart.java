/*     */ package policedataapp;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.EntityManagerFactory;
/*     */ import javax.persistence.Persistence;
/*     */ import javax.persistence.Query;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
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
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
/*     */ 
/*     */ public class CreateChart extends JFrame {
/*     */   int c1index;
/*     */   boolean chartcreated;
/*     */   JFreeChart barChart;
/*     */   private JButton back_b;
/*     */   
/*     */   public CreateChart() {
/*  44 */     this.c1index = 0;
/*  45 */     this.chartcreated = false;
/*     */     initComponents();
/*     */     ComboListener cl1 = new ComboListener(this.charttype_in);
/*     */     this.charttype_in.addItemListener(cl1);
/*     */   }
/*     */   private JComboBox charttype_in; private JLabel charttype_l; private JButton create_b; private JLabel date_l1; private JButton export_b; private JSpinner hour1_in1; private JSpinner hour2_in1; private JPanel jPanel1; private JPanel jPanel2;
/*     */   private JSpinner month_in1;
/*     */   private JLabel time_l1;
/*     */   private JLabel to_l;
/*     */   private JSpinner year_in1;
/*     */   
/*     */   private void initComponents() {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.charttype_l = new JLabel();
/*  59 */     this.charttype_in = new JComboBox();
/*  60 */     this.date_l1 = new JLabel();
/*  61 */     this.month_in1 = new JSpinner();
/*  62 */     this.year_in1 = new JSpinner();
/*  63 */     this.time_l1 = new JLabel();
/*  64 */     this.hour1_in1 = new JSpinner();
/*  65 */     this.hour2_in1 = new JSpinner();
/*  66 */     this.create_b = new JButton();
/*  67 */     this.back_b = new JButton();
/*  68 */     this.to_l = new JLabel();
/*  69 */     this.export_b = new JButton();
/*  70 */     this.jPanel2 = new JPanel();
/*     */     
/*  72 */     setDefaultCloseOperation(3);
/*     */     
/*  74 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*     */     
/*  76 */     this.charttype_l.setText("Chart Type:");
/*     */     
/*  78 */     this.charttype_in.setModel(new DefaultComboBoxModel<>(new String[] { "No Selection", "--ALL CRIMES--", "By Year", "By Month", "By Crime Type", "By Police Divison", "By Weapons", "--MONTH--", "Type of crimes during period (M)", "Crimes by Police Divison during period (M)", "Types of weapons used in crimes (M)", "--YEAR--", "Type of crimes during period (Y)", "Crimes by Police Divison during period (Y)", "Types of weapons used in crimes (Y)", "--TIME--", "Type of crimes during period (T)", "Crimes by Police Divison during period (T)", "Types of weapons used in crimes (T)" }));
/*     */     
/*  80 */     this.date_l1.setText("Date (MM:YYYY)");
/*     */     
/*  82 */     this.month_in1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
/*  83 */     this.month_in1.setEnabled(false);
/*     */     
/*  85 */     this.year_in1.setModel(new SpinnerNumberModel(2015, 2000, 2020, 1));
/*  86 */     this.year_in1.setEditor(new JSpinner.NumberEditor(this.year_in1, "0000"));
/*  87 */     this.year_in1.setEnabled(false);
/*     */     
/*  89 */     this.time_l1.setText("Time Range (HH to HH)");
/*     */     
/*  91 */     this.hour1_in1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
/*  92 */     this.hour1_in1.setEditor(new JSpinner.NumberEditor(this.hour1_in1, "00"));
/*  93 */     this.hour1_in1.setEnabled(false);
/*     */     
/*  95 */     this.hour2_in1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
/*  96 */     this.hour2_in1.setEditor(new JSpinner.NumberEditor(this.hour2_in1, "00"));
/*  97 */     this.hour2_in1.setEnabled(false);
/*     */     
/*  99 */     this.create_b.setText("Create Chart");
/* 100 */     this.create_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 102 */             CreateChart.this.create_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 106 */     this.back_b.setText("Back to Main Menu");
/* 107 */     this.back_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 109 */             CreateChart.this.back_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 113 */     this.to_l.setText("to");
/*     */     
/* 115 */     this.export_b.setText("Export chart as JPEG");
/* 116 */     this.export_b.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 118 */             CreateChart.this.export_bActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 122 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 123 */     this.jPanel1.setLayout(jPanel1Layout);
/* 124 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.create_b).addGap(18, 18, 18).addComponent(this.export_b).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.back_b).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.charttype_l).addGap(18, 18, 18).addComponent(this.charttype_in, -2, 300, -2).addGap(18, 18, 18).addComponent(this.date_l1, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.month_in1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.year_in1, -2, 55, -2).addGap(24, 24, 24).addComponent(this.time_l1).addGap(18, 18, 18).addComponent(this.hour1_in1, -2, 50, -2).addGap(18, 18, 18).addComponent(this.to_l).addGap(18, 18, 18).addComponent(this.hour2_in1, -2, 50, -2).addGap(0, 0, 32767)))));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.charttype_l).addComponent(this.charttype_in, -2, -1, -2).addComponent(this.date_l1).addComponent(this.month_in1, -2, -1, -2).addComponent(this.year_in1, -2, -1, -2).addComponent(this.time_l1).addComponent(this.hour1_in1, -2, -1, -2).addComponent(this.to_l).addComponent(this.hour2_in1, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.create_b).addComponent(this.back_b).addComponent(this.export_b)).addContainerGap(13, 32767)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 179 */     this.jPanel2.setLayout(new BorderLayout());
/*     */     
/* 181 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 182 */     getContentPane().setLayout(layout);
/* 183 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, 598, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     pack();
/*     */   }
/*     */ 
/*     */   
/*     */   private void create_bActionPerformed(ActionEvent evt) {
/* 207 */     this.chartcreated = true;
/*     */     
/* 209 */     if (this.charttype_in.getSelectedIndex() == 2) {
/* 210 */       chartByYear();
/* 211 */     } else if (this.charttype_in.getSelectedIndex() == 3) {
/* 212 */       chartByMonth();
/* 213 */     } else if (this.charttype_in.getSelectedIndex() == 4 || this.charttype_in.getSelectedIndex() == 8 || this.charttype_in.getSelectedIndex() == 12 || this.charttype_in.getSelectedIndex() == 16) {
/*     */       
/* 215 */       chartByCrimeType();
/* 216 */     } else if (this.charttype_in.getSelectedIndex() == 5 || this.charttype_in.getSelectedIndex() == 9 || this.charttype_in.getSelectedIndex() == 13 || this.charttype_in.getSelectedIndex() == 17) {
/*     */       
/* 218 */       chartByPoliceDiv();
/* 219 */     } else if (this.charttype_in.getSelectedIndex() == 6 || this.charttype_in.getSelectedIndex() == 10 || this.charttype_in.getSelectedIndex() == 14 || this.charttype_in.getSelectedIndex() == 18) {
/*     */       
/* 221 */       chartByWeapons();
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getExportedChartName() {
/* 226 */     return JOptionPane.showInputDialog(null, "Enter name for the chart", "Export Chart", -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void back_bActionPerformed(ActionEvent evt) {
/* 235 */     MainWindow mw = new MainWindow();
/* 236 */     mw.setVisible(true);
/* 237 */     dispose();
/*     */   }
/*     */   
/*     */   private void export_bActionPerformed(ActionEvent evt) {
/* 241 */     if (this.chartcreated = false) {
/* 242 */       JOptionPane.showMessageDialog(null, "No chart has been created yet.", "Error", 0);
/*     */ 
/*     */     
/*     */     }
/* 246 */     else if (this.chartcreated = true) {
/* 247 */       String message = getExportedChartName();
/* 248 */       if (message != null) {
/* 249 */         while (message.length() == 0 || !message.matches("^[a-zA-Z0-9_]*$")) {
/* 250 */           message = getExportedChartName();
/*     */         }
/*     */         
/* 253 */         int width = 640;
/*     */         
/* 255 */         int height = 480;
/*     */         
/* 257 */         File pieChart = new File(message + ".jpeg");
/*     */         try {
/* 259 */           ChartUtilities.saveChartAsJPEG(pieChart, this.barChart, width, height);
/* 260 */         } catch (IOException ex) {
/* 261 */           Logger.getLogger(CreateChart.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void chartByYear() {
/* 270 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 271 */     EntityManager entitymanager = emf.createEntityManager();
/*     */     
/* 273 */     Query query = entitymanager.createNamedQuery("CrimeReports2.countByDateY");
/*     */     
/* 275 */     query.setParameter("dateY", Integer.valueOf(2015));
/* 276 */     Object count = query.getSingleResult();
/* 277 */     query.setParameter("dateY", Integer.valueOf(2014));
/* 278 */     Object count2 = query.getSingleResult();
/* 279 */     query.setParameter("dateY", Integer.valueOf(2013));
/* 280 */     Object count3 = query.getSingleResult();
/*     */ 
/*     */     
/* 283 */     DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
/* 284 */     barChartData.setValue(((Long)count3).longValue(), "Number of Crimes", "2013");
/* 285 */     barChartData.setValue(((Long)count2).longValue(), "Number of Crimes", "2014");
/* 286 */     barChartData.setValue(((Long)count).longValue(), "Number of Crimes", "2015");
/*     */     
/* 288 */     this.barChart = ChartFactory.createBarChart("Number of Crimes Reported", "Annual", "Number of Crimes", (CategoryDataset)barChartData, PlotOrientation.VERTICAL, false, true, false);
/* 289 */     CategoryPlot cPlot = this.barChart.getCategoryPlot();
/* 290 */     cPlot.setRangeGridlinePaint(Color.BLUE);
/*     */     
/* 292 */     ChartPanel cp = new ChartPanel(this.barChart);
/* 293 */     this.jPanel2.removeAll();
/* 294 */     this.jPanel2.add((Component)cp, "Center");
/* 295 */     this.jPanel2.validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chartByMonth() {
/* 302 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 303 */     EntityManager entitymanager = emf.createEntityManager();
/*     */     
/* 305 */     Query query = entitymanager.createNamedQuery("CrimeReports2.countByDateM");
/*     */     
/* 307 */     query.setParameter("dateM", Integer.valueOf(12));
/* 308 */     Object count = query.getSingleResult();
/* 309 */     query.setParameter("dateM", Integer.valueOf(11));
/* 310 */     Object count2 = query.getSingleResult();
/* 311 */     query.setParameter("dateM", Integer.valueOf(10));
/* 312 */     Object count3 = query.getSingleResult();
/* 313 */     query.setParameter("dateM", Integer.valueOf(9));
/* 314 */     Object count4 = query.getSingleResult();
/* 315 */     query.setParameter("dateM", Integer.valueOf(8));
/* 316 */     Object count5 = query.getSingleResult();
/* 317 */     query.setParameter("dateM", Integer.valueOf(7));
/* 318 */     Object count6 = query.getSingleResult();
/* 319 */     query.setParameter("dateM", Integer.valueOf(6));
/* 320 */     Object count7 = query.getSingleResult();
/* 321 */     query.setParameter("dateM", Integer.valueOf(5));
/* 322 */     Object count8 = query.getSingleResult();
/* 323 */     query.setParameter("dateM", Integer.valueOf(4));
/* 324 */     Object count9 = query.getSingleResult();
/* 325 */     query.setParameter("dateM", Integer.valueOf(3));
/* 326 */     Object count10 = query.getSingleResult();
/* 327 */     query.setParameter("dateM", Integer.valueOf(2));
/* 328 */     Object count11 = query.getSingleResult();
/* 329 */     query.setParameter("dateM", Integer.valueOf(1));
/* 330 */     Object count12 = query.getSingleResult();
/*     */ 
/*     */     
/* 333 */     DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
/*     */     
/* 335 */     barChartData.setValue(((Long)count12).longValue(), "Number of Crimes", "January");
/* 336 */     barChartData.setValue(((Long)count11).longValue(), "Number of Crimes", "February");
/* 337 */     barChartData.setValue(((Long)count10).longValue(), "Number of Crimes", "March");
/* 338 */     barChartData.setValue(((Long)count9).longValue(), "Number of Crimes", "April");
/* 339 */     barChartData.setValue(((Long)count8).longValue(), "Number of Crimes", "May");
/* 340 */     barChartData.setValue(((Long)count7).longValue(), "Number of Crimes", "June");
/* 341 */     barChartData.setValue(((Long)count6).longValue(), "Number of Crimes", "July");
/* 342 */     barChartData.setValue(((Long)count5).longValue(), "Number of Crimes", "August");
/* 343 */     barChartData.setValue(((Long)count4).longValue(), "Number of Crimes", "September");
/* 344 */     barChartData.setValue(((Long)count3).longValue(), "Number of Crimes", "October");
/* 345 */     barChartData.setValue(((Long)count2).longValue(), "Number of Crimes", "November");
/* 346 */     barChartData.setValue(((Long)count).longValue(), "Number of Crimes", "December");
/*     */     
/* 348 */     this.barChart = ChartFactory.createBarChart("Number of Crimes Reported", "Annual", "Number of Crimes", (CategoryDataset)barChartData, PlotOrientation.VERTICAL, false, true, false);
/* 349 */     CategoryPlot cPlot = this.barChart.getCategoryPlot();
/* 350 */     cPlot.setRangeGridlinePaint(Color.BLUE);
/*     */     
/* 352 */     ChartPanel cp = new ChartPanel(this.barChart);
/* 353 */     this.jPanel2.removeAll();
/* 354 */     this.jPanel2.add((Component)cp, "Center");
/* 355 */     this.jPanel2.validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chartByCrimeType() {
/* 362 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 363 */     EntityManager entitymanager = emf.createEntityManager();
/*     */     
/* 365 */     Query query = null;
/* 366 */     Object count = null;
/* 367 */     Object count2 = null;
/* 368 */     Object count3 = null;
/* 369 */     Object count4 = null;
/* 370 */     Object count5 = null;
/* 371 */     Object count6 = null;
/* 372 */     Object count7 = null;
/* 373 */     Object count8 = null;
/* 374 */     Object count9 = null;
/* 375 */     Object count10 = null;
/* 376 */     Object count11 = null;
/*     */     
/* 378 */     if (this.charttype_in.getSelectedIndex() == 4) {
/*     */       
/* 380 */       query = entitymanager.createNamedQuery("CrimeReports2.countByCrimeType");
/*     */       
/* 382 */       query.setParameter("crimetype", "Robbery");
/* 383 */       count = query.getSingleResult();
/* 384 */       query.setParameter("crimetype", "Burglary");
/* 385 */       count2 = query.getSingleResult();
/* 386 */       query.setParameter("crimetype", "Motor Vehicle Theft");
/* 387 */       count3 = query.getSingleResult();
/* 388 */       query.setParameter("crimetype", "Motor Vehicle Snatching");
/* 389 */       count4 = query.getSingleResult();
/* 390 */       query.setParameter("crimetype", "Murder");
/* 391 */       count5 = query.getSingleResult();
/* 392 */       query.setParameter("crimetype", "Attempted Murder");
/* 393 */       count6 = query.getSingleResult();
/* 394 */       query.setParameter("crimetype", "Injury");
/* 395 */       count7 = query.getSingleResult();
/* 396 */       query.setParameter("crimetype", "Kidnapping/Abduction");
/* 397 */       count8 = query.getSingleResult();
/* 398 */       query.setParameter("crimetype", "Kidnapping/Ransom");
/* 399 */       count9 = query.getSingleResult();
/* 400 */       query.setParameter("crimetype", "Rape");
/* 401 */       count10 = query.getSingleResult();
/* 402 */       query.setParameter("crimetype", "Gang-rape");
/* 403 */       count11 = query.getSingleResult();
/* 404 */     } else if (this.charttype_in.getSelectedIndex() == 8) {
/*     */       
/* 406 */       int month = ((Integer)this.month_in1.getValue()).intValue();
/* 407 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/*     */       
/* 409 */       query = entitymanager.createNamedQuery("CrimeReports2.countByCrimeTypeMY");
/*     */       
/* 411 */       query.setParameter("crimetype", "Robbery");
/* 412 */       query.setParameter("dateY", Integer.valueOf(year));
/* 413 */       query.setParameter("dateM", Integer.valueOf(month));
/* 414 */       count = query.getSingleResult();
/* 415 */       query.setParameter("crimetype", "Burglary");
/* 416 */       query.setParameter("dateY", Integer.valueOf(year));
/* 417 */       query.setParameter("dateM", Integer.valueOf(month));
/* 418 */       count2 = query.getSingleResult();
/* 419 */       query.setParameter("crimetype", "Motor Vehicle Theft");
/* 420 */       query.setParameter("dateY", Integer.valueOf(year));
/* 421 */       query.setParameter("dateM", Integer.valueOf(month));
/* 422 */       count3 = query.getSingleResult();
/* 423 */       query.setParameter("crimetype", "Motor Vehicle Snatching");
/* 424 */       query.setParameter("dateY", Integer.valueOf(year));
/* 425 */       query.setParameter("dateM", Integer.valueOf(month));
/* 426 */       count4 = query.getSingleResult();
/* 427 */       query.setParameter("crimetype", "Murder");
/* 428 */       query.setParameter("dateY", Integer.valueOf(year));
/* 429 */       query.setParameter("dateM", Integer.valueOf(month));
/* 430 */       count5 = query.getSingleResult();
/* 431 */       query.setParameter("crimetype", "Attempted Murder");
/* 432 */       query.setParameter("dateY", Integer.valueOf(year));
/* 433 */       query.setParameter("dateM", Integer.valueOf(month));
/* 434 */       count6 = query.getSingleResult();
/* 435 */       query.setParameter("crimetype", "Injury");
/* 436 */       query.setParameter("dateY", Integer.valueOf(year));
/* 437 */       query.setParameter("dateM", Integer.valueOf(month));
/* 438 */       count7 = query.getSingleResult();
/* 439 */       query.setParameter("crimetype", "Kidnapping/Abduction");
/* 440 */       query.setParameter("dateY", Integer.valueOf(year));
/* 441 */       query.setParameter("dateM", Integer.valueOf(month));
/* 442 */       count8 = query.getSingleResult();
/* 443 */       query.setParameter("crimetype", "Kidnapping/Ransom");
/* 444 */       query.setParameter("dateY", Integer.valueOf(year));
/* 445 */       query.setParameter("dateM", Integer.valueOf(month));
/* 446 */       count9 = query.getSingleResult();
/* 447 */       query.setParameter("crimetype", "Rape");
/* 448 */       query.setParameter("dateY", Integer.valueOf(year));
/* 449 */       query.setParameter("dateM", Integer.valueOf(month));
/* 450 */       count10 = query.getSingleResult();
/* 451 */       query.setParameter("crimetype", "Gang-rape");
/* 452 */       query.setParameter("dateY", Integer.valueOf(year));
/* 453 */       query.setParameter("dateM", Integer.valueOf(month));
/* 454 */       count11 = query.getSingleResult();
/*     */     }
/* 456 */     else if (this.charttype_in.getSelectedIndex() == 12) {
/*     */       
/* 458 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/*     */       
/* 460 */       query = entitymanager.createNamedQuery("CrimeReports2.countByCrimeTypeY");
/*     */       
/* 462 */       query.setParameter("crimetype", "Robbery");
/* 463 */       query.setParameter("dateY", Integer.valueOf(year));
/* 464 */       count = query.getSingleResult();
/* 465 */       query.setParameter("crimetype", "Burglary");
/* 466 */       query.setParameter("dateY", Integer.valueOf(year));
/* 467 */       count2 = query.getSingleResult();
/* 468 */       query.setParameter("crimetype", "Motor Vehicle Theft");
/* 469 */       query.setParameter("dateY", Integer.valueOf(year));
/* 470 */       count3 = query.getSingleResult();
/* 471 */       query.setParameter("crimetype", "Motor Vehicle Snatching");
/* 472 */       query.setParameter("dateY", Integer.valueOf(year));
/* 473 */       count4 = query.getSingleResult();
/* 474 */       query.setParameter("crimetype", "Murder");
/* 475 */       query.setParameter("dateY", Integer.valueOf(year));
/* 476 */       count5 = query.getSingleResult();
/* 477 */       query.setParameter("crimetype", "Attempted Murder");
/* 478 */       query.setParameter("dateY", Integer.valueOf(year));
/* 479 */       count6 = query.getSingleResult();
/* 480 */       query.setParameter("crimetype", "Injury");
/* 481 */       query.setParameter("dateY", Integer.valueOf(year));
/* 482 */       count7 = query.getSingleResult();
/* 483 */       query.setParameter("crimetype", "Kidnapping/Abduction");
/* 484 */       query.setParameter("dateY", Integer.valueOf(year));
/* 485 */       count8 = query.getSingleResult();
/* 486 */       query.setParameter("crimetype", "Kidnapping/Ransom");
/* 487 */       query.setParameter("dateY", Integer.valueOf(year));
/* 488 */       count9 = query.getSingleResult();
/* 489 */       query.setParameter("crimetype", "Rape");
/* 490 */       query.setParameter("dateY", Integer.valueOf(year));
/* 491 */       count10 = query.getSingleResult();
/* 492 */       query.setParameter("crimetype", "Gang-rape");
/* 493 */       query.setParameter("dateY", Integer.valueOf(year));
/* 494 */       count11 = query.getSingleResult();
/* 495 */     } else if (this.charttype_in.getSelectedIndex() == 16) {
/*     */       
/* 497 */       int hour1 = ((Integer)this.hour1_in1.getValue()).intValue();
/* 498 */       int hour2 = ((Integer)this.hour2_in1.getValue()).intValue();
/*     */       
/* 500 */       query = entitymanager.createNamedQuery("CrimeReports2.countByCrimeTypeT");
/*     */       
/* 502 */       query.setParameter("crimetype", "Robbery");
/* 503 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 504 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 505 */       count = query.getSingleResult();
/* 506 */       query.setParameter("crimetype", "Burglary");
/* 507 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 508 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 509 */       count2 = query.getSingleResult();
/* 510 */       query.setParameter("crimetype", "Motor Vehicle Theft");
/* 511 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 512 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 513 */       count3 = query.getSingleResult();
/* 514 */       query.setParameter("crimetype", "Motor Vehicle Snatching");
/* 515 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 516 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 517 */       count4 = query.getSingleResult();
/* 518 */       query.setParameter("crimetype", "Murder");
/* 519 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 520 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 521 */       count5 = query.getSingleResult();
/* 522 */       query.setParameter("crimetype", "Attempted Murder");
/* 523 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 524 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 525 */       count6 = query.getSingleResult();
/* 526 */       query.setParameter("crimetype", "Injury");
/* 527 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 528 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 529 */       count7 = query.getSingleResult();
/* 530 */       query.setParameter("crimetype", "Kidnapping/Abduction");
/* 531 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 532 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 533 */       count8 = query.getSingleResult();
/* 534 */       query.setParameter("crimetype", "Kidnapping/Ransom");
/* 535 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 536 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 537 */       count9 = query.getSingleResult();
/* 538 */       query.setParameter("crimetype", "Rape");
/* 539 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 540 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 541 */       count10 = query.getSingleResult();
/* 542 */       query.setParameter("crimetype", "Gang-rape");
/* 543 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 544 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 545 */       count11 = query.getSingleResult();
/*     */     } 
/*     */ 
/*     */     
/* 549 */     DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
/* 550 */     barChartData.setValue(((Long)count11).longValue(), "Number of Crimes", "Gang-rape");
/* 551 */     barChartData.setValue(((Long)count10).longValue(), "Number of Crimes", "Rape");
/* 552 */     barChartData.setValue(((Long)count9).longValue(), "Number of Crimes", "Kidnapping/Ransom");
/* 553 */     barChartData.setValue(((Long)count8).longValue(), "Number of Crimes", "Kidnapping/Abduction");
/* 554 */     barChartData.setValue(((Long)count7).longValue(), "Number of Crimes", "Injury");
/* 555 */     barChartData.setValue(((Long)count6).longValue(), "Number of Crimes", "Attempted Murder");
/* 556 */     barChartData.setValue(((Long)count5).longValue(), "Number of Crimes", "Murder");
/* 557 */     barChartData.setValue(((Long)count4).longValue(), "Number of Crimes", "Motor Vehicle Snatching");
/* 558 */     barChartData.setValue(((Long)count3).longValue(), "Number of Crimes", "Motor Vehicle Theft");
/* 559 */     barChartData.setValue(((Long)count2).longValue(), "Number of Crimes", "Burglary");
/* 560 */     barChartData.setValue(((Long)count).longValue(), "Number of Crimes", "Robbery");
/*     */     
/* 562 */     this.barChart = ChartFactory.createBarChart("Number of Crimes Reported", "Annual", "Number of Crimes", (CategoryDataset)barChartData, PlotOrientation.VERTICAL, false, true, false);
/* 563 */     CategoryPlot cPlot = this.barChart.getCategoryPlot();
/* 564 */     cPlot.setRangeGridlinePaint(Color.BLUE);
/*     */ 
/*     */ 
/*     */     
/* 568 */     ChartPanel cp = new ChartPanel(this.barChart);
/* 569 */     this.jPanel2.removeAll();
/* 570 */     this.jPanel2.add((Component)cp, "Center");
/* 571 */     this.jPanel2.validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chartByPoliceDiv() {
/* 578 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 579 */     EntityManager entitymanager = emf.createEntityManager();
/*     */     
/* 581 */     Query query = null;
/* 582 */     Object count = null;
/* 583 */     Object count2 = null;
/* 584 */     Object count3 = null;
/* 585 */     Object count4 = null;
/* 586 */     Object count5 = null;
/* 587 */     Object count6 = null;
/*     */     
/* 589 */     if (this.charttype_in.getSelectedIndex() == 5) {
/*     */       
/* 591 */       query = entitymanager.createNamedQuery("CrimeReports2.countByPoliceDiv");
/* 592 */       query.setParameter("policediv", Integer.valueOf(0));
/* 593 */       count = query.getSingleResult();
/* 594 */       query.setParameter("policediv", Integer.valueOf(1));
/* 595 */       count2 = query.getSingleResult();
/* 596 */       query.setParameter("policediv", Integer.valueOf(2));
/* 597 */       count3 = query.getSingleResult();
/* 598 */       query.setParameter("policediv", Integer.valueOf(3));
/* 599 */       count4 = query.getSingleResult();
/* 600 */       query.setParameter("policediv", Integer.valueOf(4));
/* 601 */       count5 = query.getSingleResult();
/* 602 */       query.setParameter("policediv", Integer.valueOf(5));
/* 603 */       count6 = query.getSingleResult();
/* 604 */     } else if (this.charttype_in.getSelectedIndex() == 9) {
/* 605 */       int month = ((Integer)this.month_in1.getValue()).intValue();
/* 606 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/*     */       
/* 608 */       query = entitymanager.createNamedQuery("CrimeReports2.countByPoliceDivMY");
/*     */       
/* 610 */       query.setParameter("policediv", Integer.valueOf(0));
/* 611 */       query.setParameter("dateY", Integer.valueOf(year));
/* 612 */       query.setParameter("dateM", Integer.valueOf(month));
/* 613 */       count = query.getSingleResult();
/* 614 */       query.setParameter("policediv", Integer.valueOf(1));
/* 615 */       query.setParameter("dateY", Integer.valueOf(year));
/* 616 */       query.setParameter("dateM", Integer.valueOf(month));
/* 617 */       count2 = query.getSingleResult();
/* 618 */       query.setParameter("policediv", Integer.valueOf(2));
/* 619 */       query.setParameter("dateY", Integer.valueOf(year));
/* 620 */       query.setParameter("dateM", Integer.valueOf(month));
/* 621 */       count3 = query.getSingleResult();
/* 622 */       query.setParameter("policediv", Integer.valueOf(3));
/* 623 */       query.setParameter("dateY", Integer.valueOf(year));
/* 624 */       query.setParameter("dateM", Integer.valueOf(month));
/* 625 */       count4 = query.getSingleResult();
/* 626 */       query.setParameter("policediv", Integer.valueOf(4));
/* 627 */       query.setParameter("dateY", Integer.valueOf(year));
/* 628 */       query.setParameter("dateM", Integer.valueOf(month));
/* 629 */       count5 = query.getSingleResult();
/* 630 */       query.setParameter("policediv", Integer.valueOf(5));
/* 631 */       query.setParameter("dateY", Integer.valueOf(year));
/* 632 */       query.setParameter("dateM", Integer.valueOf(month));
/* 633 */       count6 = query.getSingleResult();
/*     */     }
/* 635 */     else if (this.charttype_in.getSelectedIndex() == 13) {
/*     */       
/* 637 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/*     */       
/* 639 */       query = entitymanager.createNamedQuery("CrimeReports2.countByPoliceDivY");
/* 640 */       query.setParameter("policediv", Integer.valueOf(0));
/* 641 */       query.setParameter("dateY", Integer.valueOf(year));
/* 642 */       count = query.getSingleResult();
/* 643 */       query.setParameter("policediv", Integer.valueOf(1));
/* 644 */       query.setParameter("dateY", Integer.valueOf(year));
/* 645 */       count2 = query.getSingleResult();
/* 646 */       query.setParameter("policediv", Integer.valueOf(2));
/* 647 */       query.setParameter("dateY", Integer.valueOf(year));
/* 648 */       count3 = query.getSingleResult();
/* 649 */       query.setParameter("policediv", Integer.valueOf(3));
/* 650 */       query.setParameter("dateY", Integer.valueOf(year));
/* 651 */       count4 = query.getSingleResult();
/* 652 */       query.setParameter("policediv", Integer.valueOf(4));
/* 653 */       query.setParameter("dateY", Integer.valueOf(year));
/* 654 */       count5 = query.getSingleResult();
/* 655 */       query.setParameter("policediv", Integer.valueOf(5));
/* 656 */       query.setParameter("dateY", Integer.valueOf(year));
/* 657 */       count6 = query.getSingleResult();
/* 658 */     } else if (this.charttype_in.getSelectedIndex() == 17) {
/*     */       
/* 660 */       int hour1 = ((Integer)this.hour1_in1.getValue()).intValue();
/* 661 */       int hour2 = ((Integer)this.hour2_in1.getValue()).intValue();
/*     */       
/* 663 */       query = entitymanager.createNamedQuery("CrimeReports2.countByPoliceDivT");
/* 664 */       query.setParameter("policediv", Integer.valueOf(0));
/* 665 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 666 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 667 */       count = query.getSingleResult();
/* 668 */       query.setParameter("policediv", Integer.valueOf(1));
/* 669 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 670 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 671 */       count2 = query.getSingleResult();
/* 672 */       query.setParameter("policediv", Integer.valueOf(2));
/* 673 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 674 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 675 */       count3 = query.getSingleResult();
/* 676 */       query.setParameter("policediv", Integer.valueOf(3));
/* 677 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 678 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 679 */       count4 = query.getSingleResult();
/* 680 */       query.setParameter("policediv", Integer.valueOf(4));
/* 681 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 682 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 683 */       count5 = query.getSingleResult();
/* 684 */       query.setParameter("policediv", Integer.valueOf(5));
/* 685 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 686 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 687 */       count6 = query.getSingleResult();
/*     */     } 
/*     */ 
/*     */     
/* 691 */     DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
/* 692 */     barChartData.setValue(((Long)count6).longValue(), "Number of Crimes", "Civil Lines");
/* 693 */     barChartData.setValue(((Long)count5).longValue(), "Number of Crimes", "City");
/* 694 */     barChartData.setValue(((Long)count4).longValue(), "Number of Crimes", "Model Town");
/* 695 */     barChartData.setValue(((Long)count3).longValue(), "Number of Crimes", "Cantt");
/* 696 */     barChartData.setValue(((Long)count2).longValue(), "Number of Crimes", "Sadar");
/* 697 */     barChartData.setValue(((Long)count).longValue(), "Number of Crimes", "Iqbal Town");
/*     */     
/* 699 */     this.barChart = ChartFactory.createBarChart("Number of Crimes by Division", "Annual", "Number of Crimes", (CategoryDataset)barChartData, PlotOrientation.VERTICAL, false, true, false);
/* 700 */     CategoryPlot cPlot = this.barChart.getCategoryPlot();
/* 701 */     cPlot.setRangeGridlinePaint(Color.BLUE);
/*     */     
/* 703 */     ChartPanel cp = new ChartPanel(this.barChart);
/* 704 */     this.jPanel2.removeAll();
/* 705 */     this.jPanel2.add((Component)cp, "Center");
/* 706 */     this.jPanel2.validate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void chartByWeapons() {
/* 713 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 714 */     EntityManager entitymanager = emf.createEntityManager();
/*     */     
/* 716 */     Query query = null;
/* 717 */     Object count = null;
/* 718 */     Object count2 = null;
/* 719 */     Object count3 = null;
/* 720 */     Object count4 = null;
/* 721 */     Object count5 = null;
/* 722 */     Object count6 = null;
/*     */     
/* 724 */     if (this.charttype_in.getSelectedIndex() == 6) {
/*     */       
/* 726 */       query = entitymanager.createNamedQuery("CrimeReports2.countByWeapons");
/*     */       
/* 728 */       query.setParameter("weapons", "No weapons");
/* 729 */       count = query.getSingleResult();
/* 730 */       query.setParameter("weapons", "Personal Weapons (Hands, Fists, Feet, etc)");
/* 731 */       count2 = query.getSingleResult();
/* 732 */       query.setParameter("weapons", "Knife/Blade");
/* 733 */       count3 = query.getSingleResult();
/* 734 */       query.setParameter("weapons", "Small Firearms");
/* 735 */       count4 = query.getSingleResult();
/* 736 */       query.setParameter("weapons", "Automatic");
/* 737 */       count5 = query.getSingleResult();
/* 738 */       query.setParameter("weapons", "Explosives");
/* 739 */       count6 = query.getSingleResult();
/*     */     }
/* 741 */     else if (this.charttype_in.getSelectedIndex() == 10) {
/*     */       
/* 743 */       int month = ((Integer)this.month_in1.getValue()).intValue();
/* 744 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/*     */       
/* 746 */       query = entitymanager.createNamedQuery("CrimeReports2.countByWeaponsMY");
/*     */       
/* 748 */       query.setParameter("weapons", "No weapons");
/* 749 */       query.setParameter("dateY", Integer.valueOf(year));
/* 750 */       query.setParameter("dateM", Integer.valueOf(month));
/* 751 */       count = query.getSingleResult();
/* 752 */       query.setParameter("weapons", "Personal Weapons (Hands, Fists, Feet, etc)");
/* 753 */       query.setParameter("dateY", Integer.valueOf(year));
/* 754 */       query.setParameter("dateM", Integer.valueOf(month));
/* 755 */       count2 = query.getSingleResult();
/* 756 */       query.setParameter("weapons", "Knife/Blade");
/* 757 */       query.setParameter("dateY", Integer.valueOf(year));
/* 758 */       query.setParameter("dateM", Integer.valueOf(month));
/* 759 */       count3 = query.getSingleResult();
/* 760 */       query.setParameter("weapons", "Small Firearms");
/* 761 */       query.setParameter("dateY", Integer.valueOf(year));
/* 762 */       query.setParameter("dateM", Integer.valueOf(month));
/* 763 */       count4 = query.getSingleResult();
/* 764 */       query.setParameter("weapons", "Automatic");
/* 765 */       query.setParameter("dateY", Integer.valueOf(year));
/* 766 */       query.setParameter("dateM", Integer.valueOf(month));
/* 767 */       count5 = query.getSingleResult();
/* 768 */       query.setParameter("weapons", "Explosives");
/* 769 */       query.setParameter("dateY", Integer.valueOf(year));
/* 770 */       query.setParameter("dateM", Integer.valueOf(month));
/* 771 */       count6 = query.getSingleResult();
/*     */     }
/* 773 */     else if (this.charttype_in.getSelectedIndex() == 14) {
/*     */       
/* 775 */       int year = ((Integer)this.year_in1.getValue()).intValue();
/* 776 */       query = entitymanager.createNamedQuery("CrimeReports2.countByWeaponsY");
/*     */       
/* 778 */       query.setParameter("weapons", "No weapons");
/* 779 */       query.setParameter("dateY", Integer.valueOf(year));
/* 780 */       count = query.getSingleResult();
/* 781 */       query.setParameter("weapons", "Personal Weapons (Hands, Fists, Feet, etc)");
/* 782 */       query.setParameter("dateY", Integer.valueOf(year));
/* 783 */       count2 = query.getSingleResult();
/* 784 */       query.setParameter("weapons", "Knife/Blade");
/* 785 */       query.setParameter("dateY", Integer.valueOf(year));
/* 786 */       count3 = query.getSingleResult();
/* 787 */       query.setParameter("weapons", "Small Firearms");
/* 788 */       query.setParameter("dateY", Integer.valueOf(year));
/* 789 */       count4 = query.getSingleResult();
/* 790 */       query.setParameter("weapons", "Automatic");
/* 791 */       query.setParameter("dateY", Integer.valueOf(year));
/* 792 */       count5 = query.getSingleResult();
/* 793 */       query.setParameter("weapons", "Explosives");
/* 794 */       query.setParameter("dateY", Integer.valueOf(year));
/* 795 */       count6 = query.getSingleResult();
/*     */     }
/* 797 */     else if (this.charttype_in.getSelectedIndex() == 18) {
/*     */       
/* 799 */       int hour1 = ((Integer)this.hour1_in1.getValue()).intValue();
/* 800 */       int hour2 = ((Integer)this.hour2_in1.getValue()).intValue();
/*     */       
/* 802 */       query = entitymanager.createNamedQuery("CrimeReports2.countByWeaponsT");
/*     */       
/* 804 */       query.setParameter("weapons", "No weapons");
/* 805 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 806 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 807 */       count = query.getSingleResult();
/* 808 */       query.setParameter("weapons", "Personal Weapons (Hands, Fists, Feet, etc)");
/* 809 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 810 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 811 */       count2 = query.getSingleResult();
/* 812 */       query.setParameter("weapons", "Knife/Blade");
/* 813 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 814 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 815 */       count3 = query.getSingleResult();
/* 816 */       query.setParameter("weapons", "Small Firearms");
/* 817 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 818 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 819 */       count4 = query.getSingleResult();
/* 820 */       query.setParameter("weapons", "Automatic");
/* 821 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 822 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 823 */       count5 = query.getSingleResult();
/* 824 */       query.setParameter("weapons", "Explosives");
/* 825 */       query.setParameter("hour1", Integer.valueOf(hour1));
/* 826 */       query.setParameter("hour2", Integer.valueOf(hour2));
/* 827 */       count6 = query.getSingleResult();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 832 */     DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
/* 833 */     barChartData.setValue(((Long)count6).longValue(), "Number of Crimes", "Explosives");
/* 834 */     barChartData.setValue(((Long)count5).longValue(), "Number of Crimes", "Automatic");
/* 835 */     barChartData.setValue(((Long)count4).longValue(), "Number of Crimes", "Small Firearms");
/* 836 */     barChartData.setValue(((Long)count3).longValue(), "Number of Crimes", "Knife/Blade");
/* 837 */     barChartData.setValue(((Long)count2).longValue(), "Number of Crimes", "Personal Weapons (Hands, Fists, Feet, etc)");
/* 838 */     barChartData.setValue(((Long)count).longValue(), "Number of Crimes", "No Weapons");
/*     */     
/* 840 */     this.barChart = ChartFactory.createBarChart("Number of Crimes Reported", "Annual", "Number of Crimes", (CategoryDataset)barChartData, PlotOrientation.VERTICAL, false, true, false);
/* 841 */     CategoryPlot cPlot = this.barChart.getCategoryPlot();
/* 842 */     cPlot.setRangeGridlinePaint(Color.BLUE);
/*     */     
/* 844 */     ChartPanel cp = new ChartPanel(this.barChart);
/* 845 */     this.jPanel2.removeAll();
/* 846 */     this.jPanel2.add((Component)cp, "Center");
/* 847 */     this.jPanel2.validate();
/*     */   }
/*     */   
/*     */   private class ComboListener
/*     */     implements ItemListener
/*     */   {
/*     */     private JComboBox cbox;
/* 854 */     private int cboxindex = 0;
/*     */     
/*     */     public ComboListener(JComboBox cbox) {
/* 857 */       this.cbox = cbox;
/*     */     }
/*     */ 
/*     */     
/*     */     public void itemStateChanged(ItemEvent itemEvent) {
/* 862 */       int state = itemEvent.getStateChange();
/* 863 */       if (state == 1) {
/* 864 */         this.cboxindex = this.cbox.getSelectedIndex();
/*     */         
/* 866 */         CreateChart.this.c1index = this.cboxindex;
/* 867 */         CreateChart.this.checkChartBy(CreateChart.this.c1index);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkChartBy(int x) {
/* 873 */     disableAll();
/*     */     
/* 875 */     if (x == 8 || x == 9 || x == 10) {
/* 876 */       this.month_in1.setEnabled(true);
/* 877 */       this.year_in1.setEnabled(true);
/*     */     }
/* 879 */     else if (x == 12 || x == 13 || x == 14) {
/* 880 */       this.year_in1.setEnabled(true);
/*     */     }
/* 882 */     else if (x == 16 || x == 17 || x == 18) {
/* 883 */       this.hour1_in1.setEnabled(true);
/* 884 */       this.hour2_in1.setEnabled(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void disableAll() {
/* 889 */     this.month_in1.setEnabled(false);
/* 890 */     this.year_in1.setEnabled(false);
/* 891 */     this.hour1_in1.setEnabled(false);
/* 892 */     this.hour2_in1.setEnabled(false);
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
/* 905 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 906 */         if ("Nimbus".equals(info.getName())) {
/* 907 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 911 */     } catch (ClassNotFoundException ex) {
/* 912 */       Logger.getLogger(CreateChart.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 913 */     } catch (InstantiationException ex) {
/* 914 */       Logger.getLogger(CreateChart.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 915 */     } catch (IllegalAccessException ex) {
/* 916 */       Logger.getLogger(CreateChart.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 917 */     } catch (UnsupportedLookAndFeelException ex) {
/* 918 */       Logger.getLogger(CreateChart.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 923 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 925 */             (new CreateChart()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\CreateChart.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */