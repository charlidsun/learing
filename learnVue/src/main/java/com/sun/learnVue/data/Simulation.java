package com.sun.learnVue.data;

import java.util.ArrayList;
import java.util.List;

import com.sun.learnVue.bean.BannerBean;
import com.sun.learnVue.bean.Recommend;
import com.sun.learnVue.bean.SongSheet;

public class Simulation {


	public static List<BannerBean> bannerBeanO = new ArrayList<>();
	public static List<Recommend> recommendList = new ArrayList<>();
	public static List<SongSheet> sheetList = new ArrayList<>();
	
	public static List<BannerBean> bannerBeanT = new ArrayList<>();
	
	static {	
		bannerBeanO.add(new BannerBean(1,"jack","http://p1.music.126.net/c_zPFD3IfqgoTeMAZOztmw==/109951163523565880.jpg"));
		bannerBeanO.add(new BannerBean(2,"lucy","http://p1.music.126.net/bB_VA4UQ3SCn2y9YWUES7Q==/109951163523220974.jpg"));
		bannerBeanO.add(new BannerBean(3,"when","http://p1.music.126.net/hLQQkwDjKs5aM36M9EXvOw==/109951163523265934.jpg"));
		
		sheetList.add(new SongSheet(1, "你是我散在风中最美的诗句", "http://p1.music.126.net/k4Jrv1yy_kRKAIEMx3yAzg==/19237055440199009.jpg?param=140y140"));
		sheetList.add(new SongSheet(2, "你是我散在风中最美的诗句", "http://p1.music.126.net/ObCXLNAOZ7p9ILyRWzwr1Q==/109951163510160013.jpg?param=140y140"));
		sheetList.add(new SongSheet(3, "你是我散在风中最美的诗句", "http://p1.music.126.net/qWFqUDaqmuXtxGVahEOcDg==/109951163500933771.jpg?param=140y140"));
		sheetList.add(new SongSheet(4, "你是我散在风中最美的诗句", "http://p1.music.126.net/qWkGZeU6UXyY7zYzmw3jIQ==/109951163517846808.jpg?param=140y140"));
		sheetList.add(new SongSheet(5, "你是我散在风中最美的诗句", "http://p1.music.126.net/9QX1DXgY-mhxlrB8PzsDPg==/18970973626224496.jpg?param=140y140"));
		sheetList.add(new SongSheet(6, "你是我散在风中最美的诗句", "http://p1.music.126.net/dIAXgjQ2udnOWYXbO_NSfg==/109951163521804842.jpg?param=140y140"));
		sheetList.add(new SongSheet(7, "你是我散在风中最美的诗句", "http://p1.music.126.net/LntQ-_hqbLrIiO7w1bqxCw==/109951163443431904.jpg?param=140y140"));
		sheetList.add(new SongSheet(8, "你是我散在风中最美的诗句", "http://p1.music.126.net/e4yuFgCV0y4oHkM5XU-drg==/109951163520625611.jpg?param=140y140"));
		recommendList.add(new Recommend(1, "tuijian", sheetList));
		recommendList.add(new Recommend(2, "haowu", sheetList));
		recommendList.add(new Recommend(3, "zhiliao", sheetList));
	
	}
}
