
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Hugo
 */
public class Ave {
private char sexo;
private int edad;
private static int Nroaves = 0;

    public Ave(char sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
        Nroaves++;
    }

    public static int getNroaves() {
        return Nroaves;
    }
    public void QuienSoy(){
    System.out.println(this.sexo);
    System.out.println(this.edad);
    }
    /**
     * @param args the command line arguments
     */
  
}
