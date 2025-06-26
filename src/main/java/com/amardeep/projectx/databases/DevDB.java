package com.amardeep.projectx.databases;

import com.amardeep.projectx.interfaces.DB;

public class DevDB implements DB {

    public String getData() {
        return "Dev Data";
    }
}
