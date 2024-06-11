public interface Handler {
    void handleRequest(String request);
    void setSuccessor(Handler successor);
}