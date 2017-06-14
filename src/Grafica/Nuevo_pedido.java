/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Email.HiloEnviarMail;
import LogicaDatos.Datos.Datos;
import LogicaDatos.Datos.HiloNuevoPedido;
import caguela.Pedido;
import caguela.Posicion;
import caguela.Producto;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import static java.lang.Thread.sleep;

/**
 *
 * @author rogas
 */
public class Nuevo_pedido extends javax.swing.JFrame {
    boolean resultado;
    /**
     * Creates new form Principal
     */
    public Nuevo_pedido() {
        initComponents();        
        cargarPresentacion();       
     }

/**
 * Metodo interno que carga los datos de presentacion de pantalla    
 * 
 */
private void cargarPresentacion() {
        Datos.pedidoNuevo = new Pedido();
        try {
            // ponemos todo en blanco
            jPanel1.setVisible(true);
            jPanel1.setBackground(Color.white);
            this.getContentPane().setBackground(Color.white);
            this.setResizable(false);
            
            //  ponemos cabecera y logo al panel
            this.setLocationRelativeTo(null);//  colocarla en el centro de la pantalla
            // personalizamos pantalla
            this.setTitle("PANTALLA COMPRADOR NUEVO PEDIDO    Ca' Guela  1.0    la app de los productos gourmet");
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
            jButtonReLogin.setIcon(new ImageIcon(imagen7));
            jLabelImagen1.setIcon(new ImageIcon(imagen1));  
            jLabelImagen2.setIcon(new ImageIcon(imagen2));
            jLabelImagen3.setIcon(new ImageIcon(imagen3));
            jLabelImagen4.setIcon(new ImageIcon(imagen4));
            jLabelImagen5.setIcon(new ImageIcon(imagen5));
            
            //jTablePedidos.
           jLabelNombreComprador.setText(Datos.CLIENTE.getNombre()+" "+Datos.CLIENTE.getApellidos());
           jLabelNombreVendedor.setText(Datos.VENDEDOR.getNombre()+"-"+Datos.VENDEDOR.getApellidos()); 
            
            refrescarTablaProductoGamaVendedor();
            refrescarTablaProductos();
            
            
            
        } catch (IOException ex) {
            
        }
        
}


    @SuppressWarnings("empty-statement")
    public void refrescarTablaProductoGamaVendedor( ) {
       
        
        DefaultTableModel tabla = new DefaultTableModel(); // creo una tabla objeto

        tabla.setColumnIdentifiers(new String[]{"idProducto", "Nombre", "Marca", "Precio"});// le pongo cabacera

        
        for (Producto p : Datos.productosParaVender) {
             String[] item = {p.getId()+"",p.getNombre(),p.getMarca(),p.getPrecioSinIva()+""};
            tabla.addRow(item);     // hago bucle y cargo todos los datos.
        }

        jTableGamaProductos.setModel(tabla);        // la tabla la descargo en la jtable panel principal
    }
    
    // Metodo que refresca los datos de la tabla productos
    public void refrescarTablaProductos( ) {
              
        DefaultTableModel tabla = new DefaultTableModel(); // creo una tabla objeto
        tabla.setColumnIdentifiers(new String[]{"Cantidad","idProducto", "Nombre", "Marca", "Precio"});// le pongo cabacera

        
        for (Posicion p : Datos.posicionesNuevoPedido) {
             String[] item = {p.getCantidad()+"",p.getProducto().getId()+"",p.getProducto().getNombre(),p.getProducto().getMarca(),p.getProducto().getPrecioSinIva()+""};
            tabla.addRow(item);     // hago bucle y cargo todos los datos.
        }
        
        jTableProductosPedido.setModel(tabla);        
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
        jTableGamaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductosPedido = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelNombreVendedor = new javax.swing.JLabel();
        jLabelNombreComprador = new javax.swing.JLabel();
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

        jTableGamaProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableGamaProductos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableGamaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableGamaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGamaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGamaProductos);
        if (jTableGamaProductos.getColumnModel().getColumnCount() > 0) {
            jTableGamaProductos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableGamaProductos.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTableGamaProductos.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableGamaProductos.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Todos los productos del Vendedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableProductosPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jTableProductosPedido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jTableProductosPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProductosPedido);
        if (jTableProductosPedido.getColumnModel().getColumnCount() > 0) {
            jTableProductosPedido.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableProductosPedido.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTableProductosPedido.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableProductosPedido.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Todos los Productos  en tu pedido ...");

        jButtonAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(204, 204, 0));
        jButtonAceptar.setText("Aceptar");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel5.setText("Vendedor");

        jLabel6.setText("Comprador");

        jLabelNombreVendedor.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombreVendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombreVendedor.setText("Vendedor");

        jLabelNombreComprador.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombreComprador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNombreComprador.setText("Comprador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreVendedor)
                    .addComponent(jLabelNombreComprador))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jLabelImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelImagen2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addComponent(jLabelImagen4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButtonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalir)
                            .addComponent(jButtonReLogin))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jTableProductosPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosPedidoMouseClicked
       // obtengo el pedido seleccionado
       
        int indexProducto= jTableProductosPedido.getSelectedRow();
        // propongo si lo quiere elimar o mantener
        boolean result = MetodosEstaticosDialogos.avisoDialogo(this, "Eliminar", "Volver", "Elimina este producto o vuelve al pedido");
        if(result){
            Datos.posicionesNuevoPedido.remove(indexProducto);
            refrescarTablaProductos();
        }
        
        
    }//GEN-LAST:event_jTableProductosPedidoMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        MetodosEstaticosDialogos.acercaDe(this);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        MetodosEstaticosDialogos.acercaDe(this);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTableGamaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGamaProductosMouseClicked
        // obtengo el pedido seleccionado
        int index= jTableGamaProductos.getSelectedRow();
        System.out.println("****************************** has elegido un producto para añadir "+Datos.productosParaVender.get(index).getNombre());
        Posicion posicion = MetodosEstaticosDialogos.dialogoProductoAdd(this, Datos.productosParaVender.get(index));
        Datos.posicionesNuevoPedido.add(posicion);
        System.out.println("se ha añadido el producto en posicionesNuevoPedido ya van añadidos "+Datos.posicionesNuevoPedido.size());
        refrescarTablaProductos();
    }//GEN-LAST:event_jTableGamaProductosMouseClicked

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        resultado=true;
        boolean result = MetodosEstaticosDialogos.avisoDialogo(this, "Aceptar","Cancelar", "Vamos a procesar tu nuevo pedido, Gracias.");
        if(result){
        HiloNuevoPedido hilo = new HiloNuevoPedido();
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Nuevo_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
         hilo.start();
        // como el join no funciona bien hago este "bucle";
       while(hilo.isAlive()){
            try {
                sleep(50);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Nuevo_pedido.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        System.out.println("************************ acabado el hilo de guardar el pedido :? "+!hilo.isAlive());
        MetodosEstaticosDialogos.avisoDialogo(this, "Aceptar", "Tu pedido con id: "+Datos.pedidoNuevo.getId()+" a "+Datos.pedidoNuevo.getVendedor().getNombre()+ " ha sido procesado ");
        new HiloEnviarMail("rogasturias@gmail.com", "nuevo pedido en marcha", "Te han realizado un nuevo pedido", Datos.VENDEDOR.getId()).start();
        new HiloEnviarMail("rogasturias@gmail.com", "nuevo pedido en marcha", "Has realizado un nuevo pedido", Datos.CLIENTE.getId()).start();
        }
        result = MetodosEstaticosDialogos.avisoDialogo(this, "Nuevo Pedido","Volver", "Quieres seguir haciendo pedidos, o volver");
        if(result){
            int vendedorId = MetodosEstaticosDialogos.dialogoComboEligeVendedor(this);
            Datos.VENDEDOR=Datos.todosVendedores.get(vendedorId);
            refrescarTablaProductoGamaVendedor();
            refrescarTablaProductos();
        }
        else{
            new HiloElegirOpcciones(this).start();
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        resultado=false;
        new HiloElegirOpcciones(this).start();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonReLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReLoginActionPerformed
        new HiloElegirOpcciones(this).start();
    }//GEN-LAST:event_jButtonReLoginActionPerformed
    
    
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonReLogin;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelImagen1;
    private javax.swing.JLabel jLabelImagen2;
    private javax.swing.JLabel jLabelImagen3;
    private javax.swing.JLabel jLabelImagen4;
    private javax.swing.JLabel jLabelImagen5;
    private javax.swing.JLabel jLabelNombreComprador;
    private javax.swing.JLabel jLabelNombreVendedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGamaProductos;
    private javax.swing.JTable jTableProductosPedido;
    // End of variables declaration//GEN-END:variables

    
}
