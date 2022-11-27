package models;

public class Champion_tips {
	private Integer id;
	private Champions champion;
	private String tip;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public models.Champions getChampion() {
		return champion;
	}
	public void setChampion(models.Champions champion) {
		this.champion = champion;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
}
