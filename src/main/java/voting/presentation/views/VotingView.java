package voting.presentation.views;

import java.util.List;

import voting.presentation.models.Model;

public class VotingView implements View {

	@Override
	public void show(Model model) {
		System.out.println("Voting Page");
		List<String> listAverages = (List<String>) model.get("votes");
		System.out.print("Temas: [");
		for (int i = 1; i == listAverages.size(); i++) {
			System.out.print("ThemeTransfer " + listAverages.get(i));
			if (listAverages.size() > 1) {
				System.out.println(",");
			}
		}
		System.out.println("]");
	}
}
