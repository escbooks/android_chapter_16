package com.escbooks.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        List<Product> productList = getProducts();

        ProductsAdapter adapter = new ProductsAdapter(ProductsActivity.this, productList);

        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Product productSelected = (Product) adapterView.getItemAtPosition(i);

                Intent intent = new Intent();
                intent.putExtra("PRODUCT_NAME", productSelected.getName());
                intent.putExtra("PRICE", productSelected.getPrice());
                intent.putExtra("STOCK", 5);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    private List<Product> getProducts() {
        final List<Product> productList = new ArrayList<>();

        // WATER
        Product productWater = new Product();
        productWater.setName(getString(R.string.water));
        productWater.setPrice(Float.parseFloat(getString(R.string.water_price)));
        productWater.setDescription(getString(R.string.water_description));
        productList.add(productWater);

        // COKE
        Product productCoke = new Product();
        productCoke.setName(getString(R.string.coke));
        productCoke.setPrice(Float.parseFloat(getString(R.string.coke_price)));
        productCoke.setDescription(getString(R.string.coke_description));
        productList.add(productCoke);

        // CRISPS
        Product productCrisps = new Product();
        productCrisps.setName(getString(R.string.crisps));
        productCrisps.setPrice(Float.parseFloat(getString(R.string.crisps_price)));
        productCrisps.setDescription(getString(R.string.crisps_description));
        productList.add(productCrisps);

        // SNICKERS
        Product productSnickers = new Product();
        productSnickers.setName(getString(R.string.snickers));
        productSnickers.setPrice(Float.parseFloat(getString(R.string.snickers_price)));
        productSnickers.setDescription(getString(R.string.snickers_description));
        productList.add(productSnickers);

        return productList;
    }
}
