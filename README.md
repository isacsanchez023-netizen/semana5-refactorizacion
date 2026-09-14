# Ae4 - Kata de Refactorización | Sistema de Gestión de Reservas

## 1. Descripción de la Actividad
Este repositorio contiene la solución de la **Kata de Refactorización (Ae4)**. El objetivo principal es mejorar el diseño interno, la legibilidad y la mantenibilidad del módulo `ServicioReservas` mediante transformaciones incrementales y seguras, garantizando la preservación del comportamiento observable del sistema respecto a la línea base inicial.

## 2. Diagnóstico de Code Smells (Código Inicial)
El código heredado presentaba las siguientes deficiencias de diseño:
* **Nombres poco expresivos (*Uncommunicative Names*):** Método `proc` y parámetros `r` y `h` sin intención semántica de negocio.
* **Número Mágico (*Magic Number*):** Literal `2` acoplado dentro de la condición de anticipación.
* **Anidamiento excesivo (*Arrow Anti-Pattern*):** 5 niveles de condicionales `if` anidados que sepultaban el camino feliz (*happy path*).
* **Mezcla de niveles de abstracción:** Un solo método gestionaba la validación de la entidad, las reglas de tiempo, la impresión en consola y el cambio de estado.

## 3. Secuencia de Refactorizaciones Aplicadas
La refactorización se realizó mediante un ciclo iterativo (*Refactorizar → Compilar → Probar → Commit*) dividido en 6 pasos incrementales:

1. **Rename:** Renombrado expresivo del método `proc` a `confirmarReserva`, y parámetros a `reserva` y `horasAnticipacion`.
2. **Extract Constant:** Creación de la constante privada `HORAS_MINIMAS_CONFIRMACION = 2` para otorgar sentido de negocio al número mágico.
3. **Guard Clauses:** Eliminación del anidamiento excesivo mediante retornos tempranos (`return`).
4. **Extract Method (`esReservaValida`):** Encapsulamiento de las reglas de integridad y verificación de nulidad de la reserva.
5. **Extract Method (`mostrarResumen`):** Separación de la responsabilidad de presentación e impresión en consola.
6. **Extract Method (`ejecutarConfirmacion`):** Abstracción de la fase final de confirmación como una operación de alto nivel.

## 4. Tecnologías y Comandos de Ejecución
* **Lenguaje:** Java
* **Gestor de proyectos:** Maven
* **Control de versiones:** Git

### Compilar el proyecto:
```bash
mvn clean compile