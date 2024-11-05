/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hugo
 */
public class Loro extends Ave{
private char region;
private String color;

    public Loro(char region, String color, char sexo, int edad) {
        super(sexo, edad);
        this.region = region;
        this.color = color;
    }
public String DeDondeEres(){
String salida = "";
if (region=='N') salida = "Norte";
if (region=='S') salida = "Sur";
if (region=='E') salida = "Este";
if (region=='O') salida = "Oeste";
return salida;
}
    public void setRegion(char region) {
        this.region = region;
    }

}
