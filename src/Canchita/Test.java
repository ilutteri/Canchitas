package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {

	public static void main(String[] args) {
		
		EstrellOrt e = new EstrellOrt();

		e.agregarUsuario("Saimon", "15555555", Perfil.JUGADOR, "elmaildeSaimon", "pashguord"); 
		e.agregarUsuario("Luki", "15556665", Perfil.JUGADOR, "elmaildeLuki", "pashguord");
		e.agregarUsuario("Igna", "14445555", Perfil.JUGADOR, "elmaildeIgna", "pashguord");
		
		e.agregarCancha(5000, TipoPiso.CEMENTO, TipoCancha.CANCHA_5);
		e.agregarCancha(9000, TipoPiso.SINTETICO, TipoCancha.CANCHA_7);
		e.agregarCancha(15000, TipoPiso.PARQUET, TipoCancha.CANCHA_5);
		e.agregarCancha(7000, TipoPiso.CEMENTO, TipoCancha.CANCHA_7);
		
		e.agregarDiaPorCancha(1, LocalDate.of(2023, 9, 29));
		e.agregarDiaPorCancha(2, LocalDate.of(2023, 9, 29));
		e.agregarDiaPorCancha(3, LocalDate.of(2023, 9, 29));
		e.agregarDiaPorCancha(4, LocalDate.of(2023, 9, 29));
		
		
		e.reservarCancha("elmaildeSaimon", 1, LocalDate.of(2023, 9, 29), LocalTime.of(19, 0));
		e.reservarCancha("elmaildeLuki", 1, LocalDate.of(2023, 9, 29), LocalTime.of(20, 0));
		e.reservarCancha("elmaildeIgna", 2, LocalDate.of(2023, 9, 29), LocalTime.of(19, 0));
		
		e.mostrarCanchas();
		
		e.mostrarDisponibilidadPorCancha(1, LocalDate.of(2023, 9, 29));
	}

}
