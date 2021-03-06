package com.kpos.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a sale item that a customer can order.
 *
 * Created by kpos.
 * Author: kkwang
 * Date: 3/9/12 10:47 PM
 */
@NamedQueries({
        @NamedQuery(
                name = "findBySaleItemName",
                query = "from SaleItem s where s.menuCategory.id = :aCatId and s.name = :aName"
        ),
        @NamedQuery(
                name = "listSaleItemsByCatNameAsc",
                query = "from SaleItem s where s.menuCategory.id = :aCatId order by s.name asc"
        )
})
@Entity
@Table(name = "SALE_ITEM")
public class SaleItem extends AbstractDomainObject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "price_small", nullable = true)
    private double priceSmall;

    @Column(name = "price_medium", nullable = true)
    private double priceMedium;

    @Column(name = "price_large", nullable = true)
    private double priceLarge;

    @Column(name = "is_allowed_hh", nullable = false)
    private boolean isAllowedHH = false; //is item allowed for happy hour?

    @Column(name = "hh_rate", nullable = true)
    private double hhRate = 1; //happy hour rate

    @Column(name = "hh_price", nullable = true)
    private double hh_price;

    //owning entity
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private MenuCategory menuCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleItem", orphanRemoval = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "OPTION_2_ITEM_FK")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SaleItemOption> optionList = new ArrayList<SaleItemOption>();

    @Column(name = "out_price")
    private double outPrice; //take-out price

    @Column(name = "out_small", nullable = true)
    private double outPriceSmall;

    @Column(name = "out_medium", nullable = true)
    private double outPriceMed;

    @Column(name = "out_large", nullable = true)
    private double outPriceLarge;

    @Column(name = "season_price", nullable = true)
    private double seasonPrice;

    @Column(name = "single_option_only")
    private boolean singleOptionOnly = false; //whether user can select only a single option or multiple

    @Column(name = "is_taxable")
    private boolean isTaxable = true;

    @Column(name = "thumb_path", nullable = true)
    private String thumbPath;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToMany
    @JoinTable(
           name = "ITEM_PRINTER_ASSOC",
           joinColumns = @JoinColumn(name = "SALE_ITEM_ID"),
           inverseJoinColumns = @JoinColumn(name = "PRINTER_ID")
    )
    @ForeignKey(name = "ITEM_2_PRINTER_FK", inverseName = "PRINTER_2_ITEM_FK")
    private Set<Printer> printers = new HashSet<Printer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAllowedHH() {
        return isAllowedHH;
    }

    public void setAllowedHH(boolean allowedHH) {
        isAllowedHH = allowedHH;
    }

    public double getHhRate() {
        return hhRate;
    }

    public void setHhRate(double hhRate) {
        this.hhRate = hhRate;
    }

    public double getHh_price() {
        return hh_price;
    }

    public void setHh_price(double hh_price) {
        this.hh_price = hh_price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory category) {
        this.menuCategory = category;
    }

    public List<SaleItemOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<SaleItemOption> optionList) {
        this.optionList = optionList;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public boolean isSingleOptionOnly() {
        return singleOptionOnly;
    }

    public void setSingleOptionOnly(boolean singleOptionOnly) {
        this.singleOptionOnly = singleOptionOnly;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable) {
        isTaxable = taxable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public Set<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(Set<Printer> printers) {
        this.printers = printers;
    }

    public double getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(double priceSmall) {
        this.priceSmall = priceSmall;
    }

    public double getPriceMedium() {
        return priceMedium;
    }

    public void setPriceMedium(double priceMedium) {
        this.priceMedium = priceMedium;
    }

    public double getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(double priceLarge) {
        this.priceLarge = priceLarge;
    }

    public double getOutPriceSmall() {
        return outPriceSmall;
    }

    public void setOutPriceSmall(double outPriceSmall) {
        this.outPriceSmall = outPriceSmall;
    }

    public double getOutPriceMed() {
        return outPriceMed;
    }

    public void setOutPriceMed(double outPriceMed) {
        this.outPriceMed = outPriceMed;
    }

    public double getOutPriceLarge() {
        return outPriceLarge;
    }

    public void setOutPriceLarge(double outPriceLarge) {
        this.outPriceLarge = outPriceLarge;
    }

    public double getSeasonPrice() {
        return seasonPrice;
    }

    public void setSeasonPrice(double seasonPrice) {
        this.seasonPrice = seasonPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleItem saleItem = (SaleItem) o;

        if (Double.compare(saleItem.hhRate, hhRate) != 0) return false;
        if (Double.compare(saleItem.hh_price, hh_price) != 0) return false;
        if (isAllowedHH != saleItem.isAllowedHH) return false;
        if (Double.compare(saleItem.price, price) != 0) return false;
        if (menuCategory != null ? !menuCategory.equals(saleItem.menuCategory) : saleItem.menuCategory != null) return false;
        if (id != null ? !id.equals(saleItem.id) : saleItem.id != null) return false;
        if (name != null ? !name.equals(saleItem.name) : saleItem.name != null) return false;
        if (description != null ? !description.equals(saleItem.description) : saleItem.description != null) return false;
        if (thumbPath != null ? !thumbPath.equals(saleItem.thumbPath) : saleItem.thumbPath != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (thumbPath != null ? thumbPath.hashCode() : 0);
        temp = price != +0.0d ? Double.doubleToLongBits(price) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isAllowedHH ? 1 : 0);
        temp = hhRate != +0.0d ? Double.doubleToLongBits(hhRate) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = hh_price != +0.0d ? Double.doubleToLongBits(hh_price) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (menuCategory != null ? menuCategory.hashCode() : 0);
        return result;
    }
}
