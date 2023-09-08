package library.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(final ErrorCode errorCode, Object... args) {
        super(errorCode.formatDescription(args));
    }

    public ServiceException(final ErrorCode errorCode) {
        super(errorCode.getDescription());
    }
}
