import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscaSParametro {
    RandomAccessFile test;
    String linha;
    String lista[] = new String[4];
    char procura[],achado[];
    public BuscaSParametro(String banco, String nome)
    {
    	int achado=0;
        procura = new char[nome.length()];
        procura = nome.toCharArray();
        try {
            
            test = new RandomAccessFile(banco, "rw");
                        
            linha = test.readLine();
            
            while(linha!=null)
            {
                
                lista = linha.split(":");
                if(nome.compareTo(lista[0])==0)
                {
                	achado=1;
                	break;
                }
                linha = test.readLine();
            }
                        
        } catch (IOException ex) {
            Logger.getLogger(BuscaSParametro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
