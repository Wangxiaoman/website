package com.threenoodles.grab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GraberJdTech {
	
	public static final String JD_TECH = "http://weixin.sogou.com/gzh?openid=oIWsFt5dykswjlJ5YEmzWu1Lwfpc";
	public static final String TITLE_CLASS = "news_lst_tab";
	
	public static List<String> getArticleUrl(){
		try {
			Document doc = Jsoup.connect(JD_TECH).get();
			System.out.println("doc:"+doc);
			//根据文章样式取文章的url
			Elements urls = doc.select("."+TITLE_CLASS);
			System.out.println("url:"+urls);
			if(urls != null){
				List<String> result = new ArrayList<String>();
				for(int i=0 ;i<urls.size();i++){
					Element element = urls.get(i);
					System.out.println("ele:"+element);
					String articleUrl = element.select("a[href]").first().attr("href");
					System.out.println("articleUrl:"+articleUrl);
					result.add(articleUrl);
				}
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	public static void main(String[] args) {
		getArticleUrl();
	}

}
