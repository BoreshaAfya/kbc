package app.amaroll.loise.kbc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.amaroll.loise.kbc.Adapter;
import app.amaroll.loise.kbc.Data;
import app.amaroll.loise.kbc.ProductsData;
import app.amaroll.loise.kbc.R;

/**
 * Created by loise on 9/22/15.
 */
public class NewsUpdates extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<ProductsData> products;
    public static View.OnClickListener myOnClickListener;
    //private static ArrayList<Integer> removedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_fragment, container, false);

        //Set the Onclick Listener

        myOnClickListener = new MyOnclickListener(getActivity());
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        products = new ArrayList<ProductsData>();
        //Loop around the array of products
        for (int i = 0; i < Data.nameArray.length; i++) {

            products.add(new ProductsData(
                    Data.nameArray[i],
                    Data.descriptionArray[i],
                    Data.priceArray[i],
                    Data.drawableArray[i],
                    Data.id_[i]

            ));

        }
        // removedItems = new ArrayList<Integer>();
        adapter = new Adapter(products);
        recyclerView.setAdapter(adapter);

        return v;
    }

    private static class MyOnclickListener implements View.OnClickListener {

        private final Context context;

        private MyOnclickListener(Context context) {
            this.context = context;

        }


        @Override
        public void onClick(View v) {
            //removeItem(v);
        }
//
//        private void removeItem(View v) {
//            int selectedItemPosition = recyclerView.getChildPosition(v);
//            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemPosition);
//            TextView textViewProductName = (TextView) viewHolder.itemView.findViewById(R.id.name);
//            String selectedName = (String) textViewProductName.getText();
//            int selectedItemId = -1;
//
//            for (int i = 0; i < Data.nameArray.length; i++) {
//                if (selectedName.equals(Data.nameArray[i])) {
//                    selectedItemId = Data.id_[i];
//                }
//            }
//            //removedItems.add(selectedItemId);
//            products.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
//        }
//    }
//    private void addRemovedItemToList() {
//        int addItemAtListPosition = 3;
//        products.add(addItemAtListPosition, new ProductsData(
//                Data.nameArray[removedItems.get(0)],
//                Data.descriptionArray[removedItems.get(0)],
//                Data.priceArray[removedItems.get(0)],
//                Data.drawableArray[removedItems.get(0)],
//                Data.id_[removedItems.get(0)]
//        ));
//        adapter.notifyItemInserted(addItemAtListPosition);
//        removedItems.remove(0);
//    }

    }
}