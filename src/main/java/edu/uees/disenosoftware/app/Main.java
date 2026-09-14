package edu.uees.disenosoftware.app;

import edu.uees.disenosoftware.domain.Docente;
import edu.uees.disenosoftware.domain.Estudiante;
import edu.uees.disenosoftware.domain.Reserva;
import edu.uees.disenosoftware.service.ServicioReservas;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(
                "Ana Torres",
                "ana@uees.edu.ec"
        );
        Docente docente = new Docente(
                "Carlos Pérez",
                "carlos@uees.edu.ec"
        );
        Reserva reserva = new Reserva(
                "R-001",
                estudiante,
                docente
        );
        ServicioReservas servicio = new ServicioReservas();

        // Llamada actualizada con el nuevo nombre
        servicio.confirmarReserva(reserva, 4);

        System.out.println(
                "Estado final: " + reserva.getEstado()
        );
    }
}