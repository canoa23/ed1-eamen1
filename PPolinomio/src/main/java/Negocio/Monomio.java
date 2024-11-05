/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class Monomio {
    int coef; //El coeficiente incluye el signo
    int exp;
    
    
    public Monomio(){
        coef = 0;
        exp = 1;
    }
    
    public Monomio(char signo, int coef, int exp){
        this.exp = exp;
        if (signo == '+'){
            this.coef = Math.abs(coef);
        }else{
            if (signo == '-'){
                this.coef = Math.abs(coef);
            }else{
                System.out.println("Error de Signo");
            }
        }
    }
    
    public void SetCoeficiente(int coef){
        if (coef != 0) {
            if (this.coef >= 0)
                this.coef = Math.abs(coef);
            else
                this.coef = -Math.abs(coef);
        }else{ 
            System.out.println("El coeficiente no debe ser cero");
            System.exit(1);
        }
    }
    
    public void SetCoeficiente1(int coe){
        this.coef = coe;
    }
    
    public void SetExponente(int Exp){
        if (Exp >= 0){
            this.exp = Exp;
        }else{
            System.out.println("Error: Exponente negativo");
            System.exit(1);
        }
    }
    
    public void setSigno(char signo){
        if (signo == '+'){
            coef = Math.abs(coef);
        }else{
            coef = - Math.abs(coef);
        }
    }
    
    //Getters
    public int GetCoef(){
        return (Math.abs(coef));
    }
    public int GetExpo(){
        return exp;
    }
    
    public char GetSigno(){
        char r;
        if  (coef > 0){
            r = '+';
        }else{
            r = '-';
        }
        
        return r;
    }
    
    public int Evaluar(int x){
        int valor;
        //Math.pow(base, potencia);
        if (x != 0){
            valor = (int) (coef * Math.pow(x,exp));
        }else{
            valor = 0;
        }
        return valor;
    }
    
    public void Sumar(Monomio A, Monomio B){
        if (A.GetExpo() == B.GetExpo()){
            coef = A.GetCoef() + B.GetExpo();
            exp = A.GetExpo();
        }
    }
    
    public void Restar(Monomio A, Monomio B){
        if (A.GetExpo() == B.GetExpo()){
            coef = A.GetCoef() - B.GetCoef();
            exp = A.GetExpo();
        }
    }
    
    public void Multiplicar(Monomio A, Monomio B){
        coef = A.GetExpo() * B.GetCoef();
        exp = A.exp + B.exp;
    }
    
    public void Division(Monomio A, Monomio B){
        if (A.exp >= B.exp){
            coef = A.coef / B.exp;
            exp = A.exp - B.exp;
        }
        System.out.println("No se puede ejecutar la división");
    }
    
    public void Derivar(){
        if (exp == 0){
            coef = 0;
            exp = 1;
        }else{
            coef = coef * exp;
            exp = exp - 1 ;
        }
    }
    
    public void Integral(){
        if (exp == 0){
            coef = 0;
            exp = 1;
        }else{
            exp = exp + 1;
            coef = coef/exp;
        }
    }
    
    
    
    
    
    
}
