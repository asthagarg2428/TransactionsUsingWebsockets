package com.example.websocket_blockchain_demo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.websocket_blockchain_demo.R;
import com.example.websocket_blockchain_demo.databinding.RowLayoutBinding;
import com.example.websocket_blockchain_demo.model.BitcoinModel;
import com.example.websocket_blockchain_demo.util.BlockchainCommonUtil;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder> {

    private List<BitcoinModel> list;
    private final Context context;

    TransactionsAdapter(List<BitcoinModel> list, Context context){
        this.list = list;
        this.context = context;
    }
    public void updateList(List<BitcoinModel> l){
        list = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.row_layout,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TransactionsAdapter.MyViewHolder holder, int position) {
        BitcoinModel model = list.get(position);
        holder.binding.time.setText(BlockchainCommonUtil.getTimeInString(model.getTime()));
        holder.binding.hash.setText(model.getHashCode());
        holder.binding.amount.setText(String.valueOf(model.getTransactionAmount()));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public RowLayoutBinding binding;
        public MyViewHolder(RowLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
