package com.codigo.smartstore.webapi;

import java.lang.ref.WeakReference;
import java.util.List;

// @ConfigProperties(prefix = "complex")
class ComplexConfiguration {

	public String name;
	public String user;
	public String password;
	public List<Nested> inputs;
	public List<Nested> outputs;

	static class Builder {

		WeakReference<ComplexConfiguration> innerList;

		public static ComplexConfiguration init() {

			return new ComplexConfiguration();
		}

		public ComplexConfiguration config() {

			// ComplexConfiguration.this.inputs;
			return null;
		}

		public ComplexConfiguration build() {

			return new ComplexConfiguration();
		}

		class Inner {

			Inner() {

				// final var data = ComplexConfiguration.this.name;
			}
		}

	}

	public static class Nested {

		public String user;
		public String password;
	}
}
