package com.codigo.smartstore.sdk.core;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

import java.util.concurrent.ThreadLocalRandom;

// https://examples.javacodegeeks.com/java-basics/exceptions/java-lang-illegalmonitorstateexception-how-to-solve-illegalmonitorstateexception/

interface Git {

	public default void print0() {

		System.out.println("A");
	}
}

interface Sit {

	default void print0() {

		System.out.println("B");
	}
}

class GitAndSit
	implements Git, Sit {

	@Override
	public void print0() {

		Git.super.print0();
		Sit.super.print0();

	}

}

public class ThreadWait {

	static class Doit {

		static void doIt(int[] array) {

			array = null;
		}

		static void doIt(double[] array) {

			array = null;
		}
	}

	public static void main(final String[] args) {

		new Thread((
		) -> {

			try {

				Thread.currentThread()
						.wait();
				Thread.currentThread()
						.notify();
			} catch (final InterruptedException ex) {

				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		});

		final int[] array = { 1, 2, 3, 4, 5 };
		Doit.doIt(array);

		Doit.doIt(array);

		final ThreadWait data = new ThreadWait();
		final Thread sender = new Thread(new Sender(data));
		final Thread receiver = new Thread(new Receiver(data));

		sender.start();
		receiver.start();

		// var key = 1;
		//
		// key = switch (key) {
		//
		// case -1:
		// yield 99;
		//
		// default:
		// throw new IllegalArgumentException("Unexpected value: " + key);
		//
		// };
		//
		// final String message = switch (key) {
		//
		// case 404:
		// yield "Not found!";
		//
		// case 500:
		// yield "Internal server error!";
		//
		// default:
		// throw new IllegalArgumentException("Unexpected value: " + key);
		// };
	}

	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private volatile boolean transfer = true;

	public synchronized void send(final String packet) {

		while (!this.transfer)
			try {

				this.wait();
			} catch (final InterruptedException e) {

				Thread.currentThread()
						.interrupt();
				out.println("Thread interrupted");
			}
		this.transfer = false;

		this.packet = packet;
		this.notifyAll();
	}

	public synchronized String receive() {

		while (this.transfer)
			try {

				this.wait();
			} catch (final InterruptedException e) {

				Thread.currentThread()
						.interrupt();
				out.println("Thread interrupted");
			}
		this.transfer = true;

		this.notifyAll();
		return this.packet;
	}
}

class Sender
	implements Runnable {

	private final ThreadWait data;

	// standard constructors

	public Sender(final ThreadWait data) {

		this.data = data;
	}

	@Override
	public void run() {

		String packets[] = {
			"Begin", "First packet", "Second packet", "Third packet", "Fourth packet", "12", "12", "12", "End" };

		final String mama = "Andrzej,";

		packets = mama.repeat(1000)
				.split(",");

		for (final String packet : packets) {

			this.data.send(packet);

			// Thread.sleep() to mimic heavy server-side processing
			try {

				sleep(ThreadLocalRandom.current()
						.nextInt(1000, 5000));
			} catch (final InterruptedException e) {

				Thread.currentThread()
						.interrupt();
				out.println("Thread interrupted");
			}
		}
	}
}

class Receiver
	implements Runnable {

	private final ThreadWait load;

	// standard constructors

	public Receiver(final ThreadWait load) {

		this.load = load;
	}

	@Override
	public void run() {

		for (String receivedMessage = this.load.receive(); !"End".equals(receivedMessage); receivedMessage = this.load
				.receive()) {

			out.println(receivedMessage);

			// ...
			try {

				sleep(ThreadLocalRandom.current()
						.nextInt(1000, 5000));
			} catch (final InterruptedException e) {

				Thread.currentThread()
						.interrupt();
				out.println("Thread interrupted");
			}
		}
	}
}
// https://www.baeldung.com/java-wait-notify