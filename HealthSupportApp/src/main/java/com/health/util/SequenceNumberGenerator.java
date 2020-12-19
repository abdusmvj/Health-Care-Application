package com.health.util;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceNumberGenerator {

	
	private static AtomicLong numberGenerator = new AtomicLong(100001);

    public static long getNext() {
    	
        return numberGenerator.getAndIncrement();
    }
}
