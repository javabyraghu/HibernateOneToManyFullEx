package in.nit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class ModuleInfo {
	@Id
	@NonNull
	private Integer moduleId;
	
	@NonNull
	private String moduleCode;
	
	@NonNull
	private Double estimatedDevTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pidFk")
	private Project project;
}
