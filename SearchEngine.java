import java.util.Scanner;
import java.io.*;
public class SearchEngine {
    InvertedPageIndex ipi;
    int numpages=0;
    
    public SearchEngine(){
        ipi = new InvertedPageIndex();
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
                if(ipi.getPagesWhichContainWord(str)==null)//e
                {
                    System.err.println("No webpage contains word "+wordname);
                    return;
                }
                MyLinkedList<PageEntry>.Node ptr = ipi.getPagesWhichContainWord(wordname).setobj.head;
                while (ptr!=null){
                    str = ", "+ptr.data.name;
                }
                System.out.println(actionMessage+": "+str.substring(2));
            break;
            
            case "queryFindPositionsOfWordInAPage":
                wordname = sc.next();
                pagename = sc.next();
                PageEntry pe = ipi.getPageEntry(pagename);
                WordEntry we = ipi.ht.getWordEntry(wordname);
                MyLinkedList<Position>.Node ptr2 = we.getAllPositionsForThisWord().head;
                while(ptr2!=null){
                    if(ptr2.data.p.equals(pe))
                        str = ", "+ptr2.data.wi;
                }
                if(str.equals(""))
                    ;//throw
                else
                    System.out.println(actionMessage+": "+str);
            break;
            default:
                System.out.println("Incorrect Query");
        }
    }
    
}
