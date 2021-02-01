package com.codigo.smartstore.sdk.core.instance;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class SingletonFactory {

	private static final Map<Class<?>, Object> collection = new HashMap<>();

	public static <T> T getInstance(final Class<T> clazz) {

		Object instance = null;

		synchronized (SingletonFactory.class) {

			instance = collection.get(clazz);

			if (Objects.isNull(instance)) {

				try {

					instance = clazz.getDeclaredConstructor()
							.newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException ex) {

					ex.printStackTrace();
				}
				collection.put(clazz, instance);
			}
		}

		return clazz.cast(instance);
	}
}
