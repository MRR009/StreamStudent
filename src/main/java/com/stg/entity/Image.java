package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;

	@Column
	private String imageName;

	@Column
	private String imageType;

	@Lob
	@Column
	private byte[] pic;

	public Image() {
		super();
	}

	public Image(long imageId, String imageName, String imageType, byte[] pic) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.pic = pic;
	}

	public Image(String imageName, String imageType, byte[] pic) {
		super();
		this.imageName = imageName;
		this.imageType = imageType;
		this.pic = pic;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long galleryId) {
		this.imageId = galleryId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
