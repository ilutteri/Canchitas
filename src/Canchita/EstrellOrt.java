package Canchita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class EstrellOrt {

	private ArrayList<Cancha> canchas;
	private LinkedList<Usuario> usuarios;
	private LinkedList<Reserva> reservas;
	
	
	public EstrellOrt() {
		this.canchas = new ArrayList<>();
		this.usuarios =  new LinkedList<>();
		this.reservas =  new LinkedList<>();
	}
	
	public void mostrarCanchas () {
		for (Cancha c : this.canchas) {
			System.out.println(c);
		}
	}
	
	private Cancha buscarCancha(int numCancha) {
		Cancha cBuscada =null;
		Cancha cEncontrada=null;
		int i =0;
		while (i<this.canchas.size()&& cEncontrada==null) {
			cBuscada=this.canchas.get(i);
			if(cBuscada.coincideCancha(numCancha)) {
				cEncontrada=cBuscada;
			}
			i++;
		}
		return cEncontrada;
	}
	
	public void mostrarDisponibilidadPorCancha(int i, LocalDate dia) {
		Cancha c = this.buscarCancha(i);
		if(c!=null) {
			c.mostrarReservaDelDia(dia);
		}
	}
	
	private Usuario buscarUsuario(String usuario) {
		Usuario cBuscada =null;
		Usuario cEncontrada=null;
		int i =0;
		while (i<this.usuarios.size()&& cEncontrada==null) {
			cBuscada=this.usuarios.get(i);
			if(cBuscada.coincideMail(usuario)) {
				cEncontrada=cBuscada;
			}
			i++;
		}
		return cEncontrada;
	}
	
	public void agregarDiaPorCancha (int i, LocalDate dia) {
	Cancha c= this.buscarCancha(i);
	c.agregarFecha(dia);
	}
	
	public Resultado reservarCancha(String usuario, int nroCancha, LocalDate dia, LocalTime horaInicio) {
		Resultado resul= null;
		Usuario u = this.buscarUsuario(usuario);
		if (u!=null) {
			Cancha c=this.buscarCancha(nroCancha);
			if (c!=null) {
				resul= c.reservarDia( dia, horaInicio, u);
				if(resul==Resultado.RESERVA_OK) {
					this.reservas.add(new Reserva(dia, horaInicio, nroCancha));
					u.agregarReserva(new Reserva(dia, horaInicio, nroCancha));
				}
			}
		}
	
		return resul;
	}
	
	
	public void agregarCancha (double precio, TipoPiso tipoPiso, TipoCancha tipoCancha) {
		this.canchas.add(new Cancha(precio, tipoPiso,tipoCancha));
	}
	
	public void agregarUsuario (String nombre, String telefono, Perfil perfilUsuario, String email, String contraseña) {
		this.usuarios.add(new Usuario (nombre,telefono, perfilUsuario, email, contraseña));
	}
	
}
