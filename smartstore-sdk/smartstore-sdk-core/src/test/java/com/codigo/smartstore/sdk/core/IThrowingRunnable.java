package com.codigo.smartstore.sdk.core;


@FunctionalInterface
public interface IThrowingRunnable<E extends Throwable> {

	void run() throws E;
}
