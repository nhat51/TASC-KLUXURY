package com.example.kluxury.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilter {
    public static final String CATEGORY_ID = "category_id";
    public static final String BRAND_ID = "brand_id";
    public static final String PRICE = "price";
    public static final String NAME = "name";
    public static final String STATUS = "is_delete";

    private int id;
    private int category_id;
    private int brand_id;
    private double minPrice;
    private double maxPrice;
    private int page;
    private int pageSize;
    private String nameProduct;

    public static final class ProductFilterBuilder {
        private int id;
        private int category_id;
        private int brand_id;
        private double minPrice;
        private double maxPrice;
        private int page;
        private int pageSize;
        private String nameProduct;

        private ProductFilterBuilder() {
        }

        public static ProductFilterBuilder aProductFilter() {
            return new ProductFilterBuilder();
        }

        public ProductFilterBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ProductFilterBuilder withCategory_id(int category_id) {
            this.category_id = category_id;
            return this;
        }

        public ProductFilterBuilder withBrand_id(int brand_id) {
            this.brand_id = brand_id;
            return this;
        }

        public ProductFilterBuilder withMinPrice(double minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public ProductFilterBuilder withMaxPrice(double maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public ProductFilterBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public ProductFilterBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ProductFilterBuilder withNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
            return this;
        }

        public ProductFilter build() {
            ProductFilter productFilter = new ProductFilter();
            productFilter.setId(id);
            productFilter.setCategory_id(category_id);
            productFilter.setBrand_id(brand_id);
            productFilter.setMinPrice(minPrice);
            productFilter.setMaxPrice(maxPrice);
            productFilter.setPage(page);
            productFilter.setPageSize(pageSize);
            productFilter.setNameProduct(nameProduct);
            return productFilter;
        }
    }
}
