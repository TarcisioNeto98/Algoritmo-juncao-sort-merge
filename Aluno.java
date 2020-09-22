public class Aluno{
    private String nomeAluno;
    private int id;

    public Aluno(String nomeAluno, int id){
        this.nomeAluno = nomeAluno;
        this.id = id;
    }

    public String getNomeAluno(){
        return this.nomeAluno;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return this.nomeAluno + "," + this.id;
    }
}