
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Canoa
 */
public class Conjuntobit {
    Bitwise C[];
    int cant;
    
    public Conjuntobit(int NEle){
        int Nbw = NEle / 32;
        if (NEle % 32 != 0){
            Nbw++;
        }
        this.C = new Bitwise[Nbw];
        cant = NEle;
        for (int i = 0; i <= Nbw-1; i++){
            C[i] = new Bitwise();
        }
    }
    
    public void Insertar(int ele){
        if (ele <= cant){
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].EncenderBit(Nbit);
        }else{
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuera de rango");
            System.exit(1);
        }
    }
    
    public void Eliminar(int ele){
        if (ele <= cant){
            int NBW = CalcNBW(ele);
            int Nbit = CalcNbit(ele);
            C[NBW].ApagarBit(Nbit);
        }else{
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuera de rango");
            System.exit(1);
        }
    }
    
    private int CalcNBW(int ele){
        return ((ele-1) / 32);
    }
    
    private int CalcNbit(int ele){
        return ( ((ele-1) % 32) + 1);
    }
    
    public boolean Pertenece(int ele){
        int NBW = CalcNBW(ele);
        int Nbit = CalcNbit(ele);
        
        return (C[NBW].GetBit(Nbit) == 1);
    }
    
    public String toString(){
        String S = "C = {";
        for (int i = 1; i <= cant; i++){
            if (Pertenece(i))
                S = S + i + ",";
        }
        S = S + "}";
        return S;
    }
    
    
    
    
    
}
