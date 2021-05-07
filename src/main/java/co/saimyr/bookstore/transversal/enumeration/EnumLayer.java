package co.saimyr.bookstore.transversal.enumeration;

public enum EnumLayer {
    DATA("DATA", "Application's data layer."), DOMAIN("DOMAIN", "Application's domain layer"),
    BUSINESS("BUSINESS", "Application's business layer"), FACADE("FACADE", "Application's facade layer"),
    API("API", "Application's API layer"), DTO("DTO", "Application's DTO layer"),
    TRANSVERSAL("TRANSVERSAL", "Application's transversal layer"),
    BACKEND("BACKEND", "Application's backend layer");

    private String code;
    private String description;

    private EnumLayer(String code, String description) {
        setCode(code);
        setDescription(description);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private void setCode(String code) {
        this.code = code;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
