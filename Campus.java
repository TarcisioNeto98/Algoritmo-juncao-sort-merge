public class Campus{
    private String nomeCampus;
    private int idCampus;

    public Campus(String nomeCampus, int idCampus){
        this.nomeCampus = nomeCampus;
        this.idCampus = idCampus;
    }

    public String getNomeCampus(){
        return this.nomeCampus;
    }

    public int getIdCampus(){
        return this.idCampus;
    }

    @Override
    public String toString(){
        return this.nomeCampus + "," + this.idCampus;
    }
}