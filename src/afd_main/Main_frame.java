package afd_main;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;



/**
 *
 * @author Alejandro-Ruiz
 */
public class Main_frame extends javax.swing.JFrame{

//****************************  VARIABLES  *********************************************//    
    
    String AFD, Acept, Entrada;//Variables que tomaran la ruta de los archivos
    boolean next = false, next2 = false, next3 = false;//booleanos para controlar el uso de los 2 archivos
//************************************************************************************//    
     
    //**Inicializacicion de los componentes**//
    /**
     * Creates new form Main_frame
     */
    public Main_frame() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagen/ico.png")).getImage());
        tp.setVisible(false);//Iniciar  la imagen como invisible
        tp2.setVisible(false);//Iniciar  la imagen como invisible
        tp3.setVisible(false);//Iniciar  la imagen como invisible
        result.setText("Ingrese AFD...\r\nNombre su estado inicial como q0!!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tokenButton = new javax.swing.JButton();
        tp = new javax.swing.JLabel();
        tp1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        reset = new javax.swing.JButton();
        procesar = new javax.swing.JButton();
        Aceptacion = new javax.swing.JButton();
        tp2 = new javax.swing.JLabel();
        tp3 = new javax.swing.JLabel();
        Entry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setSize(new java.awt.Dimension(20, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AUTOMATA");
        jLabel1.setToolTipText("");

        tokenButton.setText("AFD");
        tokenButton.setToolTipText("");
        tokenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenButtonActionPerformed(evt);
            }
        });

        tp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ouk-.png"))); // NOI18N

        tp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logoITM.png"))); // NOI18N

        result.setColumns(20);
        result.setRows(5);
        jScrollPane2.setViewportView(result);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        procesar.setText("Go!");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });

        Aceptacion.setText("Aceptacion");
        Aceptacion.setToolTipText("");
        Aceptacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptacionActionPerformed(evt);
            }
        });

        tp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ouk-.png"))); // NOI18N

        tp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ouk-.png"))); // NOI18N

        Entry.setText("Entrada");
        Entry.setToolTipText("");
        Entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(reset)
                        .addGap(39, 39, 39)
                        .addComponent(procesar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tp1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tokenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(tp))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Aceptacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Entry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tp2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tp3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset)
                            .addComponent(procesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tokenButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Aceptacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tp3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tp1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //**Accion al hacer clic Token**//
    private void tokenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokenButtonActionPerformed
        // BOTON AFD para poder obtener ruta de archivo "AFD.txt"
        JFileChooser explorer = new JFileChooser(rutaEscritorio(System.getProperty("user.home") + "/Escritorio"));//creamos un objeto de la clase JFileChooser        
        explorer.setDialogTitle("Abrir AFD.txt");//cambiamos el titulo del Frame

        explorer.setFileFilter(new FileNameExtensionFilter("Archivo txt", "txt"));//Filtramos por extension .txt

        int seleccion = explorer.showDialog(null, "Abrir!");

        //analizamos la respuesta
        switch(seleccion) {
            case JFileChooser.APPROVE_OPTION:
            AFD = explorer.getSelectedFile().getPath();//seleccionó abrir
            tp.setVisible(true);//se habilita visivilidad del palomita
            next = true;
            if(next && next2 && next3){
                result.setText("Preparados!... Presione Go!");
            }
            break;

            case JFileChooser.CANCEL_OPTION:
            //dio click en cancelar o cerro la ventana
            break;

            case JFileChooser.ERROR_OPTION:
            JOptionPane.showMessageDialog(null, "Error...");//llega aqui si sucede un error
            break;
        }
    }//GEN-LAST:event_tokenButtonActionPerformed

    
    //**Accion al hacer clic reset**//
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        AFD = null;
        Acept = null;
        next = false;
        tp.setVisible(false);
        tp2.setVisible(false);
        tp3.setVisible(false);
        result.setText("Ingrese AFD...\r\nNombre su estado inicial como q0!!");
    }//GEN-LAST:event_resetActionPerformed

    

    ////*********Se realiza el proceso de las expresiones**********////
    ////**********************************************************////
    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
        JFileChooser file = new JFileChooser(rutaEscritorio(System.getProperty("user.home") + "/Escritorio"));
        ManejoArchivos archivos = new ManejoArchivos();//creamos un objeto de la clase ManejoArchivos 
                                                                            // para uso de sus funciones
        ManejoMatrices matriz = new ManejoMatrices();//creamos un objeto de la clase ManejoMatrices 
                                                                            // para uso de sus funciones
        AutomataFuntions autom = new AutomataFuntions();
        
        ArrayList<ArrayList<String>> afd, afdReducida;//Matriz dinamica
        ArrayList<String> entradas, edAcept, estadosF, aceptacion, estadosFReduccion, aceptacionReduccion;//Vectores dinamicos
//        String init = null;
//        init = JOptionPane.showInputDialog("Ingrese Estado de Inicio del Automata");
        AFD = "C:\\Users\\Alejandro-Ruiz\\Desktop\\AFD.txt";
        Acept = "C:\\Users\\Alejandro-Ruiz\\Desktop\\Acept.txt";
        Entrada = "C:\\Users\\Alejandro-Ruiz\\Desktop\\Entrada.txt";
        
        
        if(true){//next && next2 && next3){//Limita a especificar los dos archivos!
            
            result.setText("");
            afd = archivos.leer(AFD, "AFD.txt");//Lee Archivo del Automata
            entradas = matriz.covertirToVector(archivos.leer(Entrada, "Entrada.txt"));//Lee Archivo de entradas
            edAcept = matriz.covertirToVector(archivos.leer(Acept, "Acept.txt"));//Lee Archivo de estados de aceptacion
                        
            estadosF = autom.recorreAutom(afd, "q0", entradas);//retorna los estados finales de las cadenas procesadas
                                                                    //afd no esta minimizada
            aceptacion = autom.Aceptar(estadosF, edAcept);//retorna si la cadena se acepta o no
            //result.setText("RESULTADO \r\n\r\n Entrada\tEstado Final\tValidacion  \r\n\r\n" + matriz.resultado(entradas, estadosF, aceptacion));
            //result.setText("MATRICES \r\n\r\n" + matriz.mostrarVector(edAcept) + "\r\n" + matriz.mostrarVector(autom.separa(afd, edAcept)));
           
            //** PARA MINIMIZACION**//
            afdReducida = autom.reduccion(afd, edAcept);//reduce el afd, retorna una matriz
            estadosFReduccion = autom.recorreAutom(afdReducida, autom.estadoInicial("q0") , entradas);//retorna los estados finales de las cadenas procesadas
            aceptacionReduccion = autom.AceptarReduccion(estadosFReduccion, edAcept);//retorna si la cadena se acepta o no
            result.setText("RESULTADO \r\n\r\n Entrada\tEstado Final\tValidacion  \r\n\r\n MINIMIZADA: \r\n" + matriz.resultado(entradas, estadosFReduccion, aceptacionReduccion) + "\r\n\r\n ORIGINAL: \r\n" + matriz.resultado(entradas, estadosF, aceptacion));
            //**                  **//
            
            //result.setText(matriz.mostrarMatriz(afdReducida));
            //result.setText(autom.muestraConjuntoFinal());
//            result.setText("AFD \r\n" + matriz.mostrarMatriz(afd) + "\r\n ACEPTACION \r\n" + matriz.mostrarMatriz(acept) + "\r\n ENTRADAS \r\n" + matriz.mostrarVector(entradas));
//            result.setText(archivos.validarExpresion());    
//            file.showSaveDialog(this);
//            archivos.graba(file.getSelectedFile());
        }else{
            JOptionPane.showMessageDialog(null, "Faltan Archivos!!");
        }        
    }//GEN-LAST:event_procesarActionPerformed

    private void AceptacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptacionActionPerformed
        // BOTON Aceptacion para poder obtener ruta de archivo "Aceptacion.txt"
        JFileChooser explorer = new JFileChooser(rutaEscritorio(System.getProperty("user.home") + "/Escritorio"));//creamos un objeto de la clase JFileChooser        
        explorer.setDialogTitle("Abrir Edo_Aceptacion.txt");//cambiamos el titulo del Frame

        explorer.setFileFilter(new FileNameExtensionFilter("Archivo txt", "txt"));//Filtramos por extension .txt

        int seleccion = explorer.showDialog(null, "Abrir!");

        //analizamos la respuesta
        switch(seleccion) {
            case JFileChooser.APPROVE_OPTION:
            Acept = explorer.getSelectedFile().getPath();//seleccionó abrir
            tp2.setVisible(true);//se habilita visivilidad del palomita
            next2 = true;
            if(next && next2 && next3){
                result.setText("Preparados!... Presione Go!");
            }
            
            break;

            case JFileChooser.CANCEL_OPTION:
            //dio click en cancelar o cerro la ventana
            break;

            case JFileChooser.ERROR_OPTION:
            JOptionPane.showMessageDialog(null, "Error...");//llega aqui si sucede un error
            break;
        }
    }//GEN-LAST:event_AceptacionActionPerformed

    private void EntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryActionPerformed
       // BOTON Aceptacion para poder obtener ruta de archivo "Aceptacion.txt"
        JFileChooser explorer = new JFileChooser(rutaEscritorio(System.getProperty("user.home") + "/Escritorio"));//creamos un objeto de la clase JFileChooser        
        explorer.setDialogTitle("Abrir Entrada.txt");//cambiamos el titulo del Frame

        explorer.setFileFilter(new FileNameExtensionFilter("Archivo txt", "txt"));//Filtramos por extension .txt

        int seleccion = explorer.showDialog(null, "Abrir!");

        //analizamos la respuesta
        switch(seleccion) {
            case JFileChooser.APPROVE_OPTION:
            Entrada = explorer.getSelectedFile().getPath();//seleccionó abrir
            tp3.setVisible(true);//se habilita visivilidad del palomita
            next3 = true;
            if(next && next2 && next3){
                result.setText("Preparados!... Presione Go!");
            }
            
            break;

            case JFileChooser.CANCEL_OPTION:
            //dio click en cancelar o cerro la ventana
            break;

            case JFileChooser.ERROR_OPTION:
            JOptionPane.showMessageDialog(null, "Error...");//llega aqui si sucede un error
            break;
        }
    }//GEN-LAST:event_EntryActionPerformed
    ////**********************************************************////
    ////**********************************************************////
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptacion;
    private javax.swing.JButton Entry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton procesar;
    private javax.swing.JButton reset;
    private javax.swing.JTextArea result;
    private javax.swing.JButton tokenButton;
    private javax.swing.JLabel tp;
    private javax.swing.JLabel tp1;
    private javax.swing.JLabel tp2;
    private javax.swing.JLabel tp3;
    // End of variables declaration//GEN-END:variables
    
        
          
    String rutaEscritorio(String ruta){//Regresa la ruta de escritorio del usuario sea Desktop o Escritorio
        File e = new File(ruta);
        if (!e.exists()){
            if(ruta.contains("Escritorio")){
                ruta = ruta.replace("Escritorio", "Desktop");
            }else{
                ruta = ruta.replace("Desktop", "Escritorio");
            }
        }
        return ruta;
    }
    
}
