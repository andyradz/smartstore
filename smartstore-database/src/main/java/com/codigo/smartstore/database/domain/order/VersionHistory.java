package com.codigo.smartstore.database.domain.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Embeddable
public class VersionHistory
	implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3366605138195373904L;

	@OneToMany(cascade = CascadeType.ALL)
	@MapKey(name = "date")

	@JoinColumn(name = "ref_order_history")
	Map<Date, OrderVersion> orderVersions = new HashMap<>();

	@OneToMany
	@JoinColumn(name = "ref_order_hour_milestone")
	List<OrderVersion> orderHourMilestones = new ArrayList<>();

}
