package com.javabook.reference.stringintern;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
class StringIntern {

    /**
     * @param args
     */
    public static void main(String[] args) {

    	String stringa1 = new String("a");
    	String stringa2 = new String("a");
    	
    	// new and ==
    	System.out.println("new String(\"a\")==new String(\"a\"):" + (stringa1==stringa2));
    	
    	// both intern and ==
    	String stringb1 = new String("b").intern();
    	String stringb2 = new String("b").intern();
    	
    	System.out.println("new String(\"b\").intern()==new String(\"b\").intern():" + (stringb1==stringb2));
    	
    	// first intern and ==
    	String stringc1 = new String("c").intern();
    	String stringc2 = new String("c");
    	
    	System.out.println("new String(\"c\").intern()==new String(\"c\"):" + (stringc1==stringc2));    	
    	
    	// second intern and ==
    	String stringd1 = new String("d");
    	String stringd2 = new String("d").intern();
    	
    	System.out.println("new String(\"d\")==new String(\"d\").intern():" + (stringd1==stringd2));      	
    	
    	// ==
    	String stringe1 = "e";
    	String stringe2 = "e";
    	
    	System.out.println("\"e\"==\"e\":" + (stringe1==stringe2));   	
    	
    	// ==
    	String stringf1 = new String("f");
    	String stringf2 = "f";
    	
    	System.out.println("new String(\"f\")==\"f\":" + (stringf1==stringf2));
    	
    	// ==
    	String stringg1 = "g";
    	String stringg2 = new String("g");
    	
    	System.out.println("\"g\"==new String(\"g\"):" + (stringg1==stringg2));

    	// first intern and ==
    	String stringh1 = new String("h").intern();
    	String stringh2 = "h";
    	
    	System.out.println("new String(\"h\").intern()==\"h\"):" + (stringh1==stringh2));    	
    	
    	// second intern and ==
    	String stringi1 = "i";
    	String stringi2 = new String("i").intern();
    	
    	System.out.println("\"i\"==new String(\"i\").intern():" + (stringi1==stringi2));      	
    	
    }
}
