package br.dev.techtalk.domain.enumeration;

public enum BookNodesEnum {

    BOOK("book"),
    PUBLISHER("publisher"),
    AUTHORS("authors");

    private final String value;

    BookNodesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public BookNodesEnum findByValue(String value) {
        for (BookNodesEnum item : BookNodesEnum.values()) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return null;
    }

}
