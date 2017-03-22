/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd_main;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro-Ruiz
 */
public class ManejoMatrices {
    
    /*Matrices dinamicas*/
    ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
    
    
    ArrayList<ArrayList<String>> llenaMatriz(int linea, String resp){//linea = numero en la fila
                                                                            //resp = valores de la fila 
        mat.add(new ArrayList<String>());//Ingresa una nueva fila a la matriz
        String[] parts = resp.split("\t");//Separa la cadena
        mat.get(linea).addAll(Arrays.asList(parts)); //Ingresa los caracteres en las columnas
        return mat;
    }
    
    ArrayList<ArrayList<String>> llenaEntry(int linea, String resp){//linea = numero en la fila  ///Llena los datos de estrada
                                                                            //resp = valores de la fila 
        mat.add(new ArrayList<String>());//Ingresa una nueva fila a la matriz
        mat.get(linea).add(resp); //Ingresa los caracteres en las columnas
        return mat;
    }
    
    String mostrarMatriz(ArrayList<ArrayList<String>> mat){
        String imprime = "";
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                imprime = imprime + mat.get(i).get(j) + "\t" ;
            }
            imprime = imprime + "\r\n";
        }
        return imprime;
    }
    
    String getEstado(ArrayList<ArrayList<String>> afd, String estado, String caracter){
        mat = afd;
        String temp = "Error";
        int fila=-1, columna=-1;
        for (int i = 0; i < mat.get(0).size(); i++) {//obtener posicion del caracter del alfabeto           
            if(mat.get(0).get(i).equals(caracter)){
                fila = i;//obtener posicion
                i = mat.get(0).size();//salir del ciclo
            }
        }
        for (int i = 0; i < mat.size(); i++) {//obtener posicion del caracter del estado
            if(mat.get(i).get(0).equals(estado)){
                columna = i;//obtener posicion
                i = mat.size();//salir del ciclo
            }
        }
        
        if (fila == -1 || columna == -1) {//Vemos si tiene un error la cadena, que no coincida con un estado o alfabeto
            return temp;
        }else{
            return (mat.get(columna).get(fila));   
        } 
    }
    
    String resultado(ArrayList<String> entradas, ArrayList<String> estados, ArrayList<String> aceptacion){
        String temp = "";
        for (int i = 0; i < entradas.size(); i++) {
            temp = temp + entradas.get(i) + "\t" + estados.get(i) + "\t" + aceptacion.get(i) + "\r\n";
        }
        return temp;
    }
    
    
    //TRATO DE VECTORES//
    ArrayList<String> covertirToVector(ArrayList<ArrayList<String>> afd){
        ArrayList<String> vector = new ArrayList<String>();
        for (int i = 0; i < afd.size(); i++) {
            vector.add(afd.get(i).get(0));
        }
        return vector;
    }
    
    String mostrarVector(ArrayList<String> vect){
        String imprime = "";
        for (int i = 0; i < vect.size(); i++) {
            imprime = imprime + vect.get(i) + "\r\n" ;
        }
        return imprime;
    }
    
    Boolean compararVectores(ArrayList<String> vectx, ArrayList<String> vecty){//compara 2 vectores y si son identicos regresa true
        int count = 0;
        for (int i = 0; i < vectx.size(); i++) {//recorre columna matriz
            for (int j = 0; j < vecty.size(); j++) {//recorre filas matriz
                if (vectx.get(i).equals(vecty.get(j))) {
                    count++;
                    j = vecty.size();
                }
            }
        }
        if(vectx.size() == count){
            return true;
        }else{
            return false;
        }
    }
}
