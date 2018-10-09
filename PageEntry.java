public class PageEntry {
    String name;
    PageIndex pi;
    
    public PageEntry(String pageName){
        name = pageName;
        pi = new PageIndex();
    }
    public PageIndex getPageIndex(){
        return pi;
    }
}
