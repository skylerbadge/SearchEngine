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
        
        String pagename,str;
        
        switch(action){
            case "addPage":
                pagename = sc.next();
                Scanner psc = new Scanner(new File("./webpages/"+pagename));
                psc.useDelimiter("@#$%=1");
                str = psc.next();
                str = str.toLowerCase();
                
        }
    }
    
}
