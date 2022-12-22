package testing;

import java.io.File;
import programerdaritimurkebarat.Data;
import programerdaritimurkebarat.Matakuliah;
public class Test001 {
    public static void main(String[] args) {
        File f = new File("datamu.csv");
        Data d = new Data().read(f);
        
        System.out.println(d);
        
        ///d.delete(1);
        
        Matakuliah matakuliah = new Matakuliah("INF32145", "Pemrograman Padli", "C",2);
        d.update(3,matakuliah);
        
        File fOut = new File("datakita.csv");
        d.save(fOut);
        
    }
}
