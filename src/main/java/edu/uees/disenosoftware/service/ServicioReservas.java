package edu.uees.disenosoftware.service;

import edu.uees.disenosoftware.domain.Reserva;

public class ServicioReservas {
    public void confirmarReserva(Reserva reserva, int horasAnticipacion) {
        if (reserva != null) {
            if (reserva.getEstudiante() != null) {
                if (reserva.getDocente() != null) {
                    if (!reserva.isCancelada()) {
                        if (horasAnticipacion >= 2) {
                            System.out.println("Procesando...");
                            System.out.println("Reserva: " + reserva.getId());
                            System.out.println("Estudiante: "
                                    + reserva.getEstudiante().getNombre());
                            System.out.println("Docente: "
                                    + reserva.getDocente().getNombre());
                            reserva.confirmar();
                            System.out.println("Reserva confirmada");
                        }
                    }
                }
            }
        }
    }
}