package com.example.kluxury.utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderFilter {
    public static final String PROVINCE_ID = "province_id";
    public static final String DISTRICT_ID = "district_id";
    public static final String WARD_ID = "ward_id";
    public static final String STATUS = "status";
    public static final String USER_ID = "user_id";
    public static final String CREATED_AT = "created_at";

    private int id;
    private int province_id;
    private int district_id;
    private int ward_id;
    private int user_id;
    private LocalDate created_at;
    private int page;
    private int pageSize;


    public static final class OrderFilterBuilder {
        private int id;
        private int province_id;
        private int district_id;
        private int ward_id;
        private int user_id;
        private LocalDate created_at;
        private int page;
        private int pageSize;

        private OrderFilterBuilder() {
        }

        public static OrderFilterBuilder anOrderFilter() {
            return new OrderFilterBuilder();
        }

        public OrderFilterBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public OrderFilterBuilder withProvince_id(int province_id) {
            this.province_id = province_id;
            return this;
        }

        public OrderFilterBuilder withDistrict_id(int district_id) {
            this.district_id = district_id;
            return this;
        }

        public OrderFilterBuilder withWard_id(int ward_id) {
            this.ward_id = ward_id;
            return this;
        }

        public OrderFilterBuilder withUser_id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public OrderFilterBuilder withCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public OrderFilterBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public OrderFilterBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public OrderFilter build() {
            OrderFilter orderFilter = new OrderFilter();
            orderFilter.setId(id);
            orderFilter.setProvince_id(province_id);
            orderFilter.setDistrict_id(district_id);
            orderFilter.setWard_id(ward_id);
            orderFilter.setUser_id(user_id);
            orderFilter.setCreated_at(created_at);
            orderFilter.setPage(page);
            orderFilter.setPageSize(pageSize);
            return orderFilter;
        }
    }
}
