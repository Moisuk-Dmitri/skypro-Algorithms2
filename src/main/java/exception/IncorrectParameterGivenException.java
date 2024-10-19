package exception;

public class IncorrectParameterGivenException extends RuntimeException {
    public IncorrectParameterGivenException(String e) {
        System.out.println(e);
    }
}
