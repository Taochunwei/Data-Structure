/**
 * @author Taochunwei
 * @date 2019/7/12 - 18:30
 */
public interface Merger<E> {
    E merge(E a, E b);
}
