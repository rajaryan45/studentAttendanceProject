package database;

import java.util.ArrayList;
import java.util.Arrays;

public class XMLFormatter {
	
	public String getSubjectNameXml(String subjects) {
		String subjXml = null;
		try {
			ArrayList<String>subjArrayList = new ArrayList<String>(Arrays.asList(subjects.split(",")));
			subjXml = "<Subjects>";
			for(int i = 0 ; i<subjArrayList.size() ; i++) {
				subjXml += "\n\t<sub"+(i+1)+">\n\t\t<name> "+subjArrayList.get(i) +" </name>\n\t</sub"+(i+1)+">";
			}
			subjXml += "\n</Subject>";
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage() + " : " );
			e.printStackTrace();
		}
		return subjXml;
	}
	
}
