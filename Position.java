public class Position{
    PageEntry p;
    int wi;

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
}
