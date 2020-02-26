package com.samtel.bizagi.service;

public class MockRequestCreateCase {
    public static String request = "<![CDATA[<BizAgiWSParam>\n" +
            "         <domain>domain</domain>\n" +
            "         <userName>admon</userName>\n" +
            "         <Cases>\n" +
            "                 <Case>\n" +
            "                 <Process>Credit</Process>\n" +
            "                 <Entities>\n" +
            "                         <idRequest>\n" +
            "                                 <Applicants>\n" +
            "                                         <Applicant>\n" +
            "                                                 <DocumentNumber>785621</DocumentNumber>\n" +
            "                                                 <idDocumentType businesskey=\"Name='CC'\" />\n" +
            "                                                 <BuroScore>5</BuroScore>\n" +
            "                                         </Applicant>\n" +
            "                                 </Applicants>\n" +
            "                         </idRequest>\n" +
            "                 </Entities>\n" +
            "                 </Case>\n" +
            "         </Cases>\n" +
            " </BizAgiWSParam>]]>";
}
