package ssm.entity;

public class Role {
	/*
	 * create table shop_role(
      id number(16) primary key,
      name varchar(64)
      );
	 */
	
	private Long id;
	private String name;
	
	public Role(Long id, String name) {
	
		this.id = id;
		this.name = name;
	}
	public Role() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
