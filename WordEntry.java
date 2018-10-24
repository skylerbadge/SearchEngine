public class WordEntry {
    String word;
    MyAVL<Position> posavl;
    public WordEntry(String word) {
        this.word = word;
        posavl = new MyAVL<Position>();
    }
    public void addPosition(Position position)
    {
        posavl.insert(position);
    }
    public void addPositions(MyLinkedList<Position> positions){
        MyLinkedList<Position>.Node ptr = positions.head;
        while(ptr!=null){
            posavl.insert(ptr.data);
            ptr = ptr.next;
        }
    }
    public MyLinkedList<Position> getAllPositionsForThisWord(){
        return posavl.returnLL();
    }
    public float getTermFrequency(String page){
        MyLinkedList<Position>.Node ptr = posavl.returnLL().head;
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
