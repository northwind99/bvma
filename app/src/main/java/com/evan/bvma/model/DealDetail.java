package com.evan.bvma.model;

/**
 * Created by Evan on 2016-10-03.
 */

public class DealDetail {

    String dealId;
    String retailerId;
    String locationId;
    String catCode;
    String itemName;
    String originalPrice;
    String discountPrice;
    String percentage;
    String units;
    String quantity;
    String imagePath;
    String imageFileName;
    String effectiveDate;
    String expiryDate;
    String active;
    String countOfViews;
    String description;

    public DealDetail(String dealId, String retailerId, String locationId, String catCode, String itemName, String originalPrice,
                      String discountPrice, String percentage, String units, String quantity, String imagePath, String imageFileName,
                      String effectiveDate, String expiryDate, String active, String countOfViews, String description) {
        this.dealId = dealId;
        this.retailerId = retailerId;
        this.locationId = locationId;
        this.catCode = catCode;
        this.itemName = itemName;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.percentage = percentage;
        this.units = units;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.imageFileName = imageFileName;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.active = active;
        this.countOfViews = countOfViews;
        this.description = description;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCountOfViews() {
        return countOfViews;
    }

    public void setCountOfViews(String countOfViews) {
        this.countOfViews = countOfViews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
