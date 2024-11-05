/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class CFraccion { int num; //indica el numerador de la Fraccion + el signo de la fracción
                        int deno; //indica el demoninador de la Fracción

    public CFraccion() {
        this.num = 0;
        this.deno = 1;
    }

    public CFraccion(char signo, int num, int deno) {
        if (signo == '+'){
            this.num = + Math.abs(num);}
        else {
            this.num = - Math.abs(num);
        }
        
        this.num = num;
        this.deno = deno;
    }
//modifica el numerador de la fraccion
    public void setNum(int num) {
        if (this.num > 0){
            this.num = + Math.abs(num);
        }else{
            this.num = - Math.abs(num);
        }
    }
//modifica el denominador de la fraccion
    public void setDeno(int deno) {
        if (deno == 0) {
            System.out.println("Error: denominador = 0");
            System.exit(1);
        }else{
            this.deno = deno;       
        }
    }

    public void setSigno(char signo){
        if (signo == '+'){
            this.num = + Math.abs(num);
        }else{
            this.num = - Math.abs(num);
        }     
    }    

    public int getNum() {
        return Math.abs(num);
    }

    public int getDeno() {
        return Math.abs(deno);
    }

    public int getSigno() {
        if (num > 0){
            return '+';
        }else{
            return '-';
        }                    
    }
    
    public String toString(){
        String S = "A = ";
        S = S + getSigno() + getNum() + "/" + getDeno();
        return S;
    }
    
    public void Suma(CFraccion A, CFraccion B){
        deno = A.getNum() * B.getDeno();
        num = (A.num() * B.getDeno()) + B.num() + A.getDeno(); 
        Simplificar();
    }    
    
    public void Resta(CFraccion A, CFraccion B){
        deno = A.getNum() * B.getDeno();
        num = (A.num * B.getDeno()) - B.num + A.getDeno(); 
        Simplificar();
    } 
    
    public void Multiplicación(CFraccion A, CFraccion B){
        num = A.num * B.num;
        deno = (A.getDeno() * B.getDeno()); 
        Simplificar();
    } 
    
    public void División(CFraccion A, CFraccion B){
        num = A.num * B.getDeno();
        deno = (A.getDeno() * B.num); 
        Simplificar();
    } 
    
    public int MCD(){
        int u = Math.abs(num);
        int v = Math.abs(deno);
        if (v == 0)
            return u;
        else{
            int z;
            while (v != 0){
                z = u % v;
                u = v;
                v = z;
            }
            return(u);
        }
    }
    
    public void Simplificar(){
        int x = MCD();
        num = num/x; 
        deno = deno/x;
    }
    
    
    
    
}
