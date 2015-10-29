package com.threenoodles.utils;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.threenoodles.constants.Constants;

public class ImageUtil {
	
	private static final Logger LOGGER = Logger.getLogger(ImageUtil.class);
	
	/**
	 * 
	* @Title: thumbFile 
	* @Description: 缩略图
	* @param  orginalFile
	* @param  scale
	* @return 数组，0项为服务器原图url，1项为服务器缩略图url
	 */
	public static String[] thumbFile(CommonsMultipartFile orginalFile,Float scale,String picName) throws Exception {
		try{
			String sourceSrc = Constants.PIC_ORIGIN_SERVER_URL+picName;
        	String toSrc = Constants.PIC_ZOOM_SERVER_URL+picName;
            File localFile = new File(sourceSrc); 
			orginalFile.transferTo(localFile);
			ImageUtil.zoomScale(scale, sourceSrc, toSrc);
			return new String[]{Constants.PIC_OPPOSITE_ORIGIN_SERVER_URL+picName,Constants.PIC_OPPOSITE_ZOOM_SERVER_URL+picName};
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * 
	* @Title: saveFile 
	* @Description: 保存图片
	* @param  orginalFile
	 */
	public static String saveFile(CommonsMultipartFile orginalFile,String imageName){
		String sourcePath = Constants.PIC_ORIGIN_SERVER_URL+imageName;
		try{
            File localFile = new File(sourcePath); 
			orginalFile.transferTo(localFile);
			return Constants.PIC_OPPOSITE_ORIGIN_SERVER_URL+imageName;
		}catch(Exception ex){
			LOGGER.error("ImageUtil.saveFile error",ex);
		}
		return "";
	}
	
	/**
	 * 
	* @Title: thumbFile 
	* @Description: 保存原图和缩略图
	* @param  orginalFile
	 */
	public static String thumbFile(CommonsMultipartFile orginalFile){
		String imageName = ShortUUID.getImageName();
		String sourcePath = Constants.PIC_ORIGIN_SERVER_URL+imageName;
		String zoomPath = Constants.PIC_ZOOM_SERVER_URL+imageName;
		try{
            File localFile = new File(sourcePath); 
			orginalFile.transferTo(localFile);
			ImageUtil.zoomScale(Constants.PIC_ZOOM_SCALE, sourcePath, zoomPath);
			return Constants.PIC_OPPOSITE_ZOOM_SERVER_URL+imageName;
		}catch(Exception ex){
			LOGGER.error("ImageUtil.thumbFile error",ex);
		}
		return "";
	}
	
	public static String thumbFile(String imageName,int width, int height){
		String sourcePath = Constants.PIC_CUT_SERVER_URL+imageName;
		String zoomPath = Constants.PIC_ZOOM_SERVER_URL+imageName;
		try{
			cutForPosition(width, height, Positions.CENTER, sourcePath, zoomPath);
			return Constants.PIC_OPPOSITE_ZOOM_SERVER_URL+imageName;
		}catch(Exception ex){
			LOGGER.error("ImageUtil.cutFile error",ex);
		}
		return "";
	}
	
	
	
	/**
	 * 
	* @Title: zoom 
	* @Description: 指定大小缩放
	* @param  width
	* @param  height
	* @param  soureSrc
	* @param  toSrc 
	 */
	public static void zoom(int width,int height,String sourceSrc,String toSrc){
		try {
			Thumbnails.of(sourceSrc).size(width, height).toFile(toSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: zoomScale 
	* @Description: 指定大小缩放
	* @param  scale
	* @param  soureSrc
	* @param  toSrc
	 */
	public static void zoomScale(float scale,String sourceSrc,String toSrc){
		try {
			Thumbnails.of(sourceSrc).scale(scale).toFile(toSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: zoomNoScale 
	* @Description: 不按照比例，指定大小进行缩放
	* @param  width
	* @param  height
	* @param  soureSrc
	* @param  toSrc 
	 */
	public static void zoomNoScale(int width,int height,String sourceSrc,String toSrc){
		try {
			Thumbnails.of(sourceSrc).size(width, height).keepAspectRatio(false).toFile(toSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: cutForPosition 
	* @Description: 裁剪并压缩图片
	* @param  cutWidth
	* @param  cutHeight
	* @param  width
	* @param  height
	* @param  Positions   Positions.CENTER,Positions.TOP_LEFT...
	* @param  soureSrc
	* @param  toSrc
	* @return
	 */
	public static void cutForPosition(int cutWidth,int cutHeight, int width,int height,Positions positions,String sourceSrc,String toSrc){
		try {
			Thumbnails.of(sourceSrc).
			sourceRegion(positions, cutWidth,cutHeight).
			size(width, height).
			keepAspectRatio(false).
			toFile(toSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	* @Title: cutForPosition 
	* @Description: 裁剪图片
	* @param  cutWidth
	* @param  cutHeight
	* @param  positions
	* @param  sourceSrc
	* @param  toSrc
	 */
	public static void cutForPosition(int cutWidth,int cutHeight,Positions positions,String sourceSrc,String toSrc) throws IOException{
		try {
			Thumbnails.of(sourceSrc).
			sourceRegion(positions, cutWidth,cutHeight).
			scale(1.0f).
			toFile(toSrc);
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * 
	* @Title: imageFomart 
	* @Description: 输出其他格式的图片
	* @param  width
	* @param  height
	* @param  format
	* @param  soureSrc
	* @param  toSrc 
	 */
	public static void imageFomart(int width,int height,String format,String sourceSrc,String toSrc){
		try {
			Thumbnails.of(sourceSrc).size(width, height).outputFormat(format).toFile(toSrc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		String sourceSrc = "/Users/xiaoman/picture/pic/big.jpg";
		String toSrc = "/Users/xiaoman/picture/pic/big-zoom.jpg";
		zoomScale(0.25f,sourceSrc,toSrc);
//		zoom(200,200,sourceSrc,toSrc);
//		cutForPosition(400, 400, 200, 200, Positions.CENTER, sourceSrc, toSrc);
//		cutForPosition(300, 300, Positions.CENTER, sourceSrc, toSrc);
	}
	
	
}
