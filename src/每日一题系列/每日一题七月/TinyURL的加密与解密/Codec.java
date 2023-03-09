package 每日一题系列.每日一题七月.TinyURL的加密与解密;

import java.util.Random;

public class Codec {
    // Encodes a URL to a shortened URL.
    public  String tiny="";
    public  String first="";
    public  String second="";
    public  String key="";
    public  String host="https:";
    public  String next="//tinyurl.com";
    public String encode(String longUrl)   {
     Random random=new Random();
     int len = random.nextInt(10);
        key  = getRandomString(len);
        first=longUrl;
        second=host+next+"/"+key;
        return second;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortUrl.equals(second)){
            return first;
        }
        else {
            return null;
        }
    }
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
