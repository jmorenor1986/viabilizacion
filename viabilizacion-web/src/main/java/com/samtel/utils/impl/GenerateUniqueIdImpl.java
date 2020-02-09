package com.samtel.utils.impl;

import java.security.SecureRandom;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.samtel.utils.IGenerateUniqueId;

@Component("generateUniqueId")
public class GenerateUniqueIdImpl implements IGenerateUniqueId {
	
	private static final SecureRandom rng = new SecureRandom();

	@Override
	public String generateUniqueIdStr(Long length) {
		rng.setSeed(System.currentTimeMillis());
		Stream<Character> randomCharStream = rng.ints(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
				.mapToObj(i -> (char) i).filter(c -> {
					return c >= '0' && c <= 'z' && Character.isLetterOrDigit(c);
				}).limit(length);

		return randomCharStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}

	

	
}
