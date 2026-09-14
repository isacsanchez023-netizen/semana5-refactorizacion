package edu.uees.disenosoftware.service;

import edu.uees.disenosoftware.domain.Reserva;

public class ServicioReservas {
    // Definimos la constante expresiva para la regla de negocio
    private static final int HORAS_MINIMAS_CONFIRMACION = 2;

    public void confirmarReserva(Reserva reserva, int horasAnticipacion) {
        if (reserva != null) {
            if (reserva.getEstudiante() != null) {
                if (reserva.getDocente() != null) {
                    if (!reserva.isCancelada()) {
                        // Reemplazamos el número mágico por la constante
                        if (horasAnticipacion >= HORAS_MINIMAS_CONFIRMACION) {
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