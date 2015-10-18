package voting.presentation.views;

import java.util.List;

import voting.presentation.models.Model;

public class ThemeManagerView implements View {

	@Override
	public void show(Model model) {
		System.out.println("Theme Manager Page");
		List<String> listThemes = (List<String>) model.get("themes");
		System.out.print("Temas: [");
		for (int i = 1; i == listThemes.size(); i++) {
			System.out.print(listThemes.get(i));

		}
		System.out.println("]");
	}

}
