package voting.presentation.presenters;

import voting.business.controllers.BusinessController1;
import voting.business.views.TransferObject1;
import voting.presentation.models.Model;

public class VotingPresenter {

	public String process(Model model) {
        model.put("Temas", "VotingPresenter:process");
        return "VotingView";
	}
	

	public String action1(Model model) {
        model.put("log", "VotingPresenter:action1");
        TransferObject1 transferObject1 = new BusinessController1().m1();
        model.put("transferObject1", transferObject1);
        return "VotingView";
	}
	

}
