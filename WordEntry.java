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
    public float getTermFrequency(String word){
        word = word.toLowerCase();
        MyLinkedList<Position>.Node ptr = posavl.returnLL().head;
        PageEntry pe = ptr.data.p;
        int ctrw = pe.pi.getWordEntry(word).posavl.numNodes;
        if(ctrw==0)
            return 0.0f;
//        System.out.println(" IN TF "+word+" N = "+ctrw + "  totw  "+pe.totw);
        return (((float)ctrw)/((float)pe.totw));
    }
}
