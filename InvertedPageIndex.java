public class InvertedPageIndex {
    
    MyHashTable ht;
    
    public InvertedPageIndex(){
        ht = new MyHashTable();
    }
    public void addPage(PageEntry p){
        MyLinkedList<WordEntry> wll = p.getPageIndex().getWordEntries();
        MyLinkedList<WordEntry>.Node ptr = wll.head;
        while(ptr!=null){
            ht.addPositionsForWord(ptr.data);
            ptr = ptr.next;
        }
    }
    
    public MySet<PageEntry> getPagesWhichContainWord(String str){
        WordEntry w = ht.getWordEntry(str);
        if(w==null)
            return null;
        MyLinkedList<Position>.Node ptr = w.posll.setobj.head;
        MySet<PageEntry> pes = new MySet<>();
        while(ptr!=null){
            pes.addElement(ptr.data.getPageEntry());
            ptr=ptr.next;
        }
        return pes;
    }
}
