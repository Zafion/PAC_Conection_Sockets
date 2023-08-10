/**
 * \@author José Luis Montañana Llopis*/

package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

	//	Uso como referencia el cliente visto en el ejercicio de la Vt06.
	//	Los nombres de las variables y funciones son los mismos que los del ejercicio de la Vt06:
	//	HOST, PUERTO, socket, entradaServidor, salidaServidor, iniciarCliente
public class Client {	
	
	//	Creamos el HOST "localhost"	por ser conexión local a cambiar por ip en caso de conexión externa.
    private final String HOST = "localhost";
    
    //	Creamos el PUERTO 9876
    private final int PUERTO = 9876;
    
    //	Opertura de socket
    private Socket socket;  
    
    //	Declaración de variable scaner para recoger datos introducidos por consola.
    Scanner scaner = new Scanner(System.in);
    
    //	Definición del constructor
    public Client() throws IOException {
        socket = new Socket(HOST, PUERTO);
    }

    public void iniciarCliente() throws IOException {
    	
    	//	abrimos stream de entrada de datos
    	DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
    	
    	//	Mostramos el mensaje por consola
    	System.out.println(entradaServidor);
    	
    	//	abrimos stream de salida de datos
    	DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());    	
    	
    	System.out.println(entradaServidor);
    	//	Solicitamos nombre por consola
    	System.out.println("Facilita tu nombre para el servidor");
    	//	introducimos el nombre por consola
    	String newNombre = scaner.nextLine();
    	
    	//	enviamos nombre a servidor    	
    	salidaServidor.writeUTF(newNombre);
    	
    	//	Solicitamos cantidad de tareas por consola
    	System.out.println("¿Cuantas tareas debemos realizar");
    	
    	//	Declaración de variable nTareas donde a su vez introducimos su valor que conrresponde a la cantidad de tareas indicadas por consola.
    	int nTareas = scaner.nextInt();
    	scaner.nextLine();    	
    	//	enviamos cantidad de tareas al servidor
    	salidaServidor.writeInt(nTareas);
    	
    	//	bucle que se realiza tantas veces como tareas solicitadas 
    	for (int i = 0; i<nTareas;i++) {
    		
    		//	En cada Iteración:
    		//	Impresion por consola de mensaje de servidor indicando el nº de tarea vigente
    		//	Impresion por consola de mensaje de servidor solicitando la descripción de la tarea
    		//  Declaración de variable newDescripcion donde a su vez introducimos su valor que conrresponde a la descripción indicada por consola.
    		//	Informamos al servidor de la descripción
    		//	Impresion por consola de mensaje de servidor solicitando el estado de la tarea
    		//  Declaración de variable newStado donde a su vez introducimos su valor que conrresponde al estado indicada por consola.
    		//	Informamos al servidor del estado.
    		
    		
    		System.out.println(entradaServidor.readUTF());

    		System.out.println(entradaServidor.readUTF());    		

    		String newDescripcion = scaner.nextLine();
    		
    		salidaServidor.writeUTF(newDescripcion);

    		System.out.println(entradaServidor.readUTF());
    		

    		String newStado = scaner.nextLine();
    		salidaServidor.writeUTF(newStado);    		    	
    	}
    	
    	//	Impresion por consola de mensaje de servidor
		System.out.println(entradaServidor.readUTF()); 
		
		//	cierre de streams de salida y de entrada
		salidaServidor.close();
		entradaServidor.close();
    	
    	//	cierre de socket
    	socket.close();
    }
}
