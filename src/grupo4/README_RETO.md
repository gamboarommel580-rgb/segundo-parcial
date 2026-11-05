# Reto práctico integrador SJA-UTA (APE 3 · Grupo 4)

Base: repositorio `shirleymikaela2/APE3-Grupo4-Integracion-y-pruebas-`. Se conservan los paquetes `enums`, `modelo`, `negocio` y `app` y las firmas existentes.

## Ejecutar
```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src\grupo4 -Filter *.java).FullName
chcp 65001
java -cp out grupo4.app.Main
```
Opción **8** ejecuta el reto (41 verificaciones). Opción **7** restablece los datos iniciales.

## Cambios realizados
| Misión | Clase | Cambio |
|---|---|---|
| 1 | `ArbolOrganizacional` | `obtenerRutaJerarquica(String)` recursivo: devuelve `UTA -> ... -> codigo` o `No existe`. |
| 2 | `ArbolOrganizacional` | `eliminar` ya bloqueaba unidades con subunidades y paralelos con estudiantes (`puedeEliminarUnidad`); se verificó, no se cambió. `transformarABinario()` solo genera texto, no modifica el árbol. |
| 3 | `Estudiante` | Ya validaba matrícula > 0 y promedio finito entre 0 y 10; se verificó, no se cambió. |
| 3 | `ArbolOrganizacional` | `trasladarEstudiante(origen, destino, matricula)`: valida que ambos existan, sean distintos y de tipo PARALELO, que el estudiante esté en el origen y no en el destino; inserta primero en el destino y elimina del origen solo si la inserción fue correcta; si la eliminación fallara, deshace la inserción en el destino. |
| 4 | `ArbolEstudiantes` | `modificar` ya validaba con un `Estudiante` temporal antes de cambiar el registro real; se verificó con cédula inválida y promedio 15. |
| 5 | `ArbolEstudiantes` | `contarAprobados(double)` recursivo (promedio ≥ nota mínima). |
| 6 | `Main` | Opción 8 «Ejecutar reto integrador»; empieza con `reiniciar()`, por eso repetirla no duplica unidades ni estudiantes. La opción 7 ahora muestra la verificación del reinicio. |

## Resultados esperados (comprobados al ejecutar)
- Ruta de EB-N1-A: `UTA -> FCHE -> EB -> EB-N1 -> EB-N1-A`.
- Tras agregar SW, SW-N3 y SW-N3-A: altura 4, hojas 3, nivel de SW-N3-A = 4.
- Transformación: `Hermano Der de EB: SW` y `Hermano Der de EB-N1-A: EB-N1-B`.
- Traslados 10 (hoja), 40 (un hijo), 45 (dos hijos, sucesor 50) y 30 (raíz, sucesor 35).
- EB-N1-A = [15, 20, 35, 50, 55], promedio 8.36, altura 2; EB-N1-B = [10, 30, 40, 45], promedio 8.00, altura 2.
- Aprobados (≥ 8.00): 5 y 4.

## Por qué el inorden conserva el orden
El inorden recorre izquierdo → nodo → derecho. En un ABB todo lo de la izquierda es menor y todo lo de la derecha es mayor, y las eliminaciones (hoja, un hijo y sucesor inorden) mantienen esa propiedad; por eso las matrículas salen ordenadas antes y después de cada traslado.
