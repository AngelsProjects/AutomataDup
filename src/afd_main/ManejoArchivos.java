package afd_main;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro-Ruiz
 */
public class ManejoArchivos {
    
    FileReader archivo=null;
    BufferedReader leer=null;
    FileWriter archivito=null;
    PrintWriter graba=null;
    
    
    //*************************Metodo leer*******************************//
       //******Realiza todo el proceso para lectura del archivo******//
       //***********************************************************//
    //******************************************************************//
    ArrayList<ArrayList<String>> leer(String ruta, String nombre){
        ArrayList<ArrayList<String>> mat;
        abrirArchivo(ruta, nombre);//Abrir el archivo tokens.txt
        mat = obtener(nombre);//Lee el contenido y lo guarda
        cerrarArchivo(nombre);//Cerrar el archivo
        return mat;
    }
    //***********************************************************//
    
    
    //*************************Metodo leer*******************************//
       //******Realiza todo el proceso para lectura del archivo******//
       //***********************************************************//
    //******************************************************************//
    public void graba(File ruta){
        crearArchivo(ruta);//Abrir el archivo tokens.txt
        grabarDatos("DATOS DE SALIDA");///////////******************
        cierraArchivo();//Cerrar el archivo
    }
    //***********************************************************//
    
    
    //* SECCION PARA TRATO DE LOS ARCHIVOS *//
    
    //*                       LEER ARCHIVOS                     *//
	
    void abrirArchivo(String ruta, String nombre)//Abre el archivo
    {
	try 
	{
            archivo = new FileReader(ruta);
	} 
	catch (Exception e)
	{
            JOptionPane.showMessageDialog(null, "Error! " + nombre);
	}
    }
    
    
    ArrayList<ArrayList<String>> obtener(String nombre)//Lee el archivo
    {
        ManejoMatrices matriz = new ManejoMatrices();
        ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
        String linea;
        int n = 0;
        try 
        {
            leer = new BufferedReader(archivo);
            while((linea = leer.readLine()) != null)//Lee por linea hasta encontrar un null 
            {
                if(nombre.equals("AFD.txt")){
                    mat = matriz.llenaMatriz(n, linea);//manda a almacenar en una matriz los datos del archivo AFD.txt
                    n++;
                }
                if(nombre.equals("Acept.txt")){
                    mat = matriz.llenaEntry(n, linea);//manda a almacenar en una matriz los datos del archivo AFD.txt
                    n++;
                }
                if(nombre.equals("Entrada.txt")){//Obtener una cadena como final
                    mat = matriz.llenaEntry(n, linea);//manda a almacenar en una matriz los datos del archivo AFD.txt
                    n++;
                }
            }
        }
        catch (Exception e) 
        {
        }
        return mat;
    }
    
    void cerrarArchivo(String nombre)//Cierra el archivo
    {
	try 
	{
            archivo.close();
	}
	catch (Exception e) 
	{
            JOptionPane.showMessageDialog(null, "ARCHIVO NO CERRADO " + nombre);
	}
    }
    
    
    //*                       CREAR ARCHIVOS                     *//
    
	void crearArchivo(File ruta)//Crea archivo en la ruta especifica
	{
            try
            {
                archivito = new FileWriter(ruta + ".txt");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error no creado!");
            }		
	}
        
        void grabarDatos(String datos)//Grabar datos en el archivo
	{
            try
            {
                graba = new PrintWriter(archivito);
                graba.print(datos);
            }
            catch(Exception e)
            {
            }
	}
	
	void cierraArchivo()//Cerrar archivo 
	{
            try 
            {
                archivito.close();
                JOptionPane.showMessageDialog(null, "Se creo archivo!");
            }
            catch(IOException e) 
            {
            }
	}
	    
    //* TERMINA SECCION DE TRATO DE ARCHIVOS *//   
}