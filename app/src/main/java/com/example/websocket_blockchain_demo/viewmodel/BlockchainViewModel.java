package com.example.websocket_blockchain_demo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.websocket_blockchain_demo.model.BitcoinModel;

import java.util.List;

public class BlockchainViewModel extends ViewModel {

    public LiveData<String> connectionStatus;
    public LiveData<List<BitcoinModel>> recentTransactions;
    public BlockchainViewModel(){

    }

    public LiveData<String> establishConnection(){
        connectionStatus = BlockchainRepo.getInstance().establishConnection();
        return connectionStatus;
    }
    public LiveData<List<BitcoinModel>> fetchTransactions(){
        recentTransactions =  BlockchainRepo.getInstance().fetchTransactions();
        return recentTransactions;
    }
    public void clearAllTransactions(){
        BlockchainRepo.getInstance().clearAllTransactions();
    }
}
