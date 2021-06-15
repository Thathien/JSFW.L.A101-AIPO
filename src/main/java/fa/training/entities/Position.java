package fa.training.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="`Position`")
@Entity(name="Position")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="position_id")
	private int positionID;
	
	@Column(name="position_name",columnDefinition="nvarchar(50)")
	private String positionName;
	
	@Column(name="create_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@OneToMany(mappedBy="position",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference
	private Set<User> users= new HashSet<>();
	
}
