package com.samtel.adapters.secondary.rest.dictum;

public class MockResponseDictumTest {
    public static String APROBADO = "<ws:consultarHC2Return><![CDATA[<?xml\n" +
            "version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "<Informes><Informe fechaConsulta=\"2020-01-22T08:36:55\" respuesta=\"13\"\n" +
            "codSeguridad=\"WFN72G4\" tipoIdDigitado=\"1\"\n" +
            "identificacionDigitada=\"91518562\"\n" +
            "apellidoDigitado=\"BECERRA\"><NaturalNacional nombres=\"YEHISON FABIAN\"\n" +
            "primerApellido=\"BECERRA\" segundoApellido=\"RODRIGUEZ\"\n" +
            "nombreCompleto=\"BECERRA RODRIGUEZ YEHISON FABIAN\" validada=\"true\"\n" +
            "rut=\"true\" genero=\"4\"><Identificacion estado=\"00\"\n" +
            "fechaExpedicion=\"2001-05-07\" ciudad=\"BUCARAMANGA\"\n" +
            "departamento=\"SANTANDER\" genero=\"4\" numero=\"00091518562\" /><Edad min=\"36\"\n" +
            "max=\"45\" /><InfoDemografica /></NaturalNacional><Score tipo=\"10\"\n" +
            "puntaje=\"0.0\" clasificacion=\"P\" fecha=\"2020-01-22\" poblacion=\"0\"><Razon\n" +
            "codigo=\"783\" /><Razon codigo=\"01.69400\" /><Razon codigo=\"1\"\n" +
            "/></Score><CuentaAhorro bloqueada=\"false\" entidad=\"BANCOLOMBIA\"\n" +
            "numero=\"675517609\" fechaApertura=\"2006-11-30\" situacionTitular=\"0\"\n" +
            "oficina=\"CABECERA DEL LL\" ciudad=\"BUCARA\" codigoDaneCiudad=\"00000000\"\n" +
            "tipoIdentificacion=\"2\" identificacion=\"00890903938\"\n" +
            "sector=\"1\"><Caracteristicas clase=\"0\" /><Valores /><Estado codigo=\"05\"\n" +
            "\n" +
            "fecha=\"2008-03-31\"\n" +
            "/><Llave>10009151856251023201675517609000000000</Llave></CuentaAhorro><Ta\n" +
            "rjetaCredito bloqueada=\"false\" entidad=\"BANCO CORPBANCA\"\n" +
            "numero=\"380526179\" fechaApertura=\"2007-09-30\"\n" +
            "fechaVencimiento=\"2011-11-30\"\n" +
            "comportamiento=\"NNNNNNNNNNNNNNNNNNN---------------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00890903937\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"0\" clase=\"0\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"0\" fecha=\"2020-01-22\" /><EstadoCuenta\n" +
            "codigo=\"00\" fecha=\"2009-04-30\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2009-04-30\" /><EstadoPago codigo=\"05\" meses=\"48\"\n" +
            "fecha=\"2009-04-30\"\n" +
            "/></Estados><Llave>10009151856202001202380526179000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"BANCO DE\n" +
            "OCCIDENTE S.A.\" numero=\"006456395\" fechaApertura=\"2008-07-01\"\n" +
            "fechaVencimiento=\"2013-07-31\"\n" +
            "comportamiento=\"------------NNN-N--NNNNNNN--------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" situacionTitular=\"0\"\n" +
            "oficina=\"NO INFORMO\" ciudad=\"\" codigoDaneCiudad=\"00000000\"\n" +
            "tipoIdentificacion=\"2\" identificacion=\"00890300279\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"0\" clase=\"0\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"1\" fecha=\"2011-08-31\" /><EstadoCuenta\n" +
            "codigo=\"03\" fecha=\"2011-08-31\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2011-05-31\" /><EstadoPago codigo=\"06\" meses=\"48\"\n" +
            "fecha=\"2011-05-31\"\n" +
            "/></Estados><Llave>10009151856202990502006456395000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"BANCO DE\n" +
            "OCCIDENTE S.A.\" numero=\"459059879\" fechaApertura=\"2008-07-31\"\n" +
            "fechaVencimiento=\"2013-07-31\"\n" +
            "comportamiento=\"---------------------NNNNNNN------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00890300279\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"0\" clase=\"0\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"0\" fecha=\"2020-01-22\" /><EstadoCuenta\n" +
            "codigo=\"00\" fecha=\"2010-12-31\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2010-12-31\" /><EstadoPago codigo=\"05\" meses=\"48\"\n" +
            "fecha=\"2010-12-31\"\n" +
            "/></Estados><Llave>10009151856202990502459059879000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"BCO DAVIVIENDA\"\n" +
            "numero=\"401122107\" fechaApertura=\"2004-07-01\"\n" +
            "fechaVencimiento=\"2013-07-30\"\n" +
            "\n" +
            "comportamiento=\"NNNNNNN1NNNNNNNNNNN---------------------------- \"\n" +
            "formaPago=\"0\" probabilidadIncumplimiento=\"3.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"7\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00860034313\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"4\" clase=\"4\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"1\" fecha=\"2012-02-29\" /><EstadoCuenta\n" +
            "codigo=\"01\" fecha=\"2012-02-29\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2012-02-29\" /><EstadoPago codigo=\"13\" meses=\"48\"\n" +
            "fecha=\"2012-02-29\"\n" +
            "/></Estados><Llave>10009151856202004702401122107000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"BCO DAVIVIENDA\"\n" +
            "numero=\"302325005\" fechaApertura=\"2004-07-01\"\n" +
            "fechaVencimiento=\"2010-07-30\"\n" +
            "comportamiento=\"NNNNNNNNNNNNNNNNNNNNNN-NNNNNNNNNNNNNNNNNNNNNNNN \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"3.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"7\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00860034313\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"4\" clase=\"4\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"1\" fecha=\"2004-07-01\" /><EstadoCuenta\n" +
            "codigo=\"03\" fecha=\"2010-07-31\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2010-07-31\" /><EstadoPago codigo=\"05\" meses=\"48\"\n" +
            "fecha=\"2010-07-31\"\n" +
            "/></Estados><Llave>10009151856202004702302325005000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"CREDENCIAL\"\n" +
            "numero=\"146539011\" fechaApertura=\"2008-07-01\"\n" +
            "fechaVencimiento=\"2012-08-31\"\n" +
            "comportamiento=\"------------N-N-N--NNNNNNN--------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" situacionTitular=\"0\"\n" +
            "oficina=\"NO INFORMO\" ciudad=\"\" codigoDaneCiudad=\"00000000\"\n" +
            "tipoIdentificacion=\"2\" identificacion=\"00890300279\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"0\" clase=\"0\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"1\" fecha=\"2011-05-31\" /><EstadoCuenta\n" +
            "codigo=\"03\" fecha=\"2011-05-31\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2011-05-31\" /><EstadoPago codigo=\"06\" meses=\"48\"\n" +
            "fecha=\"2011-05-31\"\n" +
            "/></Estados><Llave>10009151856202000502146539011000000000</Llave></Tarjet\n" +
            "aCredito><TarjetaCredito bloqueada=\"false\" entidad=\"CREDENCIAL\"\n" +
            "numero=\"146539003\" fechaApertura=\"2008-07-31\"\n" +
            "fechaVencimiento=\"2012-08-31\"\n" +
            "comportamiento=\"NNNNNNN---------------------------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00890300279\" sector=\"1\"\n" +
            "\n" +
            "calificacionHD=\"true\"><Caracteristicas franquicia=\"0\" clase=\"0\"\n" +
            "marca=\"000\" amparada=\"false\" codigoAmparada=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoPlastico codigo=\"0\" fecha=\"2020-01-22\" /><EstadoCuenta\n" +
            "codigo=\"00\" fecha=\"2009-03-31\" /><EstadoOrigen codigo=\"0\"\n" +
            "fecha=\"2009-03-31\" /><EstadoPago codigo=\"07\" meses=\"48\"\n" +
            "fecha=\"2009-03-31\"\n" +
            "/></Estados><Llave>10009151856202000502146539003000000000</Llave></Tarjet\n" +
            "aCredito><CuentaCartera bloqueada=\"false\" entidad=\"BCO DE BOGOTA RED\n" +
            "MEGABANCO\" numero=\"301101568\" fechaApertura=\"2003-05-31\"\n" +
            "fechaVencimiento=\"2006-05-31\"\n" +
            "comportamiento=\"NNNNNNNNNNNNNNNNNNNNNNNN----------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"050048\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00860002964\" sector=\"1\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CAB\"\n" +
            "tipoObligacion=\"2\" tipoContrato=\"0\" ejecucionContrato=\"2\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"00\" fecha=\"2006-05-31\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2006-05-31\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2006-05-31\"\n" +
            "/></Estados><Llave>10009151856205004805301101568000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"COLSUBSIDIO CUPO\n" +
            "CREDITO\" numero=\"990006178\" fechaApertura=\"2008-09-02\"\n" +
            "fechaVencimiento=\"2060-12-31\"\n" +
            "comportamiento=\"NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN------ \"\n" +
            "formaPago=\"0\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"030012\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00860007336\" sector=\"3\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CBR\"\n" +
            "tipoObligacion=\"2\" tipoContrato=\"2\" ejecucionContrato=\"2\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"01\" fecha=\"2009-06-10\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2008-09-02\" /><EstadoPago codigo=\"01\" meses=\"48\"\n" +
            "fecha=\"2012-02-29\"\n" +
            "/></Estados><Llave>10009151856203001203990006178000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"COLSUBSIDIO CUPO\n" +
            "CREDITO\" numero=\"008658985\" fechaApertura=\"2008-06-19\"\n" +
            "fechaVencimiento=\"2012-06-30\"\n" +
            "comportamiento=\"NNNN-NNNNNNNNNNNNNNNNNNNNN--------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"6\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"030012\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00860007336\" sector=\"3\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CBR\"\n" +
            "tipoObligacion=\"2\" tipoContrato=\"2\" ejecucionContrato=\"2\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"01\" fecha=\"2010-08-31\" /><EstadoOrigen\n" +
            "\n" +
            "codigo=\"0\" fecha=\"2008-06-19\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2010-08-31\"\n" +
            "/></Estados><Llave>10009151856203001203008658985000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"COMCEL S.A.\"\n" +
            "numero=\".90114169\" fechaApertura=\"2009-11-30\"\n" +
            "fechaVencimiento=\"2010-01-03\"\n" +
            "comportamiento=\"NNNNNNNNNN------------------------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"230004\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00800153993\" sector=\"4\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CTC\"\n" +
            "tipoObligacion=\"2\" tipoContrato=\"1\" ejecucionContrato=\"2\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"2\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"03\" fecha=\"2010-09-30\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2010-09-30\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2010-09-30\"\n" +
            "/></Estados><Llave>10009151856223000423.90114169000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"MOVISTAR\"\n" +
            "numero=\"015001472\" fechaApertura=\"2001-09-30\"\n" +
            "fechaVencimiento=\"2010-12-31\"\n" +
            "comportamiento=\"NNNNNNNNNNNNNNNNNNNNNNNN----------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"230001\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00830037330\" sector=\"4\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CTC\"\n" +
            "tipoObligacion=\"1\" tipoContrato=\"0\" ejecucionContrato=\"1\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"1\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"00\" fecha=\"2004-01-31\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2004-01-31\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2004-01-31\"\n" +
            "/></Estados><Llave>10009151856223000123015001472000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"MOVISTAR\"\n" +
            "numero=\"066081894\" fechaApertura=\"2005-01-31\"\n" +
            "fechaVencimiento=\"2010-12-31\"\n" +
            "comportamiento=\"NN-NNNNNNNNNNNNNNNNN--------------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"230001\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00830037330\" sector=\"4\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CTC\"\n" +
            "tipoObligacion=\"1\" tipoContrato=\"0\" ejecucionContrato=\"1\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"1\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"00\" fecha=\"2007-01-31\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2007-01-31\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2007-01-31\"\n" +
            "/></Estados><Llave>10009151856223000123066081894000000000</Llave></Cuenta\n" +
            "Cartera><CuentaCartera bloqueada=\"false\" entidad=\"MOVISTAR\"\n" +
            "\n" +
            "numero=\"098756265\" fechaApertura=\"2006-01-31\"\n" +
            "fechaVencimiento=\"2010-12-31\"\n" +
            "comportamiento=\"------N---------------------------------------- \"\n" +
            "formaPago=\"1\" probabilidadIncumplimiento=\"0.0\" calificacion=\"1\"\n" +
            "situacionTitular=\"0\" oficina=\"NO INFORMO\" ciudad=\"\"\n" +
            "codigoDaneCiudad=\"00000000\" codSuscriptor=\"230001\" tipoIdentificacion=\"2\"\n" +
            "identificacion=\"00830037330\" sector=\"4\"\n" +
            "calificacionHD=\"true\"><Caracteristicas tipoCuenta=\"CTC\"\n" +
            "tipoObligacion=\"1\" tipoContrato=\"0\" ejecucionContrato=\"1\"\n" +
            "mesesPermanencia=\"0\" calidadDeudor=\"00\" garantia=\"1\" /><Valores\n" +
            "/><Estados><EstadoCuenta codigo=\"00\" fecha=\"2006-12-31\" /><EstadoOrigen\n" +
            "codigo=\"0\" fecha=\"2006-12-31\" /><EstadoPago codigo=\"08\" meses=\"48\"\n" +
            "fecha=\"2006-12-31\"\n" +
            "/></Estados><Llave>10009151856223000123098756265000000000</Llave></Cuenta\n" +
            "Cartera><EndeudamientoGlobal calificacion=\"A\" fuente=\"S\"\n" +
            "saldoPendiente=\"1880000\" tipoCredito=\"CNS\" moneda=\"ML\" numeroCreditos=\"1\"\n" +
            "independiente=\"\" fechaReporte=\"2011-12-31\"><Entidad nombre=\"DAVIVIENDA -\n" +
            "BC 0\" nit=\"00860034313\" sector=\"1\" /><Garantia tipo=\"0\"\n" +
            "valor=\"0.0\"\n" +
            "/><Llave>1000915185622011123101000039LSAO</Llave></EndeudamientoGlobal><E\n" +
            "ndeudamientoGlobal calificacion=\"A\" fuente=\"S\" saldoPendiente=\"1968000\"\n" +
            "tipoCredito=\"CNS\" moneda=\"ML\" numeroCreditos=\"1\" independiente=\"\"\n" +
            "fechaReporte=\"2011-09-30\"><Entidad nombre=\"DAVIVIENDA - BC\n" +
            "0\" nit=\"00860034313\" sector=\"1\" /><Garantia tipo=\"0\" valor=\"0.0\"\n" +
            "/><Llave>1000915185622011093001000039LSAO</Llave></EndeudamientoGlobal><E\n" +
            "ndeudamientoGlobal calificacion=\"B\" fuente=\"S\" saldoPendiente=\"2389000\"\n" +
            "tipoCredito=\"CNS\" moneda=\"ML\" numeroCreditos=\"1\" independiente=\"\"\n" +
            "fechaReporte=\"2011-06-30\"><Entidad nombre=\"DAVIVIENDA - BC\n" +
            "0\" nit=\"00860034313\" sector=\"1\" /><Garantia tipo=\"0\" valor=\"0.0\"\n" +
            "/><Llave>1000915185622011063001000039LSBO</Llave></EndeudamientoGlobal><C\n" +
            "onsulta fecha=\"2020-01-21\" tipoCuenta=\"CAU\" entidad=\"PREMIER\n" +
            "CREDIT SAS\" oficina=\"------------------\" ciudad=\"------------\" razon=\"00\"\n" +
            "cantidad=\"01\" nitSuscriptor=\"00900491651\"\n" +
            "sector=\"3\"><Llave>10009151856205</Llave></Consulta><Consulta\n" +
            "fecha=\"2019-12-30\" tipoCuenta=\"CAU\" entidad=\"PREMIER CREDIT SAS\"\n" +
            "oficina=\"------------------\" ciudad=\"------------\" razon=\"00\"\n" +
            "cantidad=\"01\" nitSuscriptor=\"00900491651\"\n" +
            "sector=\"3\"><Llave>10009151856204</Llave></Consulta><RespuestaPersonalizad\n" +
            "a><Linea consecutivo=\"01\">[ACIERTA_MAS][783][EDAD][40]</Linea><Linea\n" +
            "consecutivo=\"02\">[ANIO_ACTUAL][2020][MES_ACTUAL][1]</Linea><Linea\n" +
            "consecutivo=\"03\">[SMMLV][877803][HUELLAS_CONSULTA][2]</Linea><Linea\n" +
            "consecutivo=\"04\">[MOROSIDAD][0][CARTERA_RECUPERADA][0]</Linea><Linea\n" +
            "consecutivo=\"05\">[CASTIGOS][0][CALIFICACION_B][1]</Linea><Linea\n" +
            "consecutivo=\"06\">[CALIFICACION_C][0][CALIFICACION_D][0]</Linea><Linea\n" +
            "consecutivo=\"07\">[CALIFICACION_E][0][REESTRUCTURACIONES][0]</Linea><Linea\n" +
            "consecutivo=\"08\">[MORA_VIGENTE][0][CANCELACIONES_NEGATIVAS][0]</Linea><Li\n" +
            "nea consecutivo=\"09\">[EMBARGOS][0][MONTO_MINIMO][438901.5]</Linea><Linea\n" +
            "consecutivo=\"10\">[MONTO_MAXIMO][54423786][TIPO_CONSULTA][1]</Linea><Linea\n" +
            "consecutivo=\"11\">[VERSION][91906][CASTIGO][0]</Linea><Linea\n" +
            "\n" +
            "consecutivo=\"12\">[CASTIGO_INGRESO][25000000][GASTO_FIJO_MENSUAL][13750000\n" +
            "]</Linea><Linea\n" +
            "consecutivo=\"13\">[INGRESO_DISPONIBLE][11250000][CUOTA_TDC_RO][0]</Linea><\n" +
            "Linea\n" +
            "consecutivo=\"14\">[OTRAS_CUOTAS][0][DISPONIBLE_ENDEUDAMIENTO][11250000]</L\n" +
            "inea><Linea\n" +
            "consecutivo=\"15\">[CUOTA_CREDITO][1470288.72629][TASA][0.016]</Linea><Line\n" +
            "a consecutivo=\"16\">[P][60][CUOTA_TOTAL][0]</Linea><Linea\n" +
            "consecutivo=\"17\">[CONSULTA_MAREIGUA][1][VALOR_SOLICITADO][40000000]</Line\n" +
            "a><Linea\n" +
            "consecutivo=\"18\">[INGRESOS][25000000][ENDEUDAMIENTO_MAXIMO][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"19\">[VALOR_INGRESO][0][QUANTO][1486998.282]</Linea><Linea\n" +
            "consecutivo=\"20\">[CASTIGO_VALOR_INGRESO][0][CASTIGO_QUANTO][1486998.282]<\n" +
            "/Linea><Linea\n" +
            "consecutivo=\"21\">[GASTO_FIJO_MENSUAL_VI][0][GASTO_FIJO_MENSUAL_Q][817849.\n" +
            "0551]</Linea><Linea\n" +
            "consecutivo=\"22\">[INGRESO_DISPONIBLE_VI][0][INGRESO_DISPONIBLE_Q][669149.\n" +
            "2269]</Linea><Linea\n" +
            "consecutivo=\"23\">[DISPONIBLE_ENDEUDAMIENTO_VI][0][DISPONIBLE_ENDEUDAMIENT\n" +
            "O_Q][669149.2269]</Linea><Linea\n" +
            "consecutivo=\"24\">[ENDEUDAMIENTO_MAXIMO_1][0][ENDEUDAMIENTO_MAXIMO_2][2568\n" +
            "6397.52045]</Linea><Linea\n" +
            "consecutivo=\"25\">[ENDEUDAMIENTO_MAXIMO_3][431849818.37886][VAR_CUOTA_36][\n" +
            "0]</Linea><Linea\n" +
            "consecutivo=\"26\">[VAR_CUOTA_48][0][CUOTA_60][0]</Linea><Linea\n" +
            "consecutivo=\"27\">[CUOTA_72][0][CUOTA_240][0]</Linea><Linea\n" +
            "consecutivo=\"28\">[MES_1][0][MES_2][0]</Linea><Linea\n" +
            "consecutivo=\"29\">[MES_3][0][MES_4][0]</Linea><Linea\n" +
            "consecutivo=\"30\">[MES_5][0][MES_6][0]</Linea><Linea\n" +
            "consecutivo=\"31\">[MES_7][0][MES_8][0]</Linea><Linea\n" +
            "consecutivo=\"32\">[MES_9][0][MES_10][0]</Linea><Linea\n" +
            "consecutivo=\"33\">[MES_11][0][MES_12][0]</Linea><Linea\n" +
            "consecutivo=\"34\">[APORTANTE1_PAGO_1][0][APORTANTE1_PAGO_2][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"35\">[APORTANTE1_PAGO_3][0][APORTANTE1_PAGO_4][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"36\">[APORTANTE1_PAGO_5][0][APORTANTE1_PAGO_6][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"37\">[APORTANTE1_PAGO_7][0][APORTANTE1_PAGO_8][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"38\">[APORTANTE1_PAGO_9][0][APORTANTE1_PAGO_10][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"39\">[APORTANTE1_PAGO_11][0][APORTANTE1_PAGO_12][0]</Linea><L\n" +
            "inea\n" +
            "consecutivo=\"40\">[APORTANTE2_PAGO_1][0][APORTANTE2_PAGO_2][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"41\">[APORTANTE2_PAGO_3][0][APORTANTE2_PAGO_4][0]</Linea><Lin\n" +
            "ea\n" +
            "\n" +
            "consecutivo=\"42\">[APORTANTE2_PAGO_5][0][APORTANTE2_PAGO_6][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"43\">[APORTANTE2_PAGO_7][0][APORTANTE2_PAGO_8][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"44\">[APORTANTE2_PAGO_9][0][APORTANTE2_PAGO_10][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"45\">[APORTANTE2_PAGO_11][0][APORTANTE2_PAGO_12][0]</Linea><L\n" +
            "inea\n" +
            "consecutivo=\"46\">[APORTANTE3_PAGO_1][0][APORTANTE3_PAGO_2][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"47\">[APORTANTE3_PAGO_3][0][APORTANTE3_PAGO_4][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"48\">[APORTANTE3_PAGO_5][0][APORTANTE3_PAGO_6][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"49\">[APORTANTE3_PAGO_7][0][APORTANTE3_PAGO_8][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"50\">[APORTANTE3_PAGO_9][0][APORTANTE3_PAGO_10][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"51\">[APORTANTE3_PAGO_11][0][APORTANTE3_PAGO_12][0]</Linea><L\n" +
            "inea\n" +
            "consecutivo=\"52\">[APORTANTE4_PAGO_1][0][APORTANTE4_PAGO_2][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"53\">[APORTANTE4_PAGO_3][0][APORTANTE4_PAGO_4][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"54\">[APORTANTE4_PAGO_5][0][APORTANTE4_PAGO_6][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"55\">[APORTANTE4_PAGO_7][0][APORTANTE4_PAGO_8][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"56\">[APORTANTE4_PAGO_9][0][APORTANTE4_PAGO_10][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"57\">[APORTANTE4_PAGO_11][0][APORTANTE4_PAGO_12][0]</Linea><L\n" +
            "inea\n" +
            "consecutivo=\"58\">[APORTANTE5_PAGO_1][0][APORTANTE5_PAGO_2][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"59\">[APORTANTE5_PAGO_3][0][APORTANTE5_PAGO_4][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"60\">[APORTANTE5_PAGO_5][0][APORTANTE5_PAGO_6][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"61\">[APORTANTE5_PAGO_7][0][APORTANTE5_PAGO_8][0]</Linea><Lin\n" +
            "ea\n" +
            "consecutivo=\"62\">[APORTANTE5_PAGO_9][0][APORTANTE5_PAGO_10][0]</Linea><Li\n" +
            "nea\n" +
            "consecutivo=\"63\">[APORTANTE5_PAGO_11][0][APORTANTE5_PAGO_12][0]</Linea><L\n" +
            "inea\n" +
            "consecutivo=\"64\">[ANTIGUEDAD_APORTANTE_1][0][ANTIGUEDAD_APORTANTE_2][0]</\n" +
            "Linea><Linea\n" +
            "consecutivo=\"65\">[ANTIGUEDAD_APORTANTE_3][0][ANTIGUEDAD_APORTANTE_4][0]</\n" +
            "Linea><Linea\n" +
            "consecutivo=\"66\">[ANTIGUEDAD_APORTANTE_5][0][ANTIGUEDAD][0]</Linea><Linea\n" +
            "\n" +
            "consecutivo=\"67\">[EDAD][40][DECISION][APROBADO]</Linea>\n" +
            "<Linea consecutivo=\"68\">[CAUSAL_RECHAZO][NA][CAUSAL_PA1][Marcacion en\n" +
            "centrales]</Linea><Linea\n" +
            "consecutivo=\"69\">[CAUSAL_PA2][NA][CAUSAL_PA3][NA]</Linea><Linea\n" +
            "consecutivo=\"70\">[TIPO_ID][1][ACTIVIDAD][1]</Linea><Linea\n" +
            "consecutivo=\"71\">[PLAZO][36][LISTA_RESTRICTIVA1][S304]</Linea><Linea\n" +
            "consecutivo=\"72\">[LISTA_RESTRICTIVA2][0]</Linea></RespuestaPersonalizada>\n" +
            "<InfoAgregada><Resumen><Principales creditoVigentes=\"2\"\n" +
            "creditosCerrados=\"12\" creditosActualesNegativos=\"0\" histNegUlt12Meses=\"0\"\n" +
            "cuentasAbiertasAHOCCB=\"0\" cuentasCerradasAHOCCB=\"1\"\n" +
            "consultadasUlt6meses=\"2\" desacuerdosALaFecha=\"0\"\n" +
            "antiguedadDesde=\"2001-09-30\" reclamosVigentes=\"0\" /><Saldos\n" +
            "saldoTotalEnMora=\"0.0\" saldoM30=\"0.0\" saldoM60=\"0.0\" saldoM90=\"0.0\"\n" +
            "cuotaMensual=\"0.0\" saldoCreditoMasAlto=\"0.0\" saldoTotal=\"0.0\"><Sector\n" +
            "sector=\"1\" saldo=\"0.0\" participacion=\"0.0\" /><Sector sector=\"2\"\n" +
            "saldo=\"0.0\" participacion=\"0.0\" /><Sector sector=\"3\" saldo=\"0.0\"\n" +
            "participacion=\"0.0\" /><Sector sector=\"4\" saldo=\"0.0\" participacion=\"0.0\"\n" +
            "/><Mes fecha=\"2012-02-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2012-01-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-12-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-11-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-10-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-09-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-08-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-07-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-06-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-05-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-04-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-03-29\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-02-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2011-01-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-12-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-11-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-10-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-09-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-08-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-07-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-06-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-05-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-04-28\" saldoTotalMora=\"0\" saldoTotal=\"0\" /><Mes\n" +
            "fecha=\"2010-03-28\" saldoTotalMora=\"0\" saldoTotal=\"0\"\n" +
            "/></Saldos><Comportamiento><Mes fecha=\"2012-02-29\" comportamiento=\"N\"\n" +
            "cantidad=\"0\" /><Mes fecha=\"2012-01-29\" comportamiento=\"N\" cantidad=\"0\"\n" +
            "/><Mes fecha=\"2011-12-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-11-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-10-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-09-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-08-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-07-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "\n" +
            "fecha=\"2011-06-29\" comportamiento=\"1\" cantidad=\"1\" /><Mes\n" +
            "fecha=\"2011-05-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-04-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-03-29\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-02-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2011-01-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-12-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-11-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-10-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-09-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-08-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-07-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-06-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-05-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-04-28\" comportamiento=\"N\" cantidad=\"0\" /><Mes\n" +
            "fecha=\"2010-03-28\" comportamiento=\"N\" cantidad=\"0\"\n" +
            "/></Comportamiento></Resumen><Totales><TipoCuenta codigoTipo=\"CBR\"\n" +
            "tipo=\"Cartera bancaria rotativa\" calidadDeudor=\"Principal\" cupo=\"0.0\"\n" +
            "saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\" /><TipoCuenta codigoTipo=\"TDC\"\n" +
            "tipo=\"Tarjeta de crédito\" calidadDeudor=\"Principal\" cupo=\"0.0\"\n" +
            "saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\" /><Total\n" +
            "calidadDeudor=\"Principal\" participacion=\"0.0\" cupo=\"0.0\" saldo=\"0.0\"\n" +
            "saldoMora=\"0.0\" cuota=\"0.0\" /><Total calidadDeudor=\"Codeudor\"\n" +
            "participacion=\"0.0\" cupo=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "/></Totales><ComposicionPortafolio><TipoCuenta tipo=\"CBR\"\n" +
            "calidadDeudor=\"Principal\" porcentaje=\"1.0\" cantidad=\"1\"><Estado\n" +
            "codigo=\"Al dia\" cantidad=\"1\" /></TipoCuenta><TipoCuenta tipo=\"TDC\"\n" +
            "calidadDeudor=\"Principal\" porcentaje=\"1.0\" cantidad=\"1\"><Estado\n" +
            "codigo=\"Al dia Mora 30\" cantidad=\"1\"\n" +
            "/></TipoCuenta></ComposicionPortafolio><Cheques\n" +
            "/><EvolucionDeuda><Trimestre fecha=\"2011-12-01\" cuota=\"0\" cupoTotal=\"0\"\n" +
            "saldo=\"0\" porcentajeUso=\"0.0\" score=\"0.0\" calificacion=\"AA\"\n" +
            "aperturaCuentas=\"0\" cierreCuentas=\"0\" totalAbiertas=\"2\"\n" +
            "totalCerradas=\"13\" moraMaxima=\"M 0\" mesesMoraMaxima=\"0\" /><Trimestre\n" +
            "fecha=\"2011-09-01\" cuota=\"0\" cupoTotal=\"0\" saldo=\"0\" porcentajeUso=\"0.0\"\n" +
            "score=\"0.0\" calificacion=\"AA\" aperturaCuentas=\"0\" cierreCuentas=\"0\"\n" +
            "totalAbiertas=\"2\" totalCerradas=\"13\" moraMaxima=\"M 0\" mesesMoraMaxima=\"0\"\n" +
            "/><Trimestre fecha=\"2011-06-01\" cuota=\"0\" cupoTotal=\"0\" saldo=\"0\"\n" +
            "porcentajeUso=\"0.0\" score=\"0.0\" calificacion=\"AA\" aperturaCuentas=\"0\"\n" +
            "cierreCuentas=\"0\" totalAbiertas=\"2\" totalCerradas=\"13\" moraMaxima=\"M 30\"\n" +
            "mesesMoraMaxima=\"1\" /><AnalisisPromedio cuota=\"0.0\" cupoTotal=\"0.0\"\n" +
            "saldo=\"0.0\" porcentajeUso=\"0.0\" score=\"0.0\" calificacion=\"0\"\n" +
            "aperturaCuentas=\"0.0\" cierreCuentas=\"0.0\" totalAbiertas=\"0.0\"\n" +
            "totalCerradas=\"0.0\" moraMaxima=\"-30\"\n" +
            "/></EvolucionDeuda><HistoricoSaldos><TipoCuenta tipo=\"CAB\"><Trimestre\n" +
            "fecha=\"2011-12-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2011-09-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2011-06-01\" totalCuentas=\"0\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2011-03-01\"\n" +
            "\n" +
            "totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2010-12-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2010-09-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2010-06-01\" totalCuentas=\"0\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2010-03-01\"\n" +
            "totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/></TipoCuenta><TipoCuenta tipo=\"CBR\"><Trimestre fecha=\"2011-12-01\"\n" +
            "totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2011-09-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2011-06-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2011-03-01\" totalCuentas=\"1\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2010-12-01\"\n" +
            "totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2010-09-01\" totalCuentas=\"2\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2010-06-01\" totalCuentas=\"2\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2010-03-01\" totalCuentas=\"2\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /></TipoCuenta><TipoCuenta\n" +
            "tipo=\"CTC\"><Trimestre fecha=\"2011-12-01\" totalCuentas=\"0\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2011-09-01\"\n" +
            "totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2011-06-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2011-03-01\" totalCuentas=\"0\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2010-12-01\" totalCuentas=\"0\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2010-09-01\"\n" +
            "totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2010-06-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2010-03-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /></TipoCuenta><TipoCuenta tipo=\"TDC\"><Trimestre\n" +
            "fecha=\"2011-12-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2011-09-01\" totalCuentas=\"1\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2011-06-01\" totalCuentas=\"3\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2011-03-01\"\n" +
            "totalCuentas=\"3\" cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre\n" +
            "fecha=\"2010-12-01\" totalCuentas=\"4\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/><Trimestre fecha=\"2010-09-01\" totalCuentas=\"5\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0\" /><Trimestre fecha=\"2010-06-01\" totalCuentas=\"5\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0\" /><Trimestre fecha=\"2010-03-01\"\n" +
            "totalCuentas=\"5\" cuentasConsideradas=\"0\" saldo=\"0\"\n" +
            "/></TipoCuenta><Totales fecha=\"2011-12-01\" totalCuentas=\"2\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0.0\" /><Totales fecha=\"2011-09-01\"\n" +
            "totalCuentas=\"2\" cuentasConsideradas=\"0\" saldo=\"0.0\" /><Totales\n" +
            "fecha=\"2011-06-01\" totalCuentas=\"4\" cuentasConsideradas=\"0\" saldo=\"0.0\"\n" +
            "/><Totales fecha=\"2011-03-01\" totalCuentas=\"4\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0.0\" /><Totales fecha=\"2010-12-01\" totalCuentas=\"5\"\n" +
            "cuentasConsideradas=\"0\" saldo=\"0.0\" /><Totales fecha=\"2010-09-01\"\n" +
            "totalCuentas=\"8\" cuentasConsideradas=\"0\" saldo=\"0.0\" /><Totales\n" +
            "fecha=\"2010-06-01\" totalCuentas=\"8\" cuentasConsideradas=\"0\" saldo=\"0.0\"\n" +
            "/><Totales fecha=\"2010-03-01\" totalCuentas=\"8\" cuentasConsideradas=\"0\"\n" +
            "saldo=\"0.0\" /></HistoricoSaldos><ResumenEndeudamiento><Trimestre\n" +
            "\n" +
            "fecha=\"2011-02-01\"><Sector sector=\"Financiero\" codigoSector=\"1\"\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"1\"\n" +
            "valor=\"1880.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Cooperativo\" codigoSector=\"2\"\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Real\" codigoSector=\"3\" garantiaAdmisible=\"0\"\n" +
            "garantiaOtro=\"0\"><Cartera tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/><Cartera tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /></Sector><Sector sector=\"Telcos\"\n" +
            "codigoSector=\"4\" garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera\n" +
            "tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /></Sector></Trimestre><Trimestre\n" +
            "fecha=\"2011-09-01\"><Sector sector=\"Financiero\" codigoSector=\"1\"\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"1\"\n" +
            "valor=\"1968.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Cooperativo\" codigoSector=\"2\"\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Real\" codigoSector=\"3\" garantiaAdmisible=\"0\"\n" +
            "garantiaOtro=\"0\"><Cartera tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/><Cartera tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /></Sector><Sector sector=\"Telcos\"\n" +
            "codigoSector=\"4\" garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera\n" +
            "tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /></Sector></Trimestre><Trimestre\n" +
            "fecha=\"2011-06-01\"><Sector sector=\"Financiero\" codigoSector=\"1\"\n" +
            "\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"1\"\n" +
            "valor=\"2389.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Cooperativo\" codigoSector=\"2\"\n" +
            "garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera tipo=\"Comercial\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Hipotecario\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Consumo\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Tarjeta de Crédito\" numeroCuentas=\"0\"\n" +
            "valor=\"0.0\" /><Cartera tipo=\"Microcrédito\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector><Sector sector=\"Real\" codigoSector=\"3\" garantiaAdmisible=\"0\"\n" +
            "garantiaOtro=\"0\"><Cartera tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/><Cartera tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\" /></Sector><Sector sector=\"Telcos\"\n" +
            "codigoSector=\"4\" garantiaAdmisible=\"0\" garantiaOtro=\"0\"><Cartera\n" +
            "tipo=\"Comercial\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Hipotecario\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera\n" +
            "tipo=\"Consumo\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Tarjeta de\n" +
            "Crédito\" numeroCuentas=\"0\" valor=\"0.0\" /><Cartera tipo=\"Microcrédito\"\n" +
            "numeroCuentas=\"0\" valor=\"0.0\"\n" +
            "/></Sector></Trimestre></ResumenEndeudamiento></InfoAgregada><InfoAgregad\n" +
            "aMicrocredito><Resumen><PerfilGeneral><CreditosVigentes\n" +
            "sectorFinanciero=\"1\" sectorCooperativo=\"0\" sectorReal=\"1\"\n" +
            "sectorTelcos=\"0\" totalComoPrincipal=\"2\" totalComoCodeudorYOtros=\"0\"\n" +
            "/><CreditosCerrados sectorFinanciero=\"7\" sectorCooperativo=\"0\"\n" +
            "sectorReal=\"1\" sectorTelcos=\"4\" totalComoPrincipal=\"12\"\n" +
            "totalComoCodeudorYOtros=\"0\" /><CreditosReestructurados\n" +
            "sectorFinanciero=\"0\" sectorCooperativo=\"0\" sectorReal=\"0\"\n" +
            "sectorTelcos=\"0\" totalComoPrincipal=\"0\" totalComoCodeudorYOtros=\"0\"\n" +
            "/><CreditosRefinanciados sectorFinanciero=\"0\" sectorCooperativo=\"0\"\n" +
            "sectorReal=\"0\" sectorTelcos=\"0\" totalComoPrincipal=\"0\"\n" +
            "totalComoCodeudorYOtros=\"0\" /><ConsultaUlt6Meses sectorFinanciero=\"0\"\n" +
            "sectorCooperativo=\"0\" sectorReal=\"2\" sectorTelcos=\"0\"\n" +
            "totalComoPrincipal=\"0\" totalComoCodeudorYOtros=\"0\" /><Desacuerdos\n" +
            "sectorFinanciero=\"0\" sectorCooperativo=\"0\" sectorReal=\"0\"\n" +
            "sectorTelcos=\"0\" totalComoPrincipal=\"0\" totalComoCodeudorYOtros=\"0\"\n" +
            "/><AntiguedadDesde sectorFinanciero=\"2003-05-31\" sectorReal=\"2008-06-19\"\n" +
            "sectorTelcos=\"2001-09-30\" /></PerfilGeneral><VectorSaldosYMoras\n" +
            "poseeSectorCooperativo=\"false\" poseeSectorFinanciero=\"true\"\n" +
            "poseeSectorReal=\"true\" poseeSectorTelcos=\"false\"><SaldosYMoras\n" +
            "fecha=\"2012-02-29\" totalCuentasMora=\"0\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"N\" numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2012-01-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\" /><SaldosYMoras\n" +
            "fecha=\"2011-12-29\" totalCuentasMora=\"0\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"N\" numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2011-11-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\" /><SaldosYMoras\n" +
            "fecha=\"2011-10-29\" totalCuentasMora=\"0\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"N\" numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2011-09-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\" /><SaldosYMoras\n" +
            "fecha=\"2011-08-29\" totalCuentasMora=\"0\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"N\" numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2011-07-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\" /><SaldosYMoras\n" +
            "fecha=\"2011-06-29\" totalCuentasMora=\"1\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"1\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"1\" numCreditos30=\"1\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2011-05-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\" /><SaldosYMoras\n" +
            "fecha=\"2011-04-29\" totalCuentasMora=\"0\" saldoDeudaTotalMora=\"0.0\"\n" +
            "saldoDeudaTotal=\"0.0\" morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\"\n" +
            "morasMaximas=\"N\" numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/><SaldosYMoras fecha=\"2011-03-29\" totalCuentasMora=\"0\"\n" +
            "saldoDeudaTotalMora=\"0.0\" saldoDeudaTotal=\"0.0\"\n" +
            "morasMaxSectorFinanciero=\"N\" morasMaxSectorReal=\"N\" morasMaximas=\"N\"\n" +
            "numCreditos30=\"0\" numCreditosMayorIgual60=\"0\"\n" +
            "/></VectorSaldosYMoras><EndeudamientoActual><Sector\n" +
            "codSector=\"3\"><TipoCuenta tipoCuenta=\"CBR\"><Usuario\n" +
            "tipoUsuario=\"Principal\"><Cuenta estadoActual=\"Al día\" calificacion=\"A\"\n" +
            "valorInicial=\"0.0\" saldoActual=\"0.0\" saldoMora=\"0.0\" cuotaMes=\"0.0\"\n" +
            "comportamientoNegativo=\"false\" totalDeudaCarteras=\"0.0\"\n" +
            "/></Usuario></TipoCuenta></Sector><Sector codSector=\"1\"><TipoCuenta\n" +
            "tipoCuenta=\"TDC\"><Usuario tipoUsuario=\"Principal\"><Cuenta\n" +
            "estadoActual=\"Al día Mora 30\" calificacion=\"A\" valorInicial=\"0.0\"\n" +
            "saldoActual=\"0.0\" saldoMora=\"0.0\" cuotaMes=\"0.0\"\n" +
            "comportamientoNegativo=\"false\" totalDeudaCarteras=\"0.0\"\n" +
            "/></Usuario></TipoCuenta></Sector></EndeudamientoActual><ImagenTendenciaE\n" +
            "ndeudamiento\n" +
            "/></Resumen><ComportamientoEntidades><ComportamientoEntidades\n" +
            "\n" +
            "codSector=\"3\" entidad=\"COLSUBSIDIO CUPO CREDITO\"\n" +
            "numeroCuenta=\"990006178\" tipoCuenta=\"CBR\" estado=\"Al día\"\n" +
            "fechaActualizacion=\"2012-02-29\"><comportamiento valor=\"0\"\n" +
            "mes=\"2012-02-01\" /><comportamiento valor=\"0\" mes=\"2012-01-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-12-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-11-01\" /><comportamiento valor=\"0\" mes=\"2011-10-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-09-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-08-01\" /><comportamiento valor=\"0\" mes=\"2011-07-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-06-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-05-01\" /><comportamiento valor=\"0\" mes=\"2011-04-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-03-01\"\n" +
            "/></ComportamientoEntidades><ComportamientoEntidades codSector=\"1\"\n" +
            "entidad=\"BCO DAVIVIENDA\" numeroCuenta=\"401122107\" tipoCuenta=\"TDC\"\n" +
            "estado=\"Al día Mora 30\" fechaActualizacion=\"2012-02-29\"><comportamiento\n" +
            "valor=\"0\" mes=\"2012-02-01\" /><comportamiento valor=\"0\" mes=\"2012-01-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-12-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-11-01\" /><comportamiento valor=\"0\" mes=\"2011-10-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-09-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-08-01\" /><comportamiento valor=\"0\" mes=\"2011-07-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-06-01\" /><comportamiento valor=\"0\"\n" +
            "mes=\"2011-05-01\" /><comportamiento valor=\"0\" mes=\"2011-04-01\"\n" +
            "/><comportamiento valor=\"0\" mes=\"2011-03-01\"\n" +
            "/></ComportamientoEntidades></ComportamientoEntidades><AnalisisVectores><\n" +
            "Sector nombreSector=\"Sector Financiero\"><Cuenta entidad=\"BANCO DE\n" +
            "OCCIDENTE S.A.\" numeroCuenta=\"006456395\" tipoCuenta=\"TDC\"\n" +
            "estado=\"Cancelada Sin Mora\" contieneDatos=\"true\"><CaracterFecha\n" +
            "fecha=\"2012-02-29\" /><CaracterFecha fecha=\"2012-01-29\" /><CaracterFecha\n" +
            "fecha=\"2011-12-29\" /><CaracterFecha fecha=\"2011-11-29\" /><CaracterFecha\n" +
            "fecha=\"2011-10-29\" /><CaracterFecha fecha=\"2011-09-29\" /><CaracterFecha\n" +
            "fecha=\"2011-08-29\" /><CaracterFecha fecha=\"2011-07-29\" /><CaracterFecha\n" +
            "fecha=\"2011-06-29\" /><CaracterFecha fecha=\"2011-05-29\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2011-04-29\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2011-03-29\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2011-02-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2011-01-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-12-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-11-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-10-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-09-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-08-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /></Cuenta><Cuenta entidad=\"BANCO DE\n" +
            "OCCIDENTE S.A.\" numeroCuenta=\"459059879\" tipoCuenta=\"TDC\"\n" +
            "estado=\"Cancelada Vol\" contieneDatos=\"true\"><CaracterFecha\n" +
            "fecha=\"2012-02-29\" /><CaracterFecha fecha=\"2012-01-29\" /><CaracterFecha\n" +
            "\n" +
            "fecha=\"2011-12-29\" /><CaracterFecha fecha=\"2011-11-29\" /><CaracterFecha\n" +
            "fecha=\"2011-10-29\" /><CaracterFecha fecha=\"2011-09-29\" /><CaracterFecha\n" +
            "fecha=\"2011-08-29\" /><CaracterFecha fecha=\"2011-07-29\" /><CaracterFecha\n" +
            "fecha=\"2011-06-29\" /><CaracterFecha fecha=\"2011-05-29\" /><CaracterFecha\n" +
            "fecha=\"2011-04-29\" /><CaracterFecha fecha=\"2011-03-29\" /><CaracterFecha\n" +
            "fecha=\"2011-02-28\" /><CaracterFecha fecha=\"2011-01-28\" /><CaracterFecha\n" +
            "fecha=\"2010-12-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-11-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-10-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-09-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-08-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-07-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-06-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-05-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-04-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-03-28\" saldoDeudaTotalMora=\"-\" /></Cuenta><Cuenta\n" +
            "entidad=\"BCO DAVIVIENDA\" numeroCuenta=\"401122107\" tipoCuenta=\"TDC\"\n" +
            "estado=\"Al día Mora 30\" contieneDatos=\"true\"><CaracterFecha\n" +
            "fecha=\"2012-02-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2012-01-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-12-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-11-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-10-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-09-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-08-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-07-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-06-29\" saldoDeudaTotalMora=\"1\" /><CaracterFecha\n" +
            "fecha=\"2011-05-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-04-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-03-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-02-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-01-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-12-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-11-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-10-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-09-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-08-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-07-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-06-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-05-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-04-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-03-28\" saldoDeudaTotalMora=\"-\" /></Cuenta><Cuenta\n" +
            "entidad=\"BCO DAVIVIENDA\" numeroCuenta=\"302325005\" tipoCuenta=\"TDC\"\n" +
            "estado=\"Cancelada Vol\" contieneDatos=\"true\"><CaracterFecha\n" +
            "fecha=\"2012-02-29\" /><CaracterFecha fecha=\"2012-01-29\" /><CaracterFecha\n" +
            "fecha=\"2011-12-29\" /><CaracterFecha fecha=\"2011-11-29\" /><CaracterFecha\n" +
            "fecha=\"2011-10-29\" /><CaracterFecha fecha=\"2011-09-29\" /><CaracterFecha\n" +
            "fecha=\"2011-08-29\" /><CaracterFecha fecha=\"2011-07-29\" /><CaracterFecha\n" +
            "fecha=\"2011-06-29\" /><CaracterFecha fecha=\"2011-05-29\" /><CaracterFecha\n" +
            "\n" +
            "fecha=\"2011-04-29\" /><CaracterFecha fecha=\"2011-03-29\" /><CaracterFecha\n" +
            "fecha=\"2011-02-28\" /><CaracterFecha fecha=\"2011-01-28\" /><CaracterFecha\n" +
            "fecha=\"2010-12-28\" /><CaracterFecha fecha=\"2010-11-28\" /><CaracterFecha\n" +
            "fecha=\"2010-10-28\" /><CaracterFecha fecha=\"2010-09-28\" /><CaracterFecha\n" +
            "fecha=\"2010-08-28\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /></Cuenta><Cuenta entidad=\"CREDENCIAL\"\n" +
            "numeroCuenta=\"146539011\" tipoCuenta=\"TDC\" estado=\"Cancelada Sin Mora\"\n" +
            "contieneDatos=\"true\"><CaracterFecha fecha=\"2012-02-29\" /><CaracterFecha\n" +
            "fecha=\"2012-01-29\" /><CaracterFecha fecha=\"2011-12-29\" /><CaracterFecha\n" +
            "fecha=\"2011-11-29\" /><CaracterFecha fecha=\"2011-10-29\" /><CaracterFecha\n" +
            "fecha=\"2011-09-29\" /><CaracterFecha fecha=\"2011-08-29\" /><CaracterFecha\n" +
            "fecha=\"2011-07-29\" /><CaracterFecha fecha=\"2011-06-29\" /><CaracterFecha\n" +
            "fecha=\"2011-05-29\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2011-04-29\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2011-03-29\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2011-02-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2011-01-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-12-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-11-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-10-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-09-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-08-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-07-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-06-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-05-28\" saldoDeudaTotalMora=\"-\" /><CaracterFecha\n" +
            "fecha=\"2010-04-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-03-28\" saldoDeudaTotalMora=\"-\"\n" +
            "/></Cuenta><MorasMaximas><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-08-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-09-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-10-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-11-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-12-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-01-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-02-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-03-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-04-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-05-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-06-29\"\n" +
            "saldoDeudaTotalMora=\"1\" /><CaracterFecha fecha=\"2011-07-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-08-29\"\n" +
            "\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-09-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-10-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-11-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-12-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2012-01-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2012-02-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /></MorasMaximas></Sector><Sector\n" +
            "nombreSector=\"Sector Real\"><Cuenta entidad=\"COLSUBSIDIO CUPO CREDITO\"\n" +
            "numeroCuenta=\"990006178\" tipoCuenta=\"CBR\" estado=\"Al día\"\n" +
            "contieneDatos=\"true\"><CaracterFecha fecha=\"2012-02-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2012-01-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-12-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-11-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-10-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-09-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-08-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-07-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-06-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-05-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-04-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-03-29\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-02-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2011-01-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-12-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-11-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-10-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-09-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-08-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /></Cuenta><Cuenta entidad=\"COLSUBSIDIO CUPO\n" +
            "CREDITO\" numeroCuenta=\"008658985\" tipoCuenta=\"CBR\" estado=\"Pago Vol\"\n" +
            "contieneDatos=\"true\"><CaracterFecha fecha=\"2012-02-29\" /><CaracterFecha\n" +
            "fecha=\"2012-01-29\" /><CaracterFecha fecha=\"2011-12-29\" /><CaracterFecha\n" +
            "fecha=\"2011-11-29\" /><CaracterFecha fecha=\"2011-10-29\" /><CaracterFecha\n" +
            "fecha=\"2011-09-29\" /><CaracterFecha fecha=\"2011-08-29\" /><CaracterFecha\n" +
            "fecha=\"2011-07-29\" /><CaracterFecha fecha=\"2011-06-29\" /><CaracterFecha\n" +
            "fecha=\"2011-05-29\" /><CaracterFecha fecha=\"2011-04-29\" /><CaracterFecha\n" +
            "fecha=\"2011-03-29\" /><CaracterFecha fecha=\"2011-02-28\" /><CaracterFecha\n" +
            "fecha=\"2011-01-28\" /><CaracterFecha fecha=\"2010-12-28\" /><CaracterFecha\n" +
            "fecha=\"2010-11-28\" /><CaracterFecha fecha=\"2010-10-28\" /><CaracterFecha\n" +
            "fecha=\"2010-09-28\" /><CaracterFecha fecha=\"2010-08-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"-\" /></Cuenta><MorasMaximas><CaracterFecha\n" +
            "fecha=\"2010-03-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-04-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-05-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-06-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-07-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-08-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-09-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-10-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-11-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2010-12-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-01-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-02-28\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-03-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-04-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-05-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-06-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-07-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-08-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-09-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-10-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-11-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2011-12-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2012-01-29\" saldoDeudaTotalMora=\"N\" /><CaracterFecha\n" +
            "fecha=\"2012-02-29\" saldoDeudaTotalMora=\"N\"\n" +
            "/></MorasMaximas></Sector><Sector nombreSector=\"Sector Telcos\"><Cuenta\n" +
            "entidad=\"COMCEL S.A.\" numeroCuenta=\".90114169\" tipoCuenta=\"CTC\"\n" +
            "estado=\"Pago Vol\" contieneDatos=\"true\"><CaracterFecha fecha=\"2012-02-29\"\n" +
            "/><CaracterFecha fecha=\"2012-01-29\" /><CaracterFecha fecha=\"2011-12-29\"\n" +
            "/><CaracterFecha fecha=\"2011-11-29\" /><CaracterFecha fecha=\"2011-10-29\"\n" +
            "/><CaracterFecha fecha=\"2011-09-29\" /><CaracterFecha fecha=\"2011-08-29\"\n" +
            "/><CaracterFecha fecha=\"2011-07-29\" /><CaracterFecha fecha=\"2011-06-29\"\n" +
            "/><CaracterFecha fecha=\"2011-05-29\" /><CaracterFecha fecha=\"2011-04-29\"\n" +
            "/><CaracterFecha fecha=\"2011-03-29\" /><CaracterFecha fecha=\"2011-02-28\"\n" +
            "/><CaracterFecha fecha=\"2011-01-28\" /><CaracterFecha fecha=\"2010-12-28\"\n" +
            "/><CaracterFecha fecha=\"2010-11-28\" /><CaracterFecha fecha=\"2010-10-28\"\n" +
            "/><CaracterFecha fecha=\"2010-09-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-08-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-07-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-06-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-05-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-04-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/><CaracterFecha fecha=\"2010-03-28\" saldoDeudaTotalMora=\"N\"\n" +
            "/></Cuenta><MorasMaximas><CaracterFecha fecha=\"2010-03-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-04-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-05-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-06-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-07-28\"\n" +
            "\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-08-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-09-28\"\n" +
            "saldoDeudaTotalMora=\"N\" /><CaracterFecha fecha=\"2010-10-28\"\n" +
            "/><CaracterFecha fecha=\"2010-11-28\" /><CaracterFecha fecha=\"2010-12-28\"\n" +
            "/><CaracterFecha fecha=\"2011-01-28\" /><CaracterFecha fecha=\"2011-02-28\"\n" +
            "/><CaracterFecha fecha=\"2011-03-29\" /><CaracterFecha fecha=\"2011-04-29\"\n" +
            "/><CaracterFecha fecha=\"2011-05-29\" /><CaracterFecha fecha=\"2011-06-29\"\n" +
            "/><CaracterFecha fecha=\"2011-07-29\" /><CaracterFecha fecha=\"2011-08-29\"\n" +
            "/><CaracterFecha fecha=\"2011-09-29\" /><CaracterFecha fecha=\"2011-10-29\"\n" +
            "/><CaracterFecha fecha=\"2011-11-29\" /><CaracterFecha fecha=\"2011-12-29\"\n" +
            "/><CaracterFecha fecha=\"2012-01-29\" /><CaracterFecha fecha=\"2012-02-29\"\n" +
            "/></MorasMaximas></Sector></AnalisisVectores><EvolucionDeuda><Trimestres>\n" +
            "<Trimestre>2012/03</Trimestre><Trimestre>2011/12</Trimestre><Trimestre>20\n" +
            "11/09</Trimestre><Trimestre>2011/06</Trimestre><Trimestre>2011/03</Trimes\n" +
            "tre><Trimestre>2010/12</Trimestre></Trimestres><EvolucionDeudaSector\n" +
            "codSector=\"3\" nombreSector=\"Real\"><EvolucionDeudaTipoCuenta\n" +
            "tipoCuenta=\"CBR\"><EvolucionDeudaValorTrimestre trimestre=\"2012/03\"\n" +
            "tipoCuenta=\"CBR\" num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\"\n" +
            "cuota=\"0.0\" porcentajeDeuda=\"0.0\" codMenorCalificacion=\"1\"\n" +
            "textoMenorCalificacion=\"A\" /><EvolucionDeudaValorTrimestre\n" +
            "trimestre=\"2011/12\" tipoCuenta=\"CBR\" num=\"1\" cupoInicial=\"0.0\"\n" +
            "saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\" porcentajeDeuda=\"0.0\"\n" +
            "codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/09\" tipoCuenta=\"CBR\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/06\" tipoCuenta=\"CBR\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/03\" tipoCuenta=\"CBR\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2010/12\" tipoCuenta=\"CBR\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/></EvolucionDeudaTipoCuenta></EvolucionDeudaSector><EvolucionDeudaSector\n" +
            "codSector=\"1\" nombreSector=\"Financiero\"><EvolucionDeudaTipoCuenta\n" +
            "tipoCuenta=\"TDC\"><EvolucionDeudaValorTrimestre trimestre=\"2012/03\"\n" +
            "tipoCuenta=\"TDC\" num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\"\n" +
            "cuota=\"0.0\" porcentajeDeuda=\"0.0\" codMenorCalificacion=\"1\"\n" +
            "textoMenorCalificacion=\"A\" /><EvolucionDeudaValorTrimestre\n" +
            "trimestre=\"2011/12\" tipoCuenta=\"TDC\" num=\"1\" cupoInicial=\"0.0\"\n" +
            "saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\" porcentajeDeuda=\"0.0\"\n" +
            "codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/09\" tipoCuenta=\"TDC\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/06\" tipoCuenta=\"TDC\"\n" +
            "num=\"1\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2011/03\" tipoCuenta=\"TDC\"\n" +
            "num=\"3\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/><EvolucionDeudaValorTrimestre trimestre=\"2010/12\" tipoCuenta=\"TDC\"\n" +
            "num=\"4\" cupoInicial=\"0.0\" saldo=\"0.0\" saldoMora=\"0.0\" cuota=\"0.0\"\n" +
            "porcentajeDeuda=\"0.0\" codMenorCalificacion=\"0\" textoMenorCalificacion=\"-\"\n" +
            "/></EvolucionDeudaTipoCuenta></EvolucionDeudaSector></EvolucionDeuda></In\n" +
            "foAgregadaMicrocredito></Informe></Informes>]]></ws:consultarHC2Return>";

    public static String NEGADO = "consecutivo=\"67\">[EDAD][40][DECISION][NEGADO]</Linea>\n" +
            "<Linea consecutivo=\"68\">[CAUSAL_RECHAZO][NA][CAUSAL_PA1][Marcacion en\n" +
            "centrales]</Linea><Linea\n";

    public static String PREAPROBADO_SIN_DOCUMENTOS = "consecutivo=\"67\">[EDAD][40][DECISION][PREAPROBADO_SIN_DOCUMENTOS]</Linea>\n" +
            "<Linea consecutivo=\"68\">[CAUSAL_RECHAZO][NA][CAUSAL_PA1][Marcacion en\n" +
            "centrales]</Linea><Linea\n";

    public static String PREAPROBADO_CON_DOCUMENTOS = "consecutivo=\"67\">[EDAD][40][DECISION][PREAPROBADO_CON_DOCUMENTOS]</Linea>\n" +
            "<Linea consecutivo=\"68\">[CAUSAL_RECHAZO][NA][CAUSAL_PA1][Marcacion en\n" +
            "centrales]</Linea><Linea\n";

    public static String ERROR_EN_PROCESO = "consecutivo=\"67\">[EDAD][40][DECISION][ERROR EN PROCESO]</Linea>\n" +
            "<Linea consecutivo=\"68\">[CAUSAL_RECHAZO][NA][CAUSAL_PA1][Marcacion en\n" +
            "centrales]</Linea><Linea\n";
}
