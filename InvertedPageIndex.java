public class InvertedPageIndex {
    
    MyHashTable ht;
    int pageid;
    MySet<PageEntry> pes;
    public InvertedPageIndex(){
        ht = new MyHashTable();
        pageid = 1;
        pes = new MySet<PageEntry>();
    }
    public void addPage(PageEntry p){
        pes.addElement(p);
        MyLinkedList<WordEntry> wll = p.getPageIndex().getWordEntries();
        MyLinkedList<WordEntry>.Node ptr = wll.head;
        while(ptr!=null){
            ht.addPositionsForWord(ptr.data);
            ptr = ptr.next;
        }
    }
    
    public MySet<PageEntry> getPagesWhichContainWord(String str){
        str = str.toLowerCase();
        HashWord hw = ht.getHashWord(str);
        if(hw==null)
            return null;
        MyLinkedList<Position>.Node ptr = hw.posll.setobj.head;
        MySet<PageEntry> newpes = new MySet<>();
        while(ptr!=null){
            newpes.addElement(ptr.data.getPageEntry());
            ptr=ptr.next;
        }
        return newpes;
    }
    
    public int getPageId(){
        return pageid;
    }
    public void setPageId(int n){
        pageid = n;
    }
    public PageEntry getPageEntry(String str){
        MyLinkedList<PageEntry>.Node ptr = pes.setobj.head;
        while(ptr!=null){
            if(ptr.data.name.equals(str))
                break;
            ptr=ptr.next;
        }
        if(ptr==null)
            return null;
        return ptr.data;
    }
}
