/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1_recupe;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisp
 */
public class Interfaz_inicio extends javax.swing.JFrame {
    static int numero_filas;
    static int numero_columnas;
    static Lista lista_esquinas;
    static Lista lista_disponible;
    /**
     * Creates new form Interfaz_Juego
     */
    public Interfaz_inicio() {
        initComponents();
        lista_disponible = new Lista();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        generar = new javax.swing.JButton();
        inputFilas = new javax.swing.JTextField();
        inputColum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Laberinto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel2.setText("Cantidad de columnas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 130, -1));

        jLabel3.setText("Cantidad de filas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 100, 20));

        generar.setText("Generar");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        jPanel1.add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        inputFilas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputFilasKeyTyped(evt);
            }
        });
        jPanel1.add(inputFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, -1));

        inputColum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputColumActionPerformed(evt);
            }
        });
        inputColum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputColumKeyTyped(evt);
            }
        });
        jPanel1.add(inputColum, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        if (Integer.parseInt(inputColum.getText()) < 5 || Integer.parseInt(inputColum.getText()) > 30 && Integer.parseInt(inputFilas.getText()) < 5 || Integer.parseInt(inputFilas.getText()) > 30)  {
            JOptionPane.showMessageDialog(null, "No se permite un valor menor a 5 o mayor a 30");
        } else {
            for (int i = 1; i <= (Integer.parseInt(inputColum.getText())-2) * (Integer.parseInt(inputFilas.getText())-2); i++) {
                Lista listaadyacencia = new Lista();
                Vertice nuevo = new Vertice(i, listaadyacencia);
                lista_disponible.insertar(nuevo);
            }
     
            for (int i = 1; i <= (Integer.parseInt(inputColum.getText())-2)*(Integer.parseInt(inputFilas.getText())-2); i++){
//Esquina superior izquierda
            if(i==1){
                    Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
            }
            //Esquina superior derecha
            else if(i==Integer.parseInt(inputColum.getText())-2){
            Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
            }
            //Esquina inferior izquierda
            else if (i == ((Integer.parseInt(inputColum.getText())-2) * (Integer.parseInt(inputFilas.getText())-2) + 1) - (Integer.parseInt(inputColum.getText())-2)){
            Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
            }
            //Esquina inferior derecha
            else if(i == (Integer.parseInt(inputColum.getText())-2) * (Integer.parseInt(inputFilas.getText())-2)){
            Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
            }
            //Borde de arriba
            else if (i < (Integer.parseInt(inputColum.getText())-2) && i > 1) {
                    Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    Vertice nuevoadyacencia2 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia2);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
                    nuevoadyacencia1.setpNext(nuevoadyacencia2);
            }
            //Borde de abajo
            else if (i > (((Integer.parseInt(inputColum.getText())-2) * (Integer.parseInt(inputFilas.getText())-2)) + 1) - (Integer.parseInt(inputColum.getText())-2) && i < (Integer.parseInt(inputColum.getText())-2) * (Integer.parseInt(inputFilas.getText())-2)) {
                    Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    Vertice nuevoadyacencia2 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia2);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
                    nuevoadyacencia1.setpNext(nuevoadyacencia2);
            }
            //Borde derecha
            else if (i % (Integer.parseInt(inputColum.getText())-2) == 0) {
                    Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    Vertice nuevoadyacencia2 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia2);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
                    nuevoadyacencia1.setpNext(nuevoadyacencia2);
            }
            //Borde Izquierda
            else if (i % (Integer.parseInt(inputColum.getText())-2) == 1) {
                    Vertice nuevoadyacencia3 = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia3);
                    Vertice nuevoadyacencia4 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia4);
                    Vertice nuevoadyacencia5 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia5);
                    nuevoadyacencia3.setpNext(nuevoadyacencia4);
                    nuevoadyacencia4.setpNext(nuevoadyacencia5);
            }
            else{
                    Vertice nuevoadyacencia = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpPrev());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia);
                    Vertice nuevoadyacencia1 = lista_disponible.CopiarDato(lista_disponible.buscarAbajo(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia1);
                    Vertice nuevoadyacencia2 = lista_disponible.CopiarDato(lista_disponible.buscarArriba(i, Integer.parseInt(inputColum.getText())-2));
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia2);
                    Vertice nuevoadyacencia3 = lista_disponible.CopiarDato(lista_disponible.buscar(i).getpNext());
                    lista_disponible.buscar(i).getlista_adyacencia().insertar(nuevoadyacencia3);
                    nuevoadyacencia.setpNext(nuevoadyacencia1);
                    nuevoadyacencia1.setpNext(nuevoadyacencia2);
                    nuevoadyacencia2.setpNext(nuevoadyacencia3);
                }    
            }
            Lista listafinal = new Lista();
            listafinal = lista_disponible.arbolExpMinPrim(Integer.parseInt(inputColum.getText())-2,Integer.parseInt(inputFilas.getText())-2);
            this.setVisible(false);
            Interfaz_inicio.numero_columnas = Integer.parseInt(inputColum.getText());
            Interfaz_inicio.numero_filas = Integer.parseInt(inputFilas.getText());
            JFrame miventana = new JFrame("Laberinto");
            Interfaz_Juego game = new Interfaz_Juego();
            miventana.add(game);
            miventana.setSize(Interfaz_inicio.numero_columnas * 40 + 18, Interfaz_inicio.numero_filas * 40 + 41); //Tamanio de la ventana
            miventana.setResizable(false);
            miventana.setLocationRelativeTo(null);//Localizacion de la ventana
            miventana.setVisible(true);
            miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_generarActionPerformed
   
    private void inputColumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputColumActionPerformed

    }//GEN-LAST:event_inputColumActionPerformed

    private void inputColumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputColumKeyTyped
        // Con esto validamos que solo se puedan ingresar numeros 
        // y que solo pueda ser entre 5 y 10. 
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (inputColum.getText().trim().length() == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_inputColumKeyTyped

    private void inputFilasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputFilasKeyTyped
            // Con esto validamos que solo se puedan ingresar numeros 
        // y que solo pueda ser entre 5 y 10. 
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (inputFilas.getText().trim().length() == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_inputFilasKeyTyped

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
            java.util.logging.Logger.getLogger(Interfaz_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generar;
    private javax.swing.JTextField inputColum;
    private javax.swing.JTextField inputFilas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
