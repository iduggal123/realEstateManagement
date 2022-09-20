package com.bits.af.utils;

import java.util.Base64;

public class CommonUtils {

	public String base64Encode(String input) {
		String _encoded = "";
		try {
			Base64.Encoder encoder = Base64.getEncoder();
			_encoded = encoder.encodeToString(input.getBytes());
		} catch (Exception e) {
			System.out.println(String.format("Encoding failed because of [%s]", e.getMessage()));
			return _encoded;
		}
		return _encoded;
	}

	public String base64Decode(String _encoded) {
		String _decoded = "";
		try {
			Base64.Decoder decoder = Base64.getDecoder();
			_decoded = new String(decoder.decode(_encoded));
		} catch (Exception e) {
			System.out.println(String.format("Decoding failed because of [%s]", e.getMessage()));
			return _decoded;
		}
		return _decoded;
	}
}
