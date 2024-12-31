public class Login {
   
 	private String login;
	
 	public Login(String login)throws IllegalArgumentException{
		if(login==null || login.length() != 7 || (!login.substring(0,4).equals("info")&&
				!login.substring(0,4).equals("mark")&&!login.substring(0,4).equals("admi")))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	// renvoie un entier >= 0
	// cet entier represente de façon unique le login courant!
	public int hashCode(){
		// TODO 
		String renvoi = login.substring(4,7);
		String departement = login.substring(0,4);
		if (departement.equals("admi")){
			return Integer.parseInt(renvoi)-1;
		}
		else if (departement.equals("mark")){
			return Integer.parseInt(renvoi)+60;
		}
		return Integer.parseInt(renvoi)+140;
	 }
	
}

