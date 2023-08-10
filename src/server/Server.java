/**
 * \@author José Luis Montañana Llopis*/

package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

	//	Uso como referencia el servidor visto en el ejercicio de la Vt06.
	//	Los nombres de las variables y funciones son los mismos que los del ejercicio de la Vt06:
	//	PUERTO, socket, ServerSocket, entradaServidor, salidaServidor, iniciarCliente

public class Server {
	//	clausula final en la especificación del puerto dado que no va a cambiar "9876"
    private final int PUERTO = 9876; 
    
    //	declaración de servidor y socket
    private ServerSocket serverSocket;    
    private Socket socket;
    
    //	Definición del constructor
    public Server() throws IOException {
    	//	Opertura de conexión
        serverSocket = new ServerSocket(PUERTO);
        //	Opertura del cliente
        socket = new Socket(); 
    }
    
    //	Función con la que se inicia la conexión
    public void iniciarServer() throws IOException {
    	
    	while (true) {

	    	//	Mostramos mensaje por consola    	
	    	System.out.println("Esperando la conexion del cliente");
	    	//	Servidor a la espera de recibir peticiones
	    	socket = serverSocket.accept();
	    	
	    	//	abrimos stream de salida de datos    	
	    	DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());
	    	//  abrimos stream de entrada de datos
	    	DataInputStream entradaCliente = new DataInputStream(socket.getInputStream());
	    	
	    	//	Enviamos consulta al cliente
	    	salidaCliente.writeUTF("¿Cual es el nombre del cliente?");
	    	
	    	//  Una vez conectado el cliente, le lanza la solicitud de nombre    	
	    	System.out.println("Solicitando nombre a cliente");
	    	
	    	
	    	
	    	//	Declaración de variable newName donde almacenar el nombre que facilita el cliente 
	    	String newName = entradaCliente.readUTF();
	    	
	    	//	Mostramos mensaje por consola 
	    	System.out.println(newName + " es el nombre facilitado por el cliente");
	    	//salidaCliente.writeUTF("Encantado de verte, " + newName);
	    	
	    	//	Solicitamos numero de tareas a cliente
	    	System.out.println("Solicitando nº de tareas a cliente");
	    	//salidaCliente.writeUTF("¿Cuantas tareas solicita?");
	    	
	    	//	Declaramos la variable numTareas donde a su vez introducimos el valor que recibimos de cliente.  	  
	    	
	    	int numTareas = entradaCliente.readInt();
	    	System.out.println("Número de tareas a realizar: " + numTareas);
	    	
	    	//	Declaramos un arraylist llamado list_tarea
	    	ArrayList<Tarea> listTarea = new ArrayList<Tarea>();
	    	
	    	//	Bucle que se realiza tantas veces como tareas solicitadas 
	    	for(int i = 0; i<numTareas; i++) {
	    		
	    		//	En cada Iteración informamos al cliente de:
	    		//	nº de tarea en curso
	    		//	Solicitamos descripción de tarea.
	    		//	Declaramos la variable descTarea donde a su vez introducimos el valor que recibimos de cliente.
	    		//	Solicitamos estado de tarea que almacenamos en tareaState
	    		//	Declaramos la variable tareaState donde a su vez introducimos el valor que recibimos de cliente.
	    		//	Añadimos al arraylist listTarea un nuevo objeto Tarea con los valores de descTarea y tareaState
	    		
	    		salidaCliente.writeUTF("La tarea numero: " + (i+1));  
	    		
	    		salidaCliente.writeUTF("Dime la descripcion de la tarea");
	
	    		String descTarea = (entradaCliente.readUTF());
	    		
	    		salidaCliente.writeUTF("Dime el estado de la tarea");
	
	    		String tareaState = entradaCliente.readUTF();    		
	    		
	    		listTarea.add(new Tarea(descTarea, tareaState));
	    	}    	
	    	
	    	//	Se informa al cliente de que se va enviar las tareas
	    	salidaCliente.writeUTF("Se procede a enviar las tareas, estas son: " + listTarea.toString());
	    	
	    	//	Informa de las tareas por consola
	    	System.out.println("Tareas a realizar: " + listTarea.toString());
	    	
	    	//	cierre de socket
	    	socket.close();
	    	
			//	cierre de streams de salida y de entrada
	    	entradaCliente.close();
	    	salidaCliente.close();	    	
	    }
    }
    
	//	Función con el cierre de servidor
	public void finalizarServer() throws IOException {
        serverSocket.close();
        System.out.println("Programa finalizado");
        
	}
    
}