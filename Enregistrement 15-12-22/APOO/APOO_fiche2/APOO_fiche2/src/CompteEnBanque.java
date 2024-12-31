public class CompteEnBanque {


    private Personne titulaire;
    private Date dateDeValidationID;
    private String numero;
    private Date dateDOuverture;
    private double solde;

    public CompteEnBanque(Personne titulaire, Date dateDeValidationID, String numero, Date dateDOuverture, double solde) {
        this.titulaire = titulaire;
        this.dateDeValidationID = dateDeValidationID;
        this.numero = numero;
        this.dateDOuverture = dateDOuverture;
        this.solde = solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public Date getDateDeValidationID() {
        return dateDeValidationID;
    }

    public String getNumero() {
        return numero;
    }

    public Date getDateDOuverture() {
        return dateDOuverture;
    }

    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return "CompteEnBanque{" +
                "titulaire=" + titulaire +
                ", dateDeValidationID=" + dateDeValidationID +
                ", numero='" + numero + '\'' +
                ", dateDOuverture=" + dateDOuverture +
                ", solde=" + solde +
                '}';
    }

    public boolean retirer(double montant){
        if (montant>solde || montant<=0)
            return false;
        solde = solde - montant;
        return true;
    }

    public boolean deposer(double montant){
        if (montant<=0)
            return false;
        solde = solde + montant;
        return true;
    }

    public boolean faireUnVirement(double montant, CompteEnBanque compteDestinataire){
        if (montant>solde || montant<= 0)
            return false;
        solde = solde - montant;
        compteDestinataire.solde = compteDestinataire.solde + montant;
        return true;

    }

    public void setDateDeValidationID(Date dateDeValidationID) {
        this.dateDeValidationID = dateDeValidationID;
    }

}









