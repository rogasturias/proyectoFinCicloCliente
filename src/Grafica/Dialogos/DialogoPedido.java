/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica.Dialogos;

import Grafica.MetodosEstaticosDialogos;
import LogicaDatos.Datos.Datos;
import caguela.Pedido;
import caguela.Posicion;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rogas
 */
public class DialogoPedido extends javax.swing.JDialog {

    public JButton botonAceptar;
    public JButton botonCancelar;
    public boolean resultado;
    public Pedido pedido;
    public JCheckBox checkAceptar;
    public JCheckBox checkEnviar;
    public JCheckBox checkRecibir;
    private ArrayList <Posicion> posiciones;
    private boolean vendedor;
    java.awt.Frame parent;
    /**
     * Creates new form DialogoAlerta
     */
    public DialogoPedido(java.awt.Frame parent, boolean modal,Pedido pedido,boolean vendedor) {
        super(parent, modal);
        initComponents();
        this.pedido=pedido;
        this.vendedor=vendedor;
        this.parent=parent;
        cargarPresentacion();
        
        
              
    }

    private void cargarPresentacion() {

        // ponemos todo en blanco
        this.getContentPane().setBackground(Color.white);
        //  ponemos cabecera y logo al panel
        this.setLocationRelativeTo(null);//  colocarla en el centro de la pantalla
        // personalizamos pantalla
        this.setTitle("PEDIDO    Ca' Guela  1.0    la app de los productos gourmet");
        this.setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());

        botonAceptar = jButtonAceptar;
        botonCancelar = jButtonCancelar;
        checkAceptar =jCheckAceptado;
        checkEnviar = jCheckEnviado;
        checkRecibir = jCheckRecibido;
        jTextFieldNombreComprador.setEnabled(false);
        jTextFieldApellidoComprador.setEnabled(false);
        jTextFieldIdPedido.setEnabled(false);
        jTextFieldApellidoVendedor.setEnabled(false);
        jTextFieldNombreVendedor.setEnabled(false);
        jTextFieldFechaPedido.setEnabled(false);
        
        
        
        
        refrescarTablaPosiciones();
         
    }

  
    
    
    public void refrescarTablaPosiciones( ) {
       
       
        DefaultTableModel tablaPe = new DefaultTableModel(); // creo un modelo default tabla objeto
        posiciones = new ArrayList<>();
        ArrayList<Posicion> datos;
        if(vendedor){
            datos=Datos.posicionesPendientesVendedor;
           
        }
        else{
            datos = Datos.posicionesPendientesComprador;
            
        }
        for (Posicion pe : datos) {
            if(pe.getPedido().getId() == pedido.getId()){
                posiciones.add(pe);
                System.out.println("añadiendo posiciones a la pantalla de pedido ........."+pe.getProducto().getNombre());
            }
            
        }
        System.out.println("*****************total posiciones en pedido "+posiciones.size());
        System.out.println("************************ vendedor:"+pedido.getVendedor().getNombre());
        jTextFieldApellidoComprador.setText(pedido.getComprador().getApellidos());
        jTextFieldNombreComprador.setText(pedido.getComprador().getNombre());
        jTextFieldApellidoVendedor.setText(pedido.getVendedor().getApellidos());
        jTextFieldNombreVendedor.setText(pedido.getVendedor().getNombre());
        jTextFieldIdPedido.setText(pedido.getId()+"");
        jCheckAceptado.setSelected(pedido.isAceptado());
        jCheckEnviado.setSelected(pedido.isEnviado());
        jCheckRecibido.setSelected(pedido.isRecibido());
        
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        String fecha = formatoDeFecha.format(pedido.getFecha().toGregorianCalendar().getTime());
        jTextFieldFechaPedido.setText(fecha);
        tablaPe.setColumnIdentifiers(new String[]{"Id_producto", "Cantidad", "Producto","Precio"} );// le pongo cabacera
        
       
        for (Posicion pro : posiciones) {
            
            String[] fila = new String[4] ;
            fila[0] = pro.getProducto().getId()+""; 
            fila[1] = pro.getCantidad()+"";
            fila[2] = pro.getProducto().getNombre();
            fila[3] = pro.getProducto().getPrecioSinIva()+"";            
            tablaPe.addRow(fila);     // hago bucle y cargo todos los datos.
        
        }
        jTableProductosPedido.setModel(tablaPe);        // la tabla la descargo en la jtable panel principal
    }
    
    public void actualizarPedido(){
        pedido.setAceptado(jCheckAceptado.isSelected());
        pedido.setEnviado(jCheckEnviado.isSelected());
        pedido.setRecibido(jCheckRecibido.isSelected()); 
        
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIdPedido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombreVendedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNombreComprador = new javax.swing.JTextField();
        jTextFieldApellidoVendedor = new javax.swing.JTextField();
        jTextFieldApellidoComprador = new javax.swing.JTextField();
        jTextFieldFechaPedido = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductosPedido = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jCheckAceptado = new javax.swing.JCheckBox();
        jCheckEnviado = new javax.swing.JCheckBox();
        jCheckRecibido = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 102));
        jLabel4.setText("este es tu pedido...");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 102));
        jLabel3.setText("Ca' Guela    ");

        jButtonAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(204, 204, 0));
        jButtonAceptar.setText("Guardar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 102, 0));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("idPedido");

        jTextFieldIdPedido.setText("idProducto 1");

        jLabel2.setForeground(new java.awt.Color(255, 204, 102));
        jLabel2.setText("Vendedor");

        jTextFieldNombreVendedor.setText("nombre");

        jLabel5.setForeground(new java.awt.Color(255, 204, 102));
        jLabel5.setText("Comprador");

        jTextFieldNombreComprador.setText("apellido");
        jTextFieldNombreComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreCompradorActionPerformed(evt);
            }
        });

        jTextFieldApellidoVendedor.setText("nombre");

        jTextFieldApellidoComprador.setText("nombre");

        jTextFieldFechaPedido.setText("fecha");
        jTextFieldFechaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaPedidoActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 204, 102));
        jLabel7.setText("fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFechaPedido)
                    .addComponent(jTextFieldIdPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldApellidoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoComprador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombreComprador, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldApellidoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jTableProductosPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableProductosPedido.setForeground(new java.awt.Color(255, 204, 102));
        jTableProductosPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProductosPedido);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 102));
        jLabel6.setText("Productos en el Pedido");

        jCheckAceptado.setText("Aceptado");

        jCheckEnviado.setText("Enviado");

        jCheckRecibido.setText("Recibido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckAceptado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckEnviado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckRecibido)
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addContainerGap(494, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckEnviado)
                    .addComponent(jCheckAceptado)
                    .addComponent(jCheckRecibido))
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFechaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaPedidoActionPerformed

    }//GEN-LAST:event_jTextFieldFechaPedidoActionPerformed

    private void jTextFieldNombreCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreCompradorActionPerformed

/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////// CODIGO  BOTON CANCELAR ////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        resultado = false;
        // recuperar el estaDo original del PEDIDO, y deshechar el nuevo PEDIDO
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        resultado = true;
        // aqui procesar guardar este PEDIDO o actualizar tanto en local como bbdd
        actualizarPedido();
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    

/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////// CODIGO  BOTON ACEPTAR /////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    public void setBotonCancelar(JButton botonCancelar) {
        this.botonCancelar = botonCancelar;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckAceptado;
    private javax.swing.JCheckBox jCheckEnviado;
    private javax.swing.JCheckBox jCheckRecibido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductosPedido;
    private javax.swing.JTextField jTextFieldApellidoComprador;
    private javax.swing.JTextField jTextFieldApellidoVendedor;
    private javax.swing.JTextField jTextFieldFechaPedido;
    private javax.swing.JTextField jTextFieldIdPedido;
    private javax.swing.JTextField jTextFieldNombreComprador;
    private javax.swing.JTextField jTextFieldNombreVendedor;
    // End of variables declaration//GEN-END:variables
}
