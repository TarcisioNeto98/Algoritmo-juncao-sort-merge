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
        List<String> auxiliar = new ArrayList(), resultado = new ArrayList();
        int aux, cont = 0;
        int qtdTurma = 0;
        aux = alunos[0].getId();
        for(Aluno aluno : alunos){
            if(cont == 0){
                auxiliar.add(aluno.toString());
                cont++;
            }
            else if(aux == aluno.getId()) auxiliar.add(aluno.toString());
            else{
                for(int i = qtdTurma; i < campus.length; i++){
                    if(campus[i].getIdCampus() == aux){
                        for(int j = 0; j < auxiliar.size(); j++)
                            resultado.add(auxiliar.get(j)+campus[i].toString());
                    }
                    if(campus[i].getIdCampus() > aux){
                        auxiliar = new ArrayList();
                        break;
                    }
                    qtdTurma++;
                }
                aux = aluno.getId();
                auxiliar.add(aluno.toString());
            }
        }
        for(int i = qtdTurma; i < campus.length; i++){
            if(campus[i].getIdCampus() == aux){
                for(int j = 0; j < auxiliar.size(); j++)
                    resultado.add(auxiliar.get(j)+campus[i].toString());
            }
            if(campus[i].getIdCampus() > aux){
                auxiliar = new ArrayList();
                break;
            }
            qtdTurma++;
        }
        return resultado;
    }

    public static void main(String [] args){
        List<String> tabelaAluno = null;
        List<String> tabelaCampus = null;
        try{
            tabelaAluno = Files.readAllLines(Paths.get("ALUNO.csv"));
            tabelaCampus = Files.readAllLines(Paths.get("CAMPUS.csv"));
            /*System.out.println(Paths.get("ALUNO.csv"));
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
        List<String> resultado = sort_merge(aluno, campus);
        for(int i = 0; i < resultado.size(); i++) System.out.println(resultado.get(i));

        try{
            Path path = Files.createFile(Paths.get("texto.csv"));
            System.out.println(Files.write(path, resultado));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}