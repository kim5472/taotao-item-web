package com.taotao.item.pojo;

import java.io.Serializable;

import com.taotao.pojo.TbItem;

public class Item extends TbItem implements Serializable{

	public Item(TbItem tbItem){
		// 初始化属性
		this.setId(this.getId());
		this.setTitle(this.getTitle());
		this.setSellPoint(this.getSellPoint());
		this.setPrice(this.getPrice());
		this.setNum(this.getNum());
		this.setBarcode(this.getBarcode());
		this.setImage(this.getImage());
		this.setCid(this.getCid());
		this.setStatus(this.getStatus());
		this.setCreated(this.getCreated());
		this.setUpdated(this.getUpdated());
	}
	public String[] getImages(){

		if (this.getImages()!=null&&!"".equals(this.getImages())){
			String image2 = this.getImage();
			String[] strings = image2.split(",");
			return strings;
		}
		return null;
	}
}
