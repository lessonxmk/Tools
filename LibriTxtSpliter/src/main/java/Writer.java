import java.io.File;
import java.io.FileWriter;

public class  Writer {
    public static void TxtWriter(File Path,String Content,int count){
        if(count<0)
            return;
        try {
            String writePath=Path.getName().replaceAll(".txt","");
            String num=String.format("%04d",count);
            File target=new File(Path.getParent()+"/"+writePath+"-"+num+".txt");
            if(!target.exists()){
                target.createNewFile();
            }
            FileWriter fw=new FileWriter(target);
            fw.write(Content);
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
