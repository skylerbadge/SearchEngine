public class PageIndex {
    MySet<WordEntry> wes;
    public PageIndex(){
        wes = new MySet<WordEntry>();
    }
    public void addPositionForWord(String str, Position p){
        str = str.toLowerCase();
        MyLinkedList<WordEntry>.Node ptr = wes.setobj.head;
        while(ptr!=null){
            if(ptr.data.word.equals(str))
                break;
            ptr = ptr.next;
        }
        if (ptr == null){
            WordEntry newwe = new WordEntry(str);
            newwe.addPosition(p);
            wes.addElement(newwe);
        }
        else{
            ptr.data.addPosition(p);
        }
    }
    public MyLinkedList<WordEntry> getWordEntries(){
        return wes.setobj;
    }
    
    public WordEntry getWordEntry(String str){
        str = str.toLowerCase();
        MyLinkedList<WordEntry>.Node ptr = getWordEntries().head;
        while(ptr!=null){
            if(ptr.data.word.equals(str))
                break;
            ptr=ptr.next;
        }
        if(ptr==null){
            return null;
        }
        else
            return ptr.data;
    }    
     //contains all words
    public int numPhrase(String str[]){
        int ctr = 0;
        MyLinkedList<Position>.Node ptr = getWordEntry(str[0]).posavl.returnLL().head;
        MyLinkedList<Position>.Node check;
        int wordindex,i;
        while(ptr!=null){
            wordindex = ptr.data.swi;
            for(i = 1; i<str.length; i++){
                check = getWordEntry(str[i]).getAllPositionsForThisWord().head;
                while (check!=null) {                    
                    if(check.data.swi==(wordindex+i))
                        break;
                    check = check.next;
                }
                if(check==null){
                    break;
                }
            }
            if(i==str.length)
                ctr++;
            ptr = ptr.next;
        }
        return ctr;
    }
}
