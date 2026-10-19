# DeustoBooking — Grupo 17

## Ejecutar el avance de habitaciones

En Eclipse, abre `main/MainHabitaciones.java` dentro de la carpeta de código y elige **Run As > Java Application**. El proyecto está preparado para Java 17 o superior y UTF-8. No necesita librerías externas para este prototipo.

La carpeta de código configurada es `src/es/deusto/deustobooking`, porque los archivos originales declaran los paquetes `obj` y `gui.loginui`. Se conserva esa organización para facilitar la integración con el trabajo del equipo.

## Qué funciona

- Lista de habitaciones de ejemplo de un hotel, con número, tipo, capacidad, precio y disponibilidad.
- Filtro por número de huéspedes y por disponibilidad.
- Tabla en el mismo orden que la lista, sin ordenación por cabeceras para simplificar la selección.
- Selección de una habitación y cálculo del alojamiento según las noches.
- Resumen informativo y mensaje cuando no hay resultados.
- Validación de número, tipo, capacidad, precio y noches en `Habitacion`.

**Son datos simulados en memoria.** No se crean reservas ni se comprueba disponibilidad por fechas. Se selecciona una habitación física cada vez; todavía no se agrupan por tipo ni se ofrece cantidad de habitaciones o desayuno como en el boceto completo.

## Cómo está dividido el código

- `obj/Habitacion.java`: representa una habitación y valida sus datos. `calcularImporte` calcula precio por noche × noches.
- `gui/habitacionesui/HabitacionesWindow.java`: construye la ventana con layouts, carga los resultados en un `DefaultTableModel` y responde a los eventos.
- `main/MainHabitaciones.java`: crea los datos de ejemplo y abre la ventana en el hilo de Swing.
- `gui/loginui/LoginWindow.java`: conserva la pantalla original. Solo se ha corregido su punto de entrada para que sea público y use el hilo de Swing. El login todavía no está conectado a habitaciones.

## Relación con los contenidos de clase

Se usan clases, constructores, getters y setters, listas, bucles, condiciones, layouts de Swing, tablas y eventos. El inicio crea un `ArrayList` y añade las habitaciones una a una.

La versión simplificada elimina los renderers de colores, el formato de moneda con `Locale` y la multiplicación con `BigDecimal`. Usa condiciones `if/else` para mostrar la selección y los resultados. El precio se multiplica por las noches y se redondea a dos decimales con `Math.round`; es suficiente para estos datos de ejemplo, aunque no es una solución contable general.

Se conservan dos detalles que evitan errores y conviene comprender:

- `Double.isFinite`: impide guardar un precio infinito o NaN.
- `commitEdit`: valida el número escrito en los controles de huéspedes y noches.

`SwingUtilities.invokeLater` abre la ventana en el hilo de Swing, como en los materiales. No se afirma que cada método concreto esté explicado en clase. Se mantienen los comentarios de fuente externa que pide la asignatura.

Para seguir el funcionamiento: `MainHabitaciones` crea los datos, `cargarTabla` aplica los filtros, `getSeleccionada` obtiene la habitación elegida, `actualizarSeleccion` calcula su importe y `mostrarResumen` muestra el mensaje.

Contraste con los apuntes 3A y 4A: aparecen `JSpinner`, `DefaultTableModel`, `isCellEditable`, selección mediante listeners, lambdas e `invokeLater`. Se ha retirado la ordenación automática y `convertRowIndexToModel`, de modo que el índice seleccionado sirve directamente para consultar la lista. `commitEdit` es un detalle de validación del control; no se ha localizado explicado en los apuntes revisados.

## Próximos pasos del equipo

1. Integrar la ventana con la selección de hotel y el flujo de acceso.
2. Acordar la relación entre hotel, habitación y reserva y consultar disponibilidad por fechas.
3. Añadir gestión de habitaciones y persistencia SQLite.
4. Completar cantidad de habitaciones, desayuno y confirmación real según los bocetos.
5. Acordar la organización exigida de paquetes `main`, `gui`, `domain` y `db`; el paquete original `obj` sigue pendiente de migración.

## Verificación del avance

Versión simplificada: compilación con JDK 17 y `-Xlint:all`, más quince comprobaciones del modelo (importes, decimales, entradas inválidas y conservación del valor anterior al rechazar una modificación). La versión anterior también se probó visualmente desde Eclipse; esas pruebas visuales no se han repetido para esta revisión.

Eclipse puede mostrar avisos anteriores por atributos todavía sin usar en `Usuario`, y errores de otros proyectos del mismo espacio de trabajo. No equivalen a errores de compilación de esta ventana.
