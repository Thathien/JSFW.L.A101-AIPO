package fa.training.dto;

import lombok.NoArgsConstructor;

import org.hibernate.annotations.NotFound;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
	@NotFound
	private String key;
}
