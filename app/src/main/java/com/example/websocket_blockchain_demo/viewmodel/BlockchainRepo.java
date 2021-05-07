package com.example.websocket_blockchain_demo.viewmodel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.websocket_blockchain_demo.model.BitcoinModel;
import com.example.websocket_blockchain_demo.model.RootResponseModel;
import com.example.websocket_blockchain_demo.myinterfaces.StatusListenerInterface;
import com.example.websocket_blockchain_demo.util.BlockchainCommonUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class BlockchainRepo implements StatusListenerInterface {

    private static BlockchainRepo repo;
    private WebSocket ws;
    public MutableLiveData<String> connectionStatus;
    public MutableLiveData<List<BitcoinModel>> recentTransactions;
    private List<BitcoinModel> list;

    private final OkHttpClient client;

    private BlockchainRepo(){
        client = new OkHttpClient();
        connectionStatus = new MutableLiveData<>(BlockchainCommonUtil.CONNECTION_CONNECTING);
        recentTransactions = new MutableLiveData<>();
        list = new ArrayList<>(BlockchainCommonUtil.MAX_COUNT);
    }

    public static BlockchainRepo getInstance(){
        if(repo == null){
            repo = new BlockchainRepo();
        }
        return repo;
    }

    // can be moved later
    public LiveData<String> establishConnection() {
        Request request = new Request.Builder().url("wss://ws.blockchain.info/inv").build();
        EchoWebSocketListener listener = new EchoWebSocketListener(this);
        ws = client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
        return connectionStatus;
    }

    public LiveData<List<BitcoinModel>> fetchTransactions(){
        if(ws != null){
            ws.send("{\"op\":\"unconfirmed_sub\"}");
        }
        return recentTransactions;
    }

    @Override
    public void updateConnectionStatus(String s) {
        connectionStatus.postValue(s);
    }

    @Override
    public void dataFetched(ArrayList<BitcoinModel> data) {

    }

    @Override
    public void dataFetched(BitcoinModel model) {
        boolean toNotify = false;
        if(list.size() < BlockchainCommonUtil.MAX_COUNT){
            list.add(model);
            toNotify = true;
        }else {
            // check if the current model is having latest time than we have
            if(isPassedTimeRecent(model.getTime())){
                list.remove(list.size()-1);
                list.add(model);
            }
        }
        Collections.sort(list);
        if(toNotify){
            recentTransactions.setValue(list);
        }

    }

    @Override
    public void dataFetched(String data) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                RootResponseModel responseModel =  gson.fromJson(data,RootResponseModel.class);
                if(responseModel != null && responseModel.getX() != null && responseModel.getX().getOut() != null){
                    long amt = 0;
                    for(int i = 0; i < responseModel.getX().getOut().size() ; i++){
                        amt = amt + responseModel.getX().getOut().get(i).getValue();
                        // convert-- Todo
                    }
                    BitcoinModel model = new BitcoinModel(responseModel.getX().getHash(),amt,responseModel.getX().getTime());
                    dataFetched(model);
                }
            }
        });

    }

    private boolean isPassedTimeRecent(long passedTime){
        if(list.size() == 0)
            return true;
        Collections.sort(list);
        return passedTime < list.size() - 1;
    }
    public void clearAllTransactions(){
        if(list != null){
            list.clear();
            recentTransactions.setValue(list);
        }
    }
}
