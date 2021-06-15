package fa.training.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="`Group`")
@Entity(name="Group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Group implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private int groupID;
	
	@Column(name="group_name",columnDefinition="nvarchar(50)")
	private String groupName;
	
	@Column(name="object_Data", columnDefinition="nvarchar(50)")
	private String objectData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id",columnDefinition="int",referencedColumnName="post_id")
	private Post post;
	
	@Column(name="group_alias_name",columnDefinition="nvarchar(50)")
	private String groupAliasName;
	
	@Column(name="public_flag",columnDefinition="nvarchar(50)")
	private String publicFlag;
	
}
