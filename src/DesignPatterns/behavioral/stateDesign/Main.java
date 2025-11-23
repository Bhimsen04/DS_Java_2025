package DesignPatterns.behavioral.stateDesign;

/*
    The State pattern allows an object to change its behavior when its internal state changes. Instead of using if-else for state
    transitions, each state is represented as a separate class. In real-world systems like payment workflows, order tracking,
    delivery lifecycle, and booking systems, the State pattern makes transitions clean, testable, and easily extendable.
    Use State Pattern when:
        An object’s behavior changes based on its state.
        You have lots of if-else or switch-case statements for different states.
        You want clean separation of behaviors for each state.
    Not use below
        if(state == "NEW") { ... }
        else if(state == "PROCESSING") { ... }
        else if(state == "SHIPPED") { ... }
 */
public class Main {

    public static void main(String[] args) {
        OrderContext ctx = new OrderContext();

        ctx.printStatus();   // NEW
        ctx.next();

        ctx.printStatus();   // PROCESSING
        ctx.next();

        ctx.printStatus();   // SHIPPED
        ctx.next();

        ctx.printStatus();   // DELIVERED
    }
}
