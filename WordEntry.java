public class WordEntry {
    String word;
    MySet<Position> posll;
    public WordEntry(String word) {
        this.word = word;
        posll = new MySet<Position>();
    }
    public void addPosition(Position position) throws Exception{
        posll.addElement(position);
    }
    public void addPositions(MyLinkedList<Position> positions){
        //fill
    }
    public MyLinkedList<Position> getAllPositionsForThisWord(){
        return posll.setobj;
    }
    //tf
}
