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
                //System.out.println(ipi.ht.num);
                //System.out.println(newpe.pi.wes.setobj.numNodes);                
            break;
            
            case "queryFindPagesWhichContainWord":
                wordname = sc.next();
                if(ipi.getPagesWhichContainWord(wordname)==null)//e
                {
                    System.out.println("No webpage contains word "+wordname);
                    return;
                }
                MyLinkedList<PageEntry>.Node ptr = ipi.getPagesWhichContainWord(wordname).setobj.head;
                while (ptr!=null){
                    str = ", "+ptr.data.name;
                    ptr = ptr.next;
                }
                System.out.println(str.substring(2));
            break;
            
            case "queryFindPositionsOfWordInAPage":
                wordname = sc.next();
                pagename = sc.next();
                PageEntry pe = ipi.getPageEntry(pagename);
                if(pe==null)//e
                {
                    System.out.println("No webpage "+pagename+" found");
                    return;
                }
                WordEntry we = ipi.ht.getWordEntry(wordname);
                if(we==null)//e
                {
                    System.out.println("Webpage "+pagename+" does not contain word "+wordname);
                    return;
                }
                System.out.println(we);
                MyLinkedList<Position>.Node ptr2 = we.getAllPositionsForThisWord().head;
                while(ptr2!=null){
                    if(ptr2.data.p.equals(pe))
                        str = ", "+ptr2.data.wi;
                }
                if(str.equals(""))//e
                {
                    System.out.println("Webpage "+pagename+" does not contain word "+wordname);
                    return;
                }                    
                else
                    System.out.println(str);
            break;
            default:
                System.out.println("Incorrect Query");
        }
    }
    
}
