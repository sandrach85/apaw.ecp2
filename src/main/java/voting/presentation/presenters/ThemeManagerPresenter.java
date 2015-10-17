package voting.presentation.presenters;

import java.util.List;

import voting.business.controllers.BusinessController;
import voting.presentation.models.Model;

public class ThemeManagerPresenter {

	public List<String> process() {
        List<String> themes = new BusinessController().getThemes();
        return themes;
	}

	public void createTheme(Model model) {
		new BusinessController().createTheme((String)model.get("themeName"));
		}

}
