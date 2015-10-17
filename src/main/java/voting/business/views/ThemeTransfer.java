package voting.business.views;

public class ThemeTransfer {
	public String themeName;
	public double average;
	
	public ThemeTransfer(String name, double value){
		this.themeName=name;
		this.average=value;
	}
	
	public String getThemeName(){
		return themeName;
	}

	public double getAverage(){
		return average;
	}
}
