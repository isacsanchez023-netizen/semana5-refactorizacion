package edu.uees.disenosoftware.service;

import edu.uees.disenosoftware.domain.Reserva;

public class ServicioReservas {
    private static final int HORAS_MINIMAS_CONFIRMACION = 2;

    public void confirmarReserva(Reserva reserva, int horasAnticipacion) {
        // Cláusulas de guarda: retornos tempranos si no se cumplen las condiciones
        if (reserva == null) {
            return;
        }
        if (reserva.getEstudiante() == null) {
            return;
        }
        if (reserva.getDocente() == null) {
            return;
        }
        if (reserva.isCancelada()) {
            return;
        }
        if (horasAnticipacion < HORAS_MINIMAS_CONFIRMACION) {
            return;
        }

        // Caminito feliz (lógica principal sin anidamiento)
        System.out.println("Procesando...");
        System.out.println("Reserva: " + reserva.getId());
        System.out.println("Estudiante: " + reserva.getEstudiante().getNombre());
        System.out.println("Docente: " + reserva.getDocente().getNombre());
        reserva.confirmar();
        System.out.println("Reserva confirmada");
    }
}