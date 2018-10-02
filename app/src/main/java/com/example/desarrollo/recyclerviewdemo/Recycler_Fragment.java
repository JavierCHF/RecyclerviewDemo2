package com.example.desarrollo.recyclerviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Recycler_Fragment extends Fragment {

    public static Fragment newInstance() {

        return new Recycler_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment,container,false);
        List<String> list = new ArrayList<>();
        list.add("Lic. Luis García");
        list.add("Lic. Perla Jiménez");
        list.add("Lic. María Gutierrez");
        list.add("Dr. Claudia López");
        list.add("Lic. Pedro Pérez");
        List<String> listImage = new ArrayList<>();
        listImage.add("https://farm2.staticflickr.com/1877/30901028688_af3e376158_k.jpg");
        listImage.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        listImage.add( "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        listImage.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        listImage.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        ImageView i = view.findViewById(R.id.image_holder);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list,i));




        Bitmap bmp = null;
        try {
             bmp = BitmapFactory.decodeStream((InputStream)new URL("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg").getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        i.setImageBitmap(bmp);



        return view;

    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView mTextView;
        private ImageView mImageView;

        public RecyclerViewHolder(View itemView){
            super (itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view,container,false));

            mCardView = itemView.findViewById(R.id.card_container);
            mTextView = itemView.findViewById(R.id.text_holder);
            mImageView = itemView.findViewById(R.id.image_holder);
        }

    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        List<String> mList;
        List<String> mListImage;
        ImageView i;

        public RecyclerViewAdapter(List<String> list,ImageView i){
            this.mList = list;
            this.i = i;

        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {

           recyclerViewHolder.mTextView.setText(mList.get(i));
            recyclerViewHolder.mTextView.setText(mListImage.get(i));


        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

    }



}
