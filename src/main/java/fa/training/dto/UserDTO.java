package fa.training.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@NotNull
	@NotBlank
	@Length(min=8,max=40, message="Input invalid (8-40) character")
	private String loginName;
	@NotNull
	@NotBlank
	@Length(min=8,max=40, message="Input invalid (8-40) character")
	private String passWord;
	@NotNull
	@NotBlank
	@Length(min=8,max=40, message="Input invalid (8-40) character")
	private String confirmPass;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String fName;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String lName;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String fNameKana;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String lNameKana;
	@NotNull
	@NotBlank
	@Length(min=8,max=40, message="Input invalid (8-40) character")
	private String email;
//	in_telephone
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String numOutSide1;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String numOutSide2;
	@NotNull
	@NotBlank
	@Length(min=2,max=15, message="Input invalid (2-15) character")
	private String numOutSide3;
//	cellular_phone
	@NotNull
	@NotBlank
	@Length(min=3,max=4, message="Input invalid (3-4) number")
	private String exPhone1;
	@NotNull
	@NotBlank
	@Length(min=3,max=4, message="Input invalid (3-4) number")
	private String exPhone2;
	@NotNull
	@NotBlank
	@Length(min=10,max=11, message="Input invalid (10-11) number")
	private String exPhone3;
	
//	out_telephone
	@NotNull
	@NotBlank
	@Length(min=10,max=11, message="Input invalid (10-11) number")
	private String ouPhone1;
	
	
	@NotEmpty
	@NotNull
	private List<String> department;
	
	@NotEmpty
	@NotBlank
	private String position;
	
}
