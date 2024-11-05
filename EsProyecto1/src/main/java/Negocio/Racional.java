/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class Racional {int numerador; //representa al numerador y signo   
                        int denominador;
//constructor por defecto 
    public Racional(){                    
        numerador = 0;
        denominador = 1;
    }    
                        
                        
//constructor sobrecargado                       
    public Racional(char signo, int numerador, int denominador) {
        if (denominador == 0){
            System.out.println("Error::Racional:Denominador no debe ser 0");
            System.exit(1);
        }
        else {
            if (signo == '+'){
                this.numerador = +Math.abs(numerador);
            }else{
                this.numerador = -Math.abs(numerador);
            }
        
       
        this.denominador = Math.abs(denominador);
        }
    }
    
    //modifica el numerador del racional
    public void setNumerador(int numerador) {
        if (this.numerador >= 0){
            this.numerador = + Math.abs(numerador);
        }else{
            this.numerador = -  Math.abs(numerador);
        }
        simplificar();

    }

    public void setDenominador(int denominador) {
        if (denominador == 0){
            System.out.println("Error::Setdenominador: Denominador no debe ser 0");
            System.exit(1);
        }else{ 
            this.denominador = denominador;
        }
        simplificar();
        
    }
          
    public void setSigno(char signo){
        if (signo == '+'){
            this.numerador = + Math.abs(numerador);
        }else{
            this.numerador = - Math.abs(numerador);           
        }
      
    }

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return Math.abs(numerador);
    }
    
    public char getSigno(){
        if (this.numerador >= 0)
            return ('+');
        else 
            return ('-');
    }
    
    public void Suma(Racional A, Racional B){
        int comunD = A.denominador * B.denominador;
        this.numerador = comunD/A.denominador * A.numerador + comunD/B.denominador * B.numerador;
        this.denominador = comunD;
        simplificar();
    }
    
    public void Resta(Racional A, Racional B){
        int comunD = A.denominador * B.denominador;
        this.numerador = comunD/A.denominador * A.numerador - comunD/B.denominador * B.numerador;
        this.denominador = comunD;
        simplificar();
    }
    
    public void simplificar(){
        
    }
    
    
}
