/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pconjunto;
//import Negocio.Conjunto;

import Negocio.Conjunto;

/**
 *
 * @author Canoa
 */
public class PConjunto {

    public static void main(String[] args) {
       //public static void main(String[] args) {
        // TODO code application logic here
        Conjunto A = new Conjunto();
        A.insertar(2);
        A.insertar(8);
        A.insertar(2);
        A.insertar(7);
        System.out.println(A);
        A.eliminar(2);
        A.eliminar(5);

        Conjunto B = new Conjunto();
        B.insertar(2);
        B.insertar(8);
        B.insertar(21);
        B.insertar(3);
        B.insertar(35);
        System.out.println(B);

        Conjunto C = new Conjunto();
        // C.Union(A, B);
        C.Interseccion(A, B);
        System.out.println(C);
    
    }
}
