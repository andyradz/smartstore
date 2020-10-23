// package com.codigo.smartstore.sdk.core;
//
// import java.io.ByteArrayOutputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
//
// public class TestYield {
//
// public static class Producer
// extends
// Thread {
//
// @Override
// public void run() {
//
// for (int i = 0; i < 5; i++) { System.out.println("I am Producer : Produced
// Item " + i); Thread.yield(); }
// }
// }
//
// public static class Consumer
// extends
// Thread {
//
// @Override
// public void run() {
//
// for (int i = 0; i < 5; i++) { System.out.println("I am Consumer : Consumed
// Item " + i); Thread.yield(); }
// }
// }
//
// public static void main(final String[] args) throws InterruptedException,
// IOException {
//
// final Thread producer = new Producer();
// final Thread consumer = new Consumer();
//
// // producer.setPriority(Thread.MIN_PRIORITY); // Min Priority
// // consumer.setPriority(Thread.MAX_PRIORITY); // Max Priority
//
// producer.start();
// producer.join();
// consumer.start();
// consumer.join();
//
// final Boolean b = false, z = true, g = true;
//
// if (b instanceof Boolean logic) {
//
// final var val = logic;
// System.out.println(val + " "
// + z
// + " "
// + g);
// }
//
// try (ByteArrayOutputStream f = new ByteArrayOutputStream(23);
// FileOutputStream dou = new FileOutputStream("c:\\kodix")) {
//
// f.write(new byte[] { 1, 2, 3, 4 });
// f.close();
// dou.close();
// }
// }
// }
