package com.example.websocket_blockchain_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BitcoinModel implements Comparable{
    public BitcoinModel(String h, long amt, long timeInMs) {
        hashCode = h;
        transactionAmount = amt;
        this.timeInMs = timeInMs;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getTime() {
        return timeInMs;
    }

    public void setTime(long time) {
        this.timeInMs = time;
    }

    /*
              - Transaction hash
            - Transaction amount in USD. Use any online public REST API for BTC/USD price
        */
    private String hashCode;
    private long transactionAmount;
    private long timeInMs;

    @Override
    public int compareTo(Object o) {
        if(o instanceof BitcoinModel){
            return Long.compare(((BitcoinModel) o).timeInMs, this.timeInMs);
        }else return 0;
    }
}
