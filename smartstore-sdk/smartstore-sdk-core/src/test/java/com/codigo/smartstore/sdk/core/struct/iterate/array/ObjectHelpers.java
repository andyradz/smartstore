package com.codigo.smartstore.sdk.core.struct.iterate.array;

import java.lang.instrument.Instrumentation;
import java.util.Objects;

// https://www.baeldung.com/java-size-of-object

public class ObjectHelpers {

	public static long sizeOf(final Object object) {

		return InstrumentationAgent.getObjectSize(object);
	}

	private static class InstrumentationAgent {

		private static volatile Instrumentation globalInstrumentation;

		// public static void premain(final String agentArgs, final Instrumentation
		// inst) {
		//
		// globalInstrumentation = inst;
		// }

		public static long getObjectSize(final Object object) {

			if (Objects.isNull(globalInstrumentation))
				throw new IllegalStateException("Agent not initialized.");

			return globalInstrumentation.getObjectSize(object);
		}
	}
}
