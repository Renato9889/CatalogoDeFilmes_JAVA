
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlteracaoDeDado {
    RandomAccessFile test;
    String linha,registroNovo;
    String lista[] = new String[4];        
    char auxilio[];

    public AlteracaoDeDado(String banco, String nome,String titulo, String genero, String estudio, String ano)
    {
        try {
            
        	
        	test = new RandomAccessFile(banco, "rw");
            
            registroNovo=titulo+":"+genero+":"+estudio+":"+ano+":";
            
            while(registroNovo.length()<165)
            {
            	registroNovo=registroNovo+" ";
            }
            	
            
            do
            {
                linha = test.readLine();
                lista = linha.split(":");
                if(lista[0].compareTo(nome)==0)
                {
                    break;
                }
                
            }while(linha!=null);            
            test.seek(test.getFilePointer()-167);
            test.writeBytes(registroNovo);
            test.writeBytes("\r\n");
            test.close();
        } catch (IOException ex) {
            Logger.getLogger(AlteracaoDeDado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
