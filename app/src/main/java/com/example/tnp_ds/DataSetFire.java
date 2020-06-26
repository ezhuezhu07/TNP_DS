package com.example.tnp_ds;

public class DataSetFire {
    String qname;
    String qtype;

    public String getQname()
    {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public DataSetFire() {
    }

    public DataSetFire(String qname, String qtype) {
        this.qname = qname;
        this.qtype = qtype;
    }
}

