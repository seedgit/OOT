package th.ac.kmitl.it.oot.motorcycle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Generated;

@Entity
@Table(name = "brand")
public class Brand {
	private Integer id;
	private String name;
	public Brand() {
		this.id = 0;
		this.name = "Yamaha";
	}
	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}