public class MySet<T>
{
	MyLinkedList<T> setobj;
        
	public MySet()
	{
            setobj = new MyLinkedList<T>();
	}
        public boolean isEmpty()
	{
		return setobj.isEmpty();
	}
	public boolean isMember(T o)
	{
		return setobj.isMember(o);
	}
	public void addElement(T element) throws Exception
	{
		if(!setobj.isMember(element))
			setobj.addAtHead(element);
		else
			throw new Exception("Element already exists in set");
	}
	public void Delete(T element) throws Exception
	{
		if(setobj.isMember(element))
			setobj.deleteAtIndex(setobj.findob(element));
		else
			throw new Exception("Element does not exist in set");
	}
	public MySet<T> union(MySet<T> otherSet)
	{
		MySet<T> unset = new MySet<T>();
		MyLinkedList<T>.Node t = setobj.head;
		while(t!=null)
		{
			try{
				unset.addElement(t.data);
			} catch(Exception e){}
			t=t.next;
		}

		t = otherSet.setobj.head;
		while(t!=null)
		{
			try{
				unset.addElement(t.data);
			} catch(Exception e){}
			t=t.next;
		}
		return unset;
	}
	public MySet<T> intersection(MySet<T> otherSet)
	{
		MySet<T> intset = new MySet<T>();
		MyLinkedList<T>.Node t = setobj.head;
		while(t!=null)
		{
			if(otherSet.isMember(t.data))
			{
                            try{
                            intset.addElement(t.data);
                            } catch(Exception e){}
			}
			t=t.next;
		}
		return intset;
	}
//        public static void main(String[] args)
//        {
//            try
//            {
//                MySet<Integer> a = new MySet<>();
//                System.out.println(a.isEmpty());
//                a.addElement(1);
//                a.addElement(2);
//                a.addElement(3);
//                a.addElement(4);
//                a.addElement(5);
//                System.out.println(a.isEmpty());
//                a.setobj.printList();
//                a.Delete(3);
//                a.setobj.printList();
//
//
//                MySet<Integer> b = new MySet<>();
//                b.addElement(4);
//                b.addElement(3);
//                b.addElement(0);
//                b.addElement(9);
//                b.addElement(7);
//                b.addElement(-1);
//                System.out.println(a.isMember(1));
//                System.out.println(a.isMember(7));
//                System.out.println(b);
//                a.union(b).setobj.printList();
//                 System.out.println(b);
//                a.intersection(b).setobj.printList();
//            }
//            catch (Exception e)
//            {
//                System.out.println("Except");
//            }
//        }
}