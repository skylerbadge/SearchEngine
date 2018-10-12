import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SearchEngine {
    InvertedPageIndex ipi;
    int numpages=0;
    
    public SearchEngine(){
        ipi = new InvertedPageIndex();
    }    
    
    public void performAction(String actionMessage){
        Scanner sc = new Scanner(actionMessage);
        String action = sc.next();
        String pagename,wordname,str="";
        WordEntry we;
        
        switch(action){
            case "addPage":
                pagename = sc.next();
                PageEntry newpe;
                try {
                    newpe = new PageEntry(pagename);
                    newpe.setid(ipi.getPageId());
                    ipi.setPageId(ipi.getPageId()+1);
                    ipi.addPage(newpe);
                } catch (FileNotFoundException ex) {
                    System.out.println("No webpage with the name "+pagename+" exists");
                }
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
                //System.out.println(ipi.getPagesWhichContainWord(wordname).setobj.numNodes);
                we = ipi.ht.getWordEntry(wordname);
                while (ptr!=null){
                    str = str+", "+ptr.data.name;
                    System.out.println(we.getTermFrequency(ptr.data.name));
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
                we = ipi.ht.getWordEntry(wordname);
                if(we==null)//e
                {
                    System.out.println("Webpage "+pagename+" does not contain word "+wordname);
                    return;
                }
                MyLinkedList<Position>.Node ptr2 = we.getAllPositionsForThisWord().head;
                while(ptr2!=null){
                    if(ptr2.data.p.equals(pe))
                        str = str+", "+ptr2.data.wi;
                    ptr2=ptr2.next;
                }
                if(str.equals(""))//e
                {
                    System.out.println("Webpage "+pagename+" does not contain word "+wordname);
                    return;
                }                    
                else
                    System.out.println(wordname+" : "+str.substring(2));
            break;
            default:
                System.out.println("Incorrect Query");
        }
    }
    
}
