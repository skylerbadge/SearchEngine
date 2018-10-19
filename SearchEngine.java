import java.util.Scanner;
import java.io.*;
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
        //WordEntry we;
        HashWord hw;
        
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
            break;
            
            case "queryFindPagesWhichContainWord":
                wordname = sc.next();
                if(ipi.getPagesWhichContainWord(wordname)==null)//exception
                {
                    System.out.println("No webpage contains word "+wordname);
                    return;
                }
                MyLinkedList<PageEntry>.Node ptr = ipi.getPagesWhichContainWord(wordname).setobj.head;
                while (ptr!=null){
                    str = str+", "+ptr.data.name;
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
                hw = ipi.ht.getHashWord(wordname);
                if(hw==null)//exception
                {
                    System.out.println("Webpage "+pagename+" does not contain word "+wordname);
                    return;
                }
                MyLinkedList<Position>.Node ptr2 = hw.getAllPositionsForThisWord().head;
                while(ptr2!=null){
                    if(ptr2.data.p.equals(pe))
                        str = str+", "+ptr2.data.wi;
                    ptr2=ptr2.next;
                }
                if(str.equals(""))//exception
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
