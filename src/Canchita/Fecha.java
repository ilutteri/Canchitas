package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
public class Fecha {

	
		private LocalDate dias;
		private Turno[] turnosDisp= {new Turno (LocalTime.of(14, 0)), new Turno (LocalTime.of(15, 0)), new Turno (LocalTime.of(16, 0)), new Turno (LocalTime.of(17, 0)),new Turno (LocalTime.of(18, 0)),new Turno (LocalTime.of(19, 0)),
				new Turno (LocalTime.of(20, 0)), new Turno (LocalTime.of(21, 0)), new Turno (LocalTime.of(22, 0)), new Turno (LocalTime.of(23, 0))};
		private ArrayList<Turno>turnosReservados;
		
		
		
		public Fecha (LocalDate dia) {
			this.dias=dia;
			this.turnosReservados=new ArrayList<>();
		}
		
		public boolean coincideDia(LocalDate dia2) {
			return this.dias.equals(dia2);
		}

		public void mostrarTurnosDisponibles () {
			for (int i =0; i<this.turnosDisp.length;i++) {
				
				if(this.turnosDisp[i].puedeReservar()) {
					System.out.println("El dia "+dias+" "+this.turnosDisp[i].toString());
				}
			}
		}
		
		public Resultado reservarTurno(LocalTime horaInicio, Usuario usuario) {
			Resultado resul= null;
			Turno turnoAReservar= this.buscarHora (horaInicio) ;
			if(turnoAReservar!=null) {
				if(turnoAReservar.puedeReservar()) {
					turnoAReservar.reservar(usuario);
					resul= Resultado.RESERVA_OK;
					this.turnosReservados.add(turnoAReservar);
					
				} else {resul= Resultado.CANCHA_NO_DISPONIBLE;}
			} else {resul= Resultado.HORARIO_NO_DISPONIBLE;}
			System.out.println(resul);
			return resul;
		}
		
		
		private Turno buscarHora(LocalTime horario) {
			Turno hBuscado=null;
			Turno hEncontrada= null;
			int i =0;
			
			while (i<this.turnosDisp.length && hEncontrada==null) {
				hBuscado=this.turnosDisp[i];
				if (hBuscado.coincideHora(horario)) {
					hEncontrada= hBuscado;
				}
				i++;
			}
			return hEncontrada;
		}

		@Override
		public String toString() {
			return "Fecha [dias=" + dias + ", turnosDisp=" + Arrays.toString(turnosDisp) + ", turnosReservados="
					+ turnosReservados + "]";
		}
		
		
		
}
