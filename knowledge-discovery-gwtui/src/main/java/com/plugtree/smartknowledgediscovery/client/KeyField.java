package com.plugtree.smartknowledgediscovery.client;

public class KeyField extends Field {

    public KeyField(String name) {
        super(name, new Validator(false, 30) {

            @Override
            public boolean isValid(String data) {
                return true;
            }
        });
    }

    @Override
    public boolean isKey() {
        return true;
    }
}
