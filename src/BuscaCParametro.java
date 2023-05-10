import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscaCParametro {
    RandomAccessFile test;
    String linha;
    String lista[] = new String[4];
    char procura[],achado[];    
    public BuscaCParametro(String banco,String busca,int tipo)
    {
        procura = new char[busca.length()];
        procura = busca.toCharArray();
        try {
            test = new RandomAccessFile(banco, "rw");
                      
            
                    linha=test.readLine();
                    while(linha!=null)
                    {                                              
                        lista = linha.split(":");
                        achado = new char[lista[tipo].length()];
                        achado = lista[tipo].toCharArray();
                        int j = 0;
                        for (int i = 0; i < achado.length; i++) {
                            
                            if(procura[j]==achado[i])
                            {
                                j++;
                            }
                            else
                            {
                                j=0;
                            }
                            if(j==(procura.length))
                            {
                                System.out.println(lista[0]+":"+lista[1]+":"+lista[2]+":"+lista[3]);                                
                                break;
                            }
                        }
                        linha=test.readLine();
                    }
              
        } catch (IOException ex) {
            Logger.getLogger(BuscaCParametro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
