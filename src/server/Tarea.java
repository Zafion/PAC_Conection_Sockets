/**
 * \@author José Luis Montañana Llopis*/

package server;

public class Tarea {
	//	En la clase tarea declaramos las variables "descripcion" y "estado" según lo solicitado en el enunciado
	private String descripcion;
	private String estado;
	
	//	Creamos el objeto Tarea con los atributos indicados:
	public Tarea(String descripcion, String estado) {				
		this.descripcion = descripcion;
		this.estado = estado;		
	}
	
	//	Getters:
	public String getDescripcion() {
		return descripcion;
	}		
	public String getEstado() {
		return estado;
	}
	
	//	Setters:		
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;		
	}		
	public void setEstado(String estado) {
			this.estado = estado;			
	}
	
	//	Metodo toString que establece el return de las tareas.
	@Override
	public String toString() {
		return "\nRecibida nueva tarea" + " Descripcion: " + descripcion + 
				", estado de la tarea: " + estado;
	}

}
