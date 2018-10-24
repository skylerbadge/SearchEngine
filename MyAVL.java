public class MyAVL<T extends Comparable<T>> {
    class Node{
        T data;
        Node leftChild, rightChild, parent;
        int height;
        public Node()
        {
            data = null;
            leftChild = null;
            rightChild = null;
            parent = null;
            height = 0;
            
        }
        public Node(T o){
            data = o;
            leftChild = null;
            rightChild = null;
            parent = null;
            height = 0;
        }
    }
    
    Node root;
    int numNodes;
    
    public MyAVL(){
        root = null;
        numNodes = 0;
    }
    public boolean isEmpty()
    {
         return numNodes==0;
    }
    private int height(Node n){
        if(n == null)
            return -1;
        else
            return n.height;
    }
    public Node search(T o){
        Node ptr = root;
        while(ptr!=null){
            if (ptr.data.compareTo(o)==0)
                break;
            else if(ptr.data.compareTo(o)>0)
                ptr = ptr.rightChild;
            else
                ptr = ptr.leftChild;
        }
        return ptr;
    }
    
    private Node rotateRight(Node n){
       Node lch = n.leftChild;
       Node T = lch.rightChild;
        
       lch.rightChild = n;
       n.leftChild = T;
       
       n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
       lch.height = Math.max(height(lch.leftChild),height(lch.rightChild))+1;

       return lch;
    }
    private Node rotateLeft(Node n){
       Node rch = n.rightChild;
       Node T = rch.leftChild;
        
       rch.leftChild = n;
       n.rightChild = T;

       n.height = Math.max(height(n.leftChild),height(n.rightChild))+1;
       rch.height = Math.max(height(rch.leftChild),height(rch.rightChild))+1;
       
       return rch;
    }

    public void insert(T o){
        root = insertrec(o,root);
        numNodes++;
    }
    
    private Node insertrec(T o, Node t)
    {
         if (t == null)
             t = new Node(o);
         else if (t.data.compareTo(o)<0)
         {
             t.leftChild = insertrec( o, t.leftChild );
             if( height( t.leftChild ) - height( t.rightChild ) == 2 )
                 if(t.leftChild.data.compareTo(o)<0)
                     t = rotateRight(t);
                 else{
                     t.leftChild = rotateLeft(t.leftChild);
                     t = rotateRight(t);
                 }
         }
         else
         {
             t.rightChild = insertrec( o, t.rightChild );
             if( height( t.rightChild ) - height( t.leftChild ) == 2 )
                 if(t.rightChild.data.compareTo(o)>0)
                     t = rotateLeft(t);
                 else{
                     t.rightChild = rotateRight(t.rightChild);
                     t = rotateLeft(t);
                 }
         }
         t.height = Math.max( height( t.leftChild ), height( t.rightChild ) ) + 1;
         return t;
    }
    public MyLinkedList<T> returnLL(){
        MyLinkedList<T> ll = new MyLinkedList<>();
        returnLLinner(root,ll);
        return ll;
    }
    private void returnLLinner(Node r, MyLinkedList<T> mll){
        if (r != null)
         {
             returnLLinner(r.leftChild,mll);
             mll.addAtHead(r.data);
             returnLLinner(r.rightChild,mll);
         }
    }
    
    public void inorder(Node r)
     {
         if (r != null)
         {
             inorder(r.leftChild);
             System.out.print(r.data +" ");
             inorder(r.rightChild);
         }
     }
    public static void main(String[] args) {
        MyAVL<Integer> av = new MyAVL<Integer>();
        av.insert(5);
        av.insert(45);
        av.insert(30);
        av.insert(3);
        av.insert(0);
        av.insert(50);
        av.insert(2);
        System.out.println(av.search(5));
        System.out.println(av.numNodes);
        av.returnLL().printList();
    }
}
