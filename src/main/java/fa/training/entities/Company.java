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

@Entity(name="Company")
@Table(name="Company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private int companyID;
	
	@Column(name="company_name",columnDefinition="nvarchar(50)")
	private String companyName;
	
	@Column(name="company_name_kanna",columnDefinition="nvarchar(50)")
	private String companyNameKanna;
	
	@Column(name="zipcode",columnDefinition="nvarchar(50)")
	private String zipcode;
	
	@Column(name="address",columnDefinition="nvarchar(50)")
	private String address;
	
	@Column(name="telephone",columnDefinition="nvarchar(50)")
	private String telephone;
	
	@Column(name="fax_number",columnDefinition="nvarchar(50)")
	private String faxNumber;
	
	@Column(name="url",columnDefinition="nvarchar(50)")
	private String url;
	
	@Column(name="ipaddress",columnDefinition="nvarchar(50)")
	private String ipaddress;
	
	@Column(name="port",columnDefinition="nvarchar(50)")
	private String port;
	
	@Column(name="ipaddress_internal",columnDefinition="nvarchar(50)")
	private String ipaddressInternal;
	
	@Column(name="port_internal",columnDefinition="nvarchar(50)")
	private String portInternal;
	
	@Column(name="create_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="update_date",columnDefinition="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	private Set<Post> posts= new HashSet<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	private Set<User>users = new HashSet<>();
	
	
	
}
