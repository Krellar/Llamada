/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Llamada;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 * @author dvs91
 */
public class Llamada implements Comparable {
    public int telefonoCliente;
    public int numeroInterlocutor;
    public boolean llamadaSaliente;
    public boolean llamadaEntrante;
    public LocalDateTime horaInicio;
    public LocalDateTime horaFin;
    public ZonaFacturacion zonafacturacion;

    public Llamada(int telefonoCliente, int numeroInterlocutor, boolean llamadaSaliente, boolean llamadaEntrante, LocalDateTime horaInicio, LocalDateTime horaFin, ZonaFacturacion zonafacturacion) {
        this.telefonoCliente = telefonoCliente;
        this.numeroInterlocutor = numeroInterlocutor;
        this.llamadaSaliente = llamadaSaliente;
        this.llamadaEntrante = llamadaEntrante;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.zonafacturacion = zonafacturacion;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getNumeroInterlocutor() {
        return numeroInterlocutor;
    }

    public void setNumeroInterlocutor(int numeroInterlocutor) {
        this.numeroInterlocutor = numeroInterlocutor;
    }

    public boolean isLlamadaSaliente() {
        return llamadaSaliente;
    }

    public void setLlamadaSaliente(boolean llamadaSaliente) {
        this.llamadaSaliente = llamadaSaliente;
    }

    public boolean isLlamadaEntrante() {
        return llamadaEntrante;
    }

    public void setLlamadaEntrante(boolean llamadaEntrante) {
        this.llamadaEntrante = llamadaEntrante;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public ZonaFacturacion getZonafacturacion() {
        return zonafacturacion;
    }

    public void setZonafacturacion(ZonaFacturacion zonafacturacion) {
        this.zonafacturacion = zonafacturacion;
    }

    @Override
    public String toString() {
        return "Llamada{" + "telefonoCliente=" + telefonoCliente + ", numeroInterlocutor=" + numeroInterlocutor + ", llamadaSaliente=" + llamadaSaliente + ", llamadaEntrante=" + llamadaEntrante + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", zonafacturacion=" + zonafacturacion + '}';
    }

  

   
    private static final double TARIFA_ZONA_1 = 0.75;
    private static final double TARIFA_ZONA_2 = 1.00;
    private static final double TARIFA_ZONA_3 = 2.10;
    private static final double TARIFA_ZONA_4 = 3.00;
    private static final double TARIFA_ZONA_5 = 4.50; 

   public double costo() {
        double precioMinuto = 0;
        if (!llamadaSaliente) {
            return 0;
        }
        switch (zonafacturacion) {
            case ZONA_1:
                precioMinuto = TARIFA_ZONA_1;
            case ZONA_2:
                precioMinuto = TARIFA_ZONA_2;
                break;
            case ZONA_3:
                precioMinuto = TARIFA_ZONA_3;
                break;
            case ZONA_4:
                precioMinuto = TARIFA_ZONA_4;
                break;
            case ZONA_5:
                precioMinuto = TARIFA_ZONA_5;
                break;
        }
        return duracionLlamada() * precioMinuto;
    }

    public long duracionLlamada(){
      return horaInicio.until(horaFin, MINUTES);
}
    
    
    @Override
    public int compareTo(Object otro) {
       int resultado;
        Llamada otraLlamada= (Llamada) otro;
        if (telefonoCliente < otraLlamada.telefonoCliente) { 
            resultado = -1; 
        } else if (telefonoCliente > otraLlamada.telefonoCliente) { //this va después que otroSocio
            resultado = 1; 
        } else {
            if (horaInicio.toEpochSecond(ZoneOffset.UTC)< otraLlamada.horaInicio.toEpochSecond(ZoneOffset.UTC)){
            resultado = -1;
        } else if (horaInicio.toEpochSecond(ZoneOffset.UTC) > otraLlamada.horaInicio.toEpochSecond(ZoneOffset.UTC)){
            resultado = 1;
        }
            else {
            resultado = 0;
        }
    }
    return resultado;
    }
        
        
        
    public enum ZonaFacturacion {
		ZONA_1,
		ZONA_2,
		ZONA_3,
		ZONA_4,
		ZONA_5,
		ZONA_6
	}
}
