package co.com.santander.bizagi.service;

public class MockRequestCreateCase {
    public static String request = "<![CDATA[ <BizAgiWSParam>\n" +
            "                       <domain>2345678</domain>\n" +
            "                       <userName>1234567</userName>\n" +
            "                       <Cases>\n" +
            "                          <Case>\n" +
            "                             <Process>23456789</Process>\n" +
            "                             <Entities>\n" +
            "                                <SolicitudCredito>\n" +
            "                                   <Cliente>\n" +
            "                                      <Tipodeidentificacion>1</Tipodeidentificacion>\n" +
            "                                      <NumeroIdentificacion>1234567</NumeroIdentificacion>\n" +
            "                                      <Apellido1>12345</Apellido1>\n" +
            "                                      <Apellido2>werty</Apellido2>\n" +
            "                                      <Nombre1>123456</Nombre1>\n" +
            "                                      <Nombre2>1234567</Nombre2>\n" +
            "                                   </Cliente>\n" +
            "                                   <AutorizaConsultaaCentrales>1</AutorizaConsultaaCentrales>\n" +
            "                                </SolicitudCredito>\n" +
            "                             </Entities>\n" +
            "                          </Case>\n" +
            "                       </Cases>\n" +
            "                    </BizAgiWSParam>]]>\n";
}
