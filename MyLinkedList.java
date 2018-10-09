public class MyLinkedList<T>
{
    class Node
    {
        //Declare class variables
        Node next;
        T data;
        
        public Node(T dat)
        {
            data = dat;
            next = null;
        }
        public Node()
        {
            data = null;
            next = null;
        }
        
        public Object getData()
        {
            return data;
        }
    }
    //Class variables for the Linked List
    Node head;
    int numNodes;
    
    public MyLinkedList()
    {
        head = null;
        numNodes=0;

    }
    public MyLinkedList(T dat)
    {
        head = new Node(dat);
        numNodes = 1;
    }
    
    public void addAtHead(T dat)
    {
        Node temp = head;
        head = new Node(dat);
        head.next = temp;
        numNodes++;
    }
    
    public void addAtTail(T dat)
    {
        if (head==null)
        {
            head = new Node(dat);
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new Node(dat);
        }
        numNodes++;
    }
    
    public void addAtIndex(int index, T dat)
    {
        Node temp = head;
        Node holder;
        for(int i=0; i < index-1 && temp.next != null; i++)
        {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(dat);
        temp.next.next = holder;
        numNodes++;
    }
    
    public void deleteAtIndex(int index)
    {
        Node temp = head;
        for(int i=0; i< index - 1 && temp.next != null; i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }
    
    public int find(Node n)
    {
        Node t = head;
        int index = 0;
        while(t != n)
        {
            index++;
            t = t.next;
        }
        return index;
    }

    public int findob(T o)
    {
        Node t = head;
        int index = 0;
        while(t != null && t.data != o)
        {
            index++;
            t = t.next;
        }
        if (t==null)
            return -1;
        else
            return index;       
    }
    
    public Node ithNode(int index)//starts from index 0
    {
        if (index >= numNodes)
            return null;
        else
        {
            Node ptr = head;
            int ctr =0;
            while(ctr<index)
            {
                ptr=ptr.next;
                ctr++;
            }
            return ptr;
        }
        
    }

    public boolean isMember(T o)
    {
        Node temp = head;
        while(temp != null)
        {
            if(o.equals(temp.data))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if (numNodes==0)
            return true;
        return false;
    }
        
    public void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    public int getSize()
    {
        return numNodes;
    }
}
