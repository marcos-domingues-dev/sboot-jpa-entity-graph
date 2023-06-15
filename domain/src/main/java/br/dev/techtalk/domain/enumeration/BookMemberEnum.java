package br.dev.techtalk.domain.enumeration;

public enum BookMemberEnum {

    BOOK("book"),
    PUBLISHER("publisher"),
    AUTHORS("authors");

    private final String value;

    BookMemberEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public BookMemberEnum findByValue(String value) {
        for (BookMemberEnum item : BookMemberEnum.values()) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return null;
    }

}
