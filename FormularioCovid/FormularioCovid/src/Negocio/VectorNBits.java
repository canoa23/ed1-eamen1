/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;
/**
 *
 * @author Hugo
 */
public class VectorNBits {
int v[];
int cant;
int CantidadBits;
String Nombres[];

public VectorNBits(int NumElementos, int CantBits){
int NumBits = NumElementos * CantBits;//calcula bits necesarios
int NumEnteros = NumBits / 32;//ve cuantos int se usan completamente
if ((NumBits%32)!=0){   //pregunta si entran cabales
NumEnteros++;// si hacen falta mas aumentar un entero extra
}
v = new int[NumEnteros];  //declara cuantos int seran necesarios en total
cant = NumElementos;//
CantidadBits = CantBits;
Nombres = new String[100];
}

public void Insertar(int ele1,int ele2,String Nombre,int pos){
int cont =1; 
Nombres[pos] = Nombre;
int NumBits = CalcularBits(pos);
int NumEntero = CalcularEntero(pos);
while (cont<=32){
int mask = 1;
mask = mask&ele1;
ele1 = ele1>>>1;
mask = mask<<NumBits;
NumBits++;
v[NumEntero]=v[NumEntero]|mask;
cont++;
if (NumBits==32){
NumBits=0;
NumEntero++;
}
}
cont =1;
while (cont<=3){
int mask = 1;
mask = mask&ele2;
ele2 = ele2>>>1;
mask = mask<<NumBits;
NumBits++;
v[NumEntero]=v[NumEntero]|mask;
cont++;
if (NumBits==32){
NumBits=0;
NumEntero++;
}
}
//meter el entero 1
//meter de un bit en un bit
//repeat until ele1 = 0
//repeat until ele2 = 0
}

public long Sacar(int pos) {
    int cont = 1;
    long mask;
    long result = 0;
    int NumBits = CalcularBits(pos);       
    int NumEntero = CalcularEntero(pos);   
    int aux = NumBits;                     
    int PosBit = 0;
    while (cont <= 35) {
        mask = 1L << NumBits;     //1L sirve para que trate al 1 como long         
        mask = mask & v[NumEntero];        
        mask = mask >> NumBits;
        result = result | (mask << PosBit);
        NumBits++;
        PosBit++;
        cont++;
        if (NumBits == 32) {
            NumBits = 0;      
            NumEntero++;        
           }
        if (cont == 1) {
            PosBit = 0;   
            PosBit = PosBit -aux; 
        }
    }

    return result;
}

/*public long Sacar(int pos){
int cont =1;
long mask;
long result=0;
int NumBits = CalcularBits(pos);
int aux = NumBits;
int NumEntero = CalcularEntero(pos);
while (cont<=35){
mask = 1;
mask = mask<<(NumBits);
mask = mask&v[NumEntero];
NumBits++;
mask=mask>>aux;
result=result|mask;
cont++;
if (NumBits%32==0){
NumEntero++;
}
}
return result;
}*/

public String AString(int pos){
String S="Datos:"+Nombres[pos]+ " Nro=";
long Num = Sacar(pos);
long mask = (long)(Math.pow(2, 7)-1);
mask = mask & Num;
S=S+mask+" Edad=";//metemos Nro
mask = (long)(Math.pow(2, 7)-1);
mask = mask<<7;
mask = mask & Num;
mask=mask>>>7;
S=S+mask+" Peso=";//metemos Edad
mask = (long)(Math.pow(2, 11)-1);
mask = mask<<14;
mask = mask &Num;
mask = mask>>>14;
S=S+mask+" Sexo=";
mask= 1;
mask=mask<<25;
mask = mask&Num;
mask = mask>>>25;
S =S+ Sexo(mask)+ " Fiebre=";
mask = 1;
mask=mask<<26;
mask = mask&Num;
mask = mask>>>26;
S = S+ SioNo(mask)+ " Tos=";
mask = 1;
mask=mask<<27;
mask = mask&Num;
mask = mask>>>27;
S = S+ SioNo(mask)+ " Dolor De Garganta=";
mask = 1;
mask=mask<<28;
mask = mask&Num;
mask = mask>>>28;
S = S+ SioNo(mask)+ " Dolor De Cabeza=";
mask = 1;
mask=mask<<29;
mask = mask&Num;
mask = mask>>>29;
S = S+ SioNo(mask)+ " Falta De Respiracion=";
mask = 1;
mask=mask<<30;
mask = mask&Num;
mask = mask>>>30;
S = S+ SioNo(mask)+ " Diarrea=";
mask = 1;
mask=mask<<31;
mask = mask&Num;
mask = mask>>>31;
S = S+ SioNo(mask)+ " Dolor Muscular=";
mask = 1;
mask=mask<<32;
mask = mask&Num;
mask = mask>>>32;
S = S+ SioNo(mask)+ " Perdida De Olfato=";
mask = 1;
mask=mask<<33;
mask = mask&Num;
mask = mask>>>33;
S = S+ SioNo(mask)+ " Perdida De Gusto=";
mask = 1;
mask=mask<<34;
mask = mask&Num;
mask = mask>>>34;
S = S+ SioNo(mask);
return S;
}

public String SioNo(long Num){
String S="";
if (Num==0) S="No";
if (Num==1) S="Si";
return S;
}

public String Sexo(long Num){
String S="";
if (Num==0) S= "Mujer";
if (Num==1) S= "Hombre";
return S;
}

    public void setNombre(String Nombre,int pos) {
    Nombres[pos]=Nombre;
    }

    public String getNombre(int pos) {
    return Nombres[pos];
    }

private int CalcularBits(int pos){
return (((pos-1)*35)%32);
}

private int CalcularEntero(int pos){
return (((pos-1)*35)/32);
}


    public static void main(String[] args) {
    }
}
