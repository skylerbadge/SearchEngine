import java.util.*;

public class MySort {
    public static ArrayList<SearchResult> sortThisList(MySet<SearchResult> listOfSortableEntries){
        ArrayList<SearchResult> al = new ArrayList<>();
        MyLinkedList<SearchResult>.Node ptr = listOfSortableEntries.setobj.head;
        while (ptr!=null) {            
            al.add(ptr.data);
            ptr = ptr.next;
        }
        
        //selection sort
        int max,i,j;
        SearchResult tmp;
        for(i = 0;i<al.size();i++){
            max = i;
            for(j = i+1;j<al.size();j++){
                if(al.get(max).compareTo(al.get(j))<0)
                    max = j;
            }
            tmp = al.get(i);
            al.set(i,al.get(max));
            al.set(max,tmp);
        }
        
        return al;
    }
}
