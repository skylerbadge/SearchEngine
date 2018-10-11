public class MyHashTable {
    int num;
    int size = 100;
   
    MySet<WordEntry>[] harray;
    public MyHashTable(){
        num = 0;
        harray = new MySet[size];
    }
    
    private int getHashIndex(String str){
        char ch[];
        ch = str.toCharArray();
        int i, sum=0;
        for (i=0; i < str.length(); i++)
            sum += ch[i];
        return sum%size;
    }
    public void addPositionsForWord(WordEntry w){
        int ind = getHashIndex(w.word);
        if(harray[ind]==null){
            harray[ind] = new MySet<WordEntry>();
            harray[ind].addElement(w);
            num++;
        }
        else{
            MyLinkedList<WordEntry>.Node ptr = harray[ind].setobj.head;
            while(ptr!=null){
                if(ptr.data.word.equals(w.word))
                    break;
                ptr=ptr.next;
            }
            if(ptr==null){
                harray[ind].addElement(w);
            }
            else
                ptr.data.addPositions(w.getAllPositionsForThisWord());
        }
    }
    public WordEntry getWordEntry(String str){
        int ind = getHashIndex(str);
        if(harray[ind]==null){
            return null;
        }
        MyLinkedList<WordEntry>.Node ptr = harray[ind].setobj.head;
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
    
}
