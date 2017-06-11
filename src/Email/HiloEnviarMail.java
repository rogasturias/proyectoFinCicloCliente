package Email;

import java.io.*;
import java.net.*;



// clase que en fora de hilo se comunica con su server tcp/ip y le envia los datos para que se 
// gestione el envio de un mail.
public class HiloEnviarMail extends  Thread {

    static final String HOST = "localhost";
    static final int PUERTO = 2100;
    Socket skClienteEmail;
    String email;
    String asunto;
    String mensaje;
    int idCliente;

    boolean apagar = false;

    public HiloEnviarMail(String email, String asunto, String mensaje, int idCliente) {
        this.email = email;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.idCliente = idCliente;

    }

   

    public void run() {
        try {

            while (!apagar) {
                skClienteEmail = new Socket(HOST, PUERTO);
                // Creo los flujos de entrada y salida
                DataInputStream flujo_entrada = new DataInputStream(skClienteEmail.getInputStream());
                DataOutputStream flujo_salida = new DataOutputStream(skClienteEmail.getOutputStream());

                System.out.println("El MainServidor dice " + flujo_entrada.readUTF());

                // TAREAS QUE REALIZA EL CLIENTE
                flujo_salida.writeInt(idCliente);
                flujo_salida.writeUTF(email);
                flujo_salida.writeUTF(asunto);
                flujo_salida.writeUTF(mensaje);

                boolean resultado = flujo_entrada.readBoolean();
                if (resultado) {
                    System.out.println("Hemos recibido la confirmacion de correo enviado");
                    
                } else {
                    System.out.println("Hemos recibido la confirmacion de correo NO enviado");
                }
                apagar = true;

                if (skClienteEmail.isConnected()) {
                    skClienteEmail.close();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
