/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hugo
 */
public class Canario extends Ave{

    public Canario(double tamaño, char sexo, int edad) {
        super(sexo, edad);
        this.tamaño = tamaño;
    }
private double tamaño;

  
public String Altura(){
String salida = "";
if (tamaño>30){
  salida = "Alto";
  }
if (tamaño<=30 && tamaño>=15){
  salida = "Mediano";
  }
if (tamaño<15){
  salida = "Bajo"; 
  }
return salida;
}

public void ModificarTamaño(double niu){
this.tamaño = niu;
}

}
