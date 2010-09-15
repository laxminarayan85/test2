package com.efi.printsmith.network;

import com.efi.printsmith.network.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MessageUtil {
	public static ByteArrayOutputStream serializeObject(Object obj,
			boolean base64) throws IOException {
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = null;
		if (base64) {
			objectOut = new ObjectOutputStream(Base64.encode(byteArrayOut));
		} else {
			objectOut = new ObjectOutputStream(byteArrayOut);
		}
		objectOut.writeObject(obj);
		objectOut.flush();
		objectOut.reset();
		objectOut.close();
		return byteArrayOut;
	}

	public static Object deserializeObject(InputStream stream, boolean base64)
			throws IOException, ClassNotFoundException {
		ObjectInputStream objectIn = null;
		if (base64) {
			objectIn = new ObjectInputStream(Base64.decode(stream));
		} else {
			objectIn = new ObjectInputStream(stream);
		}
		Object object = objectIn.readObject();
		objectIn.close();
		return object;
	}

	public static ByteArrayOutputStream serializeObject(Object obj)
			throws IOException {
		return serializeObject(obj, true);
	}

	public static Object deserializeObject(InputStream stream)
			throws IOException, ClassNotFoundException {
		return deserializeObject(stream, true);
	}

}
