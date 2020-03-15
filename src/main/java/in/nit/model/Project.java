package in.nit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="projtab")
public class Project {
	@Id
	@Column(name="prj_id")
	private Integer projId;

	@Column(name="prj_name")
	private String projName;

	@Column(name="prj_clnt_name")
	private String clientName;

	@Column(name="prj_amt")
	private double projCost;

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy = "project")
	private List<ModuleInfo> modules;
}
