package com.example.websocket_blockchain_demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootResponseModel {
    @SerializedName("op")
    @Expose
    private String op;
    @SerializedName("x")
    @Expose
    private X x;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public class X {

        @SerializedName("lock_time")
        @Expose
        private Long lockTime;
        @SerializedName("ver")
        @Expose
        private Long ver;
        @SerializedName("size")
        @Expose
        private Long size;
        @SerializedName("inputs")
        @Expose
        private List<Input> inputs = null;
        @SerializedName("time")
        @Expose
        private Long time;
        @SerializedName("tx_index")
        @Expose
        private Long txIndex;
        @SerializedName("vin_sz")
        @Expose
        private Long vinSz;
        @SerializedName("hash")
        @Expose
        private String hash;
        @SerializedName("vout_sz")
        @Expose
        private Long voutSz;
        @SerializedName("relayed_by")
        @Expose
        private String relayedBy;
        @SerializedName("out")
        @Expose
        private List<Out> out = null;

        public Long getLockTime() {
            return lockTime;
        }

        public void setLockTime(Long lockTime) {
            this.lockTime = lockTime;
        }

        public Long getVer() {
            return ver;
        }

        public void setVer(Long ver) {
            this.ver = ver;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public List<Input> getInputs() {
            return inputs;
        }

        public void setInputs(List<Input> inputs) {
            this.inputs = inputs;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public Long getTxIndex() {
            return txIndex;
        }

        public void setTxIndex(Long txIndex) {
            this.txIndex = txIndex;
        }

        public Long getVinSz() {
            return vinSz;
        }

        public void setVinSz(Long vinSz) {
            this.vinSz = vinSz;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public Long getVoutSz() {
            return voutSz;
        }

        public void setVoutSz(Long voutSz) {
            this.voutSz = voutSz;
        }

        public String getRelayedBy() {
            return relayedBy;
        }

        public void setRelayedBy(String relayedBy) {
            this.relayedBy = relayedBy;
        }

        public List<Out> getOut() {
            return out;
        }

        public void setOut(List<Out> out) {
            this.out = out;
        }
    }

    public class Out {

        @SerializedName("spent")
        @Expose
        private Boolean spent;
        @SerializedName("tx_index")
        @Expose
        private Long txIndex;
        @SerializedName("type")
        @Expose
        private Long type;
        @SerializedName("addr")
        @Expose
        private String addr;
        @SerializedName("value")
        @Expose
        private Long value;
        @SerializedName("n")
        @Expose
        private Long n;
        @SerializedName("script")
        @Expose
        private String script;

        public Boolean getSpent() {
            return spent;
        }

        public void setSpent(Boolean spent) {
            this.spent = spent;
        }

        public Long getTxIndex() {
            return txIndex;
        }

        public void setTxIndex(Long txIndex) {
            this.txIndex = txIndex;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public Long getN() {
            return n;
        }

        public void setN(Long n) {
            this.n = n;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }

    }
    public class Input {

        @SerializedName("sequence")
        @Expose
        private Long sequence;
        @SerializedName("prev_out")
        @Expose
        private PrevOut prevOut;
        @SerializedName("script")
        @Expose
        private String script;

        public Long getSequence() {
            return sequence;
        }

        public void setSequence(Long sequence) {
            this.sequence = sequence;
        }

        public PrevOut getPrevOut() {
            return prevOut;
        }

        public void setPrevOut(PrevOut prevOut) {
            this.prevOut = prevOut;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }

    }
    public class PrevOut {

        @SerializedName("spent")
        @Expose
        private Boolean spent;
        @SerializedName("tx_index")
        @Expose
        private Long txIndex;
        @SerializedName("type")
        @Expose
        private Long type;
        @SerializedName("addr")
        @Expose
        private String addr;
        @SerializedName("value")
        @Expose
        private Long value;
        @SerializedName("n")
        @Expose
        private Long n;
        @SerializedName("script")
        @Expose
        private String script;

        public Boolean getSpent() {
            return spent;
        }

        public void setSpent(Boolean spent) {
            this.spent = spent;
        }

        public Long getTxIndex() {
            return txIndex;
        }

        public void setTxIndex(Long txIndex) {
            this.txIndex = txIndex;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        public Long getN() {
            return n;
        }

        public void setN(Long n) {
            this.n = n;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }

    }
}
