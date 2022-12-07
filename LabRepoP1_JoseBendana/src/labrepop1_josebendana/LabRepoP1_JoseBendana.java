package labrepop1_josebendana;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LabRepoP1_JoseBendana {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        int opcion = 1;
        while(opcion!= 3){
            System.out.println("-------------------MENU DE EJERCICIOS-------------------");
            System.out.println();
            System.out.println("                  1.  Ajedrez Nórdico");
            System.out.println("              2.  Sistema de venta de carros");
            System.out.println("                        3.  Salir");
            System.out.println();
            System.out.print("Ingrese el ejercicio a evaluar: ");
            opcion = menu.nextInt();
            switch(opcion){
                case 1:
                    String[][] matriz = crearmatriz();
                    seguir(matriz);
                    break;
                case 2:
                    carro();
                    break;
                case 3:
                    System.out.println("Saliendo.....");
                    System.out.println("Ha salido con exito");
                    System.out.println("Gracias por evaluar mi Lab de repo");
                    break;
                default:
                    System.out.println("Ejercicio no valido, ingrese el ejercicio de nuevo");
                    break;
            }
        }
    }
    
    public static void carro(){
        char resp = 's';
        Scanner num = new Scanner(System.in);
        Scanner carac = new Scanner (System.in);
        Scanner orac = new Scanner(System.in);
        ArrayList<Carro> lista = new ArrayList();
        do{
            System.out.println("""
                               ----Menu Hermanos Rodriguez----
                               1. Ingresar un carro
                               2. Modificar un carro
                               3. Leer la lista de carros
                               4. Eliminar un carro
                               """);
            System.out.print("Ingrese una opcion: ");
            int opcion = num.nextInt();
            switch(opcion){
                case 1:
                    System.out.print("Ingrese el VIN: ");
                    String vin = orac.nextLine();
                    System.out.print("Ingrese la marca: ");
                    String marca = orac.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = orac.nextLine();
                    System.out.print("Ingrese el color: ");
                    String color = orac.nextLine();
                    System.out.print("Ingrese el year: ");
                    int year = num.nextInt();
                    lista.add(new Carro(vin, marca, modelo, color, year));
                    System.out.println("---Se ha ingresado un carro exitosamente---");
                    break;
                case 2:
                    if(lista.size()>0){
                        System.out.println("---Lista de Carros---");
                        for (int i = 1; i <= lista.size(); i++) {
                            System.out.println(i + ".  " + lista.get(i - 1));
                        }
                        System.out.println();
                        boolean flag;
                        do{
                            System.out.print("Ingrese el carro que quiere modificar: ");
                            int modcar = num.nextInt();
                            if((modcar>=0)&&(modcar<=lista.size())){
                                System.out.print("Ingrese la marca: ");
                                String nuevamarca = orac.nextLine();
                                lista.get(modcar-1).setMarca(nuevamarca);
                                System.out.print("Ingrese el modelo: ");
                                String nuevomodelo = orac.nextLine();
                                lista.get(modcar-1).setModelo(nuevomodelo);
                                System.out.print("Ingrese el color: ");
                                String nuevocolor = orac.nextLine();
                                lista.get(modcar-1).setColor(nuevocolor);
                                System.out.print("Ingrese el year: ");
                                int nuevoyear = num.nextInt();
                                lista.get(modcar-1).setYear(nuevoyear);
                                System.out.println("---Se ha modificado el carro exitosamente---");
                                flag = false;
                            }else{
                                System.out.println("---Carro no valido---");
                                System.out.println("---Ingrese un carro valido---");
                                flag = true;
                            }
                        }while(flag);
                    }else{
                        System.out.println("---La lista esta vacia---");
                    }
                   break;
                case 3:
                    if (lista.size()<=0) {
                        System.out.println("---La lista esta vacia---");
                    }else{
                        System.out.println("---Lista de Carros---");
                        for (int i = 1; i <= lista.size(); i++) {
                            System.out.println(i + ".  " + lista.get(i - 1));
                        }
                    }
                    break;
                case 4:
                    if (lista.size()>0) {
                        System.out.println("---Lista de Carros---");
                        for (int i = 1; i <= lista.size(); i++) {
                                System.out.println(i + ".  " + lista.get(i - 1));
                        }
                        int delete;
                        boolean bandera;
                        do{
                            System.out.print("Ingrese el carro que quiere eliminar: ");
                            delete = num.nextInt();
                            if((delete>=0)&&(delete<=lista.size())){
                                lista.remove(delete-1);
                                System.out.println("---Se ha eliminado el carro exitosamente---");
                                bandera = false;
                            }else{
                                System.out.println("---Carro no valido---");
                                System.out.println("Ingrese un carro valido");
                                bandera = true;
                            }
                        }while(bandera);
                    }else{
                        System.out.println("---La lista esta vacia---");
                    }
                    break;
                default:
                    System.out.println("Opcion no valida, ponga una que se pueda evaluar.");
                    break;
            }
            if ((opcion>=1)&&(opcion<=4)) {
                System.out.print("Desea ingresar a otra opcion: ");
                resp = carac.next().charAt(0);
            }
            
        }while((resp=='s')||(resp=='S'));
    }
    
    public static String[][] crearmatriz(){
        String[][] matriz = new String[9][9];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (((i==3&&j==0))||((i == 4 && j == 0))||((i==5&&j==0))||((i==8&&j==3))||((i == 8&& j == 4))||((j==5&&i==8))||((i==4&&j==1))||((i==4&&j==7))||(i==0&&j==3)||(i==0&&j==4)||(i==0&&j==5)||(i==1&&j==4)||(i==8&&j==3)||(i==8&&j==4)||(i==8&&j==5)||(i==7&&j==4)||(i==3&&j==8)||(i==4&&j==8)||(i==5&&j==8)) {
                    matriz[i][j] = "[*]";
                } else if ((i==2&&j==4)||(i==3&&j==4)||(i==4&&j==2)||(i==4&&j==3)||(i==5&&j==4)||(i==4&&j==4)||(i==4&&j==5)||(i==4&&j==6)||(i==6&&j==4)) {
                    if (i==4&&j==4) {
                        matriz[i][j]="[R]";
                    }else{
                        matriz[i][j] = "[+]";
                    }
                } else {
                    matriz[i][j] = "[ ]";
                }
            }
        } 
        return matriz;
    }
        
    public static String[][] mostrar(String[][] matriz){
        for (int k = 0; k < 9; k++) {
            if (k==0) {
                System.out.print("  ");
            }
            System.out.print(k+"  ");
        }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            System.out.print (i);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();   
        }
        return matriz;
    }
    public static void seguir(String[][] matriz){
        int numran = random();
        System.out.println();
        int evaluar;
        mostrar(matriz);
        do {
            if (numran%2==0){
                matriz = jugador1(matriz);
                matriz = jugador2(matriz);
                evaluar = evaluar(matriz);
            }else{
                matriz = jugador2(matriz);
                matriz = jugador1(matriz);
                evaluar = evaluar(matriz);
            }
            if (evaluar == 1) {
                    System.out.println("Ha ganado el jugador 2, enhorabuena");
                }else if(evaluar ==3){
                    System.out.println("Ha ganado el jugador 1, emhorrabuena");
                }
            //no dAAAAAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;
        } while ((evaluar == 2));
    }
    public static int random(){
        int num = new Random().nextInt((10 - 0) + 1) + 0;
        return num;
    }
    
    public static String[][] jugador1(String[][] matriz){
        Scanner jug1 = new Scanner(System.in);
        int fila;
        int columna;
        int fila2;
        int columna2;
        boolean flag=false;
        do {
            System.out.print("Ingrese la coordenanda  de la ficha que quiere mover jugador 1[num,num]: ");
            String coord = jug1.nextLine();
            fila = Character.getNumericValue(coord.charAt(0));
            columna = Character.getNumericValue(coord.charAt(2));
            if (matriz[fila][columna].equals("[*]")){
                do {
                    System.out.print("Ingrese la coordenada de donde quiere mover la pieza jugador 1[num,num]: ");
                    String coord2 = jug1.nextLine();
                    fila2 = Character.getNumericValue(coord2.charAt(0));
                    columna2 = Character.getNumericValue(coord2.charAt(2));
                    if ((fila2!=fila)&&(columna!=columna)){
                        System.out.println("No se puede mover en diagonal, ESO ES ILEGAL");
                        flag = false;
                    }else if((fila2>8||columna2>8)){
                        System.out.println("No se puede salir del tablero, ESO ES ILEGAL");
                        flag = false;
                    }else if(matriz[fila2][columna2].equals("[+]")){
                        System.out.println("solo se puede en espacios vacios, LO QUE QUERES HACER ES ILEGALISIMO");
                        flag = false;
                    }else if ((fila==fila2)&&(columna==columna2)){
                        System.out.println("No te podes mover a la misma posidion, ILEGAL");
                        flag = false;
                    }else{
                        matriz = mover(matriz, fila, columna, fila2, columna2);
                        flag = true;
                    }
                } while (flag == false);
            }else{
                System.out.println("Esa coordenada esta vacio o no pertenece a su respectiva ficha");
                System.out.println("Ingrese otra coordenada");
            }
        }while(flag==false);
        return matriz;
    }
    
    public static String[][] jugador2(String[][] matriz){
        Scanner jug2 = new Scanner(System.in);
        int fila;
        int columna;
        int fila2;
        int columna2;
        boolean flag= false;
        do {
            System.out.print("Ingrese la coordenanda  de la ficha que quiere mover jugador 2 [num,num]: ");
            String coord = jug2.nextLine();
            fila = Character.getNumericValue(coord.charAt(0));
            columna = Character.getNumericValue(coord.charAt(2));
            if (matriz[fila][columna].equals("[+]")||(matriz[fila][columna].equals("[R]"))){
                do {
                    System.out.print("Ingrese la coordenada de donde quiere mover la pieza jugador 2[num,num]: ");
                    String coord2 = jug2.nextLine();
                    fila2 = Character.getNumericValue(coord2.charAt(0));
                    columna2 = Character.getNumericValue(coord2.charAt(2));
                    if ((fila2!=fila)&&(columna2!=columna)){
                        System.out.println("No se puede mover en diagonal, ESO ES ILEGAL");
                        flag = false;
                    }else if((fila2>8||columna2>8)){
                        System.out.println("No se puede salir del tablero, ESO ES ILEGAL");
                        flag = false;
                    }else if(matriz[fila2][columna2].equals("[*]")){
                        System.out.println("solo se puede en espacios vacios, LO QUE QUERES HACER ES ILEGALISIMO");
                        flag = false;
                    }else if ((fila==fila2)&&(columna==columna2)){
                        System.out.println("No te podes mover a la misma posidion, ILEGAL");
                        flag = false;
                    }else{
                        matriz = mover(matriz, fila, columna, fila2, columna2);
                        flag = true;
                    }
                } while (flag==false);
            }else{
                System.out.println("Esa coordenada esta vacio o no pertenece a su respectiva ficha");
                System.out.println("Ingrese otra coordenada");
            }
        }while(flag == false);
        return matriz;
    }
    
    public static String[][] mover(String[][] matriz, int fila, int columna, int fila2, int columna2){
        if ((fila==fila2)&&(columna<columna2)){
            for (int i = columna; i < columna2; i++) {
                matriz[fila][i]="[ ]";
            }
        } else if ((fila==fila2)&&(columna>columna2)){
            for (int e = columna; e < columna; e--) {
                matriz[fila][e]="[ ]";
            }
        } else if ((fila>fila2)&&(columna==columna)){
            for (int o = fila; o < fila; o--) {
                matriz[o][columna]="[ ]";
            }
        } else if ((fila<fila2)&&(columna==columna2)){
            for (int a = fila; a < fila2; a++) {
                matriz[a][columna]="[ ]";
            }
        }
        matriz[fila][columna]="[ ]";
        int i = fila;
        int j = columna;
        if ((((i==3&&j==0))||((i == 4 && j == 0))||((i==5&&j==0))||((i==8&&j==3))||((i == 8&& j == 4))||((j==5&&i==8))||((i==4&&j==1))||((i==4&&j==7))||(i==0&&j==3)||(i==0&&j==4)||(i==0&&j==5)||(i==1&&j==4)||(i==8&&j==3)||(i==8&&j==4)||(i==8&&j==5)||(i==7&&j==4)||(i==3&&j==8)||(i==4&&j==8)||(i==5&&j==8))) {
            matriz[fila2][columna2]="[*]";
        }else if((i==2&&j==4)||(i==3&&j==4)||(i==4&&j==2)||(i==4&&j==3)||(i==5&&j==4)||(i==4&&j==4)||(i==4&&j==5)||(i==4&&j==6)||(i==6&&j==4)){
            matriz[fila2][columna2]="[+]";
        }else{
            matriz[fila2][columna2]="[*]";
        }
        mostrar(matriz);
        return matriz;
    }
    
    public static int evaluar (String[][] matriz){
        int cont=0;
        int cont2 = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((matriz[i][j].equals("[R]"))&&((matriz[0][j].equals("[R]"))||(matriz[i][0].equals("[R]")))){
                    cont++;
                    
                }else if(matriz[i][j].equals("[ ]")){
                    cont2++;
                }
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("[R]")){
                    cont2++;
                }
            }
        }
        if (cont>0){
            return 1;
        }else if(cont==0){
            return 2;
        }else if(cont2>0){
            return 3;
        }
    return 2;
    }
}
