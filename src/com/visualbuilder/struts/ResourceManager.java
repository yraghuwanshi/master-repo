package com.visualbuilder.struts;
//test
//
import java.util.ResourceBundle;

/*
 * @author VisualBuilder
 */

public class ResourceManager {
	private static ResourceBundle bundle = ResourceBundle.getBundle("com.visualbuilder.struts.ApplicationResources");
	
	public static String getString(String key){
		return bundle.getString(key);
	}	
}


