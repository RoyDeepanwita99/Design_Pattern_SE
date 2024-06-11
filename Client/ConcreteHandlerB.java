public class ConcreteHandlerB implements Handler {
    private Handler successor;

    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("Handler B is handling the request.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
