public class WordEntry {
    String word;
    MySet<Position> posll;
    public WordEntry(String word) {
        this.word = word;
        posll = new MySet<Position>();
    }
    public void addPosition(Position position)
    {
        posll.addElement(position);
    }
    public void addPositions(MyLinkedList<Position> positions){
        MyLinkedList<Position>.Node ptr = positions.head;
        while(ptr!=null){
            posll.addElement(ptr.data);
            ptr = ptr.next;
        }
    }
    public MyLinkedList<Position> getAllPositionsForThisWord(){
        return posll.setobj;
    }
    public float getTermFrequency(String page){
        MyLinkedList<Position>.Node ptr = posll.setobj.head;
        int ctrw=0;
        PageEntry pe = null;
        while(ptr!=null){
            if(ptr.data.p.name.equals(page)){
                ctrw++;
                if(ctrw==1){
                    pe = ptr.data.p;
                }
            } 
            ptr = ptr.next;
        }
        if(ctrw==0||pe==null)
            return 0.0f;
        return (((float)ctrw)/((float)pe.getPageIndex().getWordEntries().getSize()));
    }
}
