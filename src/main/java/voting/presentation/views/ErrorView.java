package voting.presentation.views;

import voting.presentation.models.*;

public class ErrorView implements View {

	@Override
	public void show(Model model) {
		System.out.println("Error \n   Lo siento, petición incorrecta. "+ model.get("error"));
	}

}
