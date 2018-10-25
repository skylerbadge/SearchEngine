import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class SearchEngine {
    InvertedPageIndex ipi;
    int numpages=0;
    
    public SearchEngine(){
        ipi = new InvertedPageIndex();
    }    
    
    public void checkPlural(String str[]){
        for(int i = 0; i<str.length; i++){
            if(str[i].equals("stacks"))
                str[i]="stack";
            else if(str[i].equals("structures"))
                str[i]="structure";
            else if(str[i].equals("applications"))
                str[i]="application";
        }
    }
    public String checkPlural(String w){
         if(w.equals("stacks"))
            w="stack";
        else if(w.equals("structures"))
            w="structure";
        else if(w.equals("applications"))
            w="application";
        return w;
    }
    public void performAction(String actionMessage){
        Scanner sc = new Scanner(actionMessage);
        String action = sc.next();
        String pagename,wordname,str="",str1="", stra[];
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
                wordname = checkPlural(wordname);
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
                wordname = checkPlural(wordname);
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
            case "queryFindPagesWhichContainAllWords":
                str = sc.nextLine().substring(1);
                str = str.toLowerCase();
                stra = str.split(" ",0);
                checkPlural(stra);
//                for (int i = 0; i < stra.length; i++) {
//                    System.out.println(stra[i]);
//                }
                MySet<PageEntry> pagesall = ipi.pagesAllWord(stra);
                if(pagesall==null||pagesall.isEmpty()){
                    System.out.println("No pages contain all of these words");
                    return;
                }
                MySet<SearchResult> tosortall = new MySet<>();
                MyLinkedList<PageEntry>.Node ptr1 = pagesall.setobj.head;
                while(ptr1!=null){
                    tosortall.addElement(new SearchResult(ptr1.data,ptr1.data.getRelevanceOfPage(stra, false, ipi)));
                    ptr1 = ptr1.next;
                }
                ArrayList<SearchResult> alsrall = MySort.sortThisList(tosortall);
                for (int i = 0; i < alsrall.size(); i++) {
                    str1 = str1+", "+alsrall.get(i).p.name;
                }
                str1 = str1.substring(2);
                System.out.println(str1);
            break;
            case "queryFindPagesWhichContainAnyOfTheseWords":
                str = sc.nextLine().substring(1);
                str = str.toLowerCase();
                stra = str.split(" ",0);
                checkPlural(stra);
                MySet<PageEntry> pagesany = ipi.pagesAnyWord(stra);
                if(pagesany==null||pagesany.isEmpty()){
                    System.out.println("No pages contain any of these words");
                    return;
                }
                MySet<SearchResult> tosortany = new MySet<>();
                MyLinkedList<PageEntry>.Node ptr3 = pagesany.setobj.head;
                while(ptr3!=null){
                    tosortany.addElement(new SearchResult(ptr3.data,ptr3.data.getRelevanceOfPage(stra, false, ipi)));
                    ptr3 = ptr3.next;
                }
                ArrayList<SearchResult> alsrany = MySort.sortThisList(tosortany);
                for (int i = 0; i < alsrany.size(); i++) {
                    str1 = str1+", "+alsrany.get(i).p.name;
                }
                str1 = str1.substring(2);
                System.out.println(str1);
            break;
            case "queryFindPagesWhichContainPhrase":
                str = sc.nextLine().substring(1);
                str = str.toLowerCase();
                stra = str.split(" ",0);
                checkPlural(stra);
                MySet<PageEntry> pagesphrase = ipi.getPagesWhichContainPhrase(stra);
//                System.out.println("here");
                if(pagesphrase==null||pagesphrase.isEmpty()){
                    System.out.println("No pages contain this phrase");
                    return;
                }
                MySet<SearchResult> tosortphrase = new MySet<>();
                MyLinkedList<PageEntry>.Node ptr4 = pagesphrase.setobj.head;
                while(ptr4!=null){
                    tosortphrase.addElement(new SearchResult(ptr4.data,ptr4.data.getRelevanceOfPage(stra, true, ipi)));
                    ptr4 = ptr4.next;
                }
                ArrayList<SearchResult> alsr = MySort.sortThisList(tosortphrase);
                for (int i = 0; i < alsr.size(); i++) {
                    str1 = str1+", "+alsr.get(i).p.name;
                }
                str1 = str1.substring(2);
                System.out.println(str1);
            break;
            default:
                System.out.println("Incorrect Query");
        }
    }
    
}
