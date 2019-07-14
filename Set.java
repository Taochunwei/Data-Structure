/**
 * @author Taochunwei
 * @date 2019/7/7 - 11:19
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
