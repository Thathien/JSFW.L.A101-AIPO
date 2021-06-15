package fa.training.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	@NotNull(message="Username is not null")
	@NotBlank
	@Length(min=1,max=40, message="username have from 4 to 40 charater")
	private String username;
	
	@NotNull(message="pass is not null")
	@NotBlank
	@Length(min=1,max=40, message="username have from 4 to 40 charater")
	private String pass;
}
