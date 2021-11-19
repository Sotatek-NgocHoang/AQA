package com.AQA.common;

import com.AQA.pages.Products;

import java.util.Comparator;

public class SortProduct implements Comparator<Products> {
    public int compare(Products product1, Products product2) {
        return product1.price - product2.price;
    }
}
