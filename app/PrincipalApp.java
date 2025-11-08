package app;

import model.Patio;
import model.Veiculo;

public class PrincipalApp {
	public static void main(String[] args) {
		
		 Veiculo c1 = new Veiculo("ABCD", "Ford Ka");
		 
		 Patio patio = new Patio();
		 
		 patio.registrarEntrada(c1);
	}
}
