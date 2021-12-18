package br.com.pessoas.testes;



import br.com.pessoas.controller.ActionControll;
import br.com.pessoas.guiControll.Cli;
import br.com.pessoas.model.Individuo;

public class Main {

	public static void main(String[] args) {

		ActionControll.register();
		ActionControll.register();
//		ActionControll.register();
		ActionControll.listIndividuos();
		Cli.showTxt("Deleta aí => ");
		String del = Cli.getTxt();
		Individuo ind1 = ActionControll.getIndByName(del);
		ActionControll.deleteIndividuo(ind1);
		ActionControll.listIndividuos();
		
		
		
	}

}
