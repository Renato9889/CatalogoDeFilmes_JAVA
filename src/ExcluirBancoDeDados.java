import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.sound.midi.Soundbank;

public class ExcluirBancoDeDados {
    
    RandomAccessFile test;
    File arquivo;    
    ArrayList<String> lista;
    public ExcluirBancoDeDados(String banco)
    {            
        String linha;        
        String registro = " ";   
        arquivo = new File(banco);
        arquivo.delete();        
        try {            
            test = new RandomAccessFile("Registro.txt","rw");            
            
            while(banco.length()<40)
            {            
                banco= banco+" ";
            }
            
            do
            {
                linha = test.readLine();                                
                
            }while(banco.compareTo(linha)!=0);                                    
                        
            while (registro.length()<40)
            {                
                registro=registro+" ";
            }
            test.seek(test.getFilePointer()-42);
            test.writeBytes(registro);
            test.writeBytes("\r\n");
            test.close();                        
            
//            try {
//            	 
//            	test = new RandomAccessFile("Registro.txt", "rw");            	            	
//                
//            	System.out.println(test.getFilePointer());            	
//                
//            	linha = test.readLine();                                  
//                
//            	int t=0;
//            	            	
//                while(linha!=null)
//                {                	
//                	if(linha.compareTo(registro)==0)
//                	{
//                		t++;
//                	}
//                	linha = test.readLine();
//                }
//                if(t!=0)
//                {
//                	FileWriter a = new FileWriter("Registro.txt");
//                			a.flush();
//                			a.close();
//                }
//                
//			} catch (IOException e) {
//				// TODO: handle exception
//			}                                    
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ExcluirBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
