/*     */ package policedataapp;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class AddReport extends JFrame {
/*     */   private JButton back_button;
/*     */   private JButton clear_button;
/*     */   private JTextField compaddress_in;
/*     */   private JLabel compaddress_l;
/*     */   private JTextField compfirstname_in;
/*     */   private JLabel compfirstname_l;
/*     */   private JTextField complastname_in;
/*     */   private JLabel complastname_l;
/*     */   private JComboBox crimetype_in;
/*     */   private JLabel crimetype_l;
/*     */   private JSpinner date_in;
/*     */   private JLabel date_l;
/*     */   private JTextArea details_in;
/*     */   private JLabel details_l;
/*     */   private JTextField fir_in;
/*     */   private JLabel fir_l;
/*     */   private JSpinner hour_in;
/*     */   
/*     */   public AddReport() {
/*  25 */     initComponents();
/*     */   }
/*     */   private JScrollPane jScrollPane1; private JTextField location_in; private JLabel location_l; private JSpinner minute_in; private JSpinner month_in; private JTextField penalcharge_in; private JLabel penalcharge_l; private JComboBox policestation_in; private JLabel policestation_l; private JTextField stolengoods_in; private JLabel stolengoods_l; private JButton submit_button; private JLabel time_l; private JTextField vehicle_in; private JLabel vehicle_l; private JComboBox weapons_in; private JLabel weapons_l; private JSpinner year_in;
/*     */   
/*     */   public AddReport(Integer x) {
/*  30 */     initComponents();
/*  31 */     int id = x.intValue();
/*     */ 
/*     */     
/*  34 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/*  35 */     EntityManager entitymanager = emf.createEntityManager();
/*  36 */     entitymanager.getTransaction().begin();
/*  37 */     CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(id));
/*     */ 
/*     */     
/*  40 */     this.fir_in.setText(Integer.toString(cr.getFir().intValue()));
/*  41 */     this.compfirstname_in.setText(cr.getCompfirstname());
/*  42 */     this.complastname_in.setText(cr.getCompsurname());
/*  43 */     this.compaddress_in.setText(cr.getCompaddress());
/*  44 */     this.penalcharge_in.setText(cr.getOffenceno());
/*  45 */     this.location_in.setText(cr.getLocation());
/*  46 */     this.stolengoods_in.setText(cr.getStolengoods());
/*  47 */     this.vehicle_in.setText(cr.getCriminalvehicledetails());
/*  48 */     this.details_in.setText(cr.getDetails());
/*  49 */     int zero = 0;
/*  50 */     this.crimetype_in.setSelectedIndex(zero);
/*  51 */     this.weapons_in.setSelectedIndex(zero);
/*  52 */     this.policestation_in.setSelectedIndex(zero);
/*     */     
/*  54 */     entitymanager.getTransaction().commit();
/*  55 */     entitymanager.close();
/*  56 */     emf.close();
/*     */   }
/*     */ 
/*     */   
/*     */   private int emptyinputcheck() {
/*  61 */     int x = 0;
/*     */     
/*  63 */     if (!this.fir_in.getText().equals("") && !this.compfirstname_in.getText().equals("") && !this.complastname_in.getText().equals("") && !this.compaddress_in.getText().equals("") && !this.penalcharge_in.getText().equals("") && !this.location_in.getText().equals(""))
/*     */     {
/*     */ 
/*     */       
/*  67 */       x = 1;
/*     */     }
/*     */     
/*  70 */     return x;
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
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  84 */     this.fir_l = new JLabel();
/*  85 */     this.fir_in = new JTextField();
/*  86 */     this.crimetype_l = new JLabel();
/*  87 */     this.crimetype_in = new JComboBox();
/*  88 */     this.date_l = new JLabel();
/*  89 */     this.date_in = new JSpinner();
/*  90 */     this.month_in = new JSpinner();
/*  91 */     this.year_in = new JSpinner();
/*  92 */     this.time_l = new JLabel();
/*  93 */     this.hour_in = new JSpinner();
/*  94 */     this.minute_in = new JSpinner();
/*  95 */     this.compfirstname_l = new JLabel();
/*  96 */     this.compfirstname_in = new JTextField();
/*  97 */     this.complastname_l = new JLabel();
/*  98 */     this.complastname_in = new JTextField();
/*  99 */     this.compaddress_l = new JLabel();
/* 100 */     this.compaddress_in = new JTextField();
/* 101 */     this.penalcharge_l = new JLabel();
/* 102 */     this.penalcharge_in = new JTextField();
/* 103 */     this.policestation_l = new JLabel();
/* 104 */     this.policestation_in = new JComboBox();
/* 105 */     this.location_l = new JLabel();
/* 106 */     this.location_in = new JTextField();
/* 107 */     this.weapons_l = new JLabel();
/* 108 */     this.weapons_in = new JComboBox();
/* 109 */     this.stolengoods_l = new JLabel();
/* 110 */     this.stolengoods_in = new JTextField();
/* 111 */     this.vehicle_l = new JLabel();
/* 112 */     this.vehicle_in = new JTextField();
/* 113 */     this.details_l = new JLabel();
/* 114 */     this.jScrollPane1 = new JScrollPane();
/* 115 */     this.details_in = new JTextArea();
/* 116 */     this.submit_button = new JButton();
/* 117 */     this.clear_button = new JButton();
/* 118 */     this.back_button = new JButton();
/*     */     
/* 120 */     setDefaultCloseOperation(3);
/*     */     
/* 122 */     this.fir_l.setText("FIR No.");
/*     */     
/* 124 */     this.fir_in.setDocument(new JTextFieldLimit(10));
/* 125 */     this.fir_in.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 127 */             AddReport.this.fir_inActionPerformed(evt);
/*     */           }
/*     */         });
/* 130 */     this.fir_in.addKeyListener(new KeyAdapter() {
/*     */           public void keyTyped(KeyEvent evt) {
/* 132 */             AddReport.this.fir_inKeyTyped(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.crimetype_l.setText("Crime Type");
/*     */     
/* 138 */     this.crimetype_in.setModel(new DefaultComboBoxModel<>(new String[] { "Robbery", "Burglary", "Motor Vehicle Theft", "Motor Vehicle Snatching", "Murder", "Attempted Murder", "Injury", "Kidnapping/Abduction", "Kidnapping/Ransom", "Rape", "Gang-rape" }));
/*     */     
/* 140 */     this.date_l.setText("Date (DD:MM:YYYY)");
/*     */     
/* 142 */     this.date_in.setModel(new SpinnerNumberModel(1, 1, 31, 1));
/*     */     
/* 144 */     this.month_in.setModel(new SpinnerNumberModel(1, 1, 12, 1));
/*     */     
/* 146 */     this.year_in.setModel(new SpinnerNumberModel(2015, 2000, 2020, 1));
/* 147 */     this.year_in.setEditor(new JSpinner.NumberEditor(this.year_in, "0000"));
/*     */     
/* 149 */     this.time_l.setText("Time (HH:MM)");
/*     */     
/* 151 */     this.hour_in.setModel(new SpinnerNumberModel(1, 0, 23, 1));
/*     */     
/* 153 */     this.minute_in.setModel(new SpinnerNumberModel(1, 1, 59, 1));
/*     */     
/* 155 */     this.compfirstname_l.setText("Complainant First Name");
/*     */     
/* 157 */     this.compfirstname_in.setDocument(new JTextFieldLimit(100));
/*     */     
/* 159 */     this.complastname_l.setText("Complainant Last Name");
/*     */     
/* 161 */     this.complastname_in.setDocument(new JTextFieldLimit(150));
/*     */     
/* 163 */     this.compaddress_l.setText("Complainant Address");
/*     */     
/* 165 */     this.compaddress_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 167 */     this.penalcharge_l.setText("Penal Code Charge");
/*     */     
/* 169 */     this.penalcharge_in.setDocument(new JTextFieldLimit(50));
/*     */     
/* 171 */     this.policestation_l.setText("Police Station");
/*     */     
/* 173 */     this.policestation_in.setModel(new DefaultComboBoxModel<>(new String[] { "Muslim Town", "Wahdat Colony", "Iqbal Town", "Gulshan Iqbal", "Samanabad", "Millat Park", "Gulshan-e-Ravi", "Sanda", "Nawan Kot", "Shera Kot", "Raiwand City", "Police Post Jia Bagga", "Manga Mandi", "Police Post Adda Sundar", "Chung", "Satto Katla", "Sabzazar", "Hanjarwal", "Town Ship", "Johar Town", "Green Town", "Defence Area A", "Defence Area B", "Factory Area", "Sarwar Road", "Police Post Air Port", "South Cantt", "North Cantt", "Police Post Guldisht Town", "Mustafa Abad", "Ghazi Abad", "Barki", "Police Post Hair", "Hadiara", "Police Post Minhala", "Baghbanpura", "Harbance Pura", "Manawan", "Bata Pur", "Police Post Wagha", "Model Town", "Liaqat Abad", "Naseerabad", "Police Post Firdous Market", "Garden Town", "Police Post Raja Market", "Faisal Town", "Ichhra", "Shadman", "Gulberg", "Ghalib Market", "Police Post Main Market", "Kahna", "Police Post Sua Assal", "Kot Lakhpat", "Police Post Rakh Chandrai", "Nishter Colony", "Islampura", "New Anarkali", "Lower Mall", "Bhatti Gate", "Tibbi City", "Masti Gate", "Yakki Gate", "Rang Mehal", "Lohari Gate", "Naulakha", "Akbari Gate", "Gowalmandi", "Mochi Gate", "Shahdara", "Shahdara Town", "Shafiq Abad", "Ravi Road", "Badamibagh", "Lorry Adda", "Missri Shah", "Shadbagh", "Race Course", "Civil Lines", "Qilla Gujjar Singh", "Garhi Shahu", "Old Anarkali", "Lytton Road", "Mozang", "Shalimar", "Gujjar Pura", " Mughalpura", "Women Police Station Race Course" }));
/*     */     
/* 175 */     this.location_l.setText("Location");
/*     */     
/* 177 */     this.location_in.setDocument(new JTextFieldLimit(150));
/*     */     
/* 179 */     this.weapons_l.setText("Weapons");
/*     */     
/* 181 */     this.weapons_in.setModel(new DefaultComboBoxModel<>(new String[] { "No weapons", "Personal Weapons (Hands, Fists, Feet, etc)", "Knife/Blade", "Small Firearms", "Automatic", "Explosives" }));
/*     */     
/* 183 */     this.stolengoods_l.setText("Stolen Goods");
/*     */     
/* 185 */     this.stolengoods_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 187 */     this.vehicle_l.setText("Criminal Vehicle Description");
/*     */     
/* 189 */     this.vehicle_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 191 */     this.details_l.setText("Details");
/*     */     
/* 193 */     this.details_in.setColumns(20);
/* 194 */     this.details_in.setDocument(new JTextFieldLimit(65535));
/* 195 */     this.details_in.setRows(5);
/* 196 */     this.jScrollPane1.setViewportView(this.details_in);
/*     */     
/* 198 */     this.submit_button.setText("Submit/Add Location");
/* 199 */     this.submit_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 201 */             AddReport.this.submit_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 205 */     this.clear_button.setText("Clear Fields");
/* 206 */     this.clear_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 208 */             AddReport.this.clear_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 212 */     this.back_button.setText("Back to Main Menu");
/* 213 */     this.back_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 215 */             AddReport.this.back_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 219 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 220 */     getContentPane().setLayout(layout);
/* 221 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.complastname_l).addComponent(this.compaddress_l).addComponent(this.fir_l).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addGap(147, 147, 147).addComponent(this.submit_button).addGap(78, 78, 78).addComponent(this.clear_button).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.back_button)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.penalcharge_l).addComponent(this.location_l).addComponent(this.weapons_l).addComponent(this.details_l).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.date_l, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.compfirstname_l, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.vehicle_l, GroupLayout.Alignment.TRAILING).addComponent(this.stolengoods_l))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.date_in, -2, -1, -2).addGap(18, 18, 18).addComponent(this.month_in, -2, -1, -2).addGap(18, 18, 18).addComponent(this.year_in, -2, 55, -2)).addComponent(this.fir_in, -2, 130, -2)).addGap(55, 55, 55).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.crimetype_l).addGap(0, 0, 32767)).addComponent(this.time_l, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.hour_in, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.minute_in, -2, 50, -2)).addComponent(this.crimetype_in, -2, 130, -2))).addComponent(this.complastname_in, -1, 458, 32767).addComponent(this.compfirstname_in, -1, 458, 32767).addComponent(this.location_in, -1, 458, 32767).addComponent(this.stolengoods_in).addComponent(this.vehicle_in).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.penalcharge_in, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.policestation_l).addGap(55, 55, 55).addComponent(this.policestation_in, -2, 120, -2)).addComponent(this.compaddress_in).addComponent(this.jScrollPane1).addComponent(this.weapons_in, -2, 150, -2))))).addContainerGap(-1, 32767)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.fir_l).addComponent(this.crimetype_l).addComponent(this.crimetype_in, -2, -1, -2).addComponent(this.fir_in, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.date_l).addComponent(this.date_in, -2, -1, -2).addComponent(this.month_in, -2, -1, -2).addComponent(this.year_in, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.time_l).addComponent(this.hour_in, -2, -1, -2).addComponent(this.minute_in, -2, -1, -2))).addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.compfirstname_in, -2, -1, -2).addComponent(this.compfirstname_l)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.complastname_l).addComponent(this.complastname_in, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.compaddress_l).addComponent(this.compaddress_in, -2, -1, -2)).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.policestation_l).addComponent(this.penalcharge_l).addComponent(this.penalcharge_in, -2, -1, -2).addComponent(this.policestation_in, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.location_l).addComponent(this.location_in, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.weapons_l).addComponent(this.weapons_in, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.stolengoods_in, -2, -1, -2).addComponent(this.stolengoods_l)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vehicle_in, -2, -1, -2).addComponent(this.vehicle_l)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 23, 32767).addGap(30, 30, 30)).addGroup(layout.createSequentialGroup().addComponent(this.details_l).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.submit_button).addComponent(this.clear_button).addComponent(this.back_button)).addGap(20, 20, 20)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     pack();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fir_inActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void fir_inKeyTyped(KeyEvent evt) {
/* 367 */     char c = evt.getKeyChar();
/* 368 */     if (!Character.isDigit(c) && c != '\b' && c != '') {
/* 369 */       getToolkit().beep();
/* 370 */       evt.consume();
/* 371 */       JOptionPane.showMessageDialog(null, "Please input numbers only.", "Error", 0);
/*     */ 
/*     */ 
/*     */       
/* 375 */       this.fir_in.setText("");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void submit_buttonActionPerformed(ActionEvent evt) {
/* 381 */     if (emptyinputcheck() == 0) {
/*     */       
/* 383 */       JOptionPane.showMessageDialog(null, "Please ensure none of the required input fields are empty. Required fields are marked with an asterik (*).", "Error", 0);
/*     */ 
/*     */ 
/*     */       
/* 387 */       this.fir_l.setText("FIR No. *");
/* 388 */       this.compfirstname_l.setText("Complainant First Name *");
/* 389 */       this.complastname_l.setText("Complainant Last Name *");
/* 390 */       this.compaddress_l.setText("Complainant Address *");
/* 391 */       this.penalcharge_l.setText("Penal Code Charge *");
/* 392 */       this.location_l.setText("Location *");
/* 393 */       this.crimetype_l.setText("Crime Type *");
/* 394 */       this.date_l.setText("Date (DD:MM:YYYY) *");
/* 395 */       this.time_l.setText("Time (HH:MM) *");
/* 396 */       this.policestation_l.setText("Police Station *");
/* 397 */       this.weapons_l.setText("Weapons *");
/*     */     }
/* 399 */     else if (emptyinputcheck() == 1) {
/*     */ 
/*     */       
/* 402 */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 403 */       EntityManager entitymanager = emf.createEntityManager();
/* 404 */       entitymanager.getTransaction().begin();
/*     */       
/* 406 */       CrimeReports2 cr = new CrimeReports2();
/*     */ 
/*     */       
/* 409 */       String firno = this.fir_in.getText();
/* 410 */       int fir_number = Integer.parseInt(firno);
/* 411 */       cr.setFir(Integer.valueOf(fir_number));
/*     */       
/* 413 */       String crime_type = (String)this.crimetype_in.getSelectedItem();
/* 414 */       cr.setCrimetype(crime_type);
/*     */       
/* 416 */       String police_station = (String)this.policestation_in.getSelectedItem();
/* 417 */       cr.setPolicestation(police_station);
/*     */       
/* 419 */       int ps_id = this.policestation_in.getSelectedIndex();
/* 420 */       cr.setPolicestationid(Integer.valueOf(ps_id + 1));
/*     */       
/* 422 */       cr.setDateD((Integer)this.date_in.getValue());
/* 423 */       cr.setDateM((Integer)this.month_in.getValue());
/* 424 */       cr.setDateY((Integer)this.year_in.getValue());
/*     */       
/* 426 */       cr.setTimeH((Integer)this.hour_in.getValue());
/* 427 */       cr.setTimeM((Integer)this.minute_in.getValue());
/*     */ 
/*     */ 
/*     */       
/* 431 */       cr.setCompfirstname(this.compfirstname_in.getText());
/* 432 */       cr.setCompsurname(this.complastname_in.getText());
/* 433 */       cr.setCompaddress(this.compaddress_in.getText());
/* 434 */       cr.setOffenceno(this.penalcharge_in.getText());
/* 435 */       cr.setLocation(this.location_in.getText());
/* 436 */       cr.setWeapons((String)this.weapons_in.getSelectedItem());
/* 437 */       cr.setStolengoods(this.stolengoods_in.getText());
/* 438 */       cr.setCriminalvehicledetails(this.vehicle_in.getText());
/* 439 */       cr.setDetails(this.details_in.getText());
/*     */       
/* 441 */       int pdiv = 0;
/*     */       
/* 443 */       if (this.policestation_in.getSelectedIndex() == 0 || this.policestation_in.getSelectedIndex() == 1 || this.policestation_in.getSelectedIndex() == 2 || this.policestation_in.getSelectedIndex() == 3 || this.policestation_in.getSelectedIndex() == 4 || this.policestation_in.getSelectedIndex() == 5 || this.policestation_in.getSelectedIndex() == 6 || this.policestation_in.getSelectedIndex() == 7 || this.policestation_in.getSelectedIndex() == 8 || this.policestation_in.getSelectedIndex() == 9) {
/*     */ 
/*     */ 
/*     */         
/* 447 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 448 */       } else if (this.policestation_in.getSelectedIndex() == 10 || this.policestation_in.getSelectedIndex() == 11 || this.policestation_in.getSelectedIndex() == 12 || this.policestation_in.getSelectedIndex() == 13 || this.policestation_in.getSelectedIndex() == 14 || this.policestation_in.getSelectedIndex() == 15 || this.policestation_in.getSelectedIndex() == 16 || this.policestation_in.getSelectedIndex() == 17 || this.policestation_in.getSelectedIndex() == 18 || this.policestation_in.getSelectedIndex() == 19 || this.policestation_in.getSelectedIndex() == 20) {
/*     */ 
/*     */ 
/*     */         
/* 452 */         pdiv = 1;
/* 453 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 454 */       } else if (this.policestation_in.getSelectedIndex() == 21 || this.policestation_in.getSelectedIndex() == 22 || this.policestation_in.getSelectedIndex() == 23 || this.policestation_in.getSelectedIndex() == 24 || this.policestation_in.getSelectedIndex() == 25 || this.policestation_in.getSelectedIndex() == 26 || this.policestation_in.getSelectedIndex() == 27 || this.policestation_in.getSelectedIndex() == 28 || this.policestation_in.getSelectedIndex() == 29 || this.policestation_in.getSelectedIndex() == 30 || this.policestation_in.getSelectedIndex() == 31 || this.policestation_in.getSelectedIndex() == 32 || this.policestation_in.getSelectedIndex() == 33 || this.policestation_in.getSelectedIndex() == 34 || this.policestation_in.getSelectedIndex() == 35 || this.policestation_in.getSelectedIndex() == 36 || this.policestation_in.getSelectedIndex() == 37 || this.policestation_in.getSelectedIndex() == 38 || this.policestation_in.getSelectedIndex() == 39) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 461 */         pdiv = 2;
/* 462 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 463 */       } else if (this.policestation_in.getSelectedIndex() == 40 || this.policestation_in.getSelectedIndex() == 41 || this.policestation_in.getSelectedIndex() == 42 || this.policestation_in.getSelectedIndex() == 43 || this.policestation_in.getSelectedIndex() == 44 || this.policestation_in.getSelectedIndex() == 45 || this.policestation_in.getSelectedIndex() == 46 || this.policestation_in.getSelectedIndex() == 47 || this.policestation_in.getSelectedIndex() == 48 || this.policestation_in.getSelectedIndex() == 49 || this.policestation_in.getSelectedIndex() == 50 || this.policestation_in.getSelectedIndex() == 51 || this.policestation_in.getSelectedIndex() == 52 || this.policestation_in.getSelectedIndex() == 53 || this.policestation_in.getSelectedIndex() == 54 || this.policestation_in.getSelectedIndex() == 55 || this.policestation_in.getSelectedIndex() == 56) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 469 */         pdiv = 3;
/* 470 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 471 */       } else if (this.policestation_in.getSelectedIndex() == 57 || this.policestation_in.getSelectedIndex() == 58 || this.policestation_in.getSelectedIndex() == 59 || this.policestation_in.getSelectedIndex() == 60 || this.policestation_in.getSelectedIndex() == 61 || this.policestation_in.getSelectedIndex() == 62 || this.policestation_in.getSelectedIndex() == 63 || this.policestation_in.getSelectedIndex() == 64 || this.policestation_in.getSelectedIndex() == 65 || this.policestation_in.getSelectedIndex() == 66 || this.policestation_in.getSelectedIndex() == 67 || this.policestation_in.getSelectedIndex() == 68 || this.policestation_in.getSelectedIndex() == 69 || this.policestation_in.getSelectedIndex() == 70 || this.policestation_in.getSelectedIndex() == 71 || this.policestation_in.getSelectedIndex() == 72 || this.policestation_in.getSelectedIndex() == 73 || this.policestation_in.getSelectedIndex() == 74 || this.policestation_in.getSelectedIndex() == 75 || this.policestation_in.getSelectedIndex() == 76 || this.policestation_in.getSelectedIndex() == 77) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 478 */         pdiv = 4;
/* 479 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 480 */       } else if (this.policestation_in.getSelectedIndex() == 78 || this.policestation_in.getSelectedIndex() == 79 || this.policestation_in.getSelectedIndex() == 80 || this.policestation_in.getSelectedIndex() == 81 || this.policestation_in.getSelectedIndex() == 82 || this.policestation_in.getSelectedIndex() == 83 || this.policestation_in.getSelectedIndex() == 84 || this.policestation_in.getSelectedIndex() == 85 || this.policestation_in.getSelectedIndex() == 86 || this.policestation_in.getSelectedIndex() == 87 || this.policestation_in.getSelectedIndex() == 88) {
/*     */ 
/*     */ 
/*     */         
/* 484 */         pdiv = 5;
/* 485 */         cr.setPolicediv(Integer.valueOf(pdiv));
/*     */       } 
/*     */ 
/*     */       
/* 489 */       cr.setLatitude(null);
/* 490 */       cr.setLongitude(null);
/*     */ 
/*     */       
/* 493 */       entitymanager.persist(cr);
/* 494 */       entitymanager.getTransaction().commit();
/* 495 */       entitymanager.close();
/* 496 */       emf.close();
/*     */ 
/*     */       
/* 499 */       AddLocation al = new AddLocation(cr.getId());
/* 500 */       al.setExtendedState(6);
/* 501 */       al.setVisible(true);
/* 502 */       dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void clear_buttonActionPerformed(ActionEvent evt) {
/* 509 */     int reset = JOptionPane.showConfirmDialog(null, "This will clear all fields of data. Proceed?", "Warning", 0, 3);
/*     */     
/* 511 */     if (reset == 0) {
/*     */ 
/*     */       
/* 514 */       this.fir_in.setText("");
/* 515 */       this.compfirstname_in.setText("");
/* 516 */       this.complastname_in.setText("");
/* 517 */       this.compaddress_in.setText("");
/* 518 */       this.penalcharge_in.setText("");
/* 519 */       this.location_in.setText("");
/* 520 */       this.stolengoods_in.setText("");
/* 521 */       this.vehicle_in.setText("");
/* 522 */       this.details_in.setText("");
/* 523 */       int x = 0;
/* 524 */       this.crimetype_in.setSelectedIndex(x);
/* 525 */       this.weapons_in.setSelectedIndex(x);
/* 526 */       this.policestation_in.setSelectedIndex(x);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void back_buttonActionPerformed(ActionEvent evt) {
/* 534 */     int exit = JOptionPane.showConfirmDialog(null, "Unsaved data will be lost. Proceed?", "Warning", 0, 3);
/*     */     
/* 536 */     if (exit == 0) {
/* 537 */       MainWindow mw = new MainWindow();
/* 538 */       mw.setVisible(true);
/* 539 */       dispose();
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
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 554 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 555 */         if ("Nimbus".equals(info.getName())) {
/* 556 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 560 */     } catch (ClassNotFoundException ex) {
/* 561 */       Logger.getLogger(AddReport.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 562 */     } catch (InstantiationException ex) {
/* 563 */       Logger.getLogger(AddReport.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 564 */     } catch (IllegalAccessException ex) {
/* 565 */       Logger.getLogger(AddReport.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 566 */     } catch (UnsupportedLookAndFeelException ex) {
/* 567 */       Logger.getLogger(AddReport.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 572 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 574 */             (new AddReport()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\AddReport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */