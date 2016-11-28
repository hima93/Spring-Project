package io.egen.app.entity;

import javax.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "role")
public class Role {
	@Id
	   private String id;
	   private String roleName;
	    	    public Role() {
			id = UUID.randomUUID().toString();
		}

	    
	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}


		public String getRoleName() {
			return roleName;
		}


		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
	    
	    
}
