import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Editor {
    public static ArrayList<String> TxtEditor(File Path){
        char [] fileName= Path.getName().toCharArray();
        String trainName="";
        char []buf=new char[102400];
        ArrayList fileContentSplit=new ArrayList<String>();
        for(int i=0;i<fileName.length-10;i++){
            trainName=trainName+fileName[i];
        }
        try {
            FileReader fr=new FileReader(Path);
            fr.read(buf);
            fr.close();
            String fileContent=new String(buf);
/*            int index=0;
            while ((index=fileContent.indexOf(trainName,index))>0){

            }*/
            String fcs[]= fileContent.split(trainName+"......");
            for(String s:fcs){
                fileContentSplit.add(s);
            }
            return fileContentSplit;
        }catch (Exception e){
             e.printStackTrace();
        }
        return fileContentSplit;
    }
}
