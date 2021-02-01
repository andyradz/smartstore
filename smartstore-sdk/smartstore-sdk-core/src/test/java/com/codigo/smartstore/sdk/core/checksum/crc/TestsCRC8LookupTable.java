package com.codigo.smartstore.sdk.core.checksum.crc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestsCRC8LookupTable {

	private int[] crcLookupTable;
	private CRC8 crc8;

	@BeforeEach
	public void initializeClass() {

		this.crc8 = new CRC8(
				CRC8_OPTIONS.CRC8);
		this.crcLookupTable = this.crc8.getLookupTable();

	}

	@Test
	void testLookTableElementsCount() {

		// assert
		assertThat(this.crcLookupTable.length, equalTo(256));
	}

	@Test
	@DisplayName("Test wykonania naliczenia tablcy")
	void testLookTableElementAt1() {

		// assert
		assertThat(this.crcLookupTable[0], equalTo(0x00));
	}

	@Test
	void testLookTableElementAt2() {

		// assert
		assertThat(this.crcLookupTable[1], equalTo(0x07));
	}

	@Test
	void testLookTableElementAt3() {

		// assert
		assertThat(this.crcLookupTable[2], equalTo(0x0e));
	}

}
