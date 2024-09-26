
# Laboratorio I-2024
## <sup>Asignatura: Patrones de Software y Programación </sup> <br><sup>Profesor: Daniel San Martín</sup> <br> <sup> Nombre Estudiante:
</sup>
<hr>
Dado el enunciado a continuación, implemente el patrón de diseño que usted considere necesario
para dar solución al requerimiento. Además, explique porqué escogió el patrón, cual es su característica
donde se clasifica el patrón y porqué da solución a la problemática.
<hr>

# Enunciado

Una empresa de desarrollo de software ha sido contratada para implementar una 
solución que gestione el acceso a una biblioteca digital de recursos multimedia, 
que incluye imágenes, vídeos y documentos. Esta biblioteca contiene archivos de 
gran tamaño, por lo que cargar todo su contenido en memoria simultáneamente podría 
generar problemas de rendimiento y consumo de memoria.

El sistema debe permitir a los usuarios visualizar una lista de los recursos 
disponibles y seleccionar uno para ser visualizado. Sin embargo, no es necesario 
cargar el contenido completo de los archivos multimedia hasta que el usuario 
decida abrir alguno de ellos. Además, algunos de estos archivos están protegidos, 
y su acceso debe ser controlado. Solo usuarios con los permisos adecuados deben 
poder abrir y visualizar los archivos protegidos.

Su tarea es diseñar una solución que permita lo siguiente:

 * Mostrar una lista de archivos disponibles sin cargarlos todos en memoria.
 * Cargar el contenido de un archivo únicamente cuando el usuario lo solicite.
 * Controlar el acceso a los archivos protegidos para asegurar que solo usuarios con 
permisos válidos puedan visualizarlos.

## Requisitos adicionales:
1. Define una interfaz adecuada para permitir que los archivos sean accesibles, y 
asegúrese de que se implemente un mecanismo de control de acceso para los archivos protegidos.

2. Implemente una solución que garantice la carga diferida de los recursos multimedia, 
evitando cargar en memoria archivos innecesarios hasta que sean solicitados explícitamente.

3. Considera posibles expansiones futuras, en las que podrían agregarse nuevos tipos de recursos multimedia o nuevos roles de usuarios con permisos específicos.

## Ejemplo de uso:
* Un usuario sin permiso intenta acceder a un archivo protegido: el sistema debe denegar el acceso.
* Un usuario autorizado selecciona un archivo: el sistema debe cargar el archivo (si no ha sido cargado ya) y mostrarlo.

<hr>

## Explicación
(Escriba aquí su explicación)


<hr>