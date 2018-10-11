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
        //System.out.println(p.name+"  hahahahah");
        pes.addElement(p);
        MyLinkedList<WordEntry> wll = p.getPageIndex().getWordEntries();
        //System.out.println(wll.numNodes+"  haello  ");        
        MyLinkedList<WordEntry>.Node ptr = wll.head;
        while(ptr!=null){
            ht.addPositionsForWord(ptr.data);
            //System.out.print(ptr.data.word+" ");
            ptr = ptr.next;
        }
    }
    
    public MySet<PageEntry> getPagesWhichContainWord(String str){
        str = str.toLowerCase();
        WordEntry w = ht.getWordEntry(str);
        //System.out.println("rere "+w);
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
        }
        if(ptr==null)
            return null;
        return ptr.data;
    }
}
