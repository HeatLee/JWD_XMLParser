package by.training.xmlparser.command;

public enum Pages {
    INDEX_JSP("page/index.jsp"),
    RESULT_JSP("page/result.jsp"),
    ERROR_PAGE_JSP("page/error.jsp"),
    INFORMER_PAGE_JSP("page/warn.jsp")
    ;

    private String value;

    Pages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
