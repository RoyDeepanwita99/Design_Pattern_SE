public class Client {
    public static void main(String[] args) {
        Handler handlerChain = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        //Handler handlerC = new ConcreteHandlerC();

        // Build the chain: A -> B -> C
        handlerChain.setSuccessor(handlerB);
       // handlerB.setSuccessor(handlerC);

        // Test the chain
        handlerChain.handleRequest("A");
        handlerChain.handleRequest("B");
        handlerChain.handleRequest("C");
        handlerChain.handleRequest("D");
    }
}