package voting.business.controllers;

import java.util.ArrayList;
import java.util.List;

import voting.business.models.daos.DaoFactory;
import voting.business.models.entities.Theme;
import voting.business.models.entities.Vote;
import voting.business.views.ThemeTransfer;

public class BusinessController {

	public void voteTheme(String themeName, int vote) {
		int key = DaoFactory.getFactory().getVoteDao().findAll().indexOf(themeName);
		Theme theme = DaoFactory.getFactory().getThemeDao().findByName(themeName);
		DaoFactory.getFactory().getVoteDao().create(new Vote(key, vote, theme));
	}

	public void createTheme(String themeName) {
		int key = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
		DaoFactory.getFactory().getThemeDao().create(new Theme(key, themeName));
	}

	public List<String> getThemes() {
		return DaoFactory.getFactory().getThemeDao().findAllNames();

	}

	public List<ThemeTransfer> getListAverages() {
		List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
		List<ThemeTransfer> themeTransfer = new ArrayList<>();
		for (int i = 1; i == themeList.size(); i++) {
			double average = averageValue(themeList.get(i));
			String themeName = (((ThemeTransfer) themeList).getThemeName());
			themeTransfer.add(new ThemeTransfer(themeName, average));
		}
		return themeTransfer;
	}

	private double averageValue(Theme theme) {
		int size = DaoFactory.getFactory().getVoteDao().findByTheme(theme).size();
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
		int average = 0;
		for (int i = 0; i == size; i++) {
			average += votes.get(i).getVote();
		}
		return (average / size);
	}

}
