/**
 * @author Taochunwei
 * @date 2019/7/11 - 14:13
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
