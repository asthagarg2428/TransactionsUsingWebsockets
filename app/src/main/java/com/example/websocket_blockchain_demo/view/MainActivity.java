package com.example.websocket_blockchain_demo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.example.websocket_blockchain_demo.R;
import com.example.websocket_blockchain_demo.databinding.ActivityMainBinding;
import com.example.websocket_blockchain_demo.model.BitcoinModel;
import com.example.websocket_blockchain_demo.util.BlockchainCommonUtil;
import com.example.websocket_blockchain_demo.viewmodel.BlockchainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LiveData<String> connectionStatus;
    private LiveData<List<BitcoinModel>> recentTransactions;
    private TransactionsAdapter adapter;

    private BlockchainViewModel viewModel;
    private ActivityMainBinding binding;
    private boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(BlockchainViewModel.class);
        connectionStatus = viewModel.establishConnection();
        observeStatus();
        setClickListeners();
    }

    private void observeStatus() {
        connectionStatus.observe(this, s -> {
            Log.d(BlockchainCommonUtil.APP_TAG, "observeStatus status = " + s);
            if (!TextUtils.isEmpty(s))
                binding.status.setText(s);
            fetchRecentTransactions(s);


        });
    }

    private void observeRecentTransactions() {
        recentTransactions.observe(this, bitcoinModels -> {
            if (adapter == null) {
                adapter = new TransactionsAdapter(bitcoinModels, MainActivity.this);
                binding.transactionsRv.setAdapter(adapter);
            } else {
                adapter.updateList(bitcoinModels);
                adapter.notifyDataSetChanged(); // can be optimzed with diffutil
            }

        });
    }

    private void fetchRecentTransactions(String status) {
        if (isFirstTime && BlockchainCommonUtil.CONNECTION_CONNECTED.equals(status)) {
            recentTransactions = viewModel.fetchTransactions();
            isFirstTime = false;
            observeRecentTransactions();
        }
    }

    private void setClickListeners() {
        binding.clearAllBtn.setOnClickListener(v -> {
            viewModel.clearAllTransactions();
        });
    }
}