package edu.uees.disenosoftware.service;

import edu.uees.disenosoftware.domain.Reserva;

public class ServicioReservas {
    private static final int HORAS_MINIMAS_CONFIRMACION = 2;

    public void confirmarReserva(Reserva reserva, int horasAnticipacion) {
        // Validación delegada al método extraído
        if (!esReservaValida(reserva)) {
            return;
        }
        if (horasAnticipacion < HORAS_MINIMAS_CONFIRMACION) {
            return;
        }

        // Flujo principal de confirmación
        System.out.println("Procesando...");
        System.out.println("Reserva: " + reserva.getId());
        System.out.println("Estudiante: " + reserva.getEstudiante().getNombre());
        System.out.println("Docente: " + reserva.getDocente().getNombre());
        reserva.confirmar();
        System.out.println("Reserva confirmada");
    }

    // Método extraído para aislar la regla de integridad de la reserva
    private boolean esReservaValida(Reserva reserva) {
        return reserva != null
                && reserva.getEstudiante() != null
                && reserva.getDocente() != null
                && !reserva.isCancelada();
    }
}