package world.asia;

public class Korea {
	
	public int population;
	String capital;
	private String language;

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		if(language.equals("한국어") || language.equals("영어")) {
			this.language = language;
		}else {
			System.out.println("언어를 잘못 설정하셨습니다.");
			return; //void method escape
		}
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}

	

}
