/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class Bitwise {
    int x;
    
    public Bitwise(){
        this.x = 0;
    }
    
    public void EncenderBit(int pos){
        if (pos <= 32){
            int mask = 1;
            mask = mask << pos-1;
            x = x | mask;
        }
    }    
    
    public void ApagarBit(int pos){
        if (pos <= 32){
            int mask = 1;
            mask = mask << pos-1;
            mask = ~mask;
            x = x & mask;
        }
    }
    
    public int GetBit(int pos){
        int mask = 1;
        mask = mask << pos-1;
        mask = mask & x;
        mask = mask >>> pos-1;
        return (mask);
    }    
        
    public String toString(){    
        String S = "X = ";
        for (int i = 32; i >= 1; i--){
            S = S + " " + GetBit(i);
        }
        return(S);
    }
                    
    
    
    
}
