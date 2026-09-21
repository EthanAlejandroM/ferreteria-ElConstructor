# ferreteria-ElConstructor

La ferretería "El Constructor" es un negocio local dedicado a la venta de herramientas, materiales de construcción y productos para el hogar.

### Integrantes

* Nicolle Mera Gomez
* Ethan Alejandro Mezu

### Estructura que se manejó

[Diagrama](docs/Diagrama.svg)

La estructura que utilizamos es muy similar al ejemplo planteado en el ejercicio, sin embargo, hicimos algunos cambios que no cambian la funcionalidad si no que la hacen más ordenada. Nuestra estructura mantiene la separación de cada responsabilid entre las carpetas. Las clases del modelo manejan los datos y las operaciones relacionadas, los controladores se ponen de acuerdo con los datos en modelo y las vistas se encargan únicamente de interactuar con el usuario.

Hubo un cambio en especifico el cual requería "listar productos". Inicialmente lo manejamos como un listado de los productos con los atributos y los datos registrados, sin embargo observamos que era un poco desordenado de ver, así que en su lugarcambiamos el nombre a "consultar inventario" en donde la funcionalidad es basicamente la misma, pero ordenada en una tabla tipo String donde se pueden visualizar todos los atributos de los productos registrados. Esto se hizo con el fin de no tener duplicados en las funcionalidades.

Al final, al observar y poner a prueba los resultados en la consola, se puede observar que todo funciona correctamente.