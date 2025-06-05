public class main {

    public static void main(String[] args) {
        stack<Integer> p = new stack<>();
        queue<Integer> f = new queue<>();

        System.out.println("-------- Stack with List --------");
        System.out.print("push(10)");
        p.push(10);
        System.out.print("\npeek(): " + p.peek());
        System.out.print("\npush(14)");
        p.push(14);
        System.out.print("\npush(32)");
        p.push(32);
        System.out.print("\npeek(): " + p.peek());
        System.out.print("\nsize(): " + p.size());
        System.out.print("\npop()");
        p.pop();
        System.out.print("\npeek(): " + p.peek());
        System.out.print("\npop()");
        System.out.print("\npop()");
        p.pop();
        p.pop();
        System.out.print("\nsize(): " + p.size());
        if (p.isEmpty() == true) {
            System.out.print("\nStack is empty!");
        } else {
            System.out.print("\nStack has values inside!");
        }
        System.out.print("\n-------- Stack with List --------");

        System.out.print("\n\n");

        System.out.println("-------- Queue with List --------");
        System.out.print("enqueue(10)");
        f.enqueue(10);
        System.out.print("\npeek(): " + f.peek());
        System.out.print("\nenqueue(14)");
        f.enqueue(14);
        System.out.print("\nenqueue(32)");
        f.enqueue(32);
        System.out.print("\npeek(): " + f.peek());
        System.out.print("\nsize(): " + f.size());
        System.out.print("\ndequeue()");
        f.dequeue();
        System.out.print("\npeek(): " + f.peek());
        System.out.print("\ndequeue()");
        System.out.print("\ndequeue()");
        f.dequeue();
        f.dequeue();
        System.out.print("\nsize(): " + f.size());
        if (f.isEmpty() == true) {
            System.out.print("\nQueue is empty!");
        } else {
            System.out.print("\nQueue has values inside!");
        }
        System.out.println("\n-------- Queue with List --------");
    }
}