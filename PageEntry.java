import java.util.Scanner;
import java.io.*;
public class PageEntry {
    String name;
    PageIndex pi;
    int id=0;
    
    public PageEntry(String pageName) throws FileNotFoundException{
        name = pageName;
        pi = new PageIndex();
        Scanner psc = new Scanner(new File("./webpages/"+pageName));
        String strn="",w="",str;
        char ch;
        int i,wi=1,swi=1;
        while(psc.hasNextLine()){
            str = psc.nextLine()+" ";
            str = str.toLowerCase();
            w="";                    
            for (i=0; i < str.length(); i++){
                ch = str.charAt(i);
                if (ch=='{'||ch=='}'||ch=='['||ch==']'||ch=='<'||ch=='>'||ch=='='||ch=='('||ch==')'||ch=='.'||ch==','||ch==';'||ch=='\''||ch=='"'||ch=='?'||ch=='#'||ch=='!'||ch=='-'||ch==':')
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
                    Position p = new Position(this,wi,swi);
                    pi.addPositionForWord(w,p);
                    swi++;
                    wi++;
                strn+=w;
                    w="";
                }
                else{
                    w = w+ch;
                }           
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
    public float getRelevanceOfPage(String str[], Boolean doTheseWordsRepresentAPhrase, InvertedPageIndex ipi){
        float tf,idf,m,rel = 0;
        if(doTheseWordsRepresentAPhrase){
            m=pi.numPhrase(str);
            rel = (float) ((m/(pi.getWordEntries().numNodes-((str.length-1)*m)))*Math.log10(ipi.numPages/ipi.getPagesWhichContainPhrase(str).setobj.getSize()));
        }
        else{
            for(int i = 0 ; i<str.length ; i++){
                tf = getPageIndex().getWordEntry(str[i]).getTermFrequency(str[i]);
                if(ipi.getPagesWhichContainWord(str[i])==null)
                    idf = 0;
                else
                    idf = (float) Math.log10(ipi.numPages/ipi.getPagesWhichContainWord(str[i]).setobj.getSize());
                rel = rel + tf*idf;
            }
        }
        return rel;
    }
}
