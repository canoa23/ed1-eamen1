/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progfraccion;

/**
 *
 * @author Hugo
 */
public class ProgFraccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CFraccion A = new CFraccion();
        A.setNum(3);
        A.setDeno(8);
        A.setSigno('+');
        
        CFraccion B = new CFraccion('-',4,3);
        System.out.println(A);
        System.out.println(B);
        
        
        
    }
    
}
