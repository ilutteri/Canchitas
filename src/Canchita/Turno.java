package Canchita;

import java.time.LocalTime;

public class Turno {

	private LocalTime horaInicio;
	private int horaFin;
	private Usuario usuarioQueReservo;
	
	
	public Turno (LocalTime horaInicio) {
		this.horaInicio=horaInicio;
	}
	
	
	
	public void reservar (Usuario user) {
		
		this.usuarioQueReservo=user;
	}
	
	public boolean puedeReservar () {
		return this.usuarioQueReservo==null;
	}
	
	public boolean coincideHora(LocalTime hora) {
		return this.horaInicio.equals(hora);
	}



	@Override
	public String toString() {
		return "Turno [horaInicio=" + horaInicio + "]";
	}
	
	
}
