package com.example.websocket_blockchain_demo.myinterfaces;

import com.example.websocket_blockchain_demo.model.BitcoinModel;

import java.util.ArrayList;

public interface StatusListenerInterface {
    void updateConnectionStatus(String s);
    void dataFetched(ArrayList<BitcoinModel> dataList);
    void dataFetched(BitcoinModel model);
    void dataFetched(String data);
}
