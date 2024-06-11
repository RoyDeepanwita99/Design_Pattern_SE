class ConcreteHandlerA implements Handler {
    private Handler successor;

    @Override
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("Handler A is handling the request.");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
