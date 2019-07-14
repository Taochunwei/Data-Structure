

/**
 * @author Taochunwei
 * @date 2019/7/11 - 9:51
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        for(int i=parent(arr.length-1);i>=0;i--)
            shiftDown(i);
    }

    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }
    public MaxHeap(){
        data=new Array<>();
    }
    public int size(){
        return data.getSize();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    //用一个索引找到父亲节点
    private int parent(int index){
        if(index==0)
            throw new IllegalArgumentException("index can't be zero");
        return (index-1)/2;
    }
    //用一个索引找到左孩子节点
    private int leftChild(int index){
        return index*2+1;
    }
    //用一个索引找到右孩子
    private int rightChild(int index){
        return index*2+2;
    }
//向堆中添加元素
    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }
    private void shiftUp(int K){
        while(K>0&&data.get(parent(K)).compareTo(data.get(K))<0){
        data.swap(K,parent(K));
        K=parent(K);
        }
    }
//从堆中找到最大元素
    public E findMax(){
        return data.get(0);
    }
    //下沉操作
    private void shiftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j =leftChild(k);
            if(j+1<data.getSize()&&data.get(j).compareTo(data.get(j+1))<0)
                j++;
            //data[j]是 leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j))>=0)
                break;
            if(data.get(k).compareTo(data.get(j))<0)
                data.swap(k,j);
            k=j;
        }
    }
//从堆中去除最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }
//取出最大元素，并将原来的元素替换成e
     public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        shiftDown(0);
        return ret;
     }



}
