package voting.presentation.presenters;

import voting.business.controllers.BusinessController2;
import voting.business.views.TransferObject2;
import voting.presentation.models.Model;

public class ThemeManagerPresenter {

	public String process(Model model) {
        model.put("log", "UI2Presenter:process");
        return "ThemeManagerView";
	}

	public String action1(Model model) {
        model.put("log", "UI2Presenter:action1");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "ThemeManagerView";
	}

}
