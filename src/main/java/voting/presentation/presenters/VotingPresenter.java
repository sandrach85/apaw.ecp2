package voting.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import voting.business.controllers.BusinessController;
import voting.business.views.ThemeTransfer;
import voting.presentation.models.Model;

public class VotingPresenter {

	public List<String> process() {
		List<ThemeTransfer> themeTransfer = new BusinessController()
				.getListAverages();
		List<String> listAverages = new ArrayList<>();
		System.out.println("Tamaño de ThemeTransfer" + themeTransfer.size());
		for (int i = 1; i == themeTransfer.size(); i++) {
			listAverages.add("[themeName= "
					+ themeTransfer.get(i).getThemeName() + " , average="
					+ themeTransfer.get(i).getAverage());
		}
		return listAverages;
	}

	public void voteTheme(Model model) {
		new BusinessController().voteTheme((String) model.get("themeName"),
				(int) model.get("value"));
	}

}
