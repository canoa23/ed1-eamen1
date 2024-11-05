/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pbitwise;

import Negocio.Bitwise;

/**
 *
 * @author Canoa
 */
public class PBitwise {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Bitwise P = new Bitwise();
        System.out.println(P);
        P.EncenderBit(1);
        P.EncenderBit(2);
        P.EncenderBit(3);
        P.EncenderBit(4);
        System.out.println(P);
        P.ApagarBit(2);
        P.ApagarBit(1);
        P.ApagarBit(32);
        P.ApagarBit(31);
        P.EncenderBit(32);
        System.out.println(P);
    }
}
