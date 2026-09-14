package edu.uees.disenosoftware.service;

import edu.uees.disenosoftware.domain.Reserva;

public class ServicioReservas {
    private static final int HORAS_MINIMAS_CONFIRMACION = 2;

    public void confirmarReserva(Reserva reserva, int horasAnticipacion) {
        if (!esReservaValida(reserva)) {
            return;
        }
        if (horasAnticipacion < HORAS_MINIMAS_CONFIRMACION) {
            return;
        }

        // Delegación de la fase final a una operación de alto nivel
        ejecutarConfirmacion(reserva);
    }

    private boolean esReservaValida(Reserva reserva) {
        return reserva != null
                && reserva.getEstudiante() != null
                && reserva.getDocente() != null
                && !reserva.isCancelada();
    }

    private void ejecutarConfirmacion(Reserva reserva) {
        mostrarResumen(reserva);
        reserva.confirmar();
        System.out.println("Reserva confirmada");
    }

    private void mostrarResumen(Reserva reserva) {
        System.out.println("Procesando...");
        System.out.println("Reserva: " + reserva.getId());
        System.out.println("Estudiante: " + reserva.getEstudiante().getNombre());
        System.out.println("Docente: " + reserva.getDocente().getNombre());
    }
}