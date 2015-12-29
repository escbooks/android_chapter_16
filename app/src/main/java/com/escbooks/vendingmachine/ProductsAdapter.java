package com.escbooks.vendingmachine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(Context context, List<Product> data) {
        super(context, R.layout.row_products, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_products, parent, false);
        }

        if (product != null) {
            ((TextView) convertView.findViewById(R.id.product_name)).setText(product.getName());

            String priceString = "£".concat(String.valueOf(product.getPrice()));
            ((TextView) convertView.findViewById(R.id.product_price)).setText(priceString);

            ((TextView) convertView.findViewById(R.id.product_description)).setText(product.getDescription());
        }

        return convertView;
    }
}
