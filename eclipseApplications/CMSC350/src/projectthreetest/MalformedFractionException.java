package projectthreetest;

class MalformedFractionException extends Exception{
    MalformedFractionException(String token) {
        super(token);
    }
}
