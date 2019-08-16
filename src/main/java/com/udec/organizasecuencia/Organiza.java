/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.organizasecuencia;
/**
 * Se implementa la libreria java.util.Scanner para el uso d entrada or consola
 * de los parametros usados en el programa.
 */
import java.util.Scanner;

/**
 * 
 * @author AndresChila, Tatiana Moreno
 */
public class Organiza {
    /**
     * Se usa la variable de tipo byte array en el cual se guarda la cadena
     * previamente convertida 
     */
    private byte[] numeros;
    /**
     * Se ua la variable de tipo String array el cual recibe y guarda la secuencia inicial
     */
    private String[] capturaArray;
    /**
     * Se usa las variables de tipo byte que muestra el numero menor y el contador 
     * para analizar los numeros faltantes de la serie
     */
    private byte menor, acumulador;
    /**
     * Metodo que separa por espacios los numeros ingresados
     */
    public Organiza(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite la secuencia separando cada numero por un espacio:  ");
        //Lectura de la cantidad de numeros a organzar
        String array = scanner.nextLine();
        capturaArray = array.split(" ");
        numeros = new byte[capturaArray.length];
        for(int i=0;i< capturaArray.length;i++){
            numeros[i] = Byte.parseByte(capturaArray[i]);
        }
        Burbuja();
        Secuencia();
    }
    /**
     * Metodo burbuja propio de internet que organiza de menor a mayor
     */
    public void Burbuja(){
        for(int i = 0; i < numeros.length - 1; i++){
            for(int j = 0; j < numeros.length - 1; j++){
                if (numeros[j] > numeros[j + 1]){
                    byte tmp = numeros[j+1];
                    numeros[j+1] = numeros[j];
                    numeros[j] = tmp;
                }
            }
        }
    }
    /**
     * Metodo que analiza y extrae los numeros faltantes
     */
    public void Secuencia(){
        menor = numeros[0];
        acumulador = menor;
        for(int i=0;i<numeros.length;i++){
            if(numeros[i] == acumulador){
                acumulador++;
            }
            else{
                System.out.println("Falta: "+ acumulador);
                acumulador++;
                i--;
            }
        }
    }
}
