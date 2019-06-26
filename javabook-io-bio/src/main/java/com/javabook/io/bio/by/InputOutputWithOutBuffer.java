package com.javabook.io.bio.by;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class InputOutputWithOutBuffer extends InputOutputProxy {

	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------
	
	@Override
	public DataInputStream openInputStream(String file) throws IOException {
		DataInputStream is = 
		new DataInputStream(
		new FileInputStream(file));
		
		return is;
	}
	
	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------
	
	@Override
	public DataOutputStream openOutputStream(String file) throws IOException {
		DataOutputStream os = 
		new DataOutputStream(
		new FileOutputStream(file));
		
		return os;
	}

}
