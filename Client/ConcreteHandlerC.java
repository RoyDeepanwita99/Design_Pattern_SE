public class ConcreteHandlerC implements Handler {
    private Handler successor;

    @Override
    public void handleRequest(String request) {
        if (request.equals("C")) {
            System.out.println("Handler C is handling the request.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}