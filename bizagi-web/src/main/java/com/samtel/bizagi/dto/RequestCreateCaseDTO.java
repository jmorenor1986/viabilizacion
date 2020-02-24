package com.samtel.bizagi.dto;

import java.util.List;

public class RequestCreateCaseDTO {

    public static class CasesInfo {
        protected List<Object> content;

        public List<Object> getContent() {
            return content;
        }

        public void setContent(List<Object> content) {
            this.content = content;
        }
    }
}
