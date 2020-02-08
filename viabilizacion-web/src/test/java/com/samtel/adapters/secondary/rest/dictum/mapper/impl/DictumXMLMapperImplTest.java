package com.samtel.adapters.secondary.rest.dictum.mapper.impl;

import com.samtel.adapters.secondary.rest.dictum.mapper.DictumXMLMapper;
import com.samtel.errors.XmlParsingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class DictumXMLMapperImplTest {
    public static final String INPUT = "<Informe fechaConsulta=\"2020-01-22T08:36:55\" respuesta=\"13\" codSeguridad=\"WFN72G4\" tipoIdDigitado=\"1\" identificacionDigitada=\"91518562\" apellidoDigitado=\"BECERRA\">\n" +
            "   <NaturalNacional nombres=\"YEHISON FABIAN\" primerApellido=\"BECERRA\" segundoApellido=\"RODRIGUEZ\" nombreCompleto=\"BECERRA RODRIGUEZ YEHISON FABIAN\" validada=\"true\" rut=\"true\" genero=\"4\">\n" +
            "      <Identificacion estado=\"00\" fechaExpedicion=\"2001-05-07\" ciudad=\"BUCARAMANGA\" departamento=\"SANTANDER\" genero=\"4\" numero=\"00091518562\"/>\n" +
            "      <Edad min=\"36\" max=\"45\"/>\n" +
            "      <InfoDemografica/>\n" +
            "   </NaturalNacional>\n" +
            "</Informe>";

    public static final String BAD_INPUT = "<Informe fechaConsulta=\"2020-01-22T08:36:55\" respuesta=\"13\" codSeguridad=\"WFN72G4\" tipoIdDigitado=\"1\" identificacionDigitada=\"91518562\" apellidoDigitado=\"BECERRA\">\n" +
            "   <NaturalNacional nombres=\"YEHISON FABIAN\" primerApellido=\"BECERRA\" segundoApellido=\"RODRIGUEZ\" nombreCompleto=\"BECERRA RODRIGUEZ YEHISON FABIAN\" validada=\"true\" rut=\"true\" genero=\"4\">\n" +
            "      <Identificacion estado=\"00\" fechaExpedicion=\"2001-05-07\" ciudad=\"BUCARAMANGA\" departamento=\"SANTANDER\" genero=\"4\" numero=\"00091518562\"/>\n" +
            "      <Edad min=\"36\" max=\"45\"/>\n" +
            "      <InfoDemografica/>\n" +
            "   </NaturalNacional>\n" +
            "";
    public static final String OUTPUT = "{\"Informe\":{\"fechaConsulta\":\"2020-01-22T08:36:55\",\"tipoIdDigitado\":1,\"identificacionDigitada\":91518562,\"apellidoDigitado\":\"BECERRA\",\"respuesta\":13,\"codSeguridad\":\"WFN72G4\",\"NaturalNacional\":{\"rut\":true,\"Edad\":{\"min\":36,\"max\":45},\"Identificacion\":{\"fechaExpedicion\":\"2001-05-07\",\"estado\":\"00\",\"numero\":\"00091518562\",\"ciudad\":\"BUCARAMANGA\",\"genero\":4,\"departamento\":\"SANTANDER\"},\"primerApellido\":\"BECERRA\",\"genero\":4,\"segundoApellido\":\"RODRIGUEZ\",\"validada\":true,\"nombreCompleto\":\"BECERRA RODRIGUEZ YEHISON FABIAN\",\"nombres\":\"YEHISON FABIAN\",\"InfoDemografica\":\"\"}}}";
    private DictumXMLMapper dictumXMLMapper;


    @Before
    public void setUp() {
        dictumXMLMapper = new DictumXMLMapperImpl();
    }

    @Test
    public void testXmlToJsonSuccess() {
        Optional<String> respuesta = dictumXMLMapper.toJsonString(INPUT);
        Assert.assertEquals(OUTPUT, respuesta.get());
    }

    @Test(expected = XmlParsingException.class)
    public void testXmlToJsonError() {
        Optional<String> respuesta = dictumXMLMapper.toJsonString(BAD_INPUT);
    }

}
