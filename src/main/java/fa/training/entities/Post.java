package fa.training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Post")
@Table(name="Post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postID;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@Column(name="post_name",columnDefinition="nvarchar(50)")
	private String postName;
	
	@Column(name="zipcode",columnDefinition="nvarchar(50)")
	private String zipcode;
	
	@Column(name="address",columnDefinition="nvarchar(50)")
	private String address;
	
	@Column(name="in_telephone",columnDefinition="nvarchar(50)")
	private String inTelephone;
	
	@Column(name="out_telephone",columnDefinition="nvarchar(50)")
	private String outTelephone;
	
	@Column(name="fax_number",columnDefinition="nvarchar(50)")
	private String faxNumber;

	@Column(name="group_name",columnDefinition="nvarchar(50)")
	private String groupName;
	
	@Column(name="sort",columnDefinition="nvarchar(50)")
	private String sort;
	
	@Column(name="create_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@OneToOne(mappedBy="post")
	private Group group;
}
