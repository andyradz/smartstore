package com.codigo.smartstore.sdk.core.tasks;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class PausableThreadPoolExecutor
		extends
		ThreadPoolExecutor {

	private boolean isPaused;
	private final ReentrantLock pauseLock;
	private final Condition unpaused;

	public PausableThreadPoolExecutor() {

		super(2, 4, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
		this.pauseLock = new ReentrantLock();
		this.unpaused = this.pauseLock.newCondition();
	}

	@Override
	protected void beforeExecute(final Thread thread, final Runnable task) {

		super.beforeExecute(thread, task);
		this.pauseLock.lock();

		try {

			while (this.isPaused)
				this.unpaused.await();
		} catch (final InterruptedException ie) {

			thread.interrupt();
		} finally {

			this.pauseLock.unlock();
		}
	}

	public void pause() {

		this.pauseLock.lock();

		try {

			this.isPaused = true;
		} finally {

			this.pauseLock.unlock();
		}
	}

	public void resume() {

		this.pauseLock.lock();

		try {

			this.isPaused = false;
			this.unpaused.signalAll();
		} finally {

			this.pauseLock.unlock();
		}
	}
}