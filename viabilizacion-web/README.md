# viabilización web

## Build

### Prerequisites
In order to build the application, you need java 8 and maven installed
```
$ mvn -version
Apache Maven 3.6.2 (40f52333136460af0dc0d7232c0dc0bcf0d9e117; 2019-08-27T17:06:16+02:00)
Maven home: C:\apache-maven-3.6.2
Java version: 1.8.0_221, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_221\jre
Default locale: es_ES, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
to build the application, just use maven
```
$ mvn clean install
```

you must see a sucessful build
```
[INFO] Reactor Summary for base-hexagonal-architecture 1.0.2:
[INFO]
[INFO] base-hexagonal-architecture ........................ SUCCESS [  2.210 s]
[INFO] base-hexagonal-architecture-web .................... SUCCESS [ 38.584 s]
[INFO] base-hexagonal-architecture-acceptance-tests ....... SUCCESS [  0.869 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  42.404 s
[INFO] Finished at: 2020-01-25T16:59:22+01:00
[INFO] ------------------------------------------------------------------------
```
To the run application, just use maven
```
mvn spring-boot:run
```
## Example
```
curl -X POST "http://localhost:5000/viabilizacion/v1/solicitud/viabilizacion" -H "accept: */*" -d "{"tipoIdentificacion":"", "numeroIdentificacion":"", "nombres":"", "apellidos":"", "direccion":"", "telefono":"", "celular":"", "correoElectronico":"", "anoNacimiento":"", "valorSolicitado":"", "ingresos":"", "plazo":"", "actividad":"", "ciudad":""}"
```

