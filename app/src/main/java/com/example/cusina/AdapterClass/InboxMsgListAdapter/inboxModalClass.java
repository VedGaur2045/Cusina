package com.example.cusina.AdapterClass.InboxMsgListAdapter;

public class inboxModalClass {
    private String megTxt,msgDate;

    public inboxModalClass(String megTxt, String msgDate) {
        this.megTxt = megTxt;
        this.msgDate = msgDate;
    }

    public String getMegTxt() {
        return megTxt;
    }

    public void setMegTxt(String megTxt) {
        this.megTxt = megTxt;
    }

    public String getmsgDate() {
        return msgDate;
    }

    public void setmsgDate(String msgDate) {
        this.msgDate = msgDate;
    }
}
