/**
 * @author Taochunwei
 * @date 2019/7/14 - 19:01
 */
public class UnionFind5 implements UF{
    private int[] parent;
    private int[] rank;
    public UnionFind5(int  size){
        parent=new int[size];
        rank=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int p){
        if(p<0||p>=parent.length)
            throw new IllegalArgumentException("Error");
        while (p!=parent[p]){
            parent[p]=parent[parent[p]];
            p=parent[p];
        }
        return p;
    }
    @Override
    public int getSize(){
        return parent.length;
    }
    @Override
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    @Override
    public void unionElements(int p,int q){
        if(p<0||p>=parent.length||q<0||q>=parent.length)
            throw new IllegalArgumentException("Error");

        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot==qRoot)
            return;
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
        }else if(rank[qRoot]<rank[pRoot]) {
            parent[qRoot]=pRoot;
        }else {
            parent[qRoot]=pRoot;
            rank[pRoot]+=1;
        }
    }
}

