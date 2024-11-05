/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class VectorBits {
        int v[];
        int cant;
        int CantidadBits;
        
    public VectorBits(int NumElementos, int CantBits){
        int NumBits = NumElementos * CantBits;
        int NumEnteros = NumBits / 32;
        if ((NumBits % 32) != 0){
            NumEnteros++;
        }
        v = new int[NumEnteros];
        cant = NumElementos;
        CantidadBits = CantBits;
    }
    
    public void insertar(int ele, int pos){
        if (pos <= cant){
            int ele1 = ele;
            int mask = (int) Math.pow(2, CantidadBits)-1;
            int NumBits = CalcularBits(pos);
            int NumEntero = CalcularEntero(pos);
            mask = mask << NumBits;
            mask = ~mask;
            v[NumEntero] = v[NumEntero] & mask;
            ele = ele << NumBits;
            v[NumEntero] = v[NumEntero] | ele;
            
            if ((NumBits + CantidadBits) > 32){
                int mask1 = (int)Math.pow(2, CantidadBits)-1;
                mask1 = mask1 >>> (32 - NumBits);
                mask1 = ~mask1;
                v[NumEntero + 1] = v[NumEntero +1] & mask1;
                ele1 = ele1 >>> (32 - NumBits);
                v[NumEntero + 1] = v[NumEntero + 1] | ele1;
            }
        }
    }
                    
    public int sacar(int pos){        
        int mask = (int) ((Math.pow(2, CantidadBits)-1));
        int NumBits = CalcularBits(pos);
        int NumEntero = CalcularEntero(pos);
        mask = mask << NumBits;
        mask = mask & v[NumEntero];
        mask = mask >>> NumBits;
        
        if ((NumBits + CantidadBits) > 32){
            int mask1 = (int) ((Math.pow(2, CantidadBits)-1));
            mask1 = mask1 >>> (32 - NumBits);
            mask1 = mask1 & v[NumEntero + 1];
            mask1 = mask1 << (32 - NumBits);
            mask = mask | mask1;
        }
        return(mask);
    }
    
    private int CalcularBits(int pos){
        return (((pos - 1) * CantidadBits % 32));
    }
    
    private int CalcularEntero(int pos){
        return ((pos - 1) * CantidadBits/32);
    }
    
    public String toString(){
        String S = "V = [";
        for (int i = 1; i <= cant; i++){
            S = S + sacar(i) + ",";
        }
        S = S + "]";
        
        return (S);
    }
    
}
