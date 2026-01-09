package TP2_Collections_Streams_Generics.Generics.Exercise2;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Product> {
    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product o) {
        products.add(o);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        products.removeIf(p -> p.getId() == id);
    }
}
