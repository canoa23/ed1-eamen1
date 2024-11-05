/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hugo
 */
public class Piolin extends Canario{

private int NroPeliculas;

    public Piolin(int NroPeliculas, double tamaño, char sexo, int edad) {
        super(tamaño, sexo, edad);
        this.NroPeliculas = NroPeliculas;
    }

   
    
    public static void main(String[] args) {
    Piolin P = new Piolin(3,0.12,'M',3);
    Loro L = new Loro('E',"Verde",'F',5);
    P.QuienSoy();
    L.QuienSoy();
    System.out.println(P.Altura());
    System.out.println(L.DeDondeEres());
    P.ModificarTamaño(0.26);
    System.out.println(P.Altura());
    L.setRegion('S');
    System.out.println(Ave.getNroaves());
    }
}
