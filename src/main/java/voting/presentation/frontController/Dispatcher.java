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
        case "UI1Presenter":
            VotingPresenter uI1Presenter = new VotingPresenter();
            nextView = uI1Presenter.process(model);
            break;
        case "UI2Presenter":
            ThemeManagerPresenter uI2Presenter = new ThemeManagerPresenter();
            nextView = uI2Presenter.process(model);
            break;        
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "UI1Presenter":
            VotingPresenter uI1Presenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.action1(model);
            } else if ("logout".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.logout(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "UI2Presenter":
            ThemeManagerPresenter uI2Presenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = uI2Presenter.action1(model);
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
