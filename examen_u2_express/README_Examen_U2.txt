EXAMEN U2 - Despacho express con bitácora (versión corta)
==============================================================

Objetivo
--------
Implementar un sistema de despacho de trabajos usando TUS estructuras:
- ArrayQueue<JobCustom>: trabajos pendientes.
- ArrayStack<JobCustom>: buffer de procesamiento (LIFO).
- SinglyLinkedList (de JobCustom): bitácora de confirmados (append al final).

Comandos
--------
ADD        -> Pide ID y encola al FINAL de la Queue.
PROCESS n  -> Pide n y mueve hasta n elementos de Queue->Stack (FIFO a LIFO).
COMMIT     -> Vuelca Stack a SinglyLinkedList con addLast (en orden de pop).
UNDO      -> Quita el ULTIMO de la bitácora (removeLast) y lo pone al FRENTE de la Queue (offerFront).
PRINT      -> Imprime estado actual de las tres estructuras.
END        -> Imprime estado final y termina.

Flujo
------------------
1) Llegan trabajos (ADD) -> Queue (front->rear).
2) Lote de proceso (PROCESS n): toma n del frente de Queue y los PUSH al Stack.
3) Confirmación (COMMIT): POP desde Stack y ADDLAST en SinglyLinkedList (bitácora).
4) Deshacer último (UNDO1): REMOVELAST en SinglyLinkedList y OFFERFRONT en Queue.
5) PRINT/END: muestras de estado.

Diagrama de flujo 
--------------------------------
[ADD] -> encola trabajo
[PROCESS] -> toma n de Queue y los PUSHEA al Stack
[COMMIT] -> vacia Stack a Bitacora (addLast)
[UNDO] -> removeLast de Bitacora y offerFront en Queue
[PRINT/END] -> imprime estados

Secuencia de ejemplo
--------------------
ADD
A
ADD
B
PROCESS
2
COMMIT
UNDO
PRINT
END

Salida ejemplo
-----------------------
QUEUE (pendientes): [Job{id=B}]
STACK (procesando): []
BITACORA (confirmados): [Job{id=A}]
=== ESTADO FINAL ===
QUEUE (pendientes): [Job{id=B}]
STACK (procesando): []
BITACORA (confirmados): [Job{id=A}]



Restricciones
-------------
- Prohibido usar java.util.Queue, java.util.Stack, LinkedList, ArrayList u otras colecciones del core.
- Obligatorio utilizar las clases provistas en /CustomQueue, /CustomStack, /CustomList y /model.



Notas
-----
- ArrayQueue incluye offerFront(T) para reinsertar al frente durante UNDO.
- Si SinglyLinkedList está vacía al hacer UNDO, debe imprimir "Nada que deshacer".
