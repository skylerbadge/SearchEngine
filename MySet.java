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
	public void Insert(T o) throws Exception
	{
		if(!setobj.isMember(o))
			setobj.addAtHead(o);
		else
			throw new Exception();
	}
	public void Delete(T o) throws Exception
	{
		if(setobj.isMember(o))
			setobj.deleteAtIndex(setobj.findob(o));
		else
			throw new Exception();
	}
	public MySet<T> Union(MySet<T> a)
	{
		MySet<T> unset = new MySet<T>();
		MyLinkedList<T>.Node t = setobj.head;
		while(t!=null)
		{
			try{
				unset.Insert(t.data);
			} catch(Exception e){}
			t=t.next;
		}

		t = a.setobj.head;
		while(t!=null)
		{
			try{
				unset.Insert(t.data);
			} catch(Exception e){}
			t=t.next;
		}
		return unset;
	}
	public MySet<T> Intersection(MySet<T> a)
	{
		MySet<T> intset = new MySet<T>();
		MyLinkedList<T>.Node t = setobj.head;
		while(t!=null)
		{
			if(a.isMember(t.data))
			{
				try{
				intset.Insert(t.data);
				} catch(Exception e){}
			}
			t=t.next;
		}
		return intset;
	}
}