/*     */ package policedataapp;
/*     */ import javax.swing.GroupLayout;
/*     */ 
/*     */ public class UpdateData extends JFrame {
/*     */   private int databaseid;
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
/*     */   public UpdateData() {
/*  25 */     initComponents();
/*     */   }
/*     */   private JScrollPane jScrollPane1; private JTextField location_in; private JLabel location_l; private JSpinner minute_in; private JSpinner month_in; private JTextField penalcharge_in; private JLabel penalcharge_l; private JComboBox policestation_in; private JLabel policestation_l; private JTextField stolengoods_in; private JLabel stolengoods_l; private JLabel time_l; private JButton update_button; private JTextField vehicle_in; private JLabel vehicle_l; private JComboBox weapons_in; private JLabel weapons_l; private JSpinner year_in;
/*     */   
/*     */   public UpdateData(Integer x) {
/*  30 */     initComponents();
/*  31 */     this.databaseid = x.intValue();
/*     */ 
/*     */     
/*  34 */     EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/*  35 */     EntityManager entitymanager = emf.createEntityManager();
/*  36 */     entitymanager.getTransaction().begin();
/*  37 */     CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(this.databaseid));
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
/*  49 */     String crimetype = cr.getCrimetype();
/*  50 */     String weapon = cr.getWeapons();
/*  51 */     this.weapons_in.setSelectedItem(weapon);
/*  52 */     this.crimetype_in.setSelectedItem(crimetype);
/*  53 */     this.policestation_in.setSelectedIndex(cr.getPolicestationid().intValue() - 1);
/*     */     
/*  55 */     this.date_in.setValue(cr.getDateD());
/*  56 */     this.month_in.setValue(cr.getDateM());
/*  57 */     this.year_in.setValue(cr.getDateY());
/*     */     
/*  59 */     this.hour_in.setValue(cr.getTimeH());
/*  60 */     this.minute_in.setValue(cr.getTimeM());
/*     */     
/*  62 */     entitymanager.getTransaction().commit();
/*  63 */     entitymanager.close();
/*  64 */     emf.close();
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
/*     */   private void initComponents() {
/*  77 */     this.back_button = new JButton();
/*  78 */     this.clear_button = new JButton();
/*  79 */     this.update_button = new JButton();
/*  80 */     this.jScrollPane1 = new JScrollPane();
/*  81 */     this.details_in = new JTextArea();
/*  82 */     this.details_l = new JLabel();
/*  83 */     this.vehicle_l = new JLabel();
/*  84 */     this.vehicle_in = new JTextField();
/*  85 */     this.stolengoods_in = new JTextField();
/*  86 */     this.stolengoods_l = new JLabel();
/*  87 */     this.weapons_l = new JLabel();
/*  88 */     this.weapons_in = new JComboBox();
/*  89 */     this.location_in = new JTextField();
/*  90 */     this.location_l = new JLabel();
/*  91 */     this.penalcharge_l = new JLabel();
/*  92 */     this.penalcharge_in = new JTextField();
/*  93 */     this.policestation_l = new JLabel();
/*  94 */     this.policestation_in = new JComboBox();
/*  95 */     this.compaddress_in = new JTextField();
/*  96 */     this.complastname_in = new JTextField();
/*  97 */     this.compfirstname_in = new JTextField();
/*  98 */     this.compfirstname_l = new JLabel();
/*  99 */     this.complastname_l = new JLabel();
/* 100 */     this.compaddress_l = new JLabel();
/* 101 */     this.date_l = new JLabel();
/* 102 */     this.fir_l = new JLabel();
/* 103 */     this.fir_in = new JTextField();
/* 104 */     this.date_in = new JSpinner();
/* 105 */     this.month_in = new JSpinner();
/* 106 */     this.year_in = new JSpinner();
/* 107 */     this.time_l = new JLabel();
/* 108 */     this.crimetype_l = new JLabel();
/* 109 */     this.crimetype_in = new JComboBox();
/* 110 */     this.hour_in = new JSpinner();
/* 111 */     this.minute_in = new JSpinner();
/*     */     
/* 113 */     setDefaultCloseOperation(3);
/*     */     
/* 115 */     this.back_button.setText("Back to Database View");
/* 116 */     this.back_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 118 */             UpdateData.this.back_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 122 */     this.clear_button.setText("Clear Fields");
/* 123 */     this.clear_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 125 */             UpdateData.this.clear_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 129 */     this.update_button.setText("Update");
/* 130 */     this.update_button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 132 */             UpdateData.this.update_buttonActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.details_in.setColumns(20);
/* 137 */     this.details_in.setDocument(new JTextFieldLimit(65535));
/* 138 */     this.details_in.setRows(5);
/* 139 */     this.jScrollPane1.setViewportView(this.details_in);
/*     */     
/* 141 */     this.details_l.setText("Details");
/*     */     
/* 143 */     this.vehicle_l.setText("Criminal Vehicle Description");
/*     */     
/* 145 */     this.vehicle_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 147 */     this.stolengoods_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 149 */     this.stolengoods_l.setText("Stolen Goods");
/*     */     
/* 151 */     this.weapons_l.setText("Weapons");
/*     */     
/* 153 */     this.weapons_in.setModel(new DefaultComboBoxModel<>(new String[] { "No weapons", "Personal Weapons (Hands, Fists, Feet, etc)", "Knife/Blade", "Small Firearms", "Automatic", "Explosives" }));
/*     */     
/* 155 */     this.location_in.setDocument(new JTextFieldLimit(150));
/*     */     
/* 157 */     this.location_l.setText("Location");
/*     */     
/* 159 */     this.penalcharge_l.setText("Penal Code Charge");
/*     */     
/* 161 */     this.penalcharge_in.setDocument(new JTextFieldLimit(50));
/*     */     
/* 163 */     this.policestation_l.setText("Police Station:");
/*     */     
/* 165 */     this.policestation_in.setModel(new DefaultComboBoxModel<>(new String[] { "Muslim Town", "Wahdat Colony", "Iqbal Town", "Gulshan Iqbal", "Samanabad", "Millat Park", "Gulshan-e-Ravi", "Sanda", "Nawan Kot", "Shera Kot", "Raiwand City", "Police Post Jia Bagga", "Manga Mandi", "Police Post Adda Sundar", "Chung", "Satto Katla", "Sabzazar", "Hanjarwal", "Town Ship", "Johar Town", "Green Town", "Defence Area A", "Defence Area B", "Factory Area", "Sarwar Road", "Police Post Air Port", "South Cantt", "North Cantt", "Police Post Guldisht Town", "Mustafa Abad", "Ghazi Abad", "Barki", "Police Post Hair", "Hadiara", "Police Post Minhala", "Baghbanpura", "Harbance Pura", "Manawan", "Bata Pur", "Police Post Wagha", "Model Town", "Liaqat Abad", "Naseerabad", "Police Post Firdous Market", "Garden Town", "Police Post Raja Market", "Faisal Town", "Ichhra", "Shadman", "Gulberg", "Ghalib Market", "Police Post Main Market", "Kahna", "Police Post Sua Assal", "Kot Lakhpat", "Police Post Rakh Chandrai", "Nishter Colony", "Islampura", "New Anarkali", "Lower Mall", "Bhatti Gate", "Tibbi City", "Masti Gate", "Yakki Gate", "Rang Mehal", "Lohari Gate", "Naulakha", "Akbari Gate", "Gowalmandi", "Mochi Gate", "Shahdara", "Shahdara Town", "Shafiq Abad", "Ravi Road", "Badamibagh", "Lorry Adda", "Missri Shah", "Shadbagh", "Race Course", "Civil Lines", "Qilla Gujjar Singh", "Garhi Shahu", "Old Anarkali", "Lytton Road", "Mozang", "Shalimar", "Gujjar Pura", " Mughalpura", "Women Police Station Race Course" }));
/*     */     
/* 167 */     this.compaddress_in.setDocument(new JTextFieldLimit(200));
/*     */     
/* 169 */     this.complastname_in.setDocument(new JTextFieldLimit(150));
/*     */     
/* 171 */     this.compfirstname_in.setDocument(new JTextFieldLimit(100));
/*     */     
/* 173 */     this.compfirstname_l.setText("Complainant First Name");
/*     */     
/* 175 */     this.complastname_l.setText("Complainant Last Name");
/*     */     
/* 177 */     this.compaddress_l.setText("Complainant Address");
/*     */     
/* 179 */     this.date_l.setText("Date (DD:MM:YYYY)");
/*     */     
/* 181 */     this.fir_l.setText("FIR No.");
/*     */     
/* 183 */     this.fir_in.setDocument(new JTextFieldLimit(10));
/* 184 */     this.fir_in.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 186 */             UpdateData.this.fir_inActionPerformed(evt);
/*     */           }
/*     */         });
/* 189 */     this.fir_in.addKeyListener(new KeyAdapter() {
/*     */           public void keyTyped(KeyEvent evt) {
/* 191 */             UpdateData.this.fir_inKeyTyped(evt);
/*     */           }
/*     */         });
/*     */     
/* 195 */     this.date_in.setModel(new SpinnerNumberModel(1, 1, 31, 1));
/*     */     
/* 197 */     this.month_in.setModel(new SpinnerNumberModel(1, 1, 12, 1));
/*     */     
/* 199 */     this.year_in.setModel(new SpinnerNumberModel(2015, 2000, 2020, 1));
/* 200 */     this.year_in.setEditor(new JSpinner.NumberEditor(this.year_in, "0000"));
/*     */     
/* 202 */     this.time_l.setText("Time (HH:MM)");
/*     */     
/* 204 */     this.crimetype_l.setText("Crime Type");
/*     */     
/* 206 */     this.crimetype_in.setModel(new DefaultComboBoxModel<>(new String[] { "Robbery", "Burglary", "Motor Vehicle Theft", "Motor Vehicle Snatching", "Murder", "Attempted Murder", "Injury", "Kidnapping/Abduction", "Kidnapping/Ransom", "Rape", "Gang-rape" }));
/*     */     
/* 208 */     this.hour_in.setModel(new SpinnerNumberModel(1, 0, 23, 1));
/*     */     
/* 210 */     this.minute_in.setModel(new SpinnerNumberModel(1, 1, 59, 1));
/*     */     
/* 212 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 213 */     getContentPane().setLayout(layout);
/* 214 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.fir_l).addComponent(this.date_l, -2, 113, -2).addComponent(this.compaddress_l).addComponent(this.complastname_l).addComponent(this.compfirstname_l).addComponent(this.details_l).addComponent(this.penalcharge_l).addComponent(this.location_l).addComponent(this.weapons_l).addComponent(this.stolengoods_l)).addGap(16, 16, 16)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.vehicle_l))).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.date_in, -2, -1, -2).addGap(18, 18, 18).addComponent(this.month_in, -2, -1, -2).addGap(18, 18, 18).addComponent(this.year_in, -2, 55, -2)).addComponent(this.fir_in, -2, 130, -2)).addGap(55, 55, 55).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.crimetype_l).addComponent(this.time_l, -2, 100, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.hour_in, -2, 50, -2).addGap(18, 18, 18).addComponent(this.minute_in, -2, 59, -2)).addComponent(this.crimetype_in, -2, -1, -2))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.update_button).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.clear_button).addGap(67, 67, 67).addComponent(this.back_button)).addComponent(this.complastname_in).addComponent(this.compaddress_in).addComponent(this.location_in).addComponent(this.stolengoods_in).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.penalcharge_in, -2, 150, -2).addGap(53, 53, 53).addComponent(this.policestation_l).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.policestation_in, -2, 120, -2)).addComponent(this.vehicle_in, -1, 458, 32767).addComponent(this.jScrollPane1, -1, 458, 32767).addComponent(this.compfirstname_in)).addComponent(this.weapons_in, -2, 150, -2)).addContainerGap()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.fir_l).addComponent(this.crimetype_l).addComponent(this.crimetype_in, -2, -1, -2))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.fir_in, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.date_l).addComponent(this.date_in, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.month_in, -2, -1, -2).addComponent(this.year_in, -2, -1, -2).addComponent(this.time_l).addComponent(this.hour_in, -2, -1, -2).addComponent(this.minute_in, -2, -1, -2))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.compfirstname_l).addComponent(this.compfirstname_in, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.complastname_l).addComponent(this.complastname_in, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.compaddress_l).addComponent(this.compaddress_in, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.penalcharge_in, -2, -1, -2).addComponent(this.penalcharge_l).addComponent(this.policestation_in, -2, -1, -2).addComponent(this.policestation_l)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.location_in, -2, -1, -2).addComponent(this.location_l)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.weapons_l).addComponent(this.weapons_in, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.stolengoods_in, -2, -1, -2).addComponent(this.stolengoods_l)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.vehicle_in, -2, -1, -2).addComponent(this.vehicle_l)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.details_l).addComponent(this.jScrollPane1, -2, 88, -2)).addGap(31, 31, 31).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.update_button).addComponent(this.clear_button).addComponent(this.back_button)).addContainerGap(-1, 32767)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     pack();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void back_buttonActionPerformed(ActionEvent evt) {
/* 356 */     int exit = JOptionPane.showConfirmDialog(null, "Unsaved data will be lost. Proceed?", "Warning", 0, 3);
/*     */     
/* 358 */     if (exit == 0) {
/* 359 */       ViewData vd = new ViewData();
/* 360 */       vd.setExtendedState(6);
/* 361 */       vd.setVisible(true);
/* 362 */       dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int emptyinputcheck() {
/* 371 */     int x = 0;
/*     */     
/* 373 */     if (!this.fir_in.getText().equals("") && !this.compfirstname_in.getText().equals("") && !this.complastname_in.getText().equals("") && !this.compaddress_in.getText().equals("") && !this.penalcharge_in.getText().equals("") && !this.location_in.getText().equals(""))
/*     */     {
/*     */ 
/*     */       
/* 377 */       x = 1;
/*     */     }
/*     */     
/* 380 */     return x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clear_buttonActionPerformed(ActionEvent evt) {
/* 387 */     int reset = JOptionPane.showConfirmDialog(null, "This will clear all fields of data. Proceed?", "Warning", 0, 3);
/*     */     
/* 389 */     if (reset == 0) {
/*     */ 
/*     */       
/* 392 */       this.fir_in.setText("");
/* 393 */       this.compfirstname_in.setText("");
/* 394 */       this.complastname_in.setText("");
/* 395 */       this.compaddress_in.setText("");
/* 396 */       this.penalcharge_in.setText("");
/* 397 */       this.location_in.setText("");
/* 398 */       this.stolengoods_in.setText("");
/* 399 */       this.vehicle_in.setText("");
/* 400 */       this.details_in.setText("");
/* 401 */       int zero = 0;
/* 402 */       this.weapons_in.setSelectedIndex(zero);
/* 403 */       this.crimetype_in.setSelectedIndex(zero);
/* 404 */       this.policestation_in.setSelectedIndex(zero);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void update_buttonActionPerformed(ActionEvent evt) {
/* 411 */     if (emptyinputcheck() == 0) {
/*     */       
/* 413 */       JOptionPane.showMessageDialog(null, "Please ensure none of the required input fields are empty. Required fields are marked with an asterik (*).", "Error", 0);
/*     */ 
/*     */ 
/*     */       
/* 417 */       this.fir_l.setText("FIR No. *");
/* 418 */       this.compfirstname_l.setText("Complainant First Name *");
/* 419 */       this.complastname_l.setText("Complainant Last Name *");
/* 420 */       this.compaddress_l.setText("Complainant Address *");
/* 421 */       this.penalcharge_l.setText("Penal Code Charge *");
/* 422 */       this.location_l.setText("Location *");
/* 423 */       this.crimetype_l.setText("Crime Type *");
/* 424 */       this.date_l.setText("Date (DD:MM:YYYY) *");
/* 425 */       this.time_l.setText("Time (HH:MM) *");
/* 426 */       this.policestation_l.setText("Police Station *");
/* 427 */       this.weapons_l.setText("Weapons *");
/*     */     }
/* 429 */     else if (emptyinputcheck() == 1) {
/*     */ 
/*     */       
/* 432 */       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeDataVisPU");
/* 433 */       EntityManager entitymanager = emf.createEntityManager();
/* 434 */       entitymanager.getTransaction().begin();
/* 435 */       CrimeReports2 cr = (CrimeReports2)entitymanager.find(CrimeReports2.class, Integer.valueOf(this.databaseid));
/*     */ 
/*     */       
/* 438 */       String firno = this.fir_in.getText();
/* 439 */       int fir_number = Integer.parseInt(firno);
/* 440 */       cr.setFir(Integer.valueOf(fir_number));
/*     */       
/* 442 */       String crime_type = (String)this.crimetype_in.getSelectedItem();
/* 443 */       cr.setCrimetype(crime_type);
/*     */       
/* 445 */       String weapon = (String)this.weapons_in.getSelectedItem();
/* 446 */       cr.setWeapons(weapon);
/*     */       
/* 448 */       String police_station = (String)this.policestation_in.getSelectedItem();
/* 449 */       cr.setPolicestation(police_station);
/*     */       
/* 451 */       int ps_id = this.policestation_in.getSelectedIndex();
/* 452 */       cr.setPolicestationid(Integer.valueOf(ps_id + 1));
/*     */       
/* 454 */       cr.setDateD((Integer)this.date_in.getValue());
/* 455 */       cr.setDateM((Integer)this.month_in.getValue());
/* 456 */       cr.setDateY((Integer)this.year_in.getValue());
/*     */       
/* 458 */       cr.setTimeH((Integer)this.hour_in.getValue());
/* 459 */       cr.setTimeM((Integer)this.minute_in.getValue());
/*     */       
/* 461 */       cr.setCompfirstname(this.compfirstname_in.getText());
/* 462 */       cr.setCompsurname(this.complastname_in.getText());
/* 463 */       cr.setCompaddress(this.compaddress_in.getText());
/* 464 */       cr.setOffenceno(this.penalcharge_in.getText());
/* 465 */       cr.setLocation(this.location_in.getText());
/* 466 */       cr.setStolengoods(this.stolengoods_in.getText());
/* 467 */       cr.setCriminalvehicledetails(this.vehicle_in.getText());
/* 468 */       cr.setDetails(this.details_in.getText());
/*     */       
/* 470 */       int pdiv = 0;
/*     */       
/* 472 */       if (this.policestation_in.getSelectedIndex() == 0 || this.policestation_in.getSelectedIndex() == 1 || this.policestation_in.getSelectedIndex() == 2 || this.policestation_in.getSelectedIndex() == 3 || this.policestation_in.getSelectedIndex() == 4 || this.policestation_in.getSelectedIndex() == 5 || this.policestation_in.getSelectedIndex() == 6 || this.policestation_in.getSelectedIndex() == 7 || this.policestation_in.getSelectedIndex() == 8 || this.policestation_in.getSelectedIndex() == 9) {
/*     */ 
/*     */ 
/*     */         
/* 476 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 477 */       } else if (this.policestation_in.getSelectedIndex() == 10 || this.policestation_in.getSelectedIndex() == 11 || this.policestation_in.getSelectedIndex() == 12 || this.policestation_in.getSelectedIndex() == 13 || this.policestation_in.getSelectedIndex() == 14 || this.policestation_in.getSelectedIndex() == 15 || this.policestation_in.getSelectedIndex() == 16 || this.policestation_in.getSelectedIndex() == 17 || this.policestation_in.getSelectedIndex() == 18 || this.policestation_in.getSelectedIndex() == 19 || this.policestation_in.getSelectedIndex() == 20) {
/*     */ 
/*     */ 
/*     */         
/* 481 */         pdiv = 1;
/* 482 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 483 */       } else if (this.policestation_in.getSelectedIndex() == 21 || this.policestation_in.getSelectedIndex() == 22 || this.policestation_in.getSelectedIndex() == 23 || this.policestation_in.getSelectedIndex() == 24 || this.policestation_in.getSelectedIndex() == 25 || this.policestation_in.getSelectedIndex() == 26 || this.policestation_in.getSelectedIndex() == 27 || this.policestation_in.getSelectedIndex() == 28 || this.policestation_in.getSelectedIndex() == 29 || this.policestation_in.getSelectedIndex() == 30 || this.policestation_in.getSelectedIndex() == 31 || this.policestation_in.getSelectedIndex() == 32 || this.policestation_in.getSelectedIndex() == 33 || this.policestation_in.getSelectedIndex() == 34 || this.policestation_in.getSelectedIndex() == 35 || this.policestation_in.getSelectedIndex() == 36 || this.policestation_in.getSelectedIndex() == 37 || this.policestation_in.getSelectedIndex() == 38 || this.policestation_in.getSelectedIndex() == 39) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 490 */         pdiv = 2;
/* 491 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 492 */       } else if (this.policestation_in.getSelectedIndex() == 40 || this.policestation_in.getSelectedIndex() == 41 || this.policestation_in.getSelectedIndex() == 42 || this.policestation_in.getSelectedIndex() == 43 || this.policestation_in.getSelectedIndex() == 44 || this.policestation_in.getSelectedIndex() == 45 || this.policestation_in.getSelectedIndex() == 46 || this.policestation_in.getSelectedIndex() == 47 || this.policestation_in.getSelectedIndex() == 48 || this.policestation_in.getSelectedIndex() == 49 || this.policestation_in.getSelectedIndex() == 50 || this.policestation_in.getSelectedIndex() == 51 || this.policestation_in.getSelectedIndex() == 52 || this.policestation_in.getSelectedIndex() == 53 || this.policestation_in.getSelectedIndex() == 54 || this.policestation_in.getSelectedIndex() == 55 || this.policestation_in.getSelectedIndex() == 56) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 498 */         pdiv = 3;
/* 499 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 500 */       } else if (this.policestation_in.getSelectedIndex() == 57 || this.policestation_in.getSelectedIndex() == 58 || this.policestation_in.getSelectedIndex() == 59 || this.policestation_in.getSelectedIndex() == 60 || this.policestation_in.getSelectedIndex() == 61 || this.policestation_in.getSelectedIndex() == 62 || this.policestation_in.getSelectedIndex() == 63 || this.policestation_in.getSelectedIndex() == 64 || this.policestation_in.getSelectedIndex() == 65 || this.policestation_in.getSelectedIndex() == 66 || this.policestation_in.getSelectedIndex() == 67 || this.policestation_in.getSelectedIndex() == 68 || this.policestation_in.getSelectedIndex() == 69 || this.policestation_in.getSelectedIndex() == 70 || this.policestation_in.getSelectedIndex() == 71 || this.policestation_in.getSelectedIndex() == 72 || this.policestation_in.getSelectedIndex() == 73 || this.policestation_in.getSelectedIndex() == 74 || this.policestation_in.getSelectedIndex() == 75 || this.policestation_in.getSelectedIndex() == 76 || this.policestation_in.getSelectedIndex() == 77) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 507 */         pdiv = 4;
/* 508 */         cr.setPolicediv(Integer.valueOf(pdiv));
/* 509 */       } else if (this.policestation_in.getSelectedIndex() == 78 || this.policestation_in.getSelectedIndex() == 79 || this.policestation_in.getSelectedIndex() == 80 || this.policestation_in.getSelectedIndex() == 81 || this.policestation_in.getSelectedIndex() == 82 || this.policestation_in.getSelectedIndex() == 83 || this.policestation_in.getSelectedIndex() == 84 || this.policestation_in.getSelectedIndex() == 85 || this.policestation_in.getSelectedIndex() == 86 || this.policestation_in.getSelectedIndex() == 87 || this.policestation_in.getSelectedIndex() == 88) {
/*     */ 
/*     */ 
/*     */         
/* 513 */         pdiv = 5;
/* 514 */         cr.setPolicediv(Integer.valueOf(pdiv));
/*     */       } 
/*     */ 
/*     */       
/* 518 */       entitymanager.persist(cr);
/* 519 */       entitymanager.getTransaction().commit();
/* 520 */       entitymanager.close();
/* 521 */       emf.close();
/*     */ 
/*     */       
/* 524 */       ViewData vd = new ViewData();
/* 525 */       vd.setVisible(true);
/* 526 */       vd.setExtendedState(6);
/* 527 */       dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fir_inActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void fir_inKeyTyped(KeyEvent evt) {
/* 537 */     char c = evt.getKeyChar();
/* 538 */     if (!Character.isDigit(c) && c != '\b' && c != '') {
/* 539 */       getToolkit().beep();
/* 540 */       evt.consume();
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
/* 555 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 556 */         if ("Nimbus".equals(info.getName())) {
/* 557 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 561 */     } catch (ClassNotFoundException ex) {
/* 562 */       Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 563 */     } catch (InstantiationException ex) {
/* 564 */       Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 565 */     } catch (IllegalAccessException ex) {
/* 566 */       Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 567 */     } catch (UnsupportedLookAndFeelException ex) {
/* 568 */       Logger.getLogger(UpdateData.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 573 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 575 */             (new UpdateData()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\UpdateData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */