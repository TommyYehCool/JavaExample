package com.exfantasy.example.collection;

import java.nio.ByteBuffer;

public class TestByteBuffer {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(256);
		
		System.out.println("Allocate ByteBuffer with 256");
		
		String hello = new String("Hello");
		String world = new String("World");

		buffer.put(hello.getBytes());
		
		System.out.println("Put \"Hello\".getBytes() to buffer done");
		
		buffer.put(world.getBytes());
		
		System.out.println("Put \"World\".getBytes() to buffer done");
		
		System.out.println("buffer.remaining(): " + buffer.remaining());
		
		buffer.flip();
		
		System.out.println("buffer.filp()");

		System.out.println("buffer.remaining(): " + buffer.remaining());

		byte[] bytes = new byte[buffer.remaining()];
		buffer.get(bytes, 0, buffer.remaining());
		System.out.println(new String(bytes));
	}

}
