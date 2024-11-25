package exception;

public class IncorrectIndexGivenException extends RuntimeException {
    public IncorrectIndexGivenException(String e) {
        System.out.println(e);
    }
}
