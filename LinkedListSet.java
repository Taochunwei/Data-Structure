import java.util.LinkedList;

/**
 * @author Taochunwei
 * @date 2019/7/9 - 15:24
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;
    public LinkedListSet(){
        list=new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.size();
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public boolean contains(E e){
        return list.contains(e);
    }
    @Override
    public void add(E e){
        if(!list.contains(e))
            list.addFirst(e);
    }
    @Override
    public void remove(E e)
    {
        list.remove(e);
    }
}
