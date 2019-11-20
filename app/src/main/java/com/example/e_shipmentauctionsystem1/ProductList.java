package com.example.e_shipmentauctionsystem1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductList extends ArrayAdapter<Product> {
    private Activity context;
    private List<Product> productList;

    public ProductList(Activity context, List<Product> productList) {
        super(context, R.layout.list_layout_2, productList);
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();

        View listViewItem= inflater.inflate(R.layout.list_layout_2, null, true);

        TextView tvWeight=(TextView) listViewItem.findViewById(R.id.tvWeight);
        TextView tvLength=(TextView) listViewItem.findViewById(R.id.tvLength);
        TextView tvWidth=(TextView) listViewItem.findViewById(R.id.tvWidth);
        TextView tvHeight=(TextView) listViewItem.findViewById(R.id.tvHeight);

        Product pr2= productList.get(position);

        tvWeight.setText(pr2.getPrWeight());
        tvLength.setText(pr2.getPrLength());
        tvWidth.setText(pr2.getPrWidth());
        tvHeight.setText(pr2.getPrHeight());

        return listViewItem;
    }
}

