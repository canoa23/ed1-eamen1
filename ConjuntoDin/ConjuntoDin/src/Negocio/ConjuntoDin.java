/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Negocio;

/**
 *
 * @author Hugo
 */
public class ConjuntoDin {   //representa del 0-9 4 bits
int v[];                     //+32 bit 
int CantEle;

public ConjuntoDin(){
v = new int[0];
CantEle = 0;
}

public void Insertar(int ele){
if ((ele>=0)&(ele<10)&(BuscarEle(ele)==-1)){ //si esta dentro de rango 0-9 y si no se encuentra ya
    int BitsNecesarios = (CantEle+1)*4;
    if (v.length<=(BitsNecesarios/32)&(BitsNecesarios%32>0)){
      AumentarCeldas();
    }
   BitsNecesarios = (CantEle*4)%32;//ahora sirve para guardar cuantos bits se estan usando actualmente
   int NumEntero = CalcularEntero(CantEle+1);//+1 porque queremos saber en donde se agregaria
   int mask = (int)((Math.pow(2, 4)-1));
   mask = mask<<BitsNecesarios;     
   mask = ~mask;             
   v[NumEntero]=v[NumEntero]&mask;     
   ele = ele<<BitsNecesarios;  
   v[NumEntero]=v[NumEntero]|ele;
   CantEle++;
   }
}

private int BuscarEle(int ele){//devuelve en que posicion se encuentra el elemento
int pos =-1;
int mask,CantBits;
for (int i=1;i<=CantEle;i++){
CantBits =(4*(i-1))%32;
mask=(int)((Math.pow(2, 4)-1));
mask=mask<<CantBits;
mask=mask&v[CalcularEntero(i)];
mask=mask>>>CantBits;          //                          4-1   32-28                         4-1
if (mask==ele) {                //                        36/4   32  28   24  20   16   12  8  4
   pos= i;                      //                          9    8   7    6   5    4    3   2  1
   break;
}
/*if ((CantBits+4)>32){
   int mask1=(int)((Math.pow(2, 4)-1));
   mask1=mask1>>>(32-CantBits);
   mask1=mask1&v[CalcularEntero(i)+1];
   mask1=mask1<<(32-CantBits);
   mask=mask|mask1;
if (mask==ele) break;
}*/
}
return pos;
}

public void Eliminar(int ele){
int pos = BuscarEle(ele);
if (pos>=0){
while(pos<CantEle) {    
int Siguiente =Sacar(pos+1);
InsertarEnPos(pos,Siguiente);
pos++;
}
InsertarEnPos(pos,0);
CantEle--;
}
}

private void InsertarEnPos(int pos,int ele){
int mask=(int)((Math.pow(2, 4)-1));
int CantBits = ((pos-1)*4)%32;
int CantEntero =CalcularEntero(pos);
mask=mask<<CantBits;
mask=~mask;
v[CantEntero]=v[CantEntero]&mask;
ele=ele<<CantBits;
v[CantEntero]=v[CantEntero]|ele;
}

private void AumentarCeldas(){
int[] newV = new int[v.length+1];
System.arraycopy(v, 0, newV, 0, v.length);
v = newV;
}

private int CalcularEntero(int pos){
return (((pos-1)*4)/32);
}

public int Sacar(int pos){
int CantBits = (4*(pos-1))%32;
int mask=(int)((Math.pow(2, 4)-1));
int NumEntero=CalcularEntero(pos); 
mask=mask<<CantBits; 
mask=mask&v[NumEntero]; 
mask=mask>>>CantBits;
return mask;
}

@Override
    public String toString() {
        String S="V=[";
        for(int i=1;i<=CantEle;i++){
        S=S+Sacar(i)+",";
        }
        S=S.replaceAll(",$", "");
        S=S+"]";
        return(S);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    ConjuntoDin a = new ConjuntoDin();
    a.Insertar(0);
    a.Insertar(1);
    a.Insertar(2);
    a.Insertar(3);
    a.Insertar(4);
    a.Insertar(5);
    a.Insertar(6);
    a.Insertar(7);
    a.Insertar(8);
    a.Insertar(9);
        System.out.println(a);
    a.Eliminar(9);
    a.Eliminar(1);
    a.Insertar(9);
        System.out.println(a);
    }

}
