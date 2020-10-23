// package com.codigo.smartstore.sdk.core;
//
// class A {
//
// void print() {
//
// System.out.println("A");
// }
// }
//
// class B
// extends
// A {
//
// @Override
// void print() {
//
// super.print();
// System.out.println("B");
// }
// }
//
// class C
// extends
// B {
//
// @Override
// void print() {
//
// super.print();
// System.out.println("c");
// }
// }
//
// public class TestMe {
//
// public void performSynchronisedTask() {
//
// synchronized (this) {
//
// }
// }
//
// public static void main(final String[] args) throws InterruptedException {
//
// final String s1 = "Andrzej";
// final String s2 = "Radziszewksi";
//
// //
// https://howtodoinjava.com/java/multi-threading/difference-between-yield-and-join-in-threads-in-java/
//
// final Runnable r1 = (
// ) -> {
//
// // synchronized (TestMe.class) {
//
// try {
//
// System.out.println(Thread.currentThread()
// .getName() + " "
// + s1);
// // Thread.yield();
// // Thread.sleep(2000);
// } catch (final InterruptedException ex) {
//
// // TODO Auto-generated catch block
// ex.printStackTrace();
// }
// // }
//
// // synchronized (TestMe.class) {
//
// try {
//
// System.out.println(Thread.currentThread()
// .getName() + " "
// + s2);
// // Thread.yield();
// // Thread.sleep(2000);
// } catch (final InterruptedException ex) {
//
// // TODO Auto-generated catch block
// ex.printStackTrace();
// }
// // }
// };
//
// final Runnable r2 = (
// ) -> {
//
// // synchronized (TestMe.class) {
//
// try {
//
// System.out.println(Thread.currentThread() + " "
// + s2);
// // Thread.yield();
// // Thread.sleep(12000);
// } catch (final InterruptedException ex) {
//
// // TODO Auto-generated catch block
// ex.printStackTrace();
// }
// // }
//
// // synchronized (TestMe.class) {
//
// System.out.println(Thread.currentThread() + " "
// + s1);
// // }
// };
//
// final Thread t1 = new Thread(r1);
// final Thread t2 = new Thread(r2);
//
// t1.start();
// t2.start();
//
// t1.join(8000);
//
// // try {
// //
// // System.out.println("try");
// // } finally {
// //
// // System.out.println("finally");
// // }
//
// // int a = 8;
// // int b = 2;
// // final int c = a + b;
// // b = a;
// // a = c - b;
// // System.out.println(a);
// // System.out.println(b);
// //
// // A a1 = new A();
// // final B b1 = new B();
// // final C c1 = new C();
//
// // a1.print();
// // b1.print();
// // c1.print();
//
// // b1 = a1;
//
// // a1 = c1;
// // a1.print();
// //
// // a1 = b1;
// // a1.print();
// // c1 = (C) b1;
// // c1.print();
//
// // final ExecutorService service = Executors.newFixedThreadPool(5);
// //
// // IntStream.range(0, 1000)
// // .forEach(count -> {
// //
// // service.submit((
// // ) -> {
// //
// // System.out.println("Executor " + Thread.currentThread()
// // .getName()
// // + " "
// // + count);
// // });
// // });
// // service.awaitTermination(1000L, TimeUnit.MILLISECONDS);
// // service.shutdown();
// }
// }
