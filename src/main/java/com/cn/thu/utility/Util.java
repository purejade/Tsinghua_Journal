package com.cn.thu.utility;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-4
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    static public boolean isEmpty(String s){
        return (s == null || s.length()==0 || s.trim().equals("") || s.trim().toLowerCase().equals("null"));
    }
    static public String string2Json(String s){
        if (isEmpty(s)) return "";
        StringBuffer buf=new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch(c){
                case '\"':
                    buf.append("\\\"");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                case '/':
                    buf.append("\\/");
                    break;
                case '\b':
                    buf.append("\\b");
                    break;
                case '\f':
                    buf.append("\\f");
                    break;
                case '\n':
                    buf.append("\\n");
                    break;
                case '\r':
                    buf.append("\\r");
                    break;
                case '\t':
                    buf.append("\\t");
                    break;
                default:
                    buf.append(c);
            }
        }
        return buf.toString();
    }

   public static boolean isContainSpace(String str) {
        if(!isEmpty(str)) {
            if(str.indexOf(" ") != -1) return  true;
        }
            return false;
    }
}
