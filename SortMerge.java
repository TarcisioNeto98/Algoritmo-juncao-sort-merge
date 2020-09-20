import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class SortMerge{
    public static void main(String [] args){
        try{
            List<String> tabelaAluno = Files.readAllLines(Paths.get("ALUNO.csv"));
            System.out.println(Paths.get("ALUNO.csv"));
            Path path = Files.createFile(Paths.get("texto.txt"));
            System.out.println(Files.write(path, tabelaAluno.get(1).getBytes()));
            System.out.println(tabelaAluno.get(1).getBytes());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}