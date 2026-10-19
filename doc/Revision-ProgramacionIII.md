# Revisión de Programación III y del proyecto

Fecha: 19 de octubre de 2026.

## Alcance de la revisión

Se ha revisado el índice completo visible de ALUD, descargado sus 41 recursos de tipo Archivo, extraído el texto de los apuntes y examinado su estructura temática. La lectura detallada se ha centrado en requisitos del proyecto, rúbrica de fase I, bocetos del grupo, Swing y los enunciados y ejemplos de JTable relevantes para habitaciones. Se han consultado los enunciados publicados como páginas y el contenido listado en las carpetas de repaso.

Esto no es una auditoría línea por línea de todos los ZIP, libros, vídeos, foros ni exámenes externos enlazados. Los materiales del profesor descargados están fuera del repositorio, en Descargas; no se añaden al proyecto del grupo.

## Contenidos publicados y aplicación al proyecto

| Bloque | Contenidos encontrados | Aplicación a DeustoBooking |
| --- | --- | --- |
| 0A–0C | POO y Java; Eclipse, JRE/JDK y paquetes; depuración y breakpoints | Modelos de dominio, configuración y búsqueda de fallos |
| 0D–0E | List, Set, Map, genéricos, Comparator, equals/hashCode; pruebas JUnit | Colecciones de hoteles/habitaciones y pruebas de lógica |
| 0F–0H | Path/Files, recursos y Properties; CSV/JSON/XML; serialización | Carga de datos y configuración, si el equipo las necesita |
| 1A–1B | Compilación, classpath, librerías y JAR ejecutable | Ejecución local y distribución final |
| 1C–1D | API de Java, fechas, localización y logger; enums, lambdas, interfaces funcionales y Optional | Fechas de estancias, precios, eventos y tipos del dominio |
| 2A–2B | Planificación, seguimiento, Git y resolución de conflictos | Gantt actualizado y trabajo incremental de los cinco integrantes |
| 3A | Swing, layouts, eventos, componentes, JTable/JTree y personalización | Ventanas del cliente y administrador; lista de habitaciones |
| 4A | Threads, interrupción, Swing, join, acceso concurrente y pools | Consultas o procesos costosos fuera del hilo de la interfaz |

Prácticas publicadas: repaso París 2024, colecciones, JUnit, prácticas de Java y librerías, calculadora con layouts/eventos, formulario con pestañas, renderizado y eventos en tablas de cómics/personajes, árbol de lanzamientos por compañía y procesamiento de ficheros con hilos. También hay una carpeta de práctica guiada con código inicial y recursos.

No se encontraron en el índice visible apuntes publicados de los bloques posteriores de bases de datos o recursividad, aunque ambas materias sí figuran entre los requisitos del proyecto.

## Qué exige el proyecto

- Organización en paquetes `main`, `gui`, `domain`, `db`; documentación en `doc`, bibliotecas en `lib` y base de datos en `resources/db`.
- GUI adaptable, al menos JTable o JTree con renderizado y eventos personalizados, y diálogos de error/confirmación.
- Un hilo independiente para una tarea costosa, SQLite con dos tablas relacionadas y operaciones de gestión de datos, y al menos un método recursivo.
- Repositorio compartido, aportaciones frecuentes de todos los miembros, planificación y seguimiento de horas.
- Identificación de fuentes externas/IA mediante comentarios en el código y capacidad de explicar el trabajo.
- El documento detallado considera JUnit opcional, mientras que la presentación final lo incluye entre los aspectos evaluables: conviene confirmar este matiz con el profesor.

## Fase I

La primera fase se centra en planificación y prototipo GUI. La rúbrica publicada reparte 40 % a calidad/arquitectura, 30 % a interfaz y demostración y 30 % a proceso, alcance y planificación. Valora especialmente separación de lógica e interfaz, componentes personalizados y datos simulados suficientes para demostrar las ventanas.

La tarea se titula «26 de octubre - 14:00», pero el campo de cierre mostrado en la página indica **26 de octubre de 2026, 12:00**. Hay una discrepancia: confirmar la hora y, mientras tanto, planificar la entrega antes de las 12:00.

El comentario del profesor sobre la propuesta aprueba la idea, los bocetos y la planificación, pero indica que entonces no tenía acceso al repositorio privado. La revisión no ha modificado permisos; el equipo debe comprobar que el profesor puede entrar.

## Estado inicial del repositorio y avance realizado

El repositorio contenía seis archivos Java: la ventana LoginWindow, Usuario con atributos, TipoUsuario y las clases vacías Hotel, Reserva y Habitacion. No tenía configuración de Eclipse ni persistencia implementada.

El avance se limita al modelo Habitacion, una ventana de consulta con filtros y presupuesto, un inicio independiente con datos simulados y la configuración de Eclipse. No completa el sistema de reservas ni la gestión administrativa. El README explica cómo ejecutarlo, los métodos utilizados y los próximos pasos.

## Fuentes revisadas

- Curso: https://alud.deusto.es/course/view.php?id=43838
- Requisitos: https://docs.google.com/document/d/1UA9Jt0BVpGkfd7Ljbhj8ZXUmnglvN9oi1axoDd-IDbw/edit
- Primera entrega: https://alud.deusto.es/mod/assign/view.php?id=1440110
- Propuesta y comentario: https://alud.deusto.es/mod/assign/view.php?id=1440109
- Plan y bocetos aportados: ProgIII-Plan-G17 (1).pdf, páginas 2–9.
- Repositorio: https://github.com/asierying2/deustobooking
