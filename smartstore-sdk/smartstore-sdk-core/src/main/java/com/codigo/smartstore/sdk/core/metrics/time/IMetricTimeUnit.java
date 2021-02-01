package com.codigo.smartstore.sdk.core.metrics.time;

import com.codigo.smartstore.sdk.core.metrics.IMetricDimension;
import com.codigo.smartstore.sdk.core.metrics.IMetricUnit;

public interface IMetricTimeUnit
	extends IMetricUnit {

	public enum MetricTimeMultiples {

	}

	public enum MetricTimeSubmultiples {

	}

	@Override
	public default IMetricDimension getMetricUnit() {

		return new IMetricDimension() {

			@Override
			public String getUnitName() {

				return "second";
			}

			@Override
			public String getUnitSymbol() {

				return "s";
			}

			@Override
			public String getQuantityName() {

				return "time";
			}

			@Override
			public String getDimensionSymbol() {

				return "T";
			}
		};
	}

	@Override
	public double getMetricValue();
}
