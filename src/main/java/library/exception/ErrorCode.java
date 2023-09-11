package library.exception;

public enum ErrorCode {
    ERR_CODE_01("ERR.CODE.01", "Книга с id %s уже выдана!"),
    ERR_CODE_02("ERR.CODE.02", "Пользователь с id %s не существует!"),
    ERR_CODE_03("ERR.CODE.03", "Книга с id %s не существует!"),
    ERR_CODE_04("ERR.CODE.04", "Выдача с id %s не существует!");
    private final String code;
    private final String description;

    ErrorCode(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String formatDescription(final Object... args) {
        return String.format(description, args);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
