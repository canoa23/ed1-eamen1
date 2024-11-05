/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pvectorbits;

import Negocio.VectorBits;

/**
 *
 * @author Canoa
 */
public class PVectorbits {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //TODO code application logic here
                      //    (NElementos,CantBits)
        VectorBits x = new VectorBits(10,6);
            //(entero,pos)
        x.insertar(33,1);
        x.insertar(22,3);
        x.insertar(58,7);
        x.insertar(35,10);
        x.insertar(8,6);
        x.insertar(34,5);
        x.insertar(18,4);
        System.out.println(x);
        x.insertar(55,4);
        x.insertar(0, 2);
        System.out.println(x);
    }
}
