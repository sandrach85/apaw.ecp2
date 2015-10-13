package voting.presentation.views;

import voting.presentation.models.Model;


public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.println("   " + model.get("Temas"));
    }

}
