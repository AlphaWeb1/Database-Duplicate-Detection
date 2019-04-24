
package duplicate;

import java.awt.*;
import java.awt.print.*;


public  class Printer implements Printable {
private static Font sFont = new Font("Georgia", Font.PLAIN , 14);
 
@Override
 public int print (Graphics g, PageFormat Pf, int pageIndex) throws PrinterException{
  if (pageIndex > 0) return NO_SUCH_PAGE;
  Graphics2D g2 = (Graphics2D)g;
  g2.setFont (sFont);
  g2.setPaint (Color.black);
  g2.drawString (this.comp, 1000,1000 );
  return PAGE_EXISTS;
}
   static  String comp;
    public Printer(String comp){
     this.comp=comp;
    }

}