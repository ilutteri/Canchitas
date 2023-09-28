package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

	private LocalDate dia ;
	private LocalTime hora;
	private int nroCancha;
	public Reserva(LocalDate dia, LocalTime hora, int nroCancha) {
		this.dia = dia;
		this.hora = hora;
		this.nroCancha=nroCancha;
	}
	
	

}
