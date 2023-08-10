/**
 * \@author José Luis Montañana Llopis*/

package client;

import java.io.IOException;

		//	Uso como referencia el Main visto en el ejercicio de la Vt06.
		//	El nombres del Cliente es cli al igual que el del ejercicio de la Vt06:

public class Main{

        public static void main(String[] args) throws IOException {
        	
        	//	Creación de objeto cli de tipo Client
            Client cli = new Client();
            
            //	Mensaje por consola:
            System.out.println("Conexión de cliente iniciada, cliente numero: "  + Math.floor(Math.random()*100+1));
            
            //	Inicio de la conexion llamando a la funcion iniciarCliente del archivo Client
            cli.iniciarCliente();
        }
}
