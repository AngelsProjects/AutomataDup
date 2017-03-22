/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd_main;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro-Ruiz
 */
public class AutomataFuntions {
    
    ArrayList<ArrayList<String>> conjuntosFinales = new ArrayList<ArrayList<String>>();
    
    String muestraConjuntoFinal(){
        ManejoMatrices matriz = new ManejoMatrices();//Objeto matriz de la clase ManejoMatrices
        return matriz.mostrarMatriz(conjuntosFinales);
    }
    
    ArrayList<String> recorreAutom(ArrayList<ArrayList<String>> afd, String estado, ArrayList<String> entrada){//estado[i,0] = columna...caracter[0, i] = fila
       
        ManejoMatrices matriz = new ManejoMatrices();//Objeto matriz de la clase ManejoMatrices
        String sigEstado, cadena, estadoTemp = estado;
        ArrayList<String> estadosF = new ArrayList<String>();
                
        for(int j = 0; j < entrada.size(); j++) { 
            cadena = entrada.get(j);
            for (int i = 0; i < cadena.length(); i++) {
                sigEstado = matriz.getEstado(afd, estadoTemp, cadena.charAt(i)+"");
                estadoTemp = sigEstado;
            }
            estadosF.add(estadoTemp);//Agrega a un vector el ultimo estado en que quedo la entrada que se proceso
            estadoTemp = estado;
        }   
        return estadosF;//retorna el ultimo estado en que queda el automata
    }
    
    ArrayList<String> Aceptar(ArrayList<String> estadosF, ArrayList<String> edAceptacion){//procesa los conjuntoEstado finales 
                                                                                    //en que quedan las cadenas y regresa
                                                                                    //si es de aceptacion o no        
        ArrayList<String> Aceptacion = new ArrayList<String>();
        boolean var = false;
        for (int i = 0; i < estadosF.size(); i++) {
            for (int j = 0; j < edAceptacion.size(); j++) {
                if(estadosF.get(i).equals(edAceptacion.get(j))){
                    var = true;
                    j = edAceptacion.size();                    
                }
            }
            if(var){
                Aceptacion.add("Aceptacion");
                var = false;
            }else{
                Aceptacion.add("No Aceptacion");                
            }
        }
        return Aceptacion;//retorna vector de los conjuntoEstado aceptados o no
    }
        
    ArrayList<ArrayList<String>> reduccion(ArrayList<ArrayList<String>> afd, ArrayList<String> edAceptacion){
        
        //ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> matrizReducida, conjuntoEstados = new ArrayList<ArrayList<String>>();
        ArrayList<String> edNAcept, alfabeto = new ArrayList<>();
        ManejoMatrices matriz = new ManejoMatrices();
        //1ra Division
        edNAcept = separa(afd, edAceptacion);//Estados de no aceptacion de la matriz original 
//        JOptionPane.showMessageDialog(null, matriz.mostrarVector(edNAcept));
        //2do Paso
        alfabeto = alfabeto(afd);//Alfabeto de la matriz original
        
        conjuntoEstados.add(edNAcept);
        conjuntoEstados.add(edAceptacion);
        //
        
        //3do Paso
        matrizReducida = minimizar(afd, conjuntoEstados, alfabeto);
        
        return matrizReducida;
        //******///******///******///
        //return conjuntoEstados;
    }
    
    ArrayList<ArrayList<String>> minimizar(ArrayList<ArrayList<String>> afd, ArrayList<ArrayList<String>> conjuntoEstados, ArrayList<String> alfabeto){
        ///***********************AQUI ME QUEDE***************************///
        ArrayList<ArrayList<String>> temp, nuevoCojuntoTemp, nuevoConjuntoEstados;
        ArrayList<String> resultadoFinal = new ArrayList<String>();
        boolean igual = false;
        
        for (int x = 0; x < afd.size(); x++) {
            
            nuevoConjuntoEstados = new ArrayList<ArrayList<String>>();
//            nuevoCojuntoTemp = new ArrayList<ArrayList<String>>();
//            temp = new ArrayList<ArrayList<String>>();
            
            ManejoMatrices matrizz = new ManejoMatrices();
            
            for (int i = 0; i < conjuntoEstados.size(); i++) {
                if(comprobar(conjuntoEstados.get(i))){//comprueba que tenga mas de 2 conjuntoEstado
                    temp = construyeMatriz(afd, conjuntoEstados.get(i), alfabeto, conjuntoEstados);//construye la matriz
                    nuevoCojuntoTemp = traduce(construyeMatriz(afd, conjuntoEstados.get(i), alfabeto, conjuntoEstados), comparacionFilas(temp));//Obtenemos los nuevos estados 
                                       
                    for (int j = 0; j < nuevoCojuntoTemp.size(); j++) {//Se agregan los nuevos estados
                        nuevoConjuntoEstados.add(nuevoCojuntoTemp.get(j));//Guardamos los nuevos estados para el sig. proceso
                    }
//                    nuevoCojuntoTemp.clear();//Se limpia la matriz temporal para no ensimar info.
//                    temp.clear();//Se limpia la matriz temporal para no ensimar info.
                
                    //nuevoConjuntoEstados = comparacionFilas(temp);//Mis nuevos estados despues de una separacion en donde se agruparan
                    //comparar filas de la matriz para agrupar estados y rehacer matriz y agregar hacer nuevo conjunto de Estados////////////////////////////////////////////////////////*************************************************
                }else{
                    igual = true;
                }
            }
            
            if(!igual){
            conjuntoEstados = nuevoConjuntoEstados;
            }
//            ManejoMatrices matrizz = new ManejoMatrices();
//            JOptionPane.showMessageDialog(null, matrizz.mostrarMatriz(conjuntoEstados));
//            nuevoConjuntoEstados.clear();
        }
        
//        ManejoMatrices matrizz = new ManejoMatrices();
//        JOptionPane.showMessageDialog(null, matrizz.mostrarMatriz(conjuntoEstados));
        conjuntosFinales = conjuntoEstados;
        for (int j = 0; j < conjuntoEstados.size(); j++) {
            resultadoFinal.add("C"+j);
        }
        temp = matrizFinal(afd, resultadoFinal, alfabeto, conjuntoEstados);//construye la matriz
        return temp;
    }
    
    ArrayList<ArrayList<String>> matrizFinal(ArrayList<ArrayList<String>> afd, ArrayList<String> estados, ArrayList<String> alfabeto, ArrayList<ArrayList<String>> conjuntoEstados){//contruye una matriz a partir de los conjuntoEstado y alfabetos
        ManejoMatrices matriz = new ManejoMatrices();//Este metodo crea la matriz final 
        
        ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
        
        mat.add(alfabeto);
        for (int i = 1; i < estados.size()+1; i++) {
            mat.add(new ArrayList<String>());//Ingresa una nueva fila a la matriz
            mat.get(i).add(estados.get(i-1));
            for (int j = 1; j < alfabeto.size(); j++) {
                String direccion = matriz.getEstado(afd, conjuntoEstados.get(i-1).get(0), alfabeto.get(j));
                mat.get(i).add("C" + queConjunto(direccion, conjuntoEstados) + "");//en que conjunto esta
            }
        }
        return mat;
    }
    
    ArrayList<ArrayList<String>> comparacionFilas(ArrayList<ArrayList<String>> matrizTemp){
        
        ArrayList<ArrayList<String>> resultado = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp, temp2,tempResult;
        boolean ok = false;//, in = false; 
        //int pos = -1;
        if(matrizTemp.size() > 2){
            
        if(matrizTemp.size() > 3){//*/*/*/*/
            
        for (int i = 1; i < matrizTemp.size()-1; i++) {
            tempResult = new ArrayList<>();
            for (int j = i+1; j < matrizTemp.size(); j++) {
                temp = matrizTemp.get(i);
                temp2 = matrizTemp.get(j);
                temp.set(0, null);
                temp2.set(0, null);
                for (int k = 0; k < resultado.size(); k++) {//checa que no se repita un estado
                    if(resultado.get(k).contains(i+"") || resultado.get(k).contains(j+"")){
                        ok = true;                        
                    }
                }
                if(temp.equals(temp2) && !ok){//que la filas sean iguales y que no contenga el estado que se agrega
//                    in = true;
//                    pos = j;
                    if(!tempResult.contains(i+"")){ tempResult.add(i+""); }
                    tempResult.add(j+"");//se agrega el numero de fila en que esta el estado                    
                }
            }
//            if(in && pos != -1){
//                if(!tempResult.contains(i+"")){ tempResult.add(i+""); }
//                tempResult.add(pos+"");//se agrega el numero de fila en que esta el estado                         
//            }else{
//                if(ok){ tempResult.add(i+""); }
//            }
            
            ok = false;//in = ok = false;  
            //pos = -1;
            if(!tempResult.isEmpty()){ resultado.add(tempResult); }
//            resultado.add(tempResult);            
        }
        
//        ManejoMatrices matrizz = new ManejoMatrices();
//        JOptionPane.showMessageDialog(null, matrizz.mostrarMatriz(resultado));
        
        //resultado = traduce(resultado, matriz);//Se envia matriz con numeros y obtenemos los estados correspondientes
        
        }else{/////////*****************
            
            temp = matrizTemp.get(1);
            temp2 = matrizTemp.get(2);
            temp.set(0, null);
            temp2.set(0, null);
            if(temp.equals(temp2)){//que la filas sean iguales y que no contenga el estado que se agrega
                tempResult = new ArrayList<String>();
                tempResult.add(1+"");
                tempResult.add(2+"");//se agrega el numero de fila en que esta el estado
                resultado.add(tempResult);
            }else{       
                tempResult = new ArrayList<String>();
                tempResult.add(1+"");
                resultado.add(tempResult);
                tempResult = new ArrayList<String>();
                tempResult.add(2+"");
                resultado.add(tempResult);
            }
        }//Fin else
        
        }else{
            tempResult = new ArrayList<String>();
            tempResult.add(1+"");
            resultado.add(tempResult);
        }
//        ManejoMatrices matrizz = new ManejoMatrices();
//        JOptionPane.showMessageDialog(null, matrizz.mostrarMatriz(matrizTemp));
        
        return resultado;
    }
    
    ArrayList<ArrayList<String>> traduce(ArrayList<ArrayList<String>> matriz, ArrayList<ArrayList<String>> resultado){//cambia los numeros de la matriz por sus estados correspondientes
//        ManejoMatrices matrizz = new ManejoMatrices();
//        JOptionPane.showMessageDialog(null, matrizz.mostrarMatriz(matriz));
        for (int i = 0; i < resultado.size(); i++) {
            for (int j = 0; j < resultado.get(i).size(); j++) {
                for (int k = 0; k < matriz.size(); k++) {//recorrer la matriz para obtener estado
                    if (resultado.get(i).get(j).equals(k+"")){
                        resultado.get(i).set(j, matriz.get(k).get(0));
                    }
                }
            }
        }
        return resultado;
    }
    
    ArrayList<ArrayList<String>> construyeMatriz(ArrayList<ArrayList<String>> afd, ArrayList<String> estados, ArrayList<String> alfabeto, ArrayList<ArrayList<String>> conjuntoEstados){//contruye una matriz a partir de los conjuntoEstado y alfabetos
        ManejoMatrices matriz = new ManejoMatrices();
        
        estados.remove("");//quitamos espacios en blanco
        
        ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
        //JOptionPane.showMessageDialog(null, matriz.mostrarVector(estados));
        mat.add(alfabeto);
        for (int i = 1; i < estados.size()+1; i++) {
            mat.add(new ArrayList<String>());//Ingresa una nueva fila a la matriz
            mat.get(i).add(estados.get(i-1));
            for (int j = 1; j < alfabeto.size(); j++) {
                String direccion = matriz.getEstado(afd, estados.get(i-1), alfabeto.get(j));
                mat.get(i).add(queConjunto(direccion, conjuntoEstados)+"");//en que conjunto esta
            }
        }
        return mat;
    }
    
    int queConjunto(String estado, ArrayList<ArrayList<String>> conjuntoEstados){//retorna el conjunto al que pertenece
        int ok = -1;
        for (int i = 0; i < conjuntoEstados.size(); i++) {
            if(conjuntoEstados.get(i).contains(estado)){
                ok = i;
                i = conjuntoEstados.size();
            }
        }
        if (ok != -1) return ok; 
        else return -1;
    }
    
    boolean comprobar(ArrayList<String> vect){//comprueba que el vector contenga mas de 1 elemento
        if(vect.size() >= 2) return true; 
        else return false;        
    }
    
    ArrayList<String> separa(ArrayList<ArrayList<String>> afd, ArrayList<String> acept){//Separa los conjuntoEstado de no aceptacion
        ArrayList<String> temp = new ArrayList<String>();
        boolean ok;
        
        ManejoMatrices matriz = new ManejoMatrices();
        
        for (int i = 0; i < afd.size(); i++) {
            ok = true;
            for (int j = 0; j < acept.size(); j++) {
                if (afd.get(i).get(0).matches(acept.get(j))) {
                    ok = false;
                    j = acept.size();
                }
            }
            if(ok){
                temp.add(afd.get(i).get(0));
            }
        }
       return temp;//retorna los de no aceptacion
    }
    
    ArrayList<String> alfabeto(ArrayList<ArrayList<String>> afd){
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < afd.get(0).size(); i++) {
            temp.add(afd.get(0).get(i));
        }
       return temp;
    }
    
    String estadoInicial(String inicio){//Retorna el conjunto donde esta 
        for (int i = 0; i < conjuntosFinales.size(); i++) {
            if(conjuntosFinales.get(i).contains(inicio)){
                inicio = "C"+i;
                i = conjuntosFinales.size();
            }
        }
        return inicio;
    }
    
    ArrayList<String> AceptarReduccion(ArrayList<String> estadosF, ArrayList<String> edAceptacion){//procesa los conjuntoEstado finales 
                                                                                    //en que quedan las cadenas y regresa
                                                                                    //si es de aceptacion o no        
        ArrayList<String> Aceptacion = new ArrayList<String>();
        boolean var = false;
        for (int i = 0; i < estadosF.size(); i++) {
            for (int j = 0; j < edAceptacion.size(); j++) {
                
                if(estadosF.get(i).equals(estadoInicial(edAceptacion.get(j)))){
                    var = true;
                    j = edAceptacion.size();                    
                }
            }
            if(var){
                Aceptacion.add("Aceptacion");
                var = false;
            }else{
                Aceptacion.add("No Aceptacion");                
            }
        }
        return Aceptacion;//retorna vector de los conjuntoEstado aceptados o no
    }
    
//    String resultadoRuducida(ArrayList<String> entradas, ArrayList<String> estados, ArrayList<String> aceptacion){
//        String temp = "";
//        for (int i = 0; i < entradas.size(); i++) {
//            temp = temp + entradas.get(i) + "\t" + estados.get(i) + "\t" + aceptacion.get(i) + "\r\n";
//        }
//        return temp;
//    }
    
}
