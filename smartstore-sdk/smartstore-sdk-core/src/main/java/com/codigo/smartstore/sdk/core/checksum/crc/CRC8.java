package com.codigo.smartstore.sdk.core.checksum.crc;

public final class CRC8
		extends
		AbstractCrc {

	/**
	 *
	 * @param parameters
	 */
	public CRC8(final ICrcParametrizable parameters) {

		// tu musimy sprawdzić czy typ pochodzi od CRC8
		super(parameters);
		if (!parameters.getClass()
				.equals(CRC8_OPTIONS.class))
			throw new IllegalArgumentException();
	}
}
