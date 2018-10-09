public class PageIndex {
    MySet<WordEntry> wes;
    public PageIndex(){
        wes = new MySet<WordEntry>();
    }
    public void addPositionForWord(String str, Position p){
        MyLinkedList<WordEntry>.Node ptr = wes.setobj.head;
        while(ptr!=null){
            if(ptr.data.word.equals(str))
                break;
            ptr = ptr.next;
        }
        if (ptr == null){
            WordEntry newwe = new WordEntry(str);
            newwe.addPosition(p);
            wes.addElement(newwe);
        }
        else{
            ptr.data.addPosition(p);
        }
    }
    public MyLinkedList<WordEntry> getWordEntries(){
        return wes.setobj;
    }
}
