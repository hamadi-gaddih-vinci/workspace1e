
public class ConnexionInfo{
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		ensembleDesConnectes = new EnsembleTableBooleens<>(999);
		// TODO

	}
 	
 	public	int nombreDeConnectes(){
 		return ensembleDesConnectes.taille();
 		// TODO
	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		return ensembleDesConnectes.ajouter(loginInfo);
		// TODO
	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		return ensembleDesConnectes.enlever(loginInfo);
		// TODO

	}

	public boolean estConnecte(LoginInfo loginInfo){
		return (ensembleDesConnectes.contient(loginInfo));
		// TODO

	}
	

}