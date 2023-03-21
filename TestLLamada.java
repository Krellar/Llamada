/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Llamada;
import Llamada.Llamada.ZonaFacturacion;
import java.time.LocalDateTime;



/**
 *
 * @author dvs91
 */
public class TestLLamada {
     public static void main(String[] args) {
        Llamada Llamada1 = new Llamada(698764354, 629087643, true,false, LocalDateTime.of(2023, 10, 19, 8, 22), LocalDateTime.of(2023, 10, 19, 9, 15), ZonaFacturacion.ZONA_2);
        Llamada Llamada2 = new Llamada(697473787, 639876709, false,true, LocalDateTime.of(2023, 10, 02, 7, 30), LocalDateTime.of(2023, 10, 02, 8, 25), ZonaFacturacion.ZONA_2);
        System.out.println(Llamada1.toString());
        System.out.println(Llamada2.toString());
        System.out.println(Llamada1.costo());
        System.out.println(Llamada1.duracionLlamada());
    }

}

