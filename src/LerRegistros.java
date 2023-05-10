import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LerRegistros {
    RandomAccessFile test;
    String linha;
    String lista[] = new String[4];
    ArrayList<String> dados = new ArrayList<String>();
    char inf[];
    public LerRegistros()
    {
        try {
            
            test = new RandomAccessFile("Registro", "rw");
                        
            linha = test.readLine();            
            
            while(linha!=null)
            {            	            	                       
                inf = new char[linha.length()];
                inf = linha.toCharArray();                               
                linha = "";
                
                for (int i = 0; i < 40; i++) 
                {
					  if(inf[i]==' ')
					  {
						  if((i+1)<40)
						  {
							  if(inf[(i+1)]==' ')
							  {
								  break;
							  }
							  else
							  {
								  linha=linha+inf[i];
							  }
						  }
						  else
						  {
							  break;
						  }
					  }
					  else
					  {
						  linha=linha+inf[i];
					  }
				}
                
              
                linha = test.readLine();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(LerRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}