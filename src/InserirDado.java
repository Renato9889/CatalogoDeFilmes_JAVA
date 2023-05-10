import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InserirDado {
    FileWriter escrever;    
    RandomAccessFile test;
    String lista[] = new String[4];
    String lista2[] = new String[4];
    String linhaBranca = " ";
    
    public InserirDado(String banco, String nome,String genero,String studio,String ano)
    {
        String registro,linha;
        System.out.println(banco);
        try {
            test = new RandomAccessFile(banco, "rw");
            registro=nome+":"+genero+":"+studio+":"+ano+":";
            while(registro.length()<165)
            {
                registro=registro+" ";
            }
                        
            
            lista2 = registro.split(":");
            
            linha = test.readLine();
            
            while(linha!=null)
            {
                lista = linha.split(":");
                if(lista[0].compareTo(lista2[0])==0)
                {
                    return;
                }                
                linha = test.readLine();
            }
            
            while(linhaBranca.length()<165)
            {
                linhaBranca=linhaBranca+" ";
            }
                 
            test.seek(0);
            
            linha = test.readLine();
            
            while(linha!=null)
            {
                if(linha.compareTo(linhaBranca)==0)
                {
                    test.seek(test.getFilePointer()-167);
                    test.writeBytes(registro);
                    test.writeBytes("\r\n");
                    test.close();                     
                    return;
                }
                linha = test.readLine();
            }
            
            test.writeBytes(registro);
            test.writeBytes("\r\n");
            test.close();            
            
        } catch (IOException ex) {
            Logger.getLogger(InserirDado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}