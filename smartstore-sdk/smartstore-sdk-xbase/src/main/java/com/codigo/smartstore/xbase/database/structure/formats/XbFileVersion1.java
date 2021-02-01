package com.codigo.smartstore.xbase.database.structure.formats;

import java.util.EnumSet;

import com.codigo.smartstore.xbase.database.structure.field.XbFieldType;

enum XbFileLimits {

	MaxFileRows(XbFileVersion1.DBASE_3);

	XbFileLimits(final XbFileVersion1 version) {

	}

}

public enum XbFileVersion1 {

	DBASE_3((byte) 0x03, XbTableFormats.XBASE3),
	DBASE_4((byte) 0x03, XbTableFormats.XBASE4),
	DBASE_5((byte) 0x03, XbTableFormats.XBASE5),
	CLIPPER_5((byte) 0x03, XbTableFormats.CLIPPER5),
	FOXPRO_26((byte) 0x03, XbTableFormats.FOXPRO5);

	public enum XbTableFormats {

		XBASE2 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		},
		XBASE3 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		},
		XBASE4 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		},
		XBASE5 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		},
		CLIPPER5 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		},
		FOXPRO5 {

			@Override
			public EnumSet<XbFieldType> fieldTypes() {

				return EnumSet.of(XbFieldType.CHARACTER, XbFieldType.NUMERIC);
			}

		};

		public abstract EnumSet<XbFieldType> fieldTypes();

	}

	// private XbTableFormats formats;

	XbFileVersion1(final byte byteVersion, final XbFileVersion1.XbTableFormats format) {

		// this.formats = format;
	}

}
