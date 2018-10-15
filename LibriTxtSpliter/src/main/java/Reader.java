

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Reader {
    List fileList=new LinkedList();
    List flacList=new ArrayList<String>();
    List txtList=new ArrayList<String>();
    public void sourceReader(File Path) {
        File []fs=Path.listFiles();
        for(File f:fs){
            if(f.isDirectory()) {
                String []name= f.list(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        if(name.endsWith(".txt"))
                            return true;
                        else
                            return false;
                    }
                });
                for(String n:name){
                    fileList.add(new File(f.getAbsolutePath()+"/"+n));
                }
                sourceReader(f);

            }
            else{

            }

        }
    }

    public void txtReader(File Path){
        File []fs=Path.listFiles();
        for(File f:fs){
            if(f.isDirectory()) {
                String []name= f.list(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        if(name.endsWith(".txt")||name.endsWith(".flac"))
                            return true;
                        else
                            return false;
                    }
                });
                for(String n:name){
                    if(n.matches("\\d+-\\d+\\.trans-\\d+\\.txt")) {             //"nnnn-nnnn.trans-nnnn.txt"
                        txtList.add(f.getAbsolutePath() + "/" + n);
                    }
                    if(n.matches("\\d+-\\d+-\\d+\\.flac")){
                        flacList.add(f.getAbsolutePath() + "/" + n);
                    }
                }
                txtReader(f);
            }
            else{

            }

        }
    }


}
