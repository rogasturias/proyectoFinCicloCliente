/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import LogicaDatos.Datos.Datos;
import LogicaDatos.Datos.HiloActualizarPedido1;
import caguela.Pedido;
import caguela.Posicion;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rogas
 */
public class Revisar_Pedido_Comprador extends javax.swing.JFrame {
   
    /**
     * Creates new form Principal
     */
    public Revisar_Pedido_Comprador() {
        initComponents();        
        cargarPresentacion();       
     }
    
private void cargarPresentacion() {
    
        try {
            // ponemos todo en blanco
            jPanel1.setVisible(true);
            jPanel1.setBackground(Color.white);            
            
            this.getContentPane().setBackground(Color.white);
            this.setResizable(false);
            
            //  ponemos cabecera y logo al panel
            this.setLocationRelativeTo(null);//  colocarla en el centro de la pantalla
            // personalizamos pantalla
            this.setTitle("PANTALLA COMPRADOR REVISANDO   Ca' Guela  1.0    la app de los productos gourmet");
            setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
            
            // cargamos las fotos y las rescalamos
           
            BufferedImage img1 = ImageIO.read(getClass().getResource("/img/tienda2.jpg"));
            BufferedImage img2 = ImageIO.read(getClass().getResource("/img/tienda.jpg"));
            BufferedImage img3 = ImageIO.read(getClass().getResource("/img/jamon.png"));
            BufferedImage img4 = ImageIO.read(getClass().getResource("/img/arbol.jpg"));
            BufferedImage img5 = ImageIO.read(getClass().getResource("/img/girasoles.jpg"));
            BufferedImage img6 = ImageIO.read(getClass().getResource("/img/icono_salir.jpg"));
            BufferedImage img7 = ImageIO.read(getClass().getResource("/img/iconoAceptar.jpg")); 
            BufferedImage img8 = ImageIO.read(getClass().getResource("/img/icono_guardar.png")); 
             
             
            Image imagen0 = (Image)img6.getScaledInstance((int)(0.2*jButtonSalir.getWidth()), (int)(0.45*jButtonSalir.getHeight()),Image.SCALE_SMOOTH);
            Image imagen7 = (Image)img7.getScaledInstance((int)(0.2*jButtonReLogin.getWidth()), (int)(0.45*jButtonReLogin.getHeight()),Image.SCALE_SMOOTH);
            Image imagen1 = (Image)img1.getScaledInstance(jLabelImagen1.getWidth(), jLabelImagen1.getHeight(),Image.SCALE_SMOOTH);
            Image imagen2 = (Image)img2.getScaledInstance(jLabelImagen2.getWidth(), jLabelImagen2.getHeight(),Image.SCALE_SMOOTH);
            Image imagen3 = (Image)img3.getScaledInstance(jLabelImagen3.getWidth(), jLabelImagen3.getHeight(),Image.SCALE_SMOOTH);
            Image imagen4 = (Image)img4.getScaledInstance(jLabelImagen4.getWidth(), jLabelImagen4.getHeight(),Image.SCALE_SMOOTH);
            Image imagen5 = (Image)img5.getScaledInstance(jLabelImagen5.getWidth(), jLabelImagen5.getHeight(),Image.SCALE_SMOOTH);
            
            jButtonSalir.setIcon(new  ImageIcon(imagen0));
            jButtonReLogin.setIcon(new  ImageIcon(imagen7));
            jLabelImagen1.setIcon(new ImageIcon(imagen1));  
            jLabelImagen2.setIcon(new ImageIcon(imagen2));
            jLabelImagen3.setIcon(new ImageIcon(imagen3));
            jLabelImagen4.setIcon(new ImageIcon(imagen4));
            jLabelImagen5.setIcon(new ImageIcon(imagen5));
            
                         
            refrescarTablaPedidos();           
                       
            
        } catch (IOException ex) {
            
        }
        
}


    @SuppressWarnings("empty-statement")
    public void refrescarTablaPedidos( ) {       
        
        DefaultTableModel tablaPe = new DefaultTableModel(); // creo un modelo default tabla objeto

        tablaPe.setColumnIdentifiers(new String[]{"Numero", "fecha", "Vendedor_id","Vendedor", "Aceptado", "Enviado","Recibido"});// le pongo cabacera
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        String fecha;
        for (Pedido ped : Datos.pedidosClienteComoComprador) {
            String[] fila = new String[7] ;
            
            fila[0] = ped.getId()+"";                       
            fila[2] = ped.getVendedor().getId()+"";            
            fila[3] = ped.getVendedor().getNombre()+"-"+ ped.getVendedor().getApellidos();
            fila[4] = ped.isAceptado()+"";
            fila[5] = ped.isEnviado()+"";
            fila[6] = ped.isRecibido()+"";
            if(ped.getFecha()!=null){
            System.out.println(ped.getFecha());
            System.out.println(ped.getFecha().toGregorianCalendar());
            System.out.println(ped.getFecha().toGregorianCalendar().getTime());
            fecha = formatoDeFecha.format(ped.getFecha().toGregorianCalendar().getTime());  
            
            fila[1] = fecha;}
            tablaPe.addRow(fila);     // hago bucle y cargo todos los datos.
        }

        jTablePedidos.setModel(tablaPe);        // la tabla la descargo en la jtable panel principal
    }
    
   

     /** This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelImagen1 = new javax.swing.JLabel();
        jLabelImagen2 = new javax.swing.JLabel();
        jLabelImagen3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelImagen4 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelImagen5 = new javax.swing.JLabel();
        jButtonReLogin = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "tus datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 204, 102))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 204, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTablePedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTablePedidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePedidos);
        if (jTablePedidos.getColumnModel().getColumnCount() > 0) {
            jTablePedidos.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTablePedidos.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTablePedidos.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTablePedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Tus Pedidos pendientes   .... haz click sobre el que quieras gestionar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Ca' Guela    ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 102));
        jLabel4.setText("la app gourmet ...");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 51, 51));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonReLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReLogin.setForeground(new java.awt.Color(153, 204, 0));
        jButtonReLogin.setText("Volver");
        jButtonReLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jLabelImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonReLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReLogin)
                    .addComponent(jButtonSalir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelImagen4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelImagen1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jLabelImagen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelImagen5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        MetodosEstaticosDialogos.acercaDe(this);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        MetodosEstaticosDialogos.acercaDe(this);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        
        System.out.println("los datos en pedidos Posiciones pendientes como comprador son "+Datos.posicionesPendientesComprador.size()); 
        
        for (Posicion pos : Datos.posicionesPendientesComprador) {
            System.out.println(pos.getProducto().getNombre());
        }
        
        System.out.println("los datos en pedidos Posiciones pendientes como vendedor son "+Datos.posicionesPendientesVendedor.size()); 
      
        for (Posicion pos : Datos.posicionesPendientesVendedor) {
            System.out.println(pos.getProducto().getNombre());
        }


        // obtengo el pedido seleccionado
        int indexPedido= jTablePedidos.getSelectedRow();
        Pedido pedido = Datos.pedidosClienteComoComprador.get(indexPedido);
        System.out.println("**************** enviando pedido del vendedor "+pedido.getVendedor().getNombre());
        // envio pedido al dialogo, indicando VENDEDOR true, y en funcion de respuesta.
        Pedido nuevoPedido= MetodosEstaticosDialogos.dialogoPedido(this, pedido,false);   
        if(nuevoPedido != null){
            HiloActualizarPedido1 hilo = new HiloActualizarPedido1(this, pedido);
            hilo.start();
            
            Datos.pedidosClienteComoComprador.remove(indexPedido);
            Datos.pedidosClienteComoComprador.add(pedido);
        }
        refrescarTablaPedidos();
    }//GEN-LAST:event_jTablePedidosMouseClicked

    private void jButtonReLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReLoginActionPerformed
        new HiloElegirOpcciones(this).start();
    }//GEN-LAST:event_jButtonReLoginActionPerformed
    
    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReLogin;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelImagen1;
    private javax.swing.JLabel jLabelImagen2;
    private javax.swing.JLabel jLabelImagen3;
    private javax.swing.JLabel jLabelImagen4;
    private javax.swing.JLabel jLabelImagen5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedidos;
    // End of variables declaration//GEN-END:variables
}
