import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class SortMerge{

    public static List<String> ordenar(List<String> lista){
        List<String> ordenado = new ArrayList();
        int cont = 0;
        lista.remove(0);
        int []valores = new int[lista.size()];
        for(int i = 0; i < lista.size(); i++) valores[i] = Integer.parseInt(lista.get(i).substring(lista.get(i).length() - 1, lista.get(i).length()));
        Arrays.sort(valores);
        for(int valor : valores){
            for(int i = 0; i < lista.size(); i++){
                int tamanho = lista.get(i).length();
                if(valor == Integer.parseInt(lista.get(i).substring(tamanho - 1, tamanho))){
                    ordenado.add(lista.get(i));
                    lista.remove(i);
                    break;
                }
            }
        }
        return ordenado;
    }

    public static List<String> sort_merge(Aluno[] alunos, Campus[] campus){
        List<String> auxiliar = new ArrayList();
        return auxiliar;
    }

    public static void main(String [] args){
        List<String> tabelaAluno = null;
        List<String> tabelaCampus = null;
        try{
            tabelaAluno = Files.readAllLines(Paths.get("ALUNO.csv"));
            tabelaCampus = Files.readAllLines(Paths.get("CAMPUS.csv"));
            /*System.out.println(Paths.get("ALUNO.csv"));
            Path path = Files.createFile(Paths.get("texto.txt"));
            System.out.println(Files.write(path, tabelaAluno.get(1).getBytes()));
            System.out.println(tabelaAluno.get(1).getBytes());*/
        }
        catch(IOException e){
            e.printStackTrace();
        }
        tabelaAluno = ordenar(tabelaAluno);
        tabelaCampus = ordenar(tabelaCampus);
        Aluno[] aluno = new Aluno[tabelaAluno.size()];
        Campus[] campus = new Campus[tabelaCampus.size()];
        System.out.println(tabelaAluno.size() + " " + tabelaCampus.size());
        for(int i = 0; i < tabelaAluno.size(); i++) {
            String[] auxiliar1 = tabelaAluno.get(i).split(",");
            aluno[i] = new Aluno(auxiliar1[0], Integer.parseInt(auxiliar1[1]));
        }

        for(int i = 0; i < tabelaCampus.size(); i++) {
            String[] auxiliar2 = tabelaCampus.get(i).split(",");
            campus[i] = new Campus(auxiliar2[0], Integer.parseInt(auxiliar2[1]));
        }
}