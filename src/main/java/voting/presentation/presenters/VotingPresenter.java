package voting.presentation.presenters;

import voting.business.controllers.BusinessController;
import voting.presentation.models.Model;

public class VotingPresenter {

	public String process() {
        model.put("Temas", "VotingPresenter:process");
        return "VotingView";
	}
	
	public void voteTheme(Model model) {
        new BusinessController().voteTheme((String)model.get("themeName"),(int) model.get("value"));
	}


}
