import java.util.Scanner;
import java.io.*;
public class PageEntry {
    String name;
    PageIndex pi;
    int id=0;
    
    public PageEntry(String pageName){
        name = pageName;
        pi = new PageIndex();
        Scanner psc = new Scanner(new File("./webpages/"+pagename));
        psc.useDelimiter("YFYF");
        String strn="",str = psc.next(),w="";
        str = str.toLowerCase();
        char ch;
        int i,wi=1;
        for (i=0; i < str.length(); i++){
            ch = str.charAt(i);
            if (ch=='{'||ch=='}'||ch=='['||ch==']'||ch=='<'||ch=='>'||ch=='='||ch=='('||ch==')'||ch=='.'||ch==','||ch==';'||ch=='’'||ch=='”'||ch=='?'||ch=='#'||ch=='!'||ch=='-'||ch==':')
            {
                ch = ' ';
                strn=strn+ch;
            }
            if(ch == ' '){
                if(w.equals(""))
                    continue;
                if(w.equals("a")||w.equals("an")||w.equals("the")||w.equals("they")||w.equals("these")||w.equals("this")||w.equals("for")||w.equals("is")||w.equals("are")||w.equals("was")||w.equals("of")||w.equals("or")||w.equals("and")||w.equals("does")||w.equals("will")||w.equals("whose"))
                {
                    strn+=w;
                    w="";
                    wi++;
                    continue;
                }
                if(w.equals("stacks"))
                    w="stack";
                else if(w.equals("structures"))
                    w="structure";
                else if(w.equals("applications"))
                    w="application";
                Position p = new Position(this,wi);
                pi.addPositionForWord(w,p);
                wi++;
                strn+=w;
                w="";
            }
            else{
                w = w+ch;
            }
            
        }
        
    }
    public PageIndex getPageIndex(){
        return pi;
    }
    public int getid(){
        return id;
    }
    public void setid(int n){
        id = n;
    }
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(new File("./webpages/stacklighting"));
        sc.useDelimiter("$#@");
        String fl = sc.next();
        System.out.println(fl.toLowerCase());
        } catch(Exception e){}
    }
}
