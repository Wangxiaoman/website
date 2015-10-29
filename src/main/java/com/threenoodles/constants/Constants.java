package com.threenoodles.constants;

public class Constants {
	public static final String SERVER_URL = "/data/picture"; //本地测试地址 /Users/xiaoman/picture/
	
	public static final String HOME_URL = "http://120.25.245.232";
	
	public static final String PIC_ORIGIN_SERVER_URL = SERVER_URL+"/pic/";//原图存放地址
	public static final String PIC_CUT_SERVER_URL = SERVER_URL+"/cut/";//剪裁之后图片存放地址
	public static final String PIC_ZOOM_SERVER_URL = SERVER_URL+"/thumb/";//缩略图存放地址
	
	public static final float PIC_ZOOM_SCALE = 0.2f;//缩略图原图缩略比例
	
	public static final String PIC_OPPOSITE_ORIGIN_SERVER_URL = HOME_URL+"/picture/pic/";//原图url
	public static final String PIC_OPPOSITE_CUT_SERVER_URL = HOME_URL+"/picture/cut/";//剪裁之后图片url
	public static final String PIC_OPPOSITE_ZOOM_SERVER_URL = HOME_URL+"/picture/thumb/";//缩略图片url
	
	public static final int PIC_CUT_WIDTH = 500;
	public static final int PIC_CUT_HEIGHT = 500;
	
	public static final int PIC_ZOOM_WIDTH = 200;
	public static final int PIC_ZOOM_HEIGHT = 200;
	
	public static final int SOURCE_HUXIU = 1;
	public static final int SOURCE_IFEVE = 2;
	public static final int SOURCE_36KR = 3;
	public static final int SOURCE_WEIXIN = 4;
	
	public static final int ARTICLE_TYPE_NEWS = 0;
	public static final int ARTICLE_TYPE_TECH = 1;
	
	public static  String WEIXIN_TOKEN = "chuangbar";
	
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	
	public static final String WEIXIN_MENU_TECH = "V1001_TODAY_TECH";
	public static final String WEIXIN_MENU_NEWS = "V1001_TODAY_NEWS";
	public static final String WEIXIN_MENU_MONEY = "V1001_GOOD";
	public static final String WEIXIN_MENU_APP = "V1001_TODAY_MUSIC";
	public static final String BASE_ARTICLE_URL = "http://weixin.chuangbar.me/article/";
	public static final String BASE_INNEST_URL = "http://weixin.chuangbar.me/invest/";
	public static final String BASE_CAREER_URL = "http://weixin.chuangbar.me/career/";
	
	public static final String BASE_INVEST_IMAGE_URL = "http://ww2.sinaimg.cn/large/005A1rQbgw1eivquar7w3j31hc0xcx6p.jpg";
	

	
}
