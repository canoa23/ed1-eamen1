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

public VectorNBits(int NumElementos, int CantBits){
int NumBits = NumElementos * CantBits;//calcula bits necesarios
int NumEnteros = NumBits / 32;//ve cuantos int se usan completamente
if ((NumBits%32)!=0){   //pregunta si entran cabales
NumEnteros++;// si hacen falta mas aumentar un entero extra
}
v = new int[NumEnteros];  //declara cuantos int seran necesarios en total
cant = NumElementos;//
CantidadBits = CantBits;
}

public void insertar(int ele, int pos){
if (pos <=cant){
    int ele1 = ele;
    int mask = (int)Math.pow(2, CantidadBits)-1;//carga una mascara con el rango maximo
    int NumBits = CalcularBits(pos);       //con pos = 1 se guarda un 0 //es cuantos bits a recorrer basado en la posicion
    int NumEntero = CalcularEntero(pos);   //devuelve desde que entero se comienza a guardar ese dato
    mask = mask<<NumBits;     //mueve la mask de full 1s hacia la posicion indicada.
    mask = ~mask;             //vuelve esa parte 0s y el resto 1s
    v[NumEntero]=v[NumEntero]&mask; //en la pos de vector 0 aplica un and con la mask, osea vuelve esa posicion puros ceros         
    ele = ele<<NumBits;  //alineamos los bits del int ele a la parte que acabamos de volver puros 0s
    v[NumEntero]=v[NumEntero]|ele;  //hacemos un or, guardando en v el elemento como bits
    if ((NumBits+CantidadBits/*6 en ejemplo*/)>32){  //si se desplazaron mas de 32 bits o menos pero sumado a la cantbits supera 32 
    int mask1=(int)Math.pow(2, CantidadBits)-1; //vuelve a cargar el rango maximo
    mask1=mask1>>>(32-NumBits);//en caso de un quebrado, recorre los 6 bits de la mascara eliminando dos, dejando los 4 de mas a la derecha 
    mask1=~mask1;//niega, quedando por ejemplo de 000...1111 a 111...0000
    v[NumEntero+1]=v[NumEntero+1]&mask1; //aplica un and, limpiando los 4 mas de la derecha del v[1]
    ele1=ele1>>>(32-NumBits); //realiza la misma operacion con el valor que ya se guardo los dos mas de la derecha
    v[NumEntero+1]=v[NumEntero+1]|ele1;//aplica un or, guardando los 4 bits que faltaron en el segundo v[]
    }
}
}

public int sacar(int pos){
int mask=(int)((Math.pow(2, CantidadBits)-1));//crea una maskara con 6 1s a la derecha
int NumBits=CalcularBits(pos);  //con pos = 1 se guarda un 0- 2 son 6- 3 son 12 y asi, es cuantos bits a recorrer basado en la posicion
int NumEntero=CalcularEntero(pos); //siempre que son menos de 32 bits devuelve 0, sirve para recuperar en que int esta esa posicion
mask=mask<<NumBits; //recorre los 1s hacia la izquierda hasta la posicion deseada
mask=mask&v[NumEntero]; //aplica un and a la mask, basicamente copia los 1s en esa posicion 
mask=mask>>>NumBits; //Mueve de nuevo a la derecha el valor copiado, para obtener su valor real de nuevo
if ((NumBits+CantidadBits)>32){//si el numero esta partido en dos int
   int mask1=(int)((Math.pow(2, CantidadBits)-1));//carga una mascara con 6 1s 
   mask1=mask1>>>(32-NumBits);//en caso de un quebrado, recorre los 6 bits de la mascara eliminando dos, dejando los 4 de mas a la derecha
   mask1=mask1&v[NumEntero+1];//hace un and con el resto de bits
   mask1=mask1<<(32-NumBits);//retorna la mask1 a la posicion ini
   mask=mask|mask1;
}
return(mask);
}

private int CalcularBits(int pos){
return (((pos-1)*CantidadBits)%32);
}

private int CalcularEntero(int pos){
return (((pos-1)*CantidadBits)/32);
}

    @Override
    public String toString() {
        String S="V=[";
        for(int i=1;i<=cant;i++){
        S=S+sacar(i)+",";
        }
        S=S.replaceAll(",$", "");
        S=S+"]";
        return(S);
    }

    public static void main(String[] args) {
    VectorNBits x=new VectorNBits(10,6);
    x.insertar(33, 1);
    x.insertar(22, 3);
    x.insertar(58, 7);
    x.insertar(35, 10);
    x.insertar(8, 6);
    x.insertar(34, 5);
    x.insertar(18, 4);
        System.out.println(x);
        x.insertar(55, 4);
        System.out.println(x);
        //((Ele-RI)%32)+1
            
    }
}
