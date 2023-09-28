package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class Cancha {

	private static int acumulador ;
	private int nroCancha;
	private double precio;
	private LinkedList<Fecha> fechas;
	private TipoPiso tipoPiso;
	private TipoCancha tipoCancha;
	
	public Cancha(double precio, TipoPiso tipoPiso, TipoCancha tipoCancha) {
		acumulador++;
		this.nroCancha=acumulador;
		this.precio = precio;
		this.tipoPiso = tipoPiso;
		this.tipoCancha = tipoCancha;
		this.fechas=new LinkedList<>();
		
	}

	public void agregarFecha(LocalDate dia) {
		
		this.fechas.add(new Fecha(dia));
	}
	
	public void mostrarReservaDelDia(LocalDate dia) {
		Fecha f = this.buscarFecha(dia);
		if(f!=null) {
			f.mostrarTurnosDisponibles();
		}
	}
	
	public boolean coincideCancha(int numCancha) {
		
		return this.nroCancha==numCancha;
	}

	public Resultado reservarDia( LocalDate dia, LocalTime horaInicio, Usuario usuario) {
		Fecha dBuscado = this.buscarFecha(dia);
		Resultado resul =null;
		if(dBuscado!=null) {
			resul= dBuscado.reservarTurno(horaInicio, usuario);
		}
		
		return resul;
	}
	
	
	
	private Fecha buscarFecha (LocalDate dia) {
		Fecha cBuscada =null;
		Fecha cEncontrada=null;
		int i =0;
		while (i<this.fechas.size()&& cEncontrada==null) {
			cBuscada=this.fechas.get(i);
			if(cBuscada.coincideDia(dia)) {
				cEncontrada=cBuscada;
			}
			i++;
		}
		
		return cEncontrada;
	}

	@Override
	public String toString() {
		return "Cancha [nroCancha=" + nroCancha + ", precio=" + precio + ", fechas=" + fechas + ", tipoPiso=" + tipoPiso
				+ ", tipoCancha=" + tipoCancha + "]";
	}
	
	
}
