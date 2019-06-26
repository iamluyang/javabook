package com.javabook.io.bio.by;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public class InputOutputWithBuffer extends InputOutputProxy {

	// --------------------------------------------------
	// DataInputStream
	// --------------------------------------------------
	
	@Override
	public DataInputStream openInputStream(String file) throws IOException {
		DataInputStream is = 
		new DataInputStream(
		new BufferedInputStream( 
		new FileInputStream(file)));
		
		return is;
	}
	
	// --------------------------------------------------
	// DataOutputStream
	// --------------------------------------------------
	
	@Override
	public DataOutputStream openOutputStream(String file) throws IOException {
		DataOutputStream os = 
		new DataOutputStream(
		new BufferedOutputStream(
		new FileOutputStream(file)));
		
		return os;
	}

}
