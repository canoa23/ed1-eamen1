/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

import Presentacion.Formulario;

/**
 *
 * @author Hugo
 */
public class FormularioCovid {
VectorNBits n;

    public FormularioCovid() {
    n = new VectorNBits(100,35);
    }

    public void Insertar(String Nombre,int Nro,int edad, int peso,boolean sexo,boolean fiebre,boolean tos,boolean dolorgarganta,
                         boolean dolorcabeza,boolean faltarespiracion,boolean diarrea,boolean dolormuscular,boolean perdidaolfato,
                         boolean perdidagusto){
    int dato =0;
    int mask = Nro;
    dato = dato|mask;//ya uso los primeros 7 bits
    
    mask = edad;
    mask = mask<<7;
    dato = dato|mask;//ya van 14 bits
    
    mask = peso;
    mask = mask<<14;
    dato = dato|mask;//ya van 25 bits
    
    mask = sexo ? 1 : 0;
    mask = mask<<25;
    dato = dato|mask;
    
    mask = fiebre? 1:0;
    mask=mask<<26;
    dato=dato|mask;
    
    mask =tos? 1:0;
    mask=mask<<27;
    dato = dato|mask;
    mask = dolorgarganta? 1:0;
    mask = mask<<28;
    dato = dato|mask;
    mask = dolorcabeza?1:0;
    mask = mask<<29;
    dato = dato|mask;
    mask = faltarespiracion?1:0;
    mask = mask<<30;
    dato = dato|mask;
    mask = diarrea?1:0;
    mask = mask<<31;
    dato = dato|mask;//dato ya esta lleno
    int dato2 =0;
    mask = dolormuscular?1:0;
    dato2 = dato2|mask;
    mask = perdidaolfato?1:0;
    mask=mask<<1;
    dato2 = dato2|mask;
    mask = perdidagusto?1:0;
    mask = mask<<2;
    dato2 = dato2|mask;
    n.Insertar(dato, dato2,Nombre,Nro);
    
    }
    
    public String Leer(int pos){
    return n.AString(pos);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     new Formulario().setVisible(true);   
    }
    
}
