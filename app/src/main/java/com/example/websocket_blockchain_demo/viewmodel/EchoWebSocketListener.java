package com.example.websocket_blockchain_demo.viewmodel;

import android.util.Log;

import com.example.websocket_blockchain_demo.myinterfaces.StatusListenerInterface;
import com.example.websocket_blockchain_demo.util.BlockchainCommonUtil;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public final class EchoWebSocketListener extends WebSocketListener {
    private StatusListenerInterface statusListenerInterface;

    public EchoWebSocketListener(StatusListenerInterface listenerInterface){
        statusListenerInterface = listenerInterface;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        if(statusListenerInterface != null)
            statusListenerInterface.updateConnectionStatus(BlockchainCommonUtil.CONNECTION_CONNECTED);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        Log.d(BlockchainCommonUtil.APP_TAG,"onMessage text "+text);
        statusListenerInterface.dataFetched(text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Log.d(BlockchainCommonUtil.APP_TAG,"onMessage with bytes "+bytes.toString());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(BlockchainCommonUtil.NORMAL_CLOSURE_STATUS, null);
        if(statusListenerInterface != null)
            statusListenerInterface.updateConnectionStatus(BlockchainCommonUtil.CONNECTION_DISCONNECTED);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if(statusListenerInterface != null)
            statusListenerInterface.updateConnectionStatus(BlockchainCommonUtil.CONNECTION_FAILURE);
    }
}