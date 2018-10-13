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
	public void addElement(T element)
	{
		if(!setobj.isMember(element))
			setobj.addAtTail(element);
	}
	public void Delete(T element)
	{
		if(setobj.isMember(element))
			setobj.deleteAtIndex(setobj.findob(element));
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
}