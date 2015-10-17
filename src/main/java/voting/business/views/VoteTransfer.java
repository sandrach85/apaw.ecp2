package voting.business.views;

public class VoteTransfer {
	public String themeName;
	public int value;

	public VoteTransfer(String name, int val) {
		this.themeName = name;
		this.value = val;
	}

	public String getThemeName() {
		return themeName;
	}

	public int getVote() {
		return value;
	}
}
