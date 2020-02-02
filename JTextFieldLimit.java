/*    */ package policedataapp;
/*    */ 
/*    */ import javax.swing.text.AttributeSet;
/*    */ import javax.swing.text.BadLocationException;
/*    */ import javax.swing.text.PlainDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JTextFieldLimit
/*    */   extends PlainDocument
/*    */ {
/*    */   private int limit;
/*    */   
/*    */   public JTextFieldLimit(int limit) {
/* 22 */     this.limit = limit;
/*    */   }
/*    */ 
/*    */   
/*    */   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
/* 27 */     if (str == null) {
/*    */       return;
/*    */     }
/*    */     
/* 31 */     if (getLength() + str.length() <= this.limit)
/* 32 */       super.insertString(offset, str, attr); 
/*    */   }
/*    */ }


/* Location:              E:\Documents\PoliceDataApp.jar!\policedataapp\JTextFieldLimit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */