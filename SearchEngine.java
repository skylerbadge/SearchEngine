import java.util.Scanner;
import java.io.*;
public class SearchEngine {
    InvertedPageIndex ipi;
    int numpages=0;
    
    public SearchEngine(){
        ipi = new InvertedPageIndex();
    }
    
    public String replaceSpecialCharacters(String str){
        
    }
    
    public void performAction(String actionMessage) throws FileNotFoundException{
        Scanner sc = new Scanner(actionMessage);
        String action = sc.next();
        String pagename,wordname,str="";
        
        switch(action){
            case "addPage":
                pagename = sc.next();
                PageEntry newpe = new PageEntry(pagename);
                newpe.setid(ipi.getPageId());
                ipi.setPageId(ipi.getPageId()+1);
                ipi.addPage(newpe);
            break;
            
            case "queryFindPagesWhichContainWord":
                wordname = sc.next();
                MyLinkedList<PageEntry>.Node ptr = ipi.getPagesWhichContainWord(wordname).setobj.head;
                while (ptr!=null){
                    str = ", "+ptr.data.name;
                }
                System.out.println(str.substring(2));
            break;
            
            case "queryFindPositionsOfWordInAPage":
                wordname = sc.next();
                pagename = sc.next();
        }
    }
    
}
