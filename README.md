Proyecto BootCamp50 
-
Hugo Oliveros Monti


### Pre-Requisitos

Plugins que deben estar instalados en su IDE:
* [Lombok](http://projectlombok.org/) - *Libreria de Bytecode que genera automaticamente los Getters y Setters*.
* [CheckStyle](http://www.checkstyle.com/) - *Plugin para poder comprobar el estilo del codigo usando las reglas de Google*
* [MongoDB](http://www.checkstyle.com/) - *Base de datos no relacional*


## Flujo de desarrollo.

* Todo desarrollo debe iniciarse en una rama con la nomenclatura `feature/nombre-de-cambio` el cual debe crearse desde la rama `develop`.

* Cuando se completa el desarrollo, se deberá generar un `New Merge Request` desde la rama creada `feature/nombre-de-cambio` hacia la rama `develop`.

* Cuando los cambios son revisados y probados, se aceptará el Merge Request, con lo que los cambios quedarán listos en la rama `develop` para realizar el despliegue en el ambiente de desarrollo.


## Ejecución de pruebas

    Para la ejecución de pruebas `unitarias` se debe ejecutar lo siguiente:

    mvn test


Actuator
-
http://localhost:8085/actuator/


Documentacion de los end point 
-
http://localhost:8085/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

http://localhost:8085/v3/api-docs

•	Un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta corriente o cuentas a plazo fijo.

    curl --location 'localhost:8085/banco/api/v1/save' \
    --header 'Content-Type: application/json' \
    --data '{
    "type": "AHORRO",
    "maxMoviento": 10,
    "descrip": "Cuenta bancia Cuenta corriente",
    "persona": {
    "nombre": "hugo",
    "apellido": "oliveros",
    "dni": "10530023"
    }
    }'

•	Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo, pero sí múltiples cuentas corrientes.

    curl --location 'localhost:8085/banco/api/v1/saveBusiness' \
    --header 'Content-Type: application/json' \
    --data '{
    "type": "Ahorro",
    "maxMoviento": 10,
    "descrip": "Cuenta bancia Cuenta corriente",
    "persona": {
    "nombre": "hugo",
    "apellido": "oliveros",
    "dni": "10530025"
    }
    }'

•	Verify that you can add only the "savings" account type 

    curl --location 'localhost:8085/banco/api/v1/saveBusiness' \
    --header 'Content-Type: application/json' \
    --data '{
    "type": "Ahorre2",
    "maxMoviento": 10,
    "descrip": "Cuenta bancia Cuenta corriente",
    "persona": {
    "nombre": "hugo",
    "apellido": "oliveros",
    "dni": "10530025"
    }
    }'