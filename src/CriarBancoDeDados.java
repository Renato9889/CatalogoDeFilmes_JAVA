import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriarBancoDeDados {
    File arqivo;
    FileWriter escrever;
    BufferedWriter escreverBF;
    FileReader ler;
    FileReader lerRegistro;
    BufferedReader lerBF;
    String registro,linha,testeLinha;
    RandomAccessFile test;
    public CriarBancoDeDados(String nome)
    {               
        try {
            lerRegistro = new FileReader("Registro.txt");
            lerRegistro.close();
        } catch (IOException ex) {
            try {
                escrever = new FileWriter("Registro.txt");
                escrever.close();
            } catch (IOException ex1) {                
            }
        }        
        
        try {            
            escrever = new FileWriter(nome+".txt");
            escrever.close();
            test = new RandomAccessFile("Registro.txt", "rw");
            registro = nome+".txt";
            
            while(registro.length()<40)
            {
                registro=registro+" ";
            }
            
            testeLinha=" ";
            
            while(testeLinha.length()<40)
            {
                testeLinha=testeLinha+" ";
            }
            
            linha = test.readLine();
            
            while(linha!=null)
            {                                
                if(registro.compareTo(linha)==0)
                {
                    System.out.println("já existe.");
                    return;
                }                
                linha = test.readLine();
            }
            
            test.seek(0);
            
            linha = test.readLine();
            
            while(linha!=null)
            {                                
                if(linha.compareTo(testeLinha)==0)
                {
                    
                    System.out.println(test.getFilePointer());
                    test.seek(test.getFilePointer()-42);
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
        }
        
    }
}
