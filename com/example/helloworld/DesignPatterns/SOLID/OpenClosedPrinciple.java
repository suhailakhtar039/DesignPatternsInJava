package com.example.helloworld.DesignPatterns.SOLID;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
}
// open closed principle
interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class BetterFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p->spec.isSatisfied(p));
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);
        List<Product> products = Arrays.asList(apple, tree, house);
        ProductFilter productFilter = new ProductFilter();
        System.out.println("Green Product(old)");
        productFilter.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println("- " + p.name + " is Green"));

        System.out.println("Green Product(new)");
        BetterFilter bf = new BetterFilter();
        bf.filter(products,new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println("- " + p.name + " is Green"));
    }
}
