/**
 * \@author José Luis Montañana Llopis*/

package server;

import java.io.IOException;

	//	Uso como referencia el mail visto en el ejercicio de la Vt06.
	//	El nombres del Server es serv al igual que el del ejercicio de la Vt06:

public class Main {

    public static void main(String[] args) throws IOException {
        //Definimos objeto
    	Server serv = new Server();
    	
        //	Mensaje por consola:
        System.out.println("Iniciando Servidor . . . .");
        
        //Iniciamos el servidor
        serv.iniciarServer();
        
        //finalizamos el servidor
        serv.finalizarServer();
    }
}
