public class SearchResult implements Comparable<SearchResult> {
    PageEntry p;
    float r;
    
    public SearchResult(PageEntry p, float r){
        this.p = p;
        this.r = r;
    }
    public PageEntry getPageEntry(){
        return p;
    }
    public float getRelevance(){
        return r;
    }

    @Override
    public int compareTo(SearchResult otherObject) {
       if(this.r==otherObject.r)
           return 0;
       else if(this.r>otherObject.r)
           return 1;
       else
           return -1;
    }
    
}
