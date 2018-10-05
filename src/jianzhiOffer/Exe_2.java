package jianzhiOffer;

public class Exe_2 {
	StringBuffer strNew=new StringBuffer();
    public String replaceSpace(StringBuffer str) {
    	for(int i=0;i<str.length();i++){
            if((str.charAt(i)!=' '))
                strNew.append(str.charAt(i));
            else
                strNew.append("%20");
        }
        return strNew.toString();
    }
    public static void main(String[] args) {
    	StringBuffer str=new StringBuffer();
    	
	}
}
