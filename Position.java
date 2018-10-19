public class Position implements Comparable<Position>{
    PageEntry p;
    int wi;
    int swi; // stored word index

    public Position(PageEntry p, int wordIndex){
        this.p = p;
        wi = wordIndex;
    }
    public PageEntry getPageEntry(){
        return p;
    }
    public int getWordIndex(){
        return wi;
    }
    
    @Override
    public int compareTo(Position obj)
    {
        return obj.swi - this.swi;
    }
}
