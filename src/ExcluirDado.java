import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcluirDado {
    
    String linha;        
    String registro = " ";
    RandomAccessFile test;
    File arqivo;     
    
    
    public ExcluirDado(String banco, String info)
    {
        String lista[]=new String[4];
        try {
            test = new RandomAccessFile(banco, "rw");
            
            while(registro.length()<165)
            {
                registro=registro+" ";
            }
            
            do
            {                
                linha=test.readLine();
                lista = linha.split(":");                
            }while(lista[0].compareTo(info)!=0);
            
            test.seek(test.getFilePointer()-167);
            test.writeBytes(registro);
            test.writeBytes("\r\n");
            test.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcluirDado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
