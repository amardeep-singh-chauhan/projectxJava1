package com.amardeep.projectx.databases;

import com.amardeep.projectx.interfaces.DB;

public class ProdDB implements DB {

    public String getData(){
        return "Prod Data";
    }
}
