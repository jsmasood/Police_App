/*     */ package policedataapp;
/*     */ 
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Basic;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Lob;
/*     */ import javax.persistence.NamedQueries;
/*     */ import javax.persistence.NamedQuery;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Transient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name = "CRIME_REPORTS2")
/*     */ @NamedQueries({@NamedQuery(name = "CrimeReports2.findAll", query = "SELECT c FROM CrimeReports2 c"), @NamedQuery(name = "CrimeReports2.findById", query = "SELECT c FROM CrimeReports2 c WHERE c.id = :id"), @NamedQuery(name = "CrimeReports2.findByFir", query = "SELECT c FROM CrimeReports2 c WHERE c.fir = :fir"), @NamedQuery(name = "CrimeReports2.findByCompfirstname", query = "SELECT c FROM CrimeReports2 c WHERE c.compfirstname = :compfirstname"), @NamedQuery(name = "CrimeReports2.findByCompsurname", query = "SELECT c FROM CrimeReports2 c WHERE c.compsurname = :compsurname"), @NamedQuery(name = "CrimeReports2.findByCompaddress", query = "SELECT c FROM CrimeReports2 c WHERE c.compaddress = :compaddress"), @NamedQuery(name = "CrimeReports2.findByOffenceno", query = "SELECT c FROM CrimeReports2 c WHERE c.offenceno = :offenceno"), @NamedQuery(name = "CrimeReports2.findByCrimetype", query = "SELECT c FROM CrimeReports2 c WHERE c.crimetype = :crimetype"), @NamedQuery(name = "CrimeReports2.findByPolicestationid", query = "SELECT c FROM CrimeReports2 c WHERE c.policestationid = :policestationid"), @NamedQuery(name = "CrimeReports2.findByPolicestation", query = "SELECT c FROM CrimeReports2 c WHERE c.policestation = :policestation"), @NamedQuery(name = "CrimeReports2.findByLocation", query = "SELECT c FROM CrimeReports2 c WHERE c.location = :location"), @NamedQuery(name = "CrimeReports2.findByWeapons", query = "SELECT c FROM CrimeReports2 c WHERE c.weapons = :weapons"), @NamedQuery(name = "CrimeReports2.findByStolengoods", query = "SELECT c FROM CrimeReports2 c WHERE c.stolengoods = :stolengoods"), @NamedQuery(name = "CrimeReports2.findByCriminalvehicledetails", query = "SELECT c FROM CrimeReports2 c WHERE c.criminalvehicledetails = :criminalvehicledetails"), @NamedQuery(name = "CrimeReports2.findByTimeH", query = "SELECT c FROM CrimeReports2 c WHERE c.timeH = :timeH"), @NamedQuery(name = "CrimeReports2.findByTimeM", query = "SELECT c FROM CrimeReports2 c WHERE c.timeM = :timeM"), @NamedQuery(name = "CrimeReports2.findByDateD", query = "SELECT c FROM CrimeReports2 c WHERE c.dateD = :dateD"), @NamedQuery(name = "CrimeReports2.findByDateM", query = "SELECT c FROM CrimeReports2 c WHERE c.dateM = :dateM"), @NamedQuery(name = "CrimeReports2.findByDateY", query = "SELECT c FROM CrimeReports2 c WHERE c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.findByPolicediv", query = "SELECT c FROM CrimeReports2 c WHERE c.policediv = :policediv"), @NamedQuery(name = "CrimeReports2.findByLatitude", query = "SELECT c FROM CrimeReports2 c WHERE c.latitude = :latitude"), @NamedQuery(name = "CrimeReports2.findByLongitude", query = "SELECT c FROM CrimeReports2 c WHERE c.longitude = :longitude"), @NamedQuery(name = "CrimeReports2.countByDateY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByDateM", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.dateM = :dateM"), @NamedQuery(name = "CrimeReports2.countByCrimeType", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.crimetype = :crimetype"), @NamedQuery(name = "CrimeReports2.countByCrimeTypeY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.crimetype = :crimetype AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByCrimeTypeMY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.crimetype = :crimetype AND c.dateM = :dateM AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByCrimeTypeT", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.crimetype = :crimetype AND c.timeH BETWEEN :hour1 AND :hour2"), @NamedQuery(name = "CrimeReports2.countByPoliceDiv", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.policediv = :policediv"), @NamedQuery(name = "CrimeReports2.countByPoliceDivY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.policediv = :policediv AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByPoliceDivMY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.policediv = :policediv AND c.dateM = :dateM AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByPoliceDivT", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.policediv = :policediv AND c.timeH BETWEEN :hour1 AND :hour2"), @NamedQuery(name = "CrimeReports2.countByWeapons", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.weapons = :weapons"), @NamedQuery(name = "CrimeReports2.countByWeaponsY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.weapons = :weapons AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByWeaponsMY", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.weapons = :weapons AND c.dateM = :dateM AND c.dateY = :dateY"), @NamedQuery(name = "CrimeReports2.countByWeaponsT", query = "SELECT COUNT(c) FROM CrimeReports2 c WHERE c.weapons = :weapons AND c.timeH BETWEEN :hour1 AND :hour2")})
/*     */ public class CrimeReports2
/*     */   implements Serializable
/*     */ {
/*     */   @Transient
/*  73 */   private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "ID")
/*     */   private Integer id;
/*     */   
/*     */   @Column(name = "FIR")
/*     */   private Integer fir;
/*     */   @Column(name = "COMPFIRSTNAME")
/*     */   private String compfirstname;
/*     */   @Column(name = "COMPSURNAME")
/*     */   private String compsurname;
/*     */   @Column(name = "COMPADDRESS")
/*     */   private String compaddress;
/*     */   @Column(name = "OFFENCENO")
/*     */   private String offenceno;
/*     */   @Column(name = "CRIMETYPE")
/*     */   private String crimetype;
/*     */   @Column(name = "POLICESTATIONID")
/*     */   private Integer policestationid;
/*     */   @Column(name = "POLICESTATION")
/*     */   private String policestation;
/*     */   @Column(name = "LOCATION")
/*     */   private String location;
/*     */   @Column(name = "WEAPONS")
/*     */   private String weapons;
/*     */   @Column(name = "STOLENGOODS")
/*     */   private String stolengoods;
/*     */   @Column(name = "CRIMINALVEHICLEDETAILS")
/*     */   private String criminalvehicledetails;
/*     */   @Column(name = "TIME_H")
/*     */   private Integer timeH;
/*     */   @Column(name = "TIME_M")
/*     */   private Integer timeM;
/*     */   @Column(name = "DATE_D")
/*     */   private Integer dateD;
/*     */   @Column(name = "DATE_M")
/*     */   private Integer dateM;
/*     */   @Column(name = "DATE_Y")
/*     */   private Integer dateY;
/*     */   @Column(name = "POLICEDIV")
/*     */   private Integer policediv;
/*     */   @Lob
/*     */   @Column(name = "DETAILS")
/*     */   private String details;
/*     */   @Column(name = "LATITUDE")
/*     */   private Double latitude;
/*     */   @Column(name = "LONGITUDE")
/*     */   private Double longitude;
/*     */   
/*     */   public CrimeReports2() {}
/*     */   
/*     */   public CrimeReports2(Integer id) {
/* 130 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getId() {
/* 134 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/* 138 */     Integer oldId = this.id;
/* 139 */     this.id = id;
/* 140 */     this.changeSupport.firePropertyChange("id", oldId, id);
/*     */   }
/*     */   
/*     */   public Integer getFir() {
/* 144 */     return this.fir;
/*     */   }
/*     */   
/*     */   public void setFir(Integer fir) {
/* 148 */     Integer oldFir = this.fir;
/* 149 */     this.fir = fir;
/* 150 */     this.changeSupport.firePropertyChange("fir", oldFir, fir);
/*     */   }
/*     */   
/*     */   public String getCompfirstname() {
/* 154 */     return this.compfirstname;
/*     */   }
/*     */   
/*     */   public void setCompfirstname(String compfirstname) {
/* 158 */     String oldCompfirstname = this.compfirstname;
/* 159 */     this.compfirstname = compfirstname;
/* 160 */     this.changeSupport.firePropertyChange("compfirstname", oldCompfirstname, compfirstname);
/*     */   }
/*     */   
/*     */   public String getCompsurname() {
/* 164 */     return this.compsurname;
/*     */   }
/*     */   
/*     */   public void setCompsurname(String compsurname) {
/* 168 */     String oldCompsurname = this.compsurname;
/* 169 */     this.compsurname = compsurname;
/* 170 */     this.changeSupport.firePropertyChange("compsurname", oldCompsurname, compsurname);
/*     */   }
/*     */   
/*     */   public String getCompaddress() {
/* 174 */     return this.compaddress;
/*     */   }
/*     */   
/*     */   public void setCompaddress(String compaddress) {
/* 178 */     String oldCompaddress = this.compaddress;
/* 179 */     this.compaddress = compaddress;
/* 180 */     this.changeSupport.firePropertyChange("compaddress", oldCompaddress, compaddress);
/*     */   }
/*     */   
/*     */   public String getOffenceno() {
/* 184 */     return this.offenceno;
/*     */   }
/*     */   
/*     */   public void setOffenceno(String offenceno) {
/* 188 */     String oldOffenceno = this.offenceno;
/* 189 */     this.offenceno = offenceno;
/* 190 */     this.changeSupport.firePropertyChange("offenceno", oldOffenceno, offenceno);
/*     */   }
/*     */   
/*     */   public String getCrimetype() {
/* 194 */     return this.crimetype;
/*     */   }
/*     */   
/*     */   public void setCrimetype(String crimetype) {
/* 198 */     String oldCrimetype = this.crimetype;
/* 199 */     this.crimetype = crimetype;
/* 200 */     this.changeSupport.firePropertyChange("crimetype", oldCrimetype, crimetype);
/*     */   }
/*     */   
/*     */   public Integer getPolicestationid() {
/* 204 */     return this.policestationid;
/*     */   }
/*     */   
/*     */   public void setPolicestationid(Integer policestationid) {
/* 208 */     Integer oldPolicestationid = this.policestationid;
/* 209 */     this.policestationid = policestationid;
/* 210 */     this.changeSupport.firePropertyChange("policestationid", oldPolicestationid, policestationid);
/*     */   }
/*     */   
/*     */   public String getPolicestation() {
/* 214 */     return this.policestation;
/*     */   }
/*     */   
/*     */   public void setPolicestation(String policestation) {
/* 218 */     String oldPolicestation = this.policestation;
/* 219 */     this.policestation = policestation;
/* 220 */     this.changeSupport.firePropertyChange("policestation", oldPolicestation, policestation);
/*     */   }
/*     */   
/*     */   public String getLocation() {
/* 224 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(String location) {
/* 228 */     String oldLocation = this.location;
/* 229 */     this.location = location;
/* 230 */     this.changeSupport.firePropertyChange("location", oldLocation, location);
/*     */   }
/*     */   
/*     */   public String getWeapons() {
/* 234 */     return this.weapons;
/*     */   }
/*     */   
/*     */   public void setWeapons(String weapons) {
/* 238 */     String oldWeapons = this.weapons;
/* 239 */     this.weapons = weapons;
/* 240 */     this.changeSupport.firePropertyChange("weapons", oldWeapons, weapons);
/*     */   }
/*     */   
/*     */   public String getStolengoods() {
/* 244 */     return this.stolengoods;
/*     */   }
/*     */   
/*     */   public void setStolengoods(String stolengoods) {
/* 248 */     String oldStolengoods = this.stolengoods;
/* 249 */     this.stolengoods = stolengoods;
/* 250 */     this.changeSupport.firePropertyChange("stolengoods", oldStolengoods, stolengoods);
/*     */   }
/*     */   
/*     */   public String getCriminalvehicledetails() {
/* 254 */     return this.criminalvehicledetails;
/*     */   }
/*     */   
/*     */   public void setCriminalvehicledetails(String criminalvehicledetails) {
/* 258 */     String oldCriminalvehicledetails = this.criminalvehicledetails;
/* 259 */     this.criminalvehicledetails = criminalvehicledetails;
/* 260 */     this.changeSupport.firePropertyChange("criminalvehicledetails", oldCriminalvehicledetails, criminalvehicledetails);
/*     */   }
/*     */   
/*     */   public Integer getTimeH() {
/* 264 */     return this.timeH;
/*     */   }
/*     */   
/*     */   public void setTimeH(Integer timeH) {
/* 268 */     Integer oldTimeH = this.timeH;
/* 269 */     this.timeH = timeH;
/* 270 */     this.changeSupport.firePropertyChange("timeH", oldTimeH, timeH);
/*     */   }
/*     */   
/*     */   public Integer getTimeM() {
/* 274 */     return this.timeM;
/*     */   }
/*     */   
/*     */   public void setTimeM(Integer timeM) {
/* 278 */     Integer oldTimeM = this.timeM;
/* 279 */     this.timeM = timeM;
/* 280 */     this.changeSupport.firePropertyChange("timeM", oldTimeM, timeM);
/*     */   }
/*     */   
/*     */   public Integer getDateD() {
/* 284 */     return this.dateD;
/*     */   }
/*     */   
/*     */   public void setDateD(Integer dateD) {
/* 288 */     Integer oldDateD = this.dateD;
/* 289 */     this.dateD = dateD;
/* 290 */     this.changeSupport.firePropertyChange("dateD", oldDateD, dateD);
/*     */   }
/*     */   
/*     */   public Integer getDateM() {
/* 294 */     return this.dateM;
/*     */   }
/*     */   
/*     */   public void setDateM(Integer dateM) {
/* 298 */     Integer oldDateM = this.dateM;
/* 299 */     this.dateM = dateM;
/* 300 */     this.changeSupport.firePropertyChange("dateM", oldDateM, dateM);
/*     */   }
/*     */   
/*     */   public Integer getDateY() {
/* 304 */     return this.dateY;
/*     */   }
/*     */   
/*     */   public void setDateY(Integer dateY) {
/* 308 */     Integer oldDateY = this.dateY;
/* 309 */     this.dateY = dateY;
/* 310 */     this.changeSupport.firePropertyChange("dateY", oldDateY, dateY);
/*     */   }
/*     */   
/*     */   public Integer getPolicediv() {
/* 314 */     return this.policediv;
/*     */   }
/*     */   
/*     */   public void setPolicediv(Integer policediv) {
/* 318 */     Integer oldPolicediv = this.policediv;
/* 319 */     this.policediv = policediv;
/* 320 */     this.changeSupport.firePropertyChange("policediv", oldPolicediv, policediv);
/*     */   }
/*     */   
/*     */   public String getDetails() {
/* 324 */     return this.details;
/*     */   }
/*     */   
/*     */   public void setDetails(String details) {
/* 328 */     String oldDetails = this.details;
/* 329 */     this.details = details;
/* 330 */     this.changeSupport.firePropertyChange("details", oldDetails, details);
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 334 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 338 */     Double oldLatitude = this.latitude;
/* 339 */     this.latitude = latitude;
/* 340 */     this.changeSupport.firePropertyChange("latitude", oldLatitude, latitude);
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/* 344 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/* 348 */     Double oldLongitude = this.longitude;
/* 349 */     this.longitude = longitude;
/* 350 */     this.changeSupport.firePropertyChange("longitude", oldLongitude, longitude);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 355 */     int hash = 0;
/* 356 */     hash += (this.id != null) ? this.id.hashCode() : 0;
/* 357 */     return hash;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object object) {
/* 363 */     if (!(object instanceof CrimeReports2)) {
/* 364 */       return false;
/*     */     }
/* 366 */     CrimeReports2 other = (CrimeReports2)object;
/* 367 */     if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
/* 368 */       return false;
/*     */     }
/* 370 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 375 */     return "policedataapp.CrimeReports2[ id=" + this.id + " ]";
/*     */   }
/*     */   
/*     */   public void addPropertyChangeListener(PropertyChangeListener listener) {
/* 379 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */   
/*     */   public void removePropertyChangeListener(PropertyChangeListener listener) {
/* 383 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\CrimeReports2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */