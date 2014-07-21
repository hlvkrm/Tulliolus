package tulliolus.respond;

public class Response {
	
	String type, mod;
	
	public Response(String type, String mod){
		this.type = type;
		this.mod = mod;
	}

	
	public String getType(){return type;}
	public String getMod(){return mod;}
	public void setType(String type){this.type = type;}
	public void setMod(String mod){this.mod = mod;}
	
}
