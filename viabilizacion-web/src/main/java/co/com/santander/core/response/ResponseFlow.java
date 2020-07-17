package co.com.santander.core.response;

public enum ResponseFlow {
    INVALID_CITY, UNEXPECTED_ERROR,
    APROBADO,
    PREAPROBADO_SIN_DOCUMENTOS,
    PREAPROBADO_CON_DOCUMENTOS,
    NEGADO;

    public static ResponseFlow evaluaRespuesta(String respuesta){
        if("APROBADO".equalsIgnoreCase(respuesta)){
            return APROBADO;
        }else if("PREAPROBADO_SIN_DOCUMENTOS".equalsIgnoreCase(respuesta)){
            return PREAPROBADO_SIN_DOCUMENTOS;
        }else if("PREAPROBADO_CON_DOCUMENTOS".equalsIgnoreCase(respuesta)){
            return PREAPROBADO_CON_DOCUMENTOS;
        }else if("NEGADO".equalsIgnoreCase(respuesta)){
            return NEGADO;
        }
        return UNEXPECTED_ERROR;
    }
}
