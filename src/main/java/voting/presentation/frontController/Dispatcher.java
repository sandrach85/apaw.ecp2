package voting.presentation.frontController;

import voting.http.HttpRequest;
import voting.http.HttpResponse;
import voting.presentation.models.Model;
import voting.presentation.presenters.VotingPresenter;
import voting.presentation.presenters.ThemeManagerPresenter;
import voting.presentation.views.*;

public class Dispatcher {

	public void doGet(HttpRequest request, HttpResponse response) {
		Model model = new Model();
		String presenter = request.getPath() + "Presenter";
		String nextView = request.getPath() + "View";

		switch (presenter) {
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			model.put("votes", votingPresenter.process());
			break;
		case "ThemeManagerPresenter":
			ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
			model.put("themes", themeManagerPresenter.process());
			break;
		}
		this.show(nextView, model);
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		Model model = new Model();
		String controller = request.getPath() + "Presenter";
		String action = request.getParams().get("action");
		String themeName = request.getParams().get("themeName");
		String nextView = request.getPath() + "View";

		switch (controller) {
		case "VotingPresenter":
			VotingPresenter votingPresenter = new VotingPresenter();
			String vote = request.getParams().get("value");
			if ("voteTheme".equals(action)) {
				model.put("themeName", themeName);
				model.put("vote", vote);
				votingPresenter.voteTheme(model);
				model.put("votes", votingPresenter.process());
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		case "ThemeManagerPresenter":
			ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
			model.put("themeName", themeName);
			if ("createTheme".equals(action)) {
				themeManagerPresenter.createTheme(model);
				model.put("themes", themeManagerPresenter.process());
			} else {
				model.put("error", "Acción no permitida: " + action);
			}
			break;
		}
		this.show(nextView, model);
	}

	private void show(String nextView, Model model) {
		View view;
		switch (nextView) {
		case "VotingView":
			view = new VotingView();
			break;
		case "ThemeManagerView":
			view = new ThemeManagerView();
			break;
		default:
			view = new ErrorView();
			model.put("error", "Vista no encontrada: " + nextView);
		}
		view.show(model);
	}

}
