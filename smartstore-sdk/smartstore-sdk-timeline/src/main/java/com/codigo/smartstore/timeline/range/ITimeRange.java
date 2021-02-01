package com.codigo.smartstore.timeline.range;

import java.time.LocalDateTime;
import java.time.Period;

import com.codigo.smartstore.timeline.period.ITimePeriod;

// ------------------------------------------------------------------------
public interface ITimeRange
	extends ITimePeriod {

	@Override
	LocalDateTime getStart();

	@Override
	boolean hasEnd();

	@Override
	LocalDateTime getEnd();

	@Override
	Period getDuration();

	void move(Period offset);

	void expandStartTo(LocalDateTime moment);

	void expandEndTo(LocalDateTime moment);

	void expandTo(LocalDateTime moment);

	void expandTo(ITimePeriod period);

	void shrinkStartTo(LocalDateTime moment);

	void shrinkEndTo(LocalDateTime moment);

	void shrinkTo(ITimePeriod period);

	ITimeRange copy(Period offset);

	ITimeRange getIntersection(ITimePeriod period);

}
