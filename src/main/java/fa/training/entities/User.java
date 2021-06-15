package fa.training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="User")
@Table(name="`User`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable{
	@Getter

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userID;
	
	@Column(name="login_name",columnDefinition="nvarchar(50)")
	private String loginName;
	
	@Column(name="password_value",columnDefinition="nvarchar(50)")
	private String passwordValue;
	
	@Column(name="first_name",columnDefinition="nvarchar(50)")
	private String firstName;
	
	@Column(name="last_name",columnDefinition="nvarchar(50)")
	private String lastName;
	
	@Column(name="email",columnDefinition="nvarchar(50)")
	private String email;
	
	@Column(name="comfirm_value",columnDefinition="nvarchar(50)")
	private String comfirmValue;
	
	@Column(name="modified",columnDefinition="nvarchar(50)")
	private String modified;
	
	@Column(name = "created", columnDefinition = "nvarchar(255)")
    private String created;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "last_login", columnDefinition = "DATE")
    private Date lastLogin;
    
    @Column(name = "disabled", columnDefinition = "nvarchar(255)")
    private String disabled;
    
    @Column(name = "objectdata", columnDefinition = "varchar(255)")
    private String objectData;
    
    @Column(name = "password_changed", columnDefinition = "varchar(55)")
    @Length(min = 8, message = "Password must be at least 8 characters")
    @Length(max = 55, message = "Password must be less than 55 characters")
    private String passwordChanged;
    
    @Column(name = "in_telephone", columnDefinition = "varchar(10)")
    private String inTelephone;

    @Column(name = "out_telephone", columnDefinition = "varchar(10)")
    private String outTelephone;
    
    @Column(name = "cellular_phone", columnDefinition = "varchar(10)")
    private String cellularPhone;

    @Column(name = "cellular_email", columnDefinition = "varchar(255)")
    private String cellularEmail;
    
    @Column(name = "cellular_uid", columnDefinition = "int")
    private int cellularUid;
    
    @Column(name = "first_name_kana", columnDefinition = "varchar(255)")
    private String firstNameKana;
    
    @Column(name = "last_name_kana", columnDefinition = "varchar(255)")
    private String lastNameKana;
    
    @Column(name = "photo", columnDefinition = "varchar(255)")
    private String photo;
    
    @Column(name = "has_photo", columnDefinition = "varchar(255)")
    private String hasPhoto;
    
    @Column(name = "photo_modified", columnDefinition = "varchar(255)")
    private String photoModified;
    
    @Column(name = "photo_smartphone", columnDefinition = "varchar(255)")
    private String photoSmartPhone;
    
    @Column(name = "has_photo_smartphone", columnDefinition = "varchar(255)")
    private String hasPhotoSmartPhone;
    
    @Column(name = "photo_modified_smartphone", columnDefinition = "varchar(255)")
    private String photoModifiedSmartphone;
    
    @Column(name = "tutorial_forbid", columnDefinition = "varchar(255)")
    private String tutorialForbid;
    
    @Column(name = "migrate_version", columnDefinition = "varchar(255)")
    private String migrateVersion;
    
    @Column(name = "created_user_id", columnDefinition = "int")
    private int createdUserId;
    
    @Column(name = "updated_user_id", columnDefinition = "int")
    private int updatedUserId;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "company_id")
    private Company company;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "position_id")
    private Position position;

	@Override
	public String toString() {
		return "User [userID=" + userID + ", loginName=" + loginName + ", passwordValue=" + passwordValue
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", comfirmValue="
				+ comfirmValue + ", modified=" + modified + ", created=" + created + ", lastLogin=" + lastLogin
				+ ", disabled=" + disabled + ", objectData=" + objectData + ", passwordChanged=" + passwordChanged
				+ ", inTelephone=" + inTelephone + ", outTelephone=" + outTelephone + ", cellularPhone=" + cellularPhone
				+ ", cellularEmail=" + cellularEmail + ", cellularUid=" + cellularUid + ", firstNameKana="
				+ firstNameKana + ", lastNameKana=" + lastNameKana + ", photo=" + photo + ", hasPhoto=" + hasPhoto
				+ ", photoModified=" + photoModified + ", photoSmartPhone=" + photoSmartPhone + ", hasPhotoSmartPhone="
				+ hasPhotoSmartPhone + ", photoModifiedSmartphone=" + photoModifiedSmartphone + ", tutorialForbid="
				+ tutorialForbid + ", migrateVersion=" + migrateVersion + ", createdUserId=" + createdUserId
				+ ", updatedUserId=" + updatedUserId + "]";
	}
    
    
	
}
