package usage.model;

public class Cloth {

	private Integer id;
	private String name;
	private ClothType type;
	
	public Cloth(Integer id, String name, ClothType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(ClothType type) {
		this.type = type;
	}
	
	public ClothType getType() {
		return type;
	}

	public enum ClothType {
		SPRING, SUMMER, AUTUMN, WINTER
	}
}
