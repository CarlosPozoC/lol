package models;

public class Champion_stats {
	private Integer champion;
	private String stat_name;
	private Integer stat_value;
	private Integer modifier_per_level;
	
	public Integer getChampion() {
		return champion;
	}
	public void setChampion(Integer champion) {
		this.champion = champion;
	}
	public String getStat_name() {
		return stat_name;
	}
	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}
	public Integer getStat_value() {
		return stat_value;
	}
	public void setStat_value(Integer stat_value) {
		this.stat_value = stat_value;
	}
	public Integer getModifier_per_level() {
		return modifier_per_level;
	}
	public void setModifier_per_level(Integer modifier_per_level) {
		this.modifier_per_level = modifier_per_level;
	}
	
	
}
