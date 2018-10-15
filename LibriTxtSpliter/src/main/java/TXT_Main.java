import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TXT_Main {
    public static void TXT_Main(String args) {
        File path=new File(args);
        Reader r=new Reader();
        r.sourceReader(path);
        Iterator iterator=r.fileList.iterator();
        while(iterator.hasNext()){
            path=new File(iterator.next().toString());
            ArrayList<String> fileContentSplit= Editor.TxtEditor(path);
            Iterator iterator1 =fileContentSplit.iterator();
            int count=0;
            while (iterator1.hasNext()){
                Writer.TxtWriter(path,fileContentSplit.get(count),count-1);
                count++;
                iterator1.next();
            }
        }
    }
}
