package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Usuario {

	private String nombre;
	private String telefono;
	private Perfil perfilUsuario;
	private String email;
	private String contraseña;
	private LinkedList<Reserva> reservas;
	
	
	public Usuario(String nombre, String telefono, Perfil perfilUsuario, String email, String contraseña) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.perfilUsuario = perfilUsuario;
		this.email = email;
		this.contraseña = contraseña;
		setTurno();
	}
	
	
	
	private void setTurno() {
		if(this.perfilUsuario== Perfil.JUGADOR) {
			this.reservas=new LinkedList<>();
		}
	}



	public boolean coincideMail(String usuario) {
		
		return this.email.equalsIgnoreCase(usuario);
	}



	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		
	}



	
	

	
}
