Enunciado del caso

El equipo de biblioteca de la Universidad Nacional Andrés Bello para la sede de Antonio Varas le ha solicitado a usted y a su equipo actualizar el sistema de biblioteca de dicha institución, para ello el establecimiento ha dispuesto la siguiente lista de requerimientos.


1. **Requerimiento usuarios:**
    1. Cada usuario tiene los siguientes atributos 
       1. Nombre completo.  
        2.	 RUN.  
        3.	 Género.  
        4.	 Carrera.  
        5.	 Préstamo.  
    2. Crear y editar usuario  
        1. El RUN no puede repetirse.  
        2.	 Debe validar formato y dígito verificador del RUN.  
        3.	 Debe validar que el género del usuario sea M o F.  
        4.	 Préstamo corresponde a si el usuario tiene en su poder o no un libro, siendo cero no, e ISBN que sí.  
    3.	Eliminar usuario, debe validar que exista.  
    4.	Existen usuarios que son Docentes o Estudiantes. A los docentes adicionalmente se les registra la profesión con sus grados (magíster y/o doctor); y a los estudiantes la carrera que está estudiando.  
2.	**Requerimiento Libro**
    1.	Cada libro debe contener los siguientes atributos
        1.	 ISBN (Código libro).
        2.	 Título.
        3.	 Autor.
        4.	 Cantidad en biblioteca.
        5.	 Cantidad disponible préstamo.
        6.	 Imagen.
    2.	Crear Libro
        1.	 El ISBN debe ser único.
        2.	 Cantidad en biblioteca debe ser mayor a cero
        3.	 Cantidad disponible debe ser mayor a cero y menor o igual a cantidad en biblioteca.
    3.	Eliminar Libro a través del ISBN, debe validar que exista.
3.	**Requerimiento Préstamo y Devolución**
    1.	***Préstamo***
        1.	 Debe ingresar ISBN del Libro a prestar.
        2.	 El libro debe existir.
        3.	 El libro debe tener al menos un ejemplar disponible.
        4.	 Debe ingresar RUN usuario quien solicitó el libro.
        5.	 El RUN debe existir.
        6.	 El usuario debe estar habilitado para préstamo.
        7.	 De cumplirse todos los puntos anteriores, el usuario debe quedar no disponible para nuevo préstamo a través del atributo préstamo, dejando el ISBN del libro a prestar.
        8.	 De cumplirse todos los puntos anteriores, debe restar uno a la cantidad de ejemplares disponibles del libro.
        9.	 Para el nuevo préstamo debe ingresar la fecha actual, de forma automática.
        10.	Debe ingresar la cantidad de días que se prestó el libro (si es docente el período máximo de préstamo es de 20 días y si es estudiante el período máximo es 10 días).
        11.	Debe ingresar la fecha que debe ser devuelto el libro de forma automática.
        12.	Finalmente generar la tarjeta de préstamo que será impresa y pegada en el libro que contenga los datos del préstamo (diseñe un formato ad-hoc).
    2.	***Devolución***
        1.	 Debe ingresar ISBN del libro a devolver.
        2.	 Debe validar que el libro exista.
        3.	 Debe ingresar el RUN del usuario.
        4.	 Debe validar que el usuario exista.
        5.	 Debe validar que tanto el ISBN del libro a devolver como el atributo préstamo del usuario sean el mismo.
        6.	 De cumplirse todo lo anterior debe dejar habilitado al usuario para que pueda solicitar un nuevo libro.
        7.	 De cumplirse todo lo anterior debe sumar uno a la cantidad de ejemplares disponibles del libro.
        8.	 Debe considerar que, si la devolución se entrega en un plazo mayor a la fecha que debió devolver el libro, al usuario se le cobrará una multa de $1.000 por cada día de retraso.

**Consideraciones**

1.	Todas las actualizaciones hechas por los requerimientos anteriores deben ser cambiados tanto en su programa como en el sistema de almacenamiento, el cual se basa en archivos de texto plano.
2.	El programa debe estar hecho en interfaz gráfica JFRAME y JDIALOG.
3.	El programa debe contar con un menú principal (home) que lleve a los requerimientos pedidos.
4.	En todo momento el programa debe ser capaz de tener acceso al home (uso ventanas secundarias o botón volver).
5.	Para todo el proyecto debe usar metodologías POO y buenas prácticas de la POO.
