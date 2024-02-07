class QueueUsingStacks<T> {
        private MyStack<T> stack1;
        private MyStack<T> stack2;

        public QueueUsingStacks() {
            stack1 = new MyStack<>();
            stack2 = new MyStack<>();
        }

        public void enQueue(T item) {
            stack1.push(item); // Push items onto stack1 (representing the rear of the queue)
        }

        public T deQueue() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new java.util.NoSuchElementException("Queue is empty");
            }

            // If stack2 is empty, transfer elements from stack1 to stack2 to reverse the order
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop(); // Pop the front element from stack2 (representing the front of the queue)
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }
}
public class Ex06 {
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());

        System.out.println("Is Empty: " + queue.isEmpty());
    }
}